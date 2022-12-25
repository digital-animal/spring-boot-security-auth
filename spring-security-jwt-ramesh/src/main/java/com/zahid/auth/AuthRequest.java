package com.zahid.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;
}
