package com.angelalfaro.kinalapp.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angelalfaro.kinalapp.entity.DetailSale;

@Repository
public interface DetailSaleRepository extends JpaRepository<DetailSale,Long> {
    
    Slice<DetailSale> findByStateDetailSale(int state, Pageable pageable);

    Slice<DetailSale> findByProductDetailProductCodeProduct(Long codeProduct, Pageable pageable);

    Slice<DetailSale> findBySaleDetailSaleCodeSale(Long codeSale, Pageable pageable);

}
