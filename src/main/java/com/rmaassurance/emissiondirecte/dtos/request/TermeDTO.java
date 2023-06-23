package com.rmaassurance.emissiondirecte.dtos.request;

import com.rmaassurance.emissiondirecte.entities.PoliceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermeDTO {
    private String terme;
    private List<PoliceEntity> polices;

}
