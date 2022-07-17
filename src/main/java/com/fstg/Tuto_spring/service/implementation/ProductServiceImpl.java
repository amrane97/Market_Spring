package com.fstg.Tuto_spring.service.implementation;

import com.fstg.Tuto_spring.dao.ProductDAO;
import com.fstg.Tuto_spring.dto.ProductDto;
import com.fstg.Tuto_spring.models.ProductEntity;
import com.fstg.Tuto_spring.service.facade.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProductDto findProductById(int id) {
        ProductEntity productEntity = productDAO.findProductById(id);
        return modelMapper.map(productEntity,ProductDto.class);
    }

    @Override
    public ProductDto findProductByLibelle(String libelle) { // pour Optionnal ici il faut obligatoirement faire le orElseThrow()
        ProductEntity productEntity = productDAO.findProductByLibelle(libelle).orElse(null);

        if (productEntity == null) return null;

        else return modelMapper.map(productEntity, ProductDto.class);
    }

    @Override
    public ProductDto findProductByRef(String ref) {
        ProductEntity productEntity = productDAO.findProductByRef(ref);
        return modelMapper.map(productEntity,ProductDto.class);
    }

    @Override
    public ProductDto findProductByPrix(int prix) {
        ProductEntity productEntity = productDAO.findProductByPrix(prix).orElse(null);

        if (productEntity == null) return null;

        return modelMapper.map(productEntity, ProductDto.class);
    }

    @Override
    public ProductDto save(ProductDto productDto) {

        if (productDto.getRef() == null) return null;

        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        ProductEntity saved = productDAO.save(productEntity);
        return modelMapper.map(saved, ProductDto.class);
    }

    @Override
    public void delete(int id) {
        productDAO.deleteById(id);
        ProductEntity productEntity = productDAO.findProductById(id);
        productDAO.delete(productEntity);
    }

    @Override
    public ProductDto update(ProductDto productDto, int id) {
        Optional<ProductEntity> optionalProductEntity = productDAO.findById(id);
        if (optionalProductEntity.isPresent()) {
            ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
            ProductEntity updated = productDAO.save(productEntity);
            return modelMapper.map(updated, ProductDto.class);
        }
        else{
            return null; // <-- exception
        }
    }

    @Override
    public List<ProductDto> findAll() {
        return productDAO.findAll().stream()
                .map(el -> modelMapper.map(productDAO, ProductDto.class))
                .collect(Collectors.toList());
    }
}
