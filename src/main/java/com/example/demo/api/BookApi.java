//package com.example.demo.api;
//
//import com.example.demo.entity.Bookings;
//import com.example.demo.entity.Providers;
//import com.example.demo.entity.Tours;
//import com.example.demo.repository.BookingRepository;
//import com.example.demo.repository.ProviderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("api/providers")
//public class BookApi {
//    @Autowired
//    BookingRepository repo;
//    @Autowired
//    ProviderRepository pRepo;
//    @GetMapping
//    public ResponseEntity<List<Bookings>> getAll() {
//        return ResponseEntity.ok(repo.findByDbStatusTrue()); // ResponseEntity.ok(repo.findByStatusTrue());
//    }
//    // hien thi cac book cua providers
//    @GetMapping
//    public ResponseEntity<List<Bookings>> getByProvider(@PathVariable("id") Long id) {
//        if (!repo.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        Providers p = pRepo.findById(id).get();
//        return ResponseEntity.ok(repo.findByProviders(p));
//    }
//    // hien thi cac book cua User
//}
