package com.inf.urlshortener.controller;

import com.inf.urlshortener.model.Url;
import com.inf.urlshortener.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping("create")
    public String convertToShortUrl(@RequestBody Url longUrl) {
        if ( !longUrl.getLongUrl().isEmpty()) {
            urlService.shortenUrl(longUrl);
            return "Uzun url adresiniz kaydedildi." + System.lineSeparator() +
                    "Kaydedilen url: " + longUrl.getLongUrl();
        }
        else {
            return  "Kisaltmak istediginiz url adresini yazmadiniz.";
        }
    }

    @GetMapping("getlonglink")
    public String getAndRedirect(@RequestParam String shortUrl) {
        String url = urlService.getUrlByKey(shortUrl);
        return url;
    }
}
