package cz.luky.wlg.repository;

import cz.luky.wlg.model.PlantAction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantActionRepositoryImpl implements PlantActionRepository {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PlantActionRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<PlantAction> findByPlantId(Long plantId) {

        String sql = """
                SELECT id, action_type, action_detail, month_from, month_to, note, plant_id
                FROM wlg.plant_action
                WHERE plant_id = ?
                """;

        return jdbcTemplate.query(
                sql,
//                (rs, rowNum) ->
//                {
//                    PlantAction action = new PlantAction();
//                    action.setId(rs.getLong("id"));
//                    action.setActionType(rs.getString("action_type"));
//                    action.setActionDetail(rs.getString("action_detail"));
//                    action.setMonthFrom(rs.getInt("month_from"));
//                    action.setMonthTo(rs.getInt("month_to"));
//                    action.setNote(rs.getString("note"));
//                    action.setPlantId(rs.getLong("plant_id"));
//                    return action;
//                },
                rowMapper,
                plantId
        );
    }

    @Override
    public List<PlantAction> findByPlantIds(List<Long> plantIds) {

        String sql = """
                SELECT id, action_type, action_detail, month_from, month_to, note, plant_id
                FROM wlg.plant_action
                WHERE plant_id IN (:plantIds)
                """;

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("plantIds", plantIds);

        return namedParameterJdbcTemplate.query(sql, params, rowMapper);
    }

    private final RowMapper<PlantAction> rowMapper = (rs, rowNum) -> {
        PlantAction action = new PlantAction();
        action.setId(rs.getLong("id"));
        action.setActionType(rs.getString("action_type"));
        action.setActionDetail(rs.getString("action_detail"));
        action.setMonthFrom(rs.getInt("month_from"));
        action.setMonthTo(rs.getInt("month_to"));
        action.setNote(rs.getString("note"));
        action.setPlantId(rs.getLong("plant_id"));
        return action;
    };
}
