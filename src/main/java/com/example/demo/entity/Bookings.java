//package com.example.demo.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "bongkings")
//public class Bookings  implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long bookingId;
//    @Column(name = "booking_date")
//    private Date bookingDate;
//    @Column(name = "phone_number")
//    private String phoneNumber;
//    @Column(name = "contact_name")
//    private String contactName;
//    @Column(name = "db_status")
//    private Boolean dbStatus;
//    @Column(name = "status")
//    private int Status;
//    @Column(name = "created_time")
//    private Date createdTime;
//    @Column(name = "updated_time")
//    private Date updatedTime;
//    @PrePersist
//    public void prePersist(){
//        this.createdTime = new Date();
//        this.updatedTime = new Date();
//    }
//    @PreUpdate
//    public void preUpdate(){
//        this.createdTime = new Date();
//        this.updatedTime = new Date();
//    }
//    @ManyToOne
//    @JoinColumn(name = "tourId")
//    private Tours tour;
//}
