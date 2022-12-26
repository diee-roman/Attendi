package com.diee.attendi.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class ApiKeyService {

    private static Integer KEY_LENGTH = 64;
    private final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final SecureRandom secureRandom = new SecureRandom();


    public String generateRandomKey(){
        StringBuilder sb = new StringBuilder();
        Random random =  new Random(secureRandom.nextLong());
        for (int i = 0; i < KEY_LENGTH; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
