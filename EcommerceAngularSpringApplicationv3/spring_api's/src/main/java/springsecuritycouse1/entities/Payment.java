package springsecuritycouse1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="payment_date")
    private  String date;

    @Column(name = "payment_method")
    private  String paymentMethod;

    @Column(name = "amount_payed")
    private  String amount;

    @Column(name = "customer")
    private  String customerName;



}
