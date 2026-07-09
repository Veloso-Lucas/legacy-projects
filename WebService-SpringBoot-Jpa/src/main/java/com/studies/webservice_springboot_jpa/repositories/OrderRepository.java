package com.studies.webservice_springboot_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.webservice_springboot_jpa.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
