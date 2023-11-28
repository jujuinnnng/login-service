package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;

    private String username;

    private String password;

    private String nickname;

    private boolean activated; //활성화여부

    @Builder.Default
    private List<Authority> authorities = new ArrayList<>();
}