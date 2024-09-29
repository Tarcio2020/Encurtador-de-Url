package com.github.Tarcio2020.encurtadorurl.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_encutador")
public class UrlEntity {
    
    @Id
    private String id; // Alterado para String
    private String fullUrl;
    private LocalDateTime expiresAt;
    
    public UrlEntity() {
    }

    public UrlEntity(String id, String fullUrl, LocalDateTime expiresAt) {
        this.id = id; // Usar id como String
        this.fullUrl = fullUrl;
        this.expiresAt = expiresAt;
    }

    public String getId() { // Alterado para String
        return id;
    }

    public void setId(String id) { // Alterado para String
        this.id = id;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        UrlEntity other = (UrlEntity) obj;
        return Objects.equals(id, other.id);
    }
}

