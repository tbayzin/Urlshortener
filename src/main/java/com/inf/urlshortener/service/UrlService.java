package com.inf.urlshortener.service;

import com.inf.urlshortener.model.Url;
import com.inf.urlshortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service

@NoArgsConstructor

public class UrlService {

    @Autowired
    UrlRepository urlRepository;

        public String createHash() {
            int min = 1;
            int max = 9998;
            int b = (int)(Math.random()*(max-min+1)+min);
            Random r = new Random();
            char c = (char)(r.nextInt(26) + 'a');
            String hashVal = Integer.toString(b) + c;
            return hashVal;
        }


    public String getUrlByKey(String key) {

        key.replaceAll(".+/", "");
            return urlRepository.getUrlByKeyUrl(key).getLongUrl().toString();

    }


    // murmur3 de kullanilabilirdi.Ben kendim bir hash metodu yazdım
    public String shortenUrl(@NonNull Url url) {
        url.setKeyUrl("www.urshortlink.com/" + createHash());
        System.out.println(url.getKeyUrl());
       return urlRepository.save(url).toString(); }
            }

