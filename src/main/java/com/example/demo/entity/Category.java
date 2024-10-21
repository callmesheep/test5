/*
 * (C) Copyright 2022. All Rights Reserved.
 *
 * @author DongTHD
 * @date Mar 10, 2022
*/
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	@Column(name = "category_Name")
	private String categoryName;
	@Column(name = "desciption")
	private String desciption;
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

}
