package com.zahid.auth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AuthResponse {

    @Getter
    private final String jwt;
}
