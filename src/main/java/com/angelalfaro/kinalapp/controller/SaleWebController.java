package com.angelalfaro.kinalapp.controller;

import com.angelalfaro.kinalapp.entity.Sale;
import com.angelalfaro.kinalapp.service.sale.SaleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/view/sales")
public class SaleWebController {

    private final SaleServiceImpl saleService;

    @GetMapping
    public String getSales(Model model) {
        model.addAttribute("sales", saleService.listAllSales());
        model.addAttribute("newSale", new Sale());
        return "cruds/sale";
    }

    @PostMapping("/save")
    public String saveSale(@ModelAttribute("newSale") Sale sale) {
        // El service ya maneja la lógica de estado por defecto y validación
        saleService.saveSale(sale);
        return "redirect:/view/sales";
    }

    @GetMapping("/edit/{code}")
    public String editSale(@PathVariable Long code, Model model) {
        Optional<Sale> saleToEdit = saleService.findByCodeSale(code);
        if (saleToEdit.isPresent()) {
            model.addAttribute("sales", saleService.listAllSales());
            model.addAttribute("newSale", saleToEdit.get());
            return "cruds/sales";
        }
        return "redirect:/view/sales";
    }

    @GetMapping("/delete/{code}")
    public String deleteSale(@PathVariable Long code) {
        saleService.deleteSale(code);
        return "redirect:/view/sales";
    }

    @GetMapping("/search")
    public String searchByCode(@RequestParam(name = "codeSearch", required = false) Long codeSearch, Model model) {
        List<Sale> results = new ArrayList<>();
        if (codeSearch != null) {
            saleService.findByCodeSale(codeSearch).ifPresent(results::add);
        } else {
            results = saleService.listAllSales();
        }
        model.addAttribute("sales", results);
        model.addAttribute("newSale", new Sale());
        return "cruds/sales";
    }
}