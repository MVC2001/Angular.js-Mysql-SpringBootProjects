package springsecuritycouse1.services.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springsecuritycouse1.entities.Customer;
import springsecuritycouse1.repositories.CustomerRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomerServiceImpl implements UserDetailsService {

    private  final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //login for fetch customer from db
        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new  UsernameNotFoundException("customer not found with email:" + email));
         return new User(customer.getEmail(),customer.getPassword(), Collections.emptyList());
    }
}
