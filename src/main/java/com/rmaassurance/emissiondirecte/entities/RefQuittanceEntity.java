package com.rmaassurance.emissiondirecte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ref_Quittance" )
public class RefQuittanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "etat_Quittance", nullable = false)
   private String etatQuittance;

    @OneToMany(mappedBy = "refQuittance")
    private List<QtcQuittanceEntity> qtcQuittance;

}
