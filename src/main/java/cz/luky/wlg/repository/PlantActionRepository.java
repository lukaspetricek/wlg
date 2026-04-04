package cz.luky.wlg.repository;

import cz.luky.wlg.model.PlantAction;

import java.util.List;

public interface PlantActionRepository {

    List<PlantAction> findByPlantId(Long plantId);

    List<PlantAction> findByPlantIds(List<Long> plantIds);
}
