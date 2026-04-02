package cz.luky.wlg.controller;

import cz.luky.wlg.model.PlantAction;
import cz.luky.wlg.service.PlantActionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlantActionController {

    private final PlantActionService plantActionService;

    public PlantActionController (PlantActionService plantActionService) {
        this.plantActionService = plantActionService;
    }

    @GetMapping("/plantaction/{plantId}")
    public List<PlantAction> getActionsForPlant(@PathVariable Long plantId) {

        return plantActionService.getActionsForPlant(plantId);
    }
}
