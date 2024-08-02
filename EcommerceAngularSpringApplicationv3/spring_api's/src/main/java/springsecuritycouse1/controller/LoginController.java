package springsecuritycouse1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import springsecuritycouse1.dto.LoginRequest;
import springsecuritycouse1.dto.LoginResponse;
import springsecuritycouse1.services.jwt.CustomerServiceImpl;
import springsecuritycouse1.utils.JwtUtil;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    public  final AuthenticationManager authenticationManager;

    public final CustomerServiceImpl customerService;

    private  final JwtUtil jwtUtil;


    @Autowired
    public LoginController(AuthenticationManager authenticationManager, CustomerServiceImpl customerService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.customerService =customerService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<LoginResponse>  login(@RequestBody LoginRequest loginRequest){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword())
            );
        } catch (AuthenticationException  e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserDetails userDetails;
        try{
            userDetails = customerService.loadUserByUsername(loginRequest.getEmail());
        }  catch(UsernameNotFoundException e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        String jwt = jwtUtil.generateToken(userDetails.getUsername());

        //Addition logic can be added here if needed
        return ResponseEntity.ok(new LoginResponse(jwt));
    }
}


