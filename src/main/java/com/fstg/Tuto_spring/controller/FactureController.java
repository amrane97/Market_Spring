package com.fstg.Tuto_spring.controller;


import com.fstg.Tuto_spring.dto.FactureDto;
import com.fstg.Tuto_spring.service.facade.FactureService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController // un controleur permet de lié une classe aux protocoles http
@RequestMapping // permet de dire si une methode ajoute une ressource ou supprime...
public class FactureController {


    private FactureService factureService;


    @GetMapping("/ref/{ref}")
    public FactureDto findByRef(@PathVariable("ref") String ref) {
        return factureService.findByRef(ref);
    }

    @GetMapping("/date/{date}")
    public FactureDto findByDate(@PathVariable("date") Date date) {
        return factureService.findByDate(date);
    }

    @PostMapping("")
    public FactureDto save(@Valid @RequestBody FactureDto factureDto) {
        return factureService.save(factureDto);
    }

    @PutMapping("")
    public FactureDto update(@Valid @RequestBody FactureDto factureDto, int id, String ref, Date date) {
        return factureService.update(factureDto, id, ref, date);
    }

    @GetMapping("/all/{listFacture}")
    public List<FactureDto> findAll(@PathVariable("listFacture") FactureDto factureDto) {
        return factureService.findAll(factureDto);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable("id") int id) {
        factureService.delete(id);
    }
}
