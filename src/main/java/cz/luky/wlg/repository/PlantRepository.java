package cz.luky.wlg.repository;

import cz.luky.wlg.model.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantRepository {

    List<Plant> findAll();
    Optional<Plant> findById(Long id);
}
