package com.angelalfaro.kinalapp.repository;

import java.util.UUID;

import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angelalfaro.kinalapp.entity.DetailSale;

@Repository
public interface DetailSaleRepository extends JpaRepository<DetailSale,UUID> {
    
    Slice<DetailSale> findByStateDetailSale(int state);

}
