package com.fstg.Tuto_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto { //Data to object c'est tout ce dont a besoin le client

    @NotBlank
    private String libelle;

    @NotBlank
    private int Prix;

    @NotBlank
    private String ref;

    @NotBlank
    private int quantiteEnStock;

}
