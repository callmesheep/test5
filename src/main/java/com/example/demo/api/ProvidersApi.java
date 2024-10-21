package com.example.demo.api;

import com.example.demo.entity.Providers;

import com.example.demo.entity.Tours;
import com.example.demo.repository.ProviderRepository;
import com.example.demo.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/providers")
public class ProvidersApi {
    @Autowired
    ProviderRepository repo;
    // Show list Providers Fail
    @Autowired
    TourRepository tRepo;

    @GetMapping
    public ResponseEntity<List<Providers>> getAll() {
        return ResponseEntity.ok(repo.findBydbStatusFalse()); // ResponseEntity.ok(repo.findByStatusTrue());
    }

    @PostMapping("{id}")
    public ResponseEntity<Void> accept(@PathVariable("id") Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Providers p = repo.findById(id).get();
        p.setDbStatus(true);
        repo.save(p);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Providers p = repo.findById(id).get();
        p.setDbStatus(false);
        repo.save(p);
        List<Tours> toursList = tRepo.findByProviders(p);
        for (Tours tour : toursList) {
            tour.setDbStatus(false);
            tRepo.save(tour);

        }
        return ResponseEntity.ok().build();
    }
}
