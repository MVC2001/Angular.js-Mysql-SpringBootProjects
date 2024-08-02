package springsecuritycouse1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springsecuritycouse1.dto.ShopWithImageDto;
import springsecuritycouse1.entities.Carts;
import springsecuritycouse1.entities.Shop;
import springsecuritycouse1.services.SalesService;
import springsecuritycouse1.services.ShopService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api4/shops")
@CrossOrigin(origins = "*")
public class ShopController {

    @Autowired
    private ShopService shopService;


    @GetMapping("/items")
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }




    @GetMapping("/item/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Long id) {
        Optional<Shop> shop = shopService.getShopById(id);
        return shop.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/item")
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop) {
        Shop savedShop = shopService.saveShop(shop);
        return ResponseEntity.ok(savedShop);
    }


    @PutMapping("/item/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        if (!shopService.getShopById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        shop.setId(id);
        Shop updatedShop = shopService.saveShop(shop);
        return ResponseEntity.ok(updatedShop);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        if (!shopService.getShopById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        shopService.deleteShop(id);
        return ResponseEntity.ok().build();
    }
}
