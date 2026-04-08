package cz.luky.wlg.service;

import cz.luky.wlg.dto.PlantDto;
import cz.luky.wlg.mapper.PlantMapper;
import cz.luky.wlg.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<PlantDto> getAllPlants() {

        return plantRepository.findAll()
                .stream()
                .map(PlantMapper::toDto)
                .toList();
    }

    public List<PlantDto> getPlantById(Long plantId) {

        return plantRepository.findById(plantId).map(PlantMapper::toDto).stream().toList();
    }
}
