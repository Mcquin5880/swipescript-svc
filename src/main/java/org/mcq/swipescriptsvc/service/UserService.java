package org.mcq.swipescriptsvc.service;

import lombok.RequiredArgsConstructor;
import org.mcq.swipescriptsvc.entity.AppUser;
import org.mcq.swipescriptsvc.error.LoginException;
import org.mcq.swipescriptsvc.error.NotFoundException;
import org.mcq.swipescriptsvc.error.RegistrationException;
import org.mcq.swipescriptsvc.model.LoginRequest;
import org.mcq.swipescriptsvc.model.LoginResponse;
import org.mcq.swipescriptsvc.model.RegistrationRequest;
import org.mcq.swipescriptsvc.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUser registerUser(RegistrationRequest request) {

        if (userRepository.existsByUsername(request.getUsername().toLowerCase())) {
            throw new RegistrationException("Username already exists!");
        }

        AppUser user = AppUser.builder()
                .username(request.getUsername().toLowerCase())
                .password(passwordEncoder.encode(request.getPassword()))
                .authority(request.getAuthority() == null ? "ROLE_USER" : request.getAuthority())
                .build();

        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {

        AppUser user = userRepository.findByUsername(request.getUsername().toLowerCase())
                .orElseThrow(() -> new LoginException("Invalid username / password!"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new LoginException("Invalid password / password!");
        }

        return new LoginResponse(request.getUsername(), "fake-12345");
    }

    public AppUser getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }
}
