package com.dispatcher.gateway.service;


import com.dispatcher.gateway.model.Token;

public interface TokenService {
    Token generate(Token token);
    Token generate(String clientId, String clientSecret, String username, String password);
}
