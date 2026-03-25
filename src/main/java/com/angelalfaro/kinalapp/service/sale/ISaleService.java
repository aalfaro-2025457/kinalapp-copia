package com.angelalfaro.kinalapp.service.sale;


import com.angelalfaro.kinalapp.entity.Sale;

import java.util.List;
import java.util.Optional;

public interface ISaleService {

    /*
    * Method to list all the Sales in the DB
    * */
    List<Sale> listAllSales();

    /*
    * Method to list all the Sales by the given state
    * */
    List<Sale> listAllByState(int state);

    /*
    * This method will save the given Sale in th DB
    * */
    Sale saveSale(Sale sale);

    /*
    * Method to find a Sale by the codeSale
    * */
    Optional<Sale> findByCodeSale(Long codeSale);

    /*
    * Method to update an existant Sale
    * */
    Sale updateSale(Long codeSale, Sale sale);

    /*
    * This method will be used to delete an existant Sale by the codeSale
    * */
    void deleteSale(Long codeSale);

    /*
    * return true if one Sale exists by the given codeSale
    * */
    boolean existsByCodeSale(Long codeSale);

}
