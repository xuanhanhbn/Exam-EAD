package com.example.EAD.controller;

import com.example.EAD.entity.SaleEntity;
import com.example.EAD.service.ProductService;
import com.example.EAD.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "sales")
public class SaleController {
    @Autowired
    SaleService saleService;

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String viewIndexPage(Model model,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<SaleEntity> categoryPage = saleService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("sales", categoryPage);
        int totalPages = categoryPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "sale";
    }

    @GetMapping("/new")
    public String viewCreatePage(Model model) {
        model.addAttribute("sale", new SaleEntity());
        model.addAttribute("products", productService.getAllProduct());
        return "create_or_edit_sale";
    }

    @GetMapping("/edit/{id}")
    public String viewEditPage(Model model, @PathVariable Long id) {
        model.addAttribute("sale", saleService.getSaleByID(id));
        model.addAttribute("products", productService.getAllProduct());
        return "create_or_edit_sale";
    }

    @PostMapping("/save")
    public String save(SaleEntity sale) {
        if (sale.getId() > 0) {
            saleService.updateSale(sale);
        } else {
            saleService.createSale(sale);
        }
        return "redirect:/sale";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        saleService.deleteSale(id);
        return "redirect:/sale";
    }
}
