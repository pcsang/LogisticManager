package com.express.repository;

import com.express.model.DeliveryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryServiceRepository extends JpaRepository<DeliveryService, String> {
}
