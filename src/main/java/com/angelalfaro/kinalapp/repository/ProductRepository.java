package com.angelalfaro.kinalapp.repository;

import com.angelalfaro.kinalapp.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Slice<Product> findByStateProduct(int state, Pageable pageable);
}
