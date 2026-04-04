package cz.luky.wlg.repository;

import cz.luky.wlg.model.Plant;
import cz.luky.wlg.model.PlantAction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantRepositoryImpl implements PlantRepository {

    private final JdbcTemplate jdbcTemplate;

    public PlantRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Plant> findAll() {

        String sql = "SELECT id, nick, name, latin_name, plant_type FROM wlg.plant";

        return jdbcTemplate.query(sql, rowMapper);
    }

    private final RowMapper<Plant> rowMapper = (rs, rowNum) -> {
        Plant plant = new Plant();
        plant.setId(rs.getLong("id"));
        plant.setNick(rs.getString("nick"));
        plant.setName(rs.getString("name"));
        plant.setLatinName(rs.getString("latin_name"));
        plant.setPlantType(rs.getString("plant_type"));
        return plant;
    };
}
