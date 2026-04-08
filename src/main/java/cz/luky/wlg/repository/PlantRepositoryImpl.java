package cz.luky.wlg.repository;

import cz.luky.wlg.model.Plant;
import cz.luky.wlg.model.PlantAction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlantRepositoryImpl implements PlantRepository {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PlantRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Plant> findAll() {

        String sql = "SELECT id, nick, name, latin_name, plant_type FROM wlg.plant";

        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Plant> findByIds(List<Long> plantIds) {

        String sql = """
                SELECT id, nick, name, latin_name, plant_type
                FROM wlg.plant
                WHERE id IN (:plantIds)
                """;

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("plantIds", plantIds);

        return namedParameterJdbcTemplate.query(sql, params, rowMapper);
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
