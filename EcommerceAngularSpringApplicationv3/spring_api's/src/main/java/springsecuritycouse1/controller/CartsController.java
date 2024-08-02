package springsecuritycouse1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springsecuritycouse1.entities.Carts;
import springsecuritycouse1.entities.Inventory;
import springsecuritycouse1.entities.Shop;
import springsecuritycouse1.services.CartsService;
import springsecuritycouse1.services.SalesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api5")
@CrossOrigin(origins = "*")
public class CartsController {

    @Autowired
    private CartsService cartsService;

    @Autowired
    private SalesService salesService;


    @GetMapping("/soldOut")
    public List<Carts> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/carts")
    public List<Carts>  getCarts() {
        return cartsService.getCarts();
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Carts> getCartById(@PathVariable Long id){
        Carts cart= cartsService.getCartById(id);
        if(cart ==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cart);
    }


    @PutMapping("/cart/{id}")
    public ResponseEntity<Long> updateInventory(@PathVariable Long id, @RequestBody Carts cart) {
        Carts existingCart = cartsService.getCartById(id);
        if (existingCart == null)
            return ResponseEntity.notFound().build();

        existingCart.setItem(cart.getItem());
        existingCart.setCategory(cart.getCategory());
        existingCart.setPrice(cart.getPrice());
        existingCart.setPaymethod(cart.getPaymethod());
        existingCart.setCardNumber(cart.getCardNumber());
        existingCart.setPhone(cart.getPhone());
        existingCart.setAmt(cart.getAmt());
        existingCart.setConfirmed(cart.getConfirmed());

        Carts updateCart = cartsService.updateCart(existingCart);
        // Returning the ID after a successful update
        return ResponseEntity.ok(id);
    }
}
