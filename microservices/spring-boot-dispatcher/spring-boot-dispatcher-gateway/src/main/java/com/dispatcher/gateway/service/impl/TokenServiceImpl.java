package com.dispatcher.gateway.service.impl;

import com.dispatcher.gateway.model.Token;
import com.dispatcher.gateway.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

//    private final KeycloakProperties properties;

    public TokenServiceImpl() {
    }

    @Override
    public Token generate(Token token) {
//        TokenManager manager = new TokenManager.Builder()
//                .serverUrl(properties.getServerUrl())
//                .realm(properties.getRealm())
//                .clientId(token.getClientId())
//                .clientSecret(token.getClientSecret())
//                .username(token.getUsername())
//                .password(token.getPassword())
//                .build();
//        AccessTokenResponse response = manager.getAccessToken();
//        token.setAccessToken(response.getToken());
//        token.setTokenType(response.getTokenType());
//        return token;
        return null;
    }

    @Override
    public Token generate(String clientId, String clientSecret, String username, String password) {
//        Token token = new Token();
//        TokenManager manager = new TokenManager.Builder()
//                .serverUrl(properties.getServerUrl())
//                .realm(properties.getRealm())
//                .clientId(clientId)
//                .clientSecret(clientSecret)
//                .username(username)
//                .password(password)
//                .build();
//        AccessTokenResponse response = manager.getAccessToken();
//        token.setAccessToken(response.getToken());
//        token.setTokenType(response.getTokenType());
//        return token;
        return null;
    }

}
