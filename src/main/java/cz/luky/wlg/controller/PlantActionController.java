package cz.luky.wlg.controller;

import cz.luky.wlg.service.PlantActionService;
import cz.luky.wlg.service.PlantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlantActionController {

    private final PlantActionService plantActionService;

    private final PlantService plantService;

    public PlantActionController(PlantService plantService, PlantActionService plantActionService) {
        this.plantService = plantService;
        this.plantActionService = plantActionService;
    }

    @GetMapping("/plantactions/{plantId}")
    public String getActionsForPlant(@PathVariable Long plantId, Model model) {

        model.addAttribute(plantActionService.getActionsForPlant(plantId));

        return "plant-actions";
    }

    @GetMapping("/plants/{plantId}")
    public String getPlant(@PathVariable Long plantId, Model model) {

        model.addAttribute("plantDtos", plantService.getPlantById(plantId));

        //todo fix this, add jte template with detail for 1 plant
        return "plants";
    }

    @GetMapping("/plants")
    public String getPlants(Model model) {

        model.addAttribute("plantDtos", plantService.getAllPlants());

        return "plants";
    }
}
