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

import com.angelalfaro.kinalapp.entity.Sale;
import com.angelalfaro.kinalapp.service.sale.SaleServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sales")
public class SaleController {
    
    private final SaleServiceImpl saleService;

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {

        List<Sale> sales = saleService.listAllSales();

        return ResponseEntity.ok(sales);
    }

    //Get all the sales by the state
    //Example.
    //if a sale is banned state = 6
    //if a sale is inactive state = 3 ...
    //etc
    @GetMapping("/state/{state}")
    public ResponseEntity<List<Sale>> getAllSalesByState(@PathVariable(name = "state") int state) {

        List<Sale> salesState = saleService.listAllByState(state);

        return ResponseEntity.ok(salesState);
    }

    @GetMapping("/{codeSale}")
    public ResponseEntity<Sale> getSaleByCode(@PathVariable(name = "codeSale") Long codeSale) {
        return saleService.findByCodeSale(codeSale)
                //If Optional has a value, return status 200 ok with the sale
                // :: call a method of a class
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> saveSale(@RequestBody Sale sale) {
        
        try {

            Sale s = saleService.saveSale(sale);

            return new ResponseEntity<>(s, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{codeSale}")
    public ResponseEntity<Sale> deleteSale(@PathVariable(name = "codeSale") Long codeSale) {
        try {

            if (!saleService.existsByCodeSale(codeSale)){
                return ResponseEntity.notFound().build();
            }

            saleService.deleteSale(codeSale);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{codeSale}")
    public ResponseEntity<?> updateSale(@PathVariable(name = "codeSale") Long codeSale,
            @RequestBody Sale sale) {
                
        try {
            if (!saleService.existsByCodeSale(codeSale)){
                return ResponseEntity.notFound().build();
            }

            Sale updSale = saleService.updateSale(codeSale,sale);

            return ResponseEntity.ok(updSale);


        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
