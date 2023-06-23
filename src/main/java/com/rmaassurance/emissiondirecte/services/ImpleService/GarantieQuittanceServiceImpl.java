package com.rmaassurance.emissiondirecte.services.ImpleService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmaassurance.emissiondirecte.entities.MyEntity;
import com.rmaassurance.emissiondirecte.entities.QtcDetailquittanceEntity;
import com.rmaassurance.emissiondirecte.entities.QtcQuittanceEntity;
import com.rmaassurance.emissiondirecte.mapper.DetailQuittanceGarantie;
import com.rmaassurance.emissiondirecte.repositories.QtcDetailQuittanceRepository;
import com.rmaassurance.emissiondirecte.services.Iservice.IGarantieQuittanceService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GarantieQuittanceServiceImpl implements IGarantieQuittanceService {

    private final QtcDetailQuittanceRepository qtcDetailQuittanceRepository;
    private final DetailQuittanceGarantie mapper;

    public GarantieQuittanceServiceImpl(QtcDetailQuittanceRepository qtcDetailQuittanceRepository, DetailQuittanceGarantie mapper) {
        this.qtcDetailQuittanceRepository = qtcDetailQuittanceRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveqtcDetail(List<String> jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<QtcDetailquittanceEntity> entities = objectMapper.readValue(jsonData.get(0), new TypeReference<List<QtcDetailquittanceEntity>>() {});
            for (QtcDetailquittanceEntity entity : entities) {
                System.out.println(entity); // Print each object from the JSON
            }
         //   qtcDetailQuittanceRepository.saveAll(entities);
        } catch (IOException e) {
            // Handle the exception or log an error
            throw new RuntimeException("Failed to parse JSON data.", e);
        }
        System.out.println();
    }



    public void saveEntities2(List<String> jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            QtcQuittanceEntity quittance =new QtcQuittanceEntity();

            for (String json : jsonData) {
                MyEntity entity = objectMapper.readValue(json, MyEntity.class);
                System.out.println(entity);

              //  System.out.println("entity.getId() "+ entity.getId());
//                System.out.println("entity.getId() "+ json[2].toString());

           /*     quittance.setPrimenette(quittance.getPrimenette()+entity.getPrimenette());
                quittance.setTauxtaxe(quittance.getTauxtaxe()+entity.getTauxtaxe());
                quittance.setMontantaccessoire(quittance.getMontantaccessoire()+entity.getMontantaccessoire());
                quittance.setTauxcommission(quittance.getTauxcommission()+entity.getTauxcommission());
                quittance.setMontantcommision(quittance.getMontantcommision()+entity.getMontantcommision());
              //quittance.setTauxPrimeEVE(quittance.getPrimenette()+entity.getPrimenette());
                quittance.setPrimeGareEve(quittance.getPrimeGareEve()+entity.getPrimeGareEve());
                quittance.setTauxTaxeParafiscale(quittance.getTauxTaxeParafiscale()+entity.getTauxTaxeParafiscale());*/




            }
            System.out.println(quittance.toString());
            // myEntityRepository.saveAll(entities);
        } catch (IOException e) {
            // Handle the exception or log an error
            throw new RuntimeException("Failed to parse JSON data.", e);
        }
    }

    public void saveEntities(List<String> jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (String json : jsonData) {
              //  MyEntity entity = mapper.mapJsonToEntity(json);
                MyEntity entity = objectMapper.readValue(json, MyEntity.class);
                System.out.println("cha cha"+entity);
                System.out.println(entity.getTaxe());

                // Save the entity to the repository
                // myEntityRepository.save(entity);
            }
        } catch (Exception e) {
            // Handle the exception or log an error
            throw new RuntimeException("Failed to parse JSON data.", e);
        }
    }


}
