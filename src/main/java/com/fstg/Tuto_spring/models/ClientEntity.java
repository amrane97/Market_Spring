package com.fstg.Tuto_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity // entity veut dire elle peut etre une table dans la base de données
@Table(name = "clients")
@Data // data de lombock elle nous fait les setters et getters
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements Serializable {

    @Id // faire attention java persistence
    @GeneratedValue(strategy = GenerationType.AUTO)// pour auto incrementer l'ID par defaut c'est auto incrementer
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = true, name = "client_telephone") // nullable par defaut c'est true
    private String tel;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private List<FactureEntity> factures;

}
