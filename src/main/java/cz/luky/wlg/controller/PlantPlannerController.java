package cz.luky.wlg.controller;

import cz.luky.wlg.service.PlantPlannerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class PlantPlannerController {

    private final PlantPlannerService plantPlannerService;

    public PlantPlannerController(PlantPlannerService plantPlannerService) {
        this.plantPlannerService = plantPlannerService;
    }

    @GetMapping("/planner")
    public String getYearPlan(@RequestParam(defaultValue = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11") List<Long> plantIds, Model model) {

        model.addAttribute("monthlyPlans", plantPlannerService.generateYearPlan(plantIds));

        return "planner";
    }
}
