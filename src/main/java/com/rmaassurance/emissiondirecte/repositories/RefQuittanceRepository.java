package com.rmaassurance.emissiondirecte.repositories;

import com.rmaassurance.emissiondirecte.entities.RefQuittanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RefQuittanceRepository extends JpaRepository<RefQuittanceEntity, Long> {
    List<RefQuittanceEntity>  findAll();
    @Query(value = "SELECT * FROM Ref_Quittance WHERE id = 1", nativeQuery = true)
    RefQuittanceEntity findByIdentifiant(Long id);
}
