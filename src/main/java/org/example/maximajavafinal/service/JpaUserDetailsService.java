package org.example.maximajavafinal.service;

import org.example.maximajavafinal.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findById(username).orElseThrow(()-> new UsernameNotFoundException("No such user!" + username));
        // Здесь можно давать учётку гостевого пользователя (.orElse())
        //return repository.findUserByUsername(username);
    }
}
