package com.example.demo.repository;


import com.example.demo.entity.Category;
import com.example.demo.entity.Providers;
import com.example.demo.entity.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tours,Long> {
    // show Tour vs gia trị true
    List<Tours> findByDbStatusTrue();
    //show tour đuưc mua nhều
    List<Tours> findByStatusTrueOrderBySoldDesc() ;//findByStatusTrueOrderBySoldDesc()

    List<Tours> findTop10ByOrderBySoldDesc();

    List<Tours> findByProviders(Providers provider);

    List<Tours> findByStatusTrueOrderByEnteredDateDesc();

    List<Tours> findByCategory(Category category);

    Tours findByToursIdAndStatusTrue(Long id);
//show tour theo rating giảm ần
    @Query(value = "Select t.* From tours t \r\n"
            + "left join review r on t.tour_id = r.tour_id\r\n"
            + "group by t.tour_id , t.name\r\n"
            + "Order by  avg(r.rating) desc, RAND()", nativeQuery = true)
    List<Tours> findToursRated();

    @Query(value = "(Select t.*, avg(r.rating) Rate From tours p \r\n"
            + "left join review r on t.tour_id = r.tour_id\r\n"
            + "Where (p.category_id = ?) and (t.tour_id != ?)\r\n"
            + "group by t.tour_id , p.name)\r\n"
            + "union\r\n"
            + "(Select t.*, avg(r.rating) Rate From tours p \r\n"
            + "left join review r on t.tour_id = r.tour_id\r\n"
            + "Where t.category_id != ?\r\n"
            + "group by t.tour_id , p.name)\r\n"
            + "Order by category_id = ? desc, Rate desc", nativeQuery = true)
    List<Tours> findProductSuggest(Long id, Long id2, Long id3, Long id4);

}
