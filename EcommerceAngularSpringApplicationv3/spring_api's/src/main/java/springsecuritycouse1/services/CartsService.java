package springsecuritycouse1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsecuritycouse1.entities.Carts;
import springsecuritycouse1.entities.Inventory;
import springsecuritycouse1.entities.Shop;
import springsecuritycouse1.repositories.CartsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartsService {

     @Autowired
     private CartsRepository cartsRepository;

    public List<Carts> getCarts() {
        return cartsRepository.findAllByOrderByIdDesc();
    }


    public Carts saveCarts(Carts carts) {
        return cartsRepository.save(carts);
    }


    public Carts  updateCart(Carts cart){
        return cartsRepository.save(cart);
    }


    public Carts getCartById(Long id){
        return cartsRepository.findById(id).orElse(null);
    }

}
