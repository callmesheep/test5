package com.example.demo.repository;


import com.example.demo.entity.Reviews;
import com.example.demo.entity.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

    List<Reviews> findAllByOrderByIdDesc();


    List<Reviews> findByToursOrderByIdDesc(Tours tours);//OrderByIdDesc

}
