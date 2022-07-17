package com.fstg.Tuto_spring.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factures")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactureEntity implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false, name = "date_creation_facture")
    private Date date;

    @ManyToOne
    private ClientEntity client;

    @OneToMany(mappedBy = "facture", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneFactureEntity> factureEntities;
}
