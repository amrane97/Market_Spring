package com.fstg.Tuto_spring.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {


    @Id
    private int id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false)
    private int prix;

    @Column(nullable = false)
    private double quantiteEnStock;

    @OneToMany(mappedBy = "product") //hibernate lien entre les tables...Etc
    private List<LigneFactureEntity> factureEntities;

}
