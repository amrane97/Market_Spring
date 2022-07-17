package com.fstg.Tuto_spring.service.facade;

import com.fstg.Tuto_spring.dto.ClientRequestDto;
import com.fstg.Tuto_spring.dto.ClientResponseDto;

import java.io.FileNotFoundException;
import java.util.List;

public interface ClientService {
    ClientResponseDto save(ClientRequestDto clientRequest);

    ClientResponseDto findById(int id);

    ClientResponseDto findByNom(String nom);

    ClientResponseDto findByPrenom(String prenom);

    ClientResponseDto findByTelephone(String telephone);

    void delete (int id);

    ClientResponseDto update(ClientRequestDto clientRequest, int id) throws FileNotFoundException;

    List<ClientResponseDto> findAll();
}
