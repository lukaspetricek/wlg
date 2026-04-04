package cz.luky.wlg.controller;

import cz.luky.wlg.model.Plant;
import cz.luky.wlg.service.PlantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PlantControllerApi {

    private final PlantService plantService;

    public PlantControllerApi(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/plants")
    public List<Plant> getAllPlants() {

        return plantService.getAllPlants();
    }

}
