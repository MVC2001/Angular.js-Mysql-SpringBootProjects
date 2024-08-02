package springsecuritycouse1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "addTo_cart")
public class AddToCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_item")
    private String item;

    @Column(name = "category")
    private String category;

    @Column(name = "item_price")
    private String price;

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private String imageData;

}
