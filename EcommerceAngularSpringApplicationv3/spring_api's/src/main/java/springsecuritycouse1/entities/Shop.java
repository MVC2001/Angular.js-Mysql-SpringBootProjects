package springsecuritycouse1.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name="shop_tbl")
public class Shop {


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


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
}
