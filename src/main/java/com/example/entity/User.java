package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;

    private String userName;

    private String userPw;

    private String nickName;

    private boolean activated; //활성화여부

}