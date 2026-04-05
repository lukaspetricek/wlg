package cz.luky.wlg.mapper;

import cz.luky.wlg.dto.PlantDto;
import cz.luky.wlg.model.Plant;

public class PlantMapper {

    public static PlantDto toDto (Plant plant) {
        if (plant == null) return null;

        PlantDto dto = new PlantDto();
        dto.setId(plant.getId());
        dto.setNick(plant.getNick());
        dto.setName(plant.getName());
        dto.setLatinName(plant.getLatinName());
        dto.setPlantType(plant.getPlantType());
        return dto;
    }

    public static Plant toEntity(PlantDto dto) {
        if (dto == null) return null;

        Plant plant = new Plant();
        plant.setId(dto.getId());
        plant.setNick(dto.getNick());
        plant.setName(dto.getName());
        plant.setLatinName(dto.getLatinName());
        plant.setPlantType(dto.getPlantType());
        return plant;
    }
}
