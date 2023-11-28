/*package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User getUser(String username) {
        return userMapper.getUser(username);
    }

}*/

package com.example.service;

import com.example.entity.Authority;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService  {

    private final UserMapper userMapper;

    public CustomUserDetailsService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {

        User user = userMapper.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));

        List<Authority> authorities = userMapper.findAuthorityByUserId(user.getUserId());
        user.setAuthorities(authorities);
        return createUser(user);
    }

    private org.springframework.security.core.userdetails.User createUser(User user) {
        if (!user.isActivated()) {
            throw new RuntimeException(user.getUsername() + " -> 활성화되어 있지 않습니다.");
        }

        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }
}
