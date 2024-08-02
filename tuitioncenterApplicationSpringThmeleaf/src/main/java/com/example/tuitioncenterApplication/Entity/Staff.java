package com.example.tuitioncenterApplication.Entity;


import jakarta.persistence.*;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(length = 255)
    private  String fullname;

    private  String category;

    @Column(unique = true)
    private  String email;

    private  String address;

    private  String phone;

    public  Staff(){}

    public  Staff(Long id, String fullname, String category, String email, String address, String phone){
         this.setId(id);
         this.setFullname(fullname);
         this.setCategory(category);
         this.setEmail(email);
         this.setAddress(address);
         this.setPhone(phone);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
