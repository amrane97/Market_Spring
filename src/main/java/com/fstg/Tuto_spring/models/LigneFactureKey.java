package com.fstg.Tuto_spring.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LigneFactureKey implements Serializable {


    @Column(name = "product_id")
    private int productId;

    @Column(name = "facture_id")
    private int factureId;
}
