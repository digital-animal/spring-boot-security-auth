package com.zahid.auth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;
}
