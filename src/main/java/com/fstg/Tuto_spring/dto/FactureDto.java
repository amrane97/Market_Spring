package com.fstg.Tuto_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureDto {

    @NotBlank
    int id;

    @NotBlank
    String ref;

    @NotBlank
    Date date;
}
