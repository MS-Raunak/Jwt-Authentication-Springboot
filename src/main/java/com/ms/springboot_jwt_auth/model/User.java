package com.ms.springboot_jwt_auth.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String userid;
    private String name;
    private String email;

}
