package springsecuritycouse1.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@Table(name = "suppliers")
public class Vendor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendor_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private double rating;

    @Column(name = "reviews")
    private String reviews;

    @Column(name = "location")
    private String location;

    @Column(name = "shipping_information")
    private String shippingInformation;


    @Column(name = "contact_information")
    private String contactInformation;

    @Column(name = "product_origin")
    private String productOrigin;

    @Column(name = "certifications")
    private String certifications;


    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private java.sql.Timestamp updatedAt;
}
