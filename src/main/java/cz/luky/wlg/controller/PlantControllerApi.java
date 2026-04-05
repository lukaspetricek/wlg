package cz.luky.wlg.controller;

import cz.luky.wlg.model.Plant;
import cz.luky.wlg.model.PlantAction;
import cz.luky.wlg.service.PlantActionService;
import cz.luky.wlg.service.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class PlantControllerApi {

    private final PlantService plantService;
    private final PlantActionService plantActionService;


    public PlantControllerApi(PlantService plantService, PlantActionService plantActionService) {
        this.plantService = plantService;
        this.plantActionService = plantActionService;
    }

    @GetMapping("/plants")
    public List<Plant> getAllPlants() {

        return plantService.getAllPlants();
    }

    @GetMapping("/plants/{plantID}")
    public Optional<Plant> getPlant(Long id) {

        return plantService.getPlantById(id);
    }

    @GetMapping("/plants/{plantId}/actions")
    public List<PlantAction> getActionsForPlant(@PathVariable Long plantId) {

        return plantActionService.getActionsForPlant(plantId);
    }
    
    @GetMapping("/plant-actions")
    public List<PlantAction> getActionsForPlants(@RequestParam(defaultValue = "1, 2, 3") List<Long> plantIds) {

        return plantActionService.getActionsForPlants(plantIds);
    }
}
