package com.rmaassurance.emissiondirecte.services.ImpleService;


import com.rmaassurance.emissiondirecte.dtos.request.PoliceSearchCriteriaDTO;
import com.rmaassurance.emissiondirecte.dtos.request.PrdVersioncommercialeDTO;
import com.rmaassurance.emissiondirecte.dtos.request.RefVilleDTO;
import com.rmaassurance.emissiondirecte.entities.PoliceEntity;
import com.rmaassurance.emissiondirecte.mapper.PoliceEntityMapper;
import com.rmaassurance.emissiondirecte.repositories.PoliceEntityRepository;
import com.rmaassurance.emissiondirecte.services.Iservice.IPoliceService;
import com.rmaassurance.emissiondirecte.dtos.request.PoliceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoliceServiceImpl implements IPoliceService {

    private final PoliceEntityRepository policeRepository;
    private final PoliceEntityMapper policeEntityMapper;

    @Autowired
    public PoliceServiceImpl(PoliceEntityRepository policeRepository, PoliceEntityMapper policeEntityMapper) {
        this.policeRepository = policeRepository;
        this.policeEntityMapper = policeEntityMapper;
    }

    @Override
    public PoliceDTO addPolice(PoliceDTO policeDTO) {
       PoliceEntity police = policeEntityMapper.toEntity(policeDTO);
       PoliceEntity savedPolice = policeRepository.save(police);
       return policeEntityMapper.toDto(savedPolice);
    }

    @Override
    public PoliceDTO updatePolice(Long policeId,PoliceDTO policeDTO) {
        PoliceEntity police = policeRepository.findById(policeId).orElseThrow(() -> new RuntimeException("Police not found"));
        policeEntityMapper.partialUpdate(policeDTO, police);
        PoliceEntity updatedPolice = policeRepository.save(police);
        return policeEntityMapper.toDto(updatedPolice);
    }

    @Override
    public List<PoliceDTO> getAllPolices() {
        List<PoliceEntity> polices = policeRepository.findAll();
        return polices.stream()
                .map(policeEntityMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public PoliceDTO getPoliceByCodePolice(String codePolice) {
        PoliceEntity police = policeRepository.findByCodePolice(codePolice);
        return policeEntityMapper.toDto(police);
    }

    @Override
    public Page<PoliceDTO> getPoliceByCriteres(PoliceSearchCriteriaDTO policeSearchCriteriaDTO, int pageNo, int pageSize) {
        Specification<PoliceEntity> policeSpecification = Specification.where(null);
        if (policeSearchCriteriaDTO.getNumClient() != null) {
            policeSpecification = policeSpecification.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("numClient"), policeSearchCriteriaDTO.getNumClient()));
        }
        if (policeSearchCriteriaDTO.getCodePolice() != null) {
            policeSpecification = policeSpecification.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("codePolice"), policeSearchCriteriaDTO.getCodePolice()));
        }
        if (policeSearchCriteriaDTO.getPrdVersioncommerciale() != null) {
            PrdVersioncommercialeDTO prdVersionCommercialeDTO = policeSearchCriteriaDTO.getPrdVersioncommerciale();
            if (prdVersionCommercialeDTO.getNomcommercial() != null) {
                policeSpecification = policeSpecification.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("prdVersioncommerciale").get("nomcommercial"), prdVersionCommercialeDTO.getNomcommercial()));
            }
        }
        if (policeSearchCriteriaDTO.getRefVille() != null) {
            RefVilleDTO refVilleDTO = policeSearchCriteriaDTO.getRefVille();
            if (refVilleDTO.getLibelle() != null) {
                policeSpecification = policeSpecification.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("refVille").get("libelle"), policeSearchCriteriaDTO.getRefVille().getLibelle()));
            }
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<PoliceDTO> policeDTOList = policeRepository.findAll(policeSpecification, pageable)
                .stream()
                .map(policeEntityMapper::toDto)
                .collect(Collectors.toList());

        long count = policeRepository.count(policeSpecification);

        return new PageImpl<>(policeDTOList, pageable, count);


    }
}




