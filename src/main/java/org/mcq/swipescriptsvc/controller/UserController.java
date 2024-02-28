package org.mcq.swipescriptsvc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mcq.swipescriptsvc.entity.AppUser;
import org.mcq.swipescriptsvc.model.LoginRequest;
import org.mcq.swipescriptsvc.model.LoginResponse;
import org.mcq.swipescriptsvc.model.RegistrationRequest;
import org.mcq.swipescriptsvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("account/register")
    public ResponseEntity<AppUser> registerUser(@Valid @RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("account/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @GetMapping("users")
    public List<AppUser> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
