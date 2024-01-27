package com.example.demo.config;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EazyBankUserDetails implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName,password;
        List<GrantedAuthority> authorities=null;
        List<Customer> customer=customerRepository.findByEmail(username);
        if(customer.isEmpty()){
            throw new UsernameNotFoundException("User not found"+username);
        }
        else{
            userName=customer.get(0).getEmail();
            password=customer.get(0).getPassword();
            authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
        }
        return new User(userName,password,authorities);
    }
}
