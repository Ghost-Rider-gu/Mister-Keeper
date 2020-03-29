/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.authservice.controller;

import corp.siendev.com.keeper.authservice.domain.user.UserModel;
import corp.siendev.com.keeper.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class AuthController {

    private UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("signin")
    public UserModel signIn(@Valid @RequestBody UserModel userModel) {
        return userRepository.findByLogin(userModel.getLogin())
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    @PostMapping("signup")
    @PreAuthorize("#oauth2.hasScope('server')")
    public ResponseEntity<UserModel> signUp(@Valid @RequestBody UserModel userModel) {
        Optional<UserModel> existUser = userRepository.findByLogin(userModel.getLogin());

        if (existUser.isPresent()) {
            return new ResponseEntity<UserModel>(HttpStatus.OK);
        } else {
            userRepository.save(userModel);
        }
        return new ResponseEntity<UserModel>(HttpStatus.OK);
    }
}
