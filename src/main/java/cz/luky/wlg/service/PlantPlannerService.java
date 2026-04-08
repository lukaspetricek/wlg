package cz.luky.wlg.service;

import cz.luky.wlg.dto.GeneratePlantResponseDto;
import cz.luky.wlg.dto.PlantItemDto;
import cz.luky.wlg.mapper.PlantItemMapper;
import cz.luky.wlg.model.Plant;
import cz.luky.wlg.model.PlantAction;
import cz.luky.wlg.repository.PlantActionRepository;
import cz.luky.wlg.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlantPlannerService {

    private final PlantRepository plantRepository;
    private final PlantActionRepository plantActionRepository;

    public PlantPlannerService (PlantRepository plantRepository, PlantActionRepository plantActionRepository) {
        this.plantRepository = plantRepository;
        this.plantActionRepository = plantActionRepository;
    }

    //from list of plants and actions agr.
    public GeneratePlantResponseDto generatePlans(List<Long> plantList) {

        List<PlantAction> plantActions = plantActionRepository.findByPlantIds(plantList);
        List<Plant> plants = plantRepository.findByIds(plantList);

        Map<Long, Plant> plantMap = new HashMap<>();
        for (Plant plant : plants) {
            plantMap.put(plant.getId(), plant);
        }

        Map<Integer, List<PlantItemDto>> planByMonth = new HashMap<>();

        for (PlantAction action: plantActions) {
            Plant plant = plantMap.get(action.getPlantId());
            PlantItemDto dto = PlantItemMapper.toDto(plant, action);

            for (int month = action.getMonthFrom() ; month <= action.getMonthTo(); month++) {

                planByMonth
                        .computeIfAbsent(month, k -> new ArrayList<>())
                        .add(dto);
            }
        }

        GeneratePlantResponseDto responseDto = new GeneratePlantResponseDto();
        responseDto.setPlanByMonth(planByMonth);

        return responseDto;
    }
}
