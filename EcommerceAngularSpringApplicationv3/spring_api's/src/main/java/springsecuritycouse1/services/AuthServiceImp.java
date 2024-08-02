package springsecuritycouse1.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springsecuritycouse1.dto.SignupRequest;
import springsecuritycouse1.entities.Customer;
import springsecuritycouse1.repositories.CustomerRepository;

@Service
public class AuthServiceImp implements AuthService {

  private CustomerRepository customerRepository;

  private  final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImp(CustomerRepository customerRepository,PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder =passwordEncoder;
    }


    @Override
    public boolean createCustomer(SignupRequest signupRequest) {
        //cheked if user exist
        if (customerRepository.existsByEmail(signupRequest.getEmail())){
            return false;
    }

        Customer customer =new Customer();
        BeanUtils.copyProperties(signupRequest,customer);

        //hash password before signin into db by password encoder
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        customer.setPassword(hashPassword);
        customerRepository.save(customer);
        return true;
    }
}
