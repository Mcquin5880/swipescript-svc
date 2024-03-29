package org.mcq.swipescriptsvc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationRequest {

    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 25, message = "Username must be between 3 and 25 characters.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, max = 100, message = "Password must be at least 8 characters long.")
    private String password;

    private String authority;
}
