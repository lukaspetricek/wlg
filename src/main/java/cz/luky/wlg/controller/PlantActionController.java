package cz.luky.wlg.controller;

import cz.luky.wlg.dto.PlantDto;
import cz.luky.wlg.mapper.PlantMapper;
import cz.luky.wlg.model.Plant;
import cz.luky.wlg.model.PlantAction;
import cz.luky.wlg.service.PlantActionService;
import cz.luky.wlg.service.PlantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class PlantActionController {

    private final PlantActionService plantActionService;

    private final PlantService plantService;

    public PlantActionController (PlantService plantService, PlantActionService plantActionService) {
        this.plantService = plantService;
        this.plantActionService = plantActionService;
    }

    @GetMapping("/plantaction/{plantId}")
    public List<PlantAction> getActionsForPlant(@PathVariable Long plantId) {

        return plantActionService.getActionsForPlant(plantId);
    }

    @GetMapping("/plant/{plantId}")
    public String getPlant(@PathVariable Long plantId, Model model) {

        Optional<Plant> plant = plantService.getPlantById(plantId);
        PlantDto plantDto = new PlantDto();
        if (plant.isPresent()) {
            plantDto = PlantMapper.toDto(plant.get());
        }

        model.addAttribute("plantDto", plantDto);

        //todo FIX this
        return "plants";
    }

    @GetMapping("/plants")
    public String getPlants(Model model) {

        List<Plant> plants = plantService.getAllPlants();

        List<PlantDto> plantDtos = plants
                .stream()
                .map(PlantMapper::toDto)
                .toList();

        model.addAttribute("plantDtos", plantDtos);

        return "plants";
    }
}
