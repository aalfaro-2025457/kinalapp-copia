package com.angelalfaro.kinalapp.repository;

import com.angelalfaro.kinalapp.entity.Sale;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    Slice<Sale> findByStateSale(int state, Pageable pageable);

    Slice<Sale> findByClientSaleDPIClient(String clientDPI, Pageable pageable);

    Slice<Sale> findByUserSalecodeUser(String codeUser, Pageable pageable);

}
