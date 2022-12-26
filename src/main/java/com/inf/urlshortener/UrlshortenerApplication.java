package com.inf.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Random;




@SpringBootApplication
public class UrlshortenerApplication {

    public static void main(String[] args) {
        int min = 1;
        int max = 9998;

        int b = (int)(Math.random()*(max-min+1)+min);

        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');

        String hashVal = Integer.toString(b) + c;

        System.out.println("HHHH" + hashVal);
        SpringApplication.run(UrlshortenerApplication.class, args);
    }

}
