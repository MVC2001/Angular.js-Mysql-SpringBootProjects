package com.obms.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "about_posts")
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;


    @Column(name = "description", nullable = false,length = 500)
    private String description;




    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = true)
    private Date createDate;

   public  About(){}

    public  About(Long id, String description, Date createDate){
       this.setId(id);
       this.setDescription(description);
       this.setCreateDate(createDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
