package com.express.repository;

import com.express.model.entities.ShipperDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperDetailsRepository extends JpaRepository<ShipperDetails, Integer> {
}
