package com.example.tuitioncenterApplication.Entity;

import jakarta.persistence.*;


@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private String name;


    private  String address;

    private  String phone;

    private  String coursetaken;

    private String enrollfrom;

    private  String  upto;

    private  String description;


    public  Enrollment(){}

    public  Enrollment(Integer id,String name, String address, String phone,String coursetaken, String enrollfrom, String upto, String  description){
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
        this.setCoursetaken(coursetaken);
        this.setEnrollfrom(enrollfrom);
        this.setUpto(upto);
        this.setDescription(description);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCoursetaken() {
        return coursetaken;
    }

    public void setCoursetaken(String coursetaken) {
        this.coursetaken = coursetaken;
    }

    public String getEnrollfrom() {
        return enrollfrom;
    }

    public void setEnrollfrom(String enrollfrom) {
        this.enrollfrom = enrollfrom;
    }

    public String getUpto() {
        return upto;
    }

    public void setUpto(String upto) {
        this.upto = upto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
