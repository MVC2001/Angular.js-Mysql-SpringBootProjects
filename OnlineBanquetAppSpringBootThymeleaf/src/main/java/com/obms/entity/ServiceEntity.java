package com.obms.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "services_posts")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  Long id;

    @Column(nullable = false, length =  500)
    private  String category;

    @Column(name = "description",nullable = false,length =  600)
    private  String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = true)
    private Date createDate;

    public  ServiceEntity(){}

    public  ServiceEntity(Long id, String category, String description, Date createDate){
        this.setId(id);
        this.setCategory(category);
        this.setDescription(description);
        this.setCreateDate(createDate);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
