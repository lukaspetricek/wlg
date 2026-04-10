package cz.luky.wlg.service;

import cz.luky.wlg.dto.MonthlyPlanResponseDto;
import cz.luky.wlg.dto.PlantItemDto;
import cz.luky.wlg.mapper.PlantItemMapper;
import cz.luky.wlg.model.Plant;
import cz.luky.wlg.model.PlantAction;
import cz.luky.wlg.repository.PlantActionRepository;
import cz.luky.wlg.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlantPlannerService {

    private final PlantRepository plantRepository;
    private final PlantActionRepository plantActionRepository;

    public PlantPlannerService(PlantRepository plantRepository, PlantActionRepository plantActionRepository) {
        this.plantRepository = plantRepository;
        this.plantActionRepository = plantActionRepository;
    }

    public List<MonthlyPlanResponseDto> generateYearPlan(List<Long> plantIds) {

        List<Plant> plants = plantRepository.findByIds(plantIds);
        List<PlantAction> actions = plantActionRepository.findByPlantIds(plantIds);

        Map<Long, Plant> plantMap = plants.stream().collect(Collectors.toMap(Plant::getId, p -> p));

        Map<Month, List<PlantItemDto>> monthMap = new HashMap<>();

        for (PlantAction action : actions) {
            for (int m = action.getMonthFrom(); m <= action.getMonthTo(); m++) {
                Month month = Month.of(m);
                monthMap.computeIfAbsent(month, k -> new ArrayList<>())
                        .add(PlantItemMapper.toDto(plantMap.get(action.getPlantId()), action));
            }
        }

        monthMap.values().forEach(list -> list.sort(Comparator.comparing(PlantItemDto::getMonthFrom)));

        List<MonthlyPlanResponseDto> response = Arrays.stream(Month.values())
                .filter(monthMap::containsKey)
                .map(month -> new MonthlyPlanResponseDto(
                        month.name(),
                        monthMap.getOrDefault(month, List.of())
                ))
                .toList();

        return response;
    }

    private Plant findPlantById(List<Plant> plants, Long plantId) {
        return plants.stream()
                .filter(p -> p.getId().equals(plantId))
                .findFirst()
                .orElseThrow();
    }

    private boolean isActionInMonth(PlantAction action, Month month) {
        return false;
    }
}
