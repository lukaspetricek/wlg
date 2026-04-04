package cz.luky.wlg.controller;

import cz.luky.wlg.model.PlantAction;
import cz.luky.wlg.service.PlantActionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlantActionControllerApi {

    private final PlantActionService plantActionService;

    public PlantActionControllerApi (PlantActionService plantActionService) {
        this.plantActionService = plantActionService;
    }

    @GetMapping("/plantaction/{plantId}")
    public List<PlantAction> getActionsForPlant(@PathVariable Long plantId) {

        return plantActionService.getActionsForPlant(plantId);
    }

    //TODO cleanup
    @GetMapping("/plantactionall/{plantId}")
    public List<PlantAction> getActionsForPlants(@PathVariable Long plantId) {

        List<Long> ids = List.of(1L,2L,3L);

        return plantActionService.getActionsForPlants(ids);
    }
}
