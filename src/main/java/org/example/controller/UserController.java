package org.example.controller;

import org.example.dto.AuthUserRequest;
import org.example.dto.RegisterUserRequest;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Создать пользователя (ADMIN)
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
            User createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Обновить данные пользователя (ADMIN)
    @PatchMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        Optional<User> existingUserOpt = userService.findById(user.getId());
        if (existingUserOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            User updatedUser = userService.save(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
    }

    // Удалить пользователя (ADMIN)
    @DeleteMapping()
    public ResponseEntity<Void> deleteUser(@RequestBody User user) {
        if (!userService.existsById(user.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteById(user.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Зарегистрировать пользователя
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUserRequest request) {
        // Регистрация пользователя и генерация токена
        // String token = userService.register(request);
        return ResponseEntity.ok(/* token */ "token-placeholder");
    }

    // Авторизация пользователя
    @PostMapping("/auth")
    public ResponseEntity<String> authenticateUser(@RequestBody AuthUserRequest request) {
        // Аутентификация и генерация токена
        // String token = userService.authenticate(request);
        return ResponseEntity.ok(/* token */ "token-placeholder");
    }
}

