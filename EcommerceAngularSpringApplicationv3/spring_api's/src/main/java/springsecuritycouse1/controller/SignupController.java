package springsecuritycouse1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springsecuritycouse1.dto.SignupRequest;
import springsecuritycouse1.services.AuthService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/signup")
public class SignupController {

    private  final AuthService authService;


    @Autowired
    public SignupController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping
    public ResponseEntity<String> signController(@RequestBody SignupRequest signupRequest){
        boolean isUserCreated = authService.createCustomer(signupRequest);
        if(isUserCreated){
            return ResponseEntity.status(HttpStatus.CREATED).body("New user added successfull");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong failed to create new customer");
        }
    }
}
