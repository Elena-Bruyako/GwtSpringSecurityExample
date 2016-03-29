package com.bruyako.server.security;

import com.bruyako.server.repository.UserRepository;
import com.bruyako.shared.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by brunyatko on 24.03.16.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository = new UserRepository();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = getUserByLogin(username);
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                roles);
    }

    public User getUserByLogin(String username) {
        for (User user : userRepository.getAll()) {
            if (user.getLogin().equals(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User not found");
    }
}
