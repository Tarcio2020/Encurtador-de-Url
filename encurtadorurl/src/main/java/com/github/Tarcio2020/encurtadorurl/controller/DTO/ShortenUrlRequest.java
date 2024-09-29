package com.github.Tarcio2020.encurtadorurl.controller.DTO;

public class ShortenUrlRequest {
    private String url;

    public ShortenUrlRequest() {
        // Construtor padrão
    }

    public ShortenUrlRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
