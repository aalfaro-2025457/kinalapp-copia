package com.angelalfaro.kinalapp.service.detailSale;

import com.angelalfaro.kinalapp.entity.DetailSale;

import java.util.List;
import java.util.Optional;

public interface IDetailSaleService {

    /*
    * Method to lis all the DetailSale
    * */
    List<DetailSale> listAllDetailSale();

    /*
    * List all the DetailSale by the given state
    * */
    List<DetailSale> listAllByState(int state);

    /*
    * Save the given DetailSale in the DB
    * */
    DetailSale saveDetailSale(DetailSale detailSale);

    /*
    * Find an existant DetailSale with the given codeDetailSale in the DB
    * */
    Optional<DetailSale> findByCodeDetailSale(Long codeDetailSale);

    /*
    * Method to update an existant Detail sale with the given codeSale
    * */
    DetailSale updateDetailSale(Long codeDetailSale, DetailSale detailSale);

    /*
    * Method to delete an existant DetailSale in the DB
    * */
    void deleteDetailSale(Long codeDetailSale);

    /*
    * Return true if one DetailSale exists by the given codeDetailSale
    * */
    boolean existsByCodeDetailSale(Long codeDetailSale);

}
