package springsecuritycouse1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private  String name;

    @Column(name = "password")
    private  String password;

    @Column(name = "email")
    private  String email;




}
