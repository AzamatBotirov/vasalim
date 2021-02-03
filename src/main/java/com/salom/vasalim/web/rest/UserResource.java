package com.salom.vasalim.web.rest;

import com.salom.vasalim.demain.User;
import com.salom.vasalim.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user) {
        if (!checkPasswordLength(user.getPassword())){
            return new ResponseEntity("Parol 4 tadan kam bo`lmasligi kerak", HttpStatus.BAD_REQUEST);
        }
        if(userService.checkUserName(user.getUserName())){
            return new ResponseEntity("Bu USER oldin ruyhatdan utgan", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.create(user));
    }
    private Boolean checkPasswordLength(String password){
        return password.length() >= 4;
    }


}
