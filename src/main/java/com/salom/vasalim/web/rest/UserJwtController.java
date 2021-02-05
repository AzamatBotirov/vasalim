package com.salom.vasalim.web.rest;

import com.salom.vasalim.demain.User;
import com.salom.vasalim.repository.UserRepository;
import com.salom.vasalim.security.JwtTokenProvider;
import com.salom.vasalim.web.rest.vm.LoginVM;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
class UserJwtController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    UserJwtController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginVM loginVM){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVM.getUsername(),loginVM.getPassword()));
       User user =userRepository.findByLogin(loginVM.getUsername());
       if(user==null){
           throw new UsernameNotFoundException("Bu foydalanuvchi mavjud emas!");
       }
       String token = jwtTokenProvider.createToken(user.getUserName(),user.getRoles());
       Map<Object, Object> map = new HashMap<>();
       map.put("username", user.getUserName());
       map.put("token", token);
       return ResponseEntity.ok(map);
    }
}