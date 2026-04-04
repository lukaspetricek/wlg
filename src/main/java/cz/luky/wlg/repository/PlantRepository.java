package cz.luky.wlg.repository;

import cz.luky.wlg.model.Plant;

import java.util.List;

public interface PlantRepository {

    List<Plant> findAll();
}
