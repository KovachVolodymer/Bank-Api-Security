package com.example.demo.config;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String userName=authentication.getName();
       String password=authentication.getCredentials().toString();
       List<Customer> customer=customerRepository.findByEmail(userName);
       if(!customer.isEmpty())
       {
           if(passwordEncoder.matches(password,customer.get(0).getPassword()))
           {
               List<GrantedAuthority> authorities=new ArrayList<>();
               authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
               return new UsernamePasswordAuthenticationToken(userName,password,authorities);
           }else{
               throw new BadCredentialsException("Invalid password");
           }
       }else{
           throw new BadCredentialsException("New user register with this details!");
       }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }


}
