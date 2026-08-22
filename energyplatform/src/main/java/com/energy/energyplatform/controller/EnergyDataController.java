package com.energy.energyplatform.controller;

import com.energy.energyplatform.model.EnergyData;
import com.energy.energyplatform.repository.EnergyDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/energy")
@CrossOrigin(origins = "*")
public class EnergyDataController {

        @Autowired
        private EnergyDataRepository repository;

        @PostMapping("/add")
        public Map<String, Object> addEnergyData(
                        @RequestBody EnergyData energyData) {

                // Save to PostgreSQL
                EnergyData savedData = repository.save(energyData);

                Map<String, Object> response = new HashMap<>();
                response.put("saved_data", savedData);
                response.put("message", "Energy data saved successfully");

                return response;
        }

        @GetMapping("/all")
        public List<EnergyData> getAllData() {
                return repository.findAll();
        }
}