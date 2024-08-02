package springsecuritycouse1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springsecuritycouse1.dto.ShopWithImageDto;
import springsecuritycouse1.entities.Shop;
import springsecuritycouse1.repositories.ShopRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Optional<Shop> getShopById(Long id) {
        return shopRepository.findById(id);
    }

    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }



    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}
