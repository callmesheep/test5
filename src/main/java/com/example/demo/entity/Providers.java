package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "providers")
public class Providers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerid;
    @Column(name ="company_name")
    private String companyName;
    @Column(name ="cpmpany_registration_number")
    private String companyRegistrationNumber;
    @Column(name ="tax_id")
    private String taxID;
    @Column(name ="company_address")
    private String companyAddress;
    @Column(name ="company_person")
    private String contactPerson;
    @Column(name ="company_email")
    private String contactEmail;
    @Column(name ="company_phone")
    private String contactPhone;
    @Column(name ="wrbsite")
    private String website;
    @Column(name ="company_description")
    private String companyDescription;
    @Column(name ="logo_url")
    private String logoUrl;
    @Column(name ="bank_account_number")
    private String bankAccountNumber;
    @Column(name ="bankName")
    private String bankName;
    @Column(name ="bank_branchname")
    private String bankBranchName;
    @Column(name ="licennse_document_url")
    private String licenseDocumentUrl;
    @Column(name ="db_status")
    private Boolean dbStatus;
    @Column(name ="rejection_reason")
    private String RejectionReason;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<AppRole> roles = new HashSet<>();
}