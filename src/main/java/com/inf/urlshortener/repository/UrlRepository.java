package com.inf.urlshortener.repository;

import com.inf.urlshortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url getUrlByKeyUrl(String keyUrl);

}
