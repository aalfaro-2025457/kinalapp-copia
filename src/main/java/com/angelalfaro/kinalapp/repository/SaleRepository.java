package com.angelalfaro.kinalapp.repository;

import com.angelalfaro.kinalapp.entity.Sale;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    Slice<Sale> findByStateSale(int state);

}
