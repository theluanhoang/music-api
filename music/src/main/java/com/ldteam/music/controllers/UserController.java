package com.ldteam.music.controllers;

import com.ldteam.music.entities.UserEntity;
import com.ldteam.music.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElse(new UserEntity());
    }

    @PostMapping
    public UserEntity createUser(@Valid @RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable("id") Long id, @Valid @RequestBody @NotNull UserEntity user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }
}
