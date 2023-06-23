package com.rmaassurance.emissiondirecte.dtos.request;

import com.rmaassurance.emissiondirecte.entities.IntermediaireEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoliceDTO {
    private Long id;
    private String codePolice;
    private Long numClient ;
    private String raisonSociale ;
    private String adresse ;
    private Calendar dateEffet;
    private Double primeNette;
    private Double taxe ;
    private Double acce ;
    private Double tauxComm ;
    private Calendar dateTerme ;
    private  Calendar dateEtat;
    private Double mnt_taxe_eve ;
    private Double mnt_taxe_parafiscale ;
    private PrdVersioncommercialeDTO prdVersioncommerciale;
    private RefVilleDTO refVille;
    private RefPoliceDTO refPolice;
    private String terme;
    private PeriodiciteDTO periodicite;
    private Calendar dateEcheance;
    private IntermediaireDTO intermediaire;
}
