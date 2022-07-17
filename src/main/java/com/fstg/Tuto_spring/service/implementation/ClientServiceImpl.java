package com.fstg.Tuto_spring.service.implementation;

import com.fstg.Tuto_spring.dao.ClientDAO;
import com.fstg.Tuto_spring.dto.ClientRequestDto;
import com.fstg.Tuto_spring.dto.ClientResponseDto;
import com.fstg.Tuto_spring.exception.NotFoundExceptionEntity;
import com.fstg.Tuto_spring.models.ClientEntity;
import com.fstg.Tuto_spring.service.facade.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("impl1")
public class ClientServiceImpl implements ClientService {

    @Autowired // crée un constructeur des methode... (c un singleton)
    private ClientDAO clientDAO;
    @Autowired
    private ModelMapper modelMapper;



    //client DAO doit parler avec l'Entité et l'Entité doit etre transformée en ClientResponse
    @Override
    public ClientResponseDto save(ClientRequestDto clientRequest) {

        ClientEntity clientEntity = modelMapper.map(clientRequest,ClientEntity.class);// dans map on met l'objet source d'abord
        ClientEntity saved = clientDAO.save(clientEntity);
        return modelMapper.map(saved,ClientResponseDto.class);
        /*
        ********************EXPLICATION********************************************************
        - Requette du client => transformée en client entité
        - On l'a enregistée dans le clientDAO => celle enregistré est une entité qui s'appelle saved
        - A la fin : ClientEntité saved => transformé en ResponseDTO
         */
    }

    @Override
    public ClientResponseDto findById(int id) {
        ClientEntity clientEntity = clientDAO.findById(id).orElseThrow(()->new NotFoundExceptionEntity("client not found"));
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity = clientDAO.findByNom(nom);
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }
    @Override
    public ClientResponseDto findByPrenom(String prenom){
        ClientEntity clientEntity = clientDAO.findByPrenom(prenom);
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByTelephone(String telephone){
        ClientEntity clientEntity = clientDAO.findByTelephone(telephone);
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public void delete(int id) {
        clientDAO.deleteById(id);// appartient aux methodes de clientDAO
        ClientEntity clientEntity = clientDAO.findById(id).get();
        clientDAO.delete(clientEntity);
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequest, int id) throws FileNotFoundException {
        Optional<ClientEntity> clientEntityOptional = clientDAO.findById(id);
        if(clientEntityOptional.isPresent()){
            ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
            clientEntity.setId(id);
            ClientEntity updated = clientDAO.save(clientEntity);
            return modelMapper.map(updated,ClientResponseDto.class);
        } else {
            throw new NotFoundExceptionEntity("Client Not Found");
        }
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDAO.findAll().stream()
                .map(el->modelMapper.map(el, ClientResponseDto.class))
                .collect(Collectors.toList());
    }
}
