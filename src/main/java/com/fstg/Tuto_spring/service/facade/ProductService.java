package com.fstg.Tuto_spring.service.facade;


import com.fstg.Tuto_spring.dto.ClientRequestDto;
import com.fstg.Tuto_spring.dto.ClientResponseDto;
import com.fstg.Tuto_spring.dto.ProductDto;
import com.fstg.Tuto_spring.models.ProductEntity;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProductService {

    ProductDto findProductById(int id);

    ProductDto findProductByLibelle(String libelle);

    ProductDto findProductByRef(String ref);

    ProductDto findProductByPrix(int prix);

    ProductDto save( ProductDto productDto);

    void delete (int id);

    ProductDto update(ProductDto productDto, int id);

    List<ProductDto> findAll();
}
