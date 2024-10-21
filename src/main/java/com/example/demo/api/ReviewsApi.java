package com.example.demo.api;


import com.example.demo.entity.Reviews;
import com.example.demo.repository.ReviewsRepository;
import com.example.demo.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/review")
public class ReviewsApi {

    @Autowired
    ReviewsRepository reviewsRepository;

//    @Autowired
//    UserRepository userRepository;

    @Autowired
    TourRepository tourRepository;

    @GetMapping
    public ResponseEntity<List<Reviews>> findAll() {
        return ResponseEntity.ok(reviewsRepository.findAllByOrderByIdDesc());//findAllByOrderByIdDesc()
    }



    @GetMapping("/tours/{id}")
    public ResponseEntity<List<Reviews>> findByTour(@PathVariable("id") Long id) {
        if (!tourRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviewsRepository.findByToursOrderByIdDesc(tourRepository.findById(id).get()));
    }

//    @PostMapping
//    public ResponseEntity<Reviews> post(@RequestBody Reviews reviews) {
//        if (!userRepository.existsById(reviews.getUser().getUserId())) {
//            return ResponseEntity.notFound().build();
//        }
//        if (!tourRepository.existsById(reviews.getTours().getTourId())) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(reviewsRepository.save(reviews));
//    }

    @PutMapping
    public ResponseEntity<Reviews> put(@RequestBody Reviews reviews) {
        if (!reviewsRepository.existsById(reviews.getReviewId())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviewsRepository.save(reviews));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!reviewsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reviewsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
