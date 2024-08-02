package com.example.tuitioncenterApplication.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  Long id;

    private  String name;

    private  String category;

    private  String amount;

    private  String date;


    public  Payment(){}


    public  Payment(Long id, String name, String category, String amount, String date){
        super();
        this.setId(id);
        this.setName(name);
        this.setCategory(category);
        this.setAmount(amount);
        this.setDate(date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
