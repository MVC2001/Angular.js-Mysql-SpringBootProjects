package springsecuritycouse1.services;

import springsecuritycouse1.dto.SignupRequest;

public interface AuthService {
    boolean createCustomer(SignupRequest signupRequest);
}
