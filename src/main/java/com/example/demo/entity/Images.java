package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Images implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageId;
    @Column(name = "image_data")
    private String imageData;
    @Column(name = "caption")
    private String caption;
    @Column(name = "image_type")
    private String imageType;
    @Column(name = "status")
    private int Status;
    @Column(name = "db_status")
    private Boolean dbStatus;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "updated_time")
    private Date updatedTime;
    @PrePersist
    public void prePersist(){
        this.createdTime = new Date();
        this.updatedTime = new Date();
    }
    @PreUpdate
    public void preUpdate(){
        this.createdTime = new Date();
        this.updatedTime = new Date();
    }
    @ManyToOne
    @JoinColumn(name = "tourId")
    private Tours tour;

    @ManyToOne
    @JoinColumn(name = "providerId")
    private Providers provider;


}
