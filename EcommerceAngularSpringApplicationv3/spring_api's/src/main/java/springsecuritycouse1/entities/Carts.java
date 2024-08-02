package springsecuritycouse1.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name="carts_tbl")
public class Carts {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_item")
    private String item;

    @Column(name = "category")
    private String category;

    @Column(name = "item_price")
    private String price;

    @Column(name = "payment_type",nullable = true)
    private String paymethod;

    @Column(name = "card_number",nullable = true)
    private String cardNumber;

    @Column(name = "contact_number",nullable = true)
    private String phone;

    @Column(name = "amount",nullable = true)
    private String amt;


    @Column(name = "confirmed_orders",nullable = true)
    private String confirmed;


    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private String imageData;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
}
