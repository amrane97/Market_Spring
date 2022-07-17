package com.fstg.Tuto_spring.dto;


import com.fstg.Tuto_spring.annotation.IpAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

   //@NotNull(message = "le nom est obligatoire")
    //@Size(min = 2, max = 20, message = "le nombre de charactere compris entre 6 et 20")
    @NotBlank
    @Size(min = 2, message = "minimum 2 charactere !")
    @Size(max = 20, message = "maximum charactere autorisé 20 ! ")
    private String nom;

    //@NotNull(message = "le prenom est obligatoire")
    //@Size(min = 2, max = 20, message = "le nombre de charactere compris entre 6 et 20")
    @NotBlank
    @Size(min = 2, message = "minimum 2 charactere !")
    @Size(max = 20, message = "maximum charactere autorisé 20 ! ")
    private String prenom;

    @NotNull
    @Pattern(regexp = "^(\\+213|0)([ \\-_/]*)(\\d[ \\-_/]*){9}$", message = "format invalide")
    private String telephone;

    @IpAddress()
    private String ip;
}
