package org.mcq.swipescriptsvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String username;
    private String fakeToken;
}
