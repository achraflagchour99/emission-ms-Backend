package com.rmaassurance.emissiondirecte.repositories;

import com.rmaassurance.emissiondirecte.entities.PoliceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

@RepositoryRestResource
@Component
public interface PoliceEntityRepository extends JpaRepository<PoliceEntity, Long>, JpaSpecificationExecutor<PoliceEntity> {
   PoliceEntity findByCodePolice(String codePolice);
}
