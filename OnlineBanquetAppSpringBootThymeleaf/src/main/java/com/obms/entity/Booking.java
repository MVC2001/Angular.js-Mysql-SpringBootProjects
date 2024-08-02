package com.obms.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Booking {


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  Long id;

    @Column(length = 255, nullable = false)
    private  String  custName;

    @Column(nullable = false, length = 255)
    private  String email;

    @Column(length = 255, nullable = false)
    private  String phone;

    @Column(nullable = false, length = 255)
    private  String hallCategory;

    @Column(length = 50)
    private  String status;

    @Column(length = 100)
    private  String booked_from;

    @Column(length = 100)
    private  String upto;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private  LocalDateTime updated_at;


    public  Booking(){}
    public  Booking(Long id, String custName, String hallCategory, String phone, String email, String status, String booked_from,String upto, LocalDateTime created_at,LocalDateTime updated_at){
        this.setId(id);
        this.setCustName(custName);
        this.setHallCategory(hallCategory);
        this.setPhone(phone);
        this.setEmail(email);
        this.setStatus(status);
        this.setBooked_from(booked_from);
        this.setUpto(upto);
        this.setCreated_at(created_at);
        this.setUpdated_at(updated_at);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getHallCategory() {
        return hallCategory;
    }

    public void setHallCategory(String hallCategory) {
        this.hallCategory = hallCategory;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBooked_from() {
        return booked_from;
    }

    public void setBooked_from(String booked_from) {
        this.booked_from = booked_from;
    }

    public String getUpto() {
        return upto;
    }

    public void setUpto(String upto) {
        this.upto = upto;
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
