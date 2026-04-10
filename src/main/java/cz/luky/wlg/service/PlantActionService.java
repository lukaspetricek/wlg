package cz.luky.wlg.service;

import cz.luky.wlg.model.PlantAction;
import cz.luky.wlg.repository.PlantActionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantActionService {

    private final PlantActionRepository plantActionRepository;

    public PlantActionService (PlantActionRepository plantActionRepository) {
        this.plantActionRepository = plantActionRepository;
    }

    public List<PlantAction> getActionsForPlant(Long plantId) {

        if (plantId == null || plantId == 0) {
            throw new IllegalArgumentException("Neplatné plant ID: " + plantId);
        }

        return plantActionRepository.findByPlantId(plantId);
    }

    public List<PlantAction> getActionsForPlants(List<Long> plantIds) {

        if (plantIds == null || plantIds.isEmpty()) {
            return List.of();
        }

        return plantActionRepository.findByPlantIds(plantIds);
    }
}
