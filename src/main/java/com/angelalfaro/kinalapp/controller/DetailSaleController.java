package com.angelalfaro.kinalapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angelalfaro.kinalapp.entity.DetailSale;
import com.angelalfaro.kinalapp.service.detailSale.DetailSaleServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("detail-sales")
public class DetailSaleController {
    
    private final DetailSaleServiceImpl detailSaleService;

    @GetMapping
    public ResponseEntity<List<DetailSale>> getAllDetailSales() {

        List<DetailSale> detailSales = detailSaleService.listAllDetailSale();

        return ResponseEntity.ok(detailSales);
    }

    //Get all the users by the detailSales
    //Example.
    //if a user is banned state = 6
    //if a user is inactive state = 3 ...
    //etc
    @GetMapping("/state/{state}")
    public ResponseEntity<List<DetailSale>> getAllDetailSalesByState(
        @PathVariable(name = "state") int state) {

        List<DetailSale> detailSalesState = detailSaleService.listAllByState(state);

        return ResponseEntity.ok(detailSalesState);
    }

    @GetMapping("/{codeDetailSale}")
    public ResponseEntity<DetailSale> getDetailSaleByCode(
        @PathVariable(name = "codeDetailSale") Long codeDetailSale) {
        return detailSaleService.findByCodeDetailSale(codeDetailSale)
                //If Optional has a value, return status 200 ok with the detailSale
                // :: call a method of a class
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> saveDetailSale(@RequestBody DetailSale detailSale) {
        
        try {

            DetailSale dS = detailSaleService.saveDetailSale(detailSale);

            return new ResponseEntity<>(dS, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{codeDetailSale}")
    public ResponseEntity<DetailSale> deleteDetailSale(
        @PathVariable(name = "codeDetailSale") Long codeDetailSale) {
        try {

            if (!detailSaleService.existsByCodeDetailSale(codeDetailSale)){
                return ResponseEntity.notFound().build();
            }

            detailSaleService.deleteDetailSale(codeDetailSale);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{codeDetailSale}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "codeDetailSale") Long codeDetailSale,
            @RequestBody DetailSale detailSale) {
                
        try {
            if (!detailSaleService.existsByCodeDetailSale(codeDetailSale)){
                return ResponseEntity.notFound().build();
            }

            DetailSale updDetailSale = detailSaleService.updateDetailSale(codeDetailSale,detailSale);

            return ResponseEntity.ok(updDetailSale);


        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
