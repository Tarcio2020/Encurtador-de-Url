package com.github.Tarcio2020.encurtadorurl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.Tarcio2020.encurtadorurl.entities.UrlEntity;

public interface UrlRepository extends JpaRepository<UrlEntity, String>{

}
