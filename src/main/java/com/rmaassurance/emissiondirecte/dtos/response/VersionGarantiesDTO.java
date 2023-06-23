package com.rmaassurance.emissiondirecte.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersionGarantiesDTO {
    private Long id;
    private String libelle;
    private Double taux;

}
