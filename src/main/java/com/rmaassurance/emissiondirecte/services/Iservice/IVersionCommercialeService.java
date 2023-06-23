package com.rmaassurance.emissiondirecte.services.Iservice;

import com.rmaassurance.emissiondirecte.dtos.request.PrdVersioncommercialeDTO;
import com.rmaassurance.emissiondirecte.dtos.response.VersionGarantiesDTO;

import java.util.List;

public interface IVersionCommercialeService {
    List<PrdVersioncommercialeDTO> getAllVersions();
    List<VersionGarantiesDTO> getGarantiesByVersionsID(String codePolice);
}
