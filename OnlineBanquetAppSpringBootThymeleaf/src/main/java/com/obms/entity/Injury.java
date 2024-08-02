package com.obms.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Injury {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;


    @Column(length = 100, nullable = false)
    private  String custName;

    @Column(length = 100, nullable = false)
    private  String hallCategory;

    @Column(length = 300,nullable = false)
    private  String description;

    @Column(length = 100, nullable = false)
    private String pendingUpto;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;


    public  Injury(){}


    public  Injury(Long id, String custName, String hallCategory, String description, LocalDateTime created_at, LocalDateTime updated_at){
        this.setId(id);
        this.setCustName(custName);
        this.setHallCategory(hallCategory);
        this.setDescription(description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPendingUpto() {
        return pendingUpto;
    }

    public void setPendingUpto(String pendingUpto) {
        this.pendingUpto = pendingUpto;
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
