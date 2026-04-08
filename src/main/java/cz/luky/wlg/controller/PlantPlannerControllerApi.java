package cz.luky.wlg.controller;

import cz.luky.wlg.dto.GeneratePlantResponseDto;
import cz.luky.wlg.dto.PlantDto;
import cz.luky.wlg.service.PlantPlannerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PlantPlannerControllerApi {

    private final PlantPlannerService plantPlannerService;

    public PlantPlannerControllerApi(PlantPlannerService plantPlannerService) {
        this.plantPlannerService = plantPlannerService;
    }

    @GetMapping("/planer")
    public GeneratePlantResponseDto getPlant(@RequestParam(defaultValue = "1, 2, 3") List<Long> plantIds) {

        return plantPlannerService.generatePlans(plantIds);
    }

}
