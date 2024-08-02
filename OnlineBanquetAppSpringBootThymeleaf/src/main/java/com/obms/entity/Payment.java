package com.obms.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  Long id;

    @Column(length = 100,nullable = false)
    private  String category;

    @Column(length = 100, nullable = false)
    private  String amount;

    @Column(nullable = false, length =  300)
    private  String  description;

    @Column(length = 255,nullable = false)
    private  String custName;

    @Column(length = 50,nullable = false)
    private  String payment_date;

    @Column(length = 50,nullable = false)
    private  String status;


    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private  LocalDateTime updated_at;


    public  Payment(){}

    public  Payment(Long id, String category, String amount, String description,String custName, String payment_date, String status, LocalDateTime created_at, LocalDateTime updated_at){
        this.setId(id);
        this.setCategory(category);
        this.setAmount(amount);
        this.setDescription(description);
        this.setCustName(custName);
        this.setPayment_date(payment_date);
        this.setStatus(status);
        this.setCreated_at(created_at);
        this.setUpdated_at(updated_at);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
