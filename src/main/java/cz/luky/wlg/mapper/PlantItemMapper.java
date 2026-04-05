package cz.luky.wlg.mapper;

import cz.luky.wlg.dto.PlantItemDto;
import cz.luky.wlg.model.Plant;
import cz.luky.wlg.model.PlantAction;

public class PlantItemMapper {

    public static PlantItemDto toDto(Plant plant, PlantAction action) {
        PlantItemDto dto = new PlantItemDto();
        dto.setPlantName(plant.getNick());
        dto.setActionType(action.getActionType());
        dto.setActionDetail(action.getActionDetail());
        dto.setNote(action.getNote());
        dto.setMonthFrom(action.getMonthFrom());
        dto.setMonthTo(action.getMonthTo());
        return dto;
    }
}
