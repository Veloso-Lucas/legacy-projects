package com.studies.webservice_springboot_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studies.webservice_springboot_jpa.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
