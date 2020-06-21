package com.example.jpa_into.repository;

import com.example.jpa_into.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                           //JpaRepository<Model,TypKlucza>
public interface AutoRepository extends JpaRepository<Auto, Integer> {
}
