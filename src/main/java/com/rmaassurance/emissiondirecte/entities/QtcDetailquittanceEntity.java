package com.rmaassurance.emissiondirecte.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "QTC_DETAILQUITTANCE" )
@JsonIgnoreProperties(ignoreUnknown = true)
public class QtcDetailquittanceEntity {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = true)
    private Long id;
    @Basic
    @Column(name = "IDQUITTANCE", nullable = true)
    private Long idquittance;
    @Basic
    @Column(name = "IDGARANTIE", nullable = true)
    private Long idgarantie;
    @Basic
    @Column(name = "POURCENTAGEGARANTIE", nullable = true)
    private double pourcentagegarantie;
    @Basic
    @Column(name = "PRIMENETTE", nullable = true)
    private double primenette;
    @Basic
    @Column(name = "MONTANTTAXE", nullable = true)
    private double montanttaxe;
    @Basic
    @Column(name = "TAUXCOMMISSION", nullable = true)
    private double tauxcommission;
    @Basic
    @Column(name = "MONTANTCOMMISSION", nullable = true)
    private double montantcommission;
    @Basic
    @Column(name = "TAUXTAXESURCOMMISSION", nullable = true)
    private double tauxtaxesurcommission;
    @Basic
    @Column(name = "MONTANTTAXESURCOMMISSION", nullable = true)
    private double montanttaxesurcommission;
    @Basic
    @Column(name = "MONTANTENCAISE", nullable = true)
    private double montantencaise;
    @Basic
    @Column(name = "MONTANTENCAISSE", nullable = true)
    private double montantencaisse;
    @Basic
    @Column(name = "MONTANTTAXEPARAFISCALE", nullable = true)
    private double montanttaxeparafiscale;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qtcQuittance")
    private QtcQuittanceEntity qtcQuittance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refGarantie")
    private RefGarantieEntity refGarantie;



    @Basic
    @Column(name = "Tauxtaxe", nullable = true)
    private double Tauxtaxe;
    @Basic
    @Column(name = "Montantaccessoire", nullable = true)
    private double Montantaccessoire;
    @Basic
    @Column(name = "Montantcommision", nullable = true)
    private double Montantcommision;
    @Basic
    @Column(name = "PrimeGareEve", nullable = true)
    private double PrimeGareEve;
    @Basic
    @Column(name = "TauxTaxeParafiscale", nullable = true)
    private double TauxTaxeParafiscale;

}
