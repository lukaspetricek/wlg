package cz.luky.wlg.repository;

import cz.luky.wlg.model.Plant;
import cz.luky.wlg.model.PlantAction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Plant> findById(Long id) {

        String sql = "SELECT id, nick, name, latin_name, plant_type FROM wlg.plant WHERE id = ?";

        return jdbcTemplate.query(sql, rowMapper, id)
                .stream()
                .findFirst();
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
