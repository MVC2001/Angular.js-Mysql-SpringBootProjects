package springsecuritycouse1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory_store")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "store_name")
    private String name;

    @Column(name = "productName")
    private  String product;

    @Column(name = "product_category")
    private  String category;

    @Column(name = "price")
    private  String price;

    @Column(name = "total")
    private  String total;

    @Column(name = "status")
    private  String status;

    @Column(name = "addedAT")
    private  String added_at;

    @Column(name = "expired_at")
    private  String expired_at;


}
