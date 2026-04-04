package cz.luky.wlg.controller;

import cz.luky.wlg.model.PlantAction;
import cz.luky.wlg.service.PlantActionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantActionControllerApi {

    private final PlantActionService plantActionService;

    public PlantActionControllerApi (PlantActionService plantActionService) {
        this.plantActionService = plantActionService;
    }

    @GetMapping("/{plantId}/actions")
    public List<PlantAction> getActionsForPlant(@PathVariable Long plantId) {

        return plantActionService.getActionsForPlant(plantId);
    }

    //TODO cleanup
    @GetMapping("/plant-actions")
    public List<PlantAction> getActionsForPlants(@RequestParam(defaultValue = "1, 2, 3") List<Long> plantIds) {

        return plantActionService.getActionsForPlants(plantIds);
    }
}
