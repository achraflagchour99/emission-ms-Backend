package com.rmaassurance.emissiondirecte.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "POLICE", schema = "CONVERGPARAM")
public class PoliceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String codePolice;
    @NotNull
    private Long numClient ;
    @NotNull
    private String raisonSociale ;
    @NotNull
    private String adresse ;

    private Calendar dateEffet;

    private Calendar dateEcheance;

    private Double primeNette;
    private Double taxe ;
    private Double acce ;
    private Double tauxComm ;
    private Calendar dateTerme ;
    private  Calendar dateEtat;
    private Double nbrtete ;
    private Double revenueAnnuel ;
    private Double dureeS ;
    private Double ff ;
    private Double mnt_taxe_eve ;
    private Double mnt_taxe_parafiscale ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quittance_id")
    private QtcQuittanceEntity quittance;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ville_id")
    private RefVilleEntity refVille;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RefPolice_ID")
    private RefPoliceEntity refPolice;

    private String terme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Periodicite_id")
    private PeriodiciteEntity periodicite;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Prd_VersionCommerciale_id")
    private PrdVersioncommercialeEntity prdVersioncommerciale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intermediaire_id")
    private IntermediaireEntity intermediaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habUtilisateur")
    private HabUtilisateurEntity habUtilisateur;



}
