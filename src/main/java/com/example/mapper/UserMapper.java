package com.example.mapper;

import com.example.entity.Authority;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> findByUsername(String username);

    List<Authority> findAuthorityByUserId(long userId);

}
