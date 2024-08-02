package springsecuritycouse1.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import springsecuritycouse1.entities.Shop;

@Data
public class ShopWithImageDto {
    private Shop shop;
    private MultipartFile image;
}
