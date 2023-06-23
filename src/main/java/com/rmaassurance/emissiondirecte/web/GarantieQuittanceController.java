package com.rmaassurance.emissiondirecte.web;

import com.rmaassurance.emissiondirecte.services.ImpleService.GarantieQuittanceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garantie-quittance")
@CrossOrigin
public class GarantieQuittanceController {
    private final GarantieQuittanceServiceImpl garantieQuittanceService;

    public GarantieQuittanceController(GarantieQuittanceServiceImpl garantieQuittanceService) {
        this.garantieQuittanceService = garantieQuittanceService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEntitdies(@RequestBody List<String> jsonData) {
        try {
            garantieQuittanceService.saveqtcDetail(jsonData);
            return ResponseEntity.ok("Entities saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save entities.");
        }
    }

    @PostMapping("/entities")
    public ResponseEntity<String> saveEntities(@RequestBody List<String> jsonData) {

            garantieQuittanceService.saveEntities(jsonData);
            return ResponseEntity.ok("Entities saved successfully");

    }
}
