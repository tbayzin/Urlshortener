package com.inf.urlshortener.service;

import com.inf.urlshortener.model.Url;
import com.inf.urlshortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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


    int min = 1;
    int max = 9998;

    int b = (int)(Math.random()*(max-min+1)+min);

    Random r = new Random();
    char c = (char)(r.nextInt(26) + 'a');

    String hashVal = Integer.toString(b) + c;


    public String getUrlByKey(String key) {

            return urlRepository.getUrlByKeyUrl(key).getLongUrl().toString();

    }
        /*
        if ((urls.containsKey(key))) {
            return urls.values().toString();
        }
        else {
            return "belirtilen kisa url kayitli degil";
        }
    }
         */

    public String shortenUrl(Url url) {
        url.setKeyUrl(hashVal);
        System.out.println(url.getKeyUrl());
       return urlRepository.save(url).toString();
    }
}
