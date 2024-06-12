package com.ms.springboot_jwt_auth.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JWTResponse {
    private String jwtToken;
    private String username;
}
