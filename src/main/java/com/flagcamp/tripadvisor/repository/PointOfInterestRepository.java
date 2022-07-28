package com.flagcamp.tripadvisor.repository;

import com.flagcamp.tripadvisor.model.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {
    PointOfInterest findByCurId(Long Id);
}

