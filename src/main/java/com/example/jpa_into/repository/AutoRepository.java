package com.example.jpa_into.repository;

import com.example.jpa_into.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository                           //JpaRepository<Model,TypKlucza>
public interface AutoRepository extends JpaRepository<Auto, Integer> {
    List<Auto> findAllByPriceBetween(double priceLow, double priceHigh);
    List<Auto> findAllByBrandLike(String pattern);
    List<Auto> findAllByBrandLikeAndPriceBetween(String pattern, double low, double high);

}
