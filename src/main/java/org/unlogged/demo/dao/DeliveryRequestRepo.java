package org.unlogged.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unlogged.demo.models.DeliveryRequest;

public interface DeliveryRequestRepo extends JpaRepository<DeliveryRequest, Long> {
}
