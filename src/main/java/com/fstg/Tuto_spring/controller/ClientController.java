package com.fstg.Tuto_spring.controller;

import com.fstg.Tuto_spring.dto.ClientRequestDto;
import com.fstg.Tuto_spring.dto.ClientResponseDto;
import com.fstg.Tuto_spring.service.facade.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;

@RestController("impl1")
//@Controller // quand c'est MVC on uttilise controleur sinon Rest Controlleur
//Le controller parle avec service
@RequestMapping("clients")
public class ClientController {

    //On peut faire l'injection avec @Autowired ou bien avec le constructeur
    private ClientService clientService;

    public ClientController (ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("y")
    public ResponseEntity<List<ClientResponseDto>> getClient() {
        //return clientService.findAll() ;
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }


    @PostMapping("") // remarque : la ou il y'a requestDto il y'a un body et une validation
    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody ClientRequestDto requestDto) {
        ClientResponseDto clientResponseDto = clientService.save(requestDto);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.CREATED);
    }


    @GetMapping("/id/{id_client}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable("id_client") int id) {
        ClientResponseDto clientResponseDto = clientService.findById(id);
        return ResponseEntity.ok(clientResponseDto);
    }


    @GetMapping("/nom/{nom}")
    public ResponseEntity<ClientResponseDto> findByNom(@PathVariable("nom") String nom) {
        ClientResponseDto clientResponseDto = clientService.findByNom(nom);
        return ResponseEntity.ok(clientResponseDto);
    }


    @DeleteMapping("/id/{id}")//no problem car meme si on a 2 path qui sont identique mais un a l'annotation get et l'autre delete
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
        // pour no content il faut un build() !
    }


    @PutMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> update(@Valid @RequestBody() ClientRequestDto clientRequest, @PathVariable("id") int id) throws FileNotFoundException{
        ClientResponseDto clientResponseDto = clientService.update(clientRequest,id);
        return ResponseEntity.accepted().body(clientResponseDto);
        // pour le accepted il faut un body(reponse) !
    }


    @GetMapping("/prenom/{prenom}")
    public ClientResponseDto findByPrenom(@PathVariable("prenom") String prenom) {
        return clientService.findByPrenom(prenom);
    }


    //@GetMapping("/telephone/{telephone}")
    @RequestMapping(path="/telephone/{telephone}",method = RequestMethod.GET)
    public ClientResponseDto findByTelephone(@PathVariable("telephone") String telephone) {
        return clientService.findByTelephone(telephone);
    }


}
