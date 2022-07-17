package com.fstg.Tuto_spring.models;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ligne_facture")
@ToString
public class LigneFactureEntity implements Serializable {

    @EmbeddedId
    private LigneFactureKey id; // clé primaire

    @ManyToOne
    @MapsId("factureId")
    @JoinColumn(name = "facture_id")
    private FactureEntity facture;
    //facture est une partie de la clé primaire et est une clé etrangere d'une relation "ManyToMany"

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private double quantity;
}
