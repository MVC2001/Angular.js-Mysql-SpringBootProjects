package springsecuritycouse1.entities;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.Data;

@Entity
@Data
@Table(name = "shopPrices_updates")
public class PriceUpdates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "product_name")
    private  String productName;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private  String price;

    @Column(name = "updated_at")
    private  String updatedAt;

}
