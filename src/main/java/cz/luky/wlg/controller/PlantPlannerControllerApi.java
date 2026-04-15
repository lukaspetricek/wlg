package cz.luky.wlg.controller;

import cz.luky.wlg.dto.MonthlyPlanResponseDto;
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

    @GetMapping("/planner")
    public List<MonthlyPlanResponseDto> getPlant(@RequestParam(defaultValue = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11") List<Long> plantIds) {

        return plantPlannerService.generateYearPlan(plantIds);
    }
}
