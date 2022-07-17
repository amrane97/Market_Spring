package com.fstg.Tuto_spring.controller;


import com.fstg.Tuto_spring.dao.ProductDAO;
import com.fstg.Tuto_spring.dto.ProductDto;
import com.fstg.Tuto_spring.service.facade.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("")
    public ProductDto save(@Valid @RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @GetMapping("/reference/{ref}")
    public ProductDto findByRef(@PathVariable("ref") String ref) {
        return productService.findProductByRef(ref);
    }

    @GetMapping("/id/{id}")
    public ProductDto findProductById(@PathVariable("id") int id) {
        return productService.findProductById(id);
    }

    @GetMapping("/prix/{prix}")
    public ProductDto findProductByPrix(@PathVariable("prix") int prix) {
        return productService.findProductByPrix(prix);
    }

    @GetMapping("/libelle/{libelle}")
    public ProductDto findProductByLibelle(@PathVariable("libelle") String libelle) {
        return productService.findProductByLibelle(libelle);
    }

    @GetMapping("all")
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable("id") int id){
        productService.delete(id);
    }

    @PutMapping("")
    public ProductDto update(@Valid @RequestBody ProductDto productDto, int id){
        return productService.update(productDto, id);
    }






}
