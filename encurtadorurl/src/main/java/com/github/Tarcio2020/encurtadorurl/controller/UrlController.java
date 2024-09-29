package com.github.Tarcio2020.encurtadorurl.controller;

import java.net.URI;
import java.time.LocalDateTime;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.Tarcio2020.encurtadorurl.controller.DTO.ShortenUrlRequest;
import com.github.Tarcio2020.encurtadorurl.controller.DTO.ShortenUrlResponse;
import com.github.Tarcio2020.encurtadorurl.entities.UrlEntity;
import com.github.Tarcio2020.encurtadorurl.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:8080") // Ajuste conforme necessário
public class UrlController {

    @Autowired
    private UrlRepository urlRepository;

    @PostMapping("/shorten-url") // Usando o valor correto da rota
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest request, HttpServletRequest servletRequest) {
        
        String id; 
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (urlRepository.existsById(id)); 

        // Criando a URL encurtada
        urlRepository.save(new UrlEntity(id, request.getUrl(), LocalDateTime.now().plusMinutes(1)));
        
        // Retornando apenas o ID na resposta
        return ResponseEntity.ok(new ShortenUrlResponse(id)); // Retorna apenas o ID
    }
    
    @GetMapping("/{id}") // Adicionando a barra inicial
    public ResponseEntity<Void> redirect(@PathVariable("id") String id) {
        var urlOptional = urlRepository.findById(id);
        
        if (urlOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se a URL não existir
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(urlOptional.get().getFullUrl()));
        
        return ResponseEntity.status(HttpStatus.FOUND) // 302 Found
                             .headers(headers)
                             .build();
    }
}

