package app.service;

import app.api.ApiService;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ClientUserDetailsService implements UserDetailsService {

    private final ApiService apiService;

    public ClientUserDetailsService(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        UserDetails user = apiService.getUserByName(name);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + name + " not found!");
        }
        return user;
    }

}