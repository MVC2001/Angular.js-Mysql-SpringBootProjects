package springsecuritycouse1.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private String jwtToken;

    // Constructor that takes a String parameter
    public LoginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
