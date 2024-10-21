package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tours")
public class Tours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourId;
    @Column(name ="name")
    private String name;
    @Column(name ="decription")
    private String description;
    @Column(name ="price")
    private Double price;
    @Column(name ="discount")
    private int discount;
    @Column(name ="duration")
    private LocalDate Duration;
    @Column(name ="db_status")
    private Boolean dbStatus;
    @Column(name ="sold")
    private int sold;
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
    @JoinColumn(name = "locationId")
    private Locations locations;
    @ManyToOne
    @JoinColumn(name = "providerid")
    private Providers providers;
}
