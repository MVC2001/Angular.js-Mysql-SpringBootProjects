package springsecuritycouse1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsecuritycouse1.entities.Carts;
import springsecuritycouse1.repositories.SalesRepository;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    public List<Carts> getAllSales() {
        return salesRepository.findByConfirmed("sold-out");
    }

}
