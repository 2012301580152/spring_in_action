package cn.coder.tacos.jdbc;

import cn.coder.tacos.domain.Ingredient;
import cn.coder.tacos.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Service
public class JdbcIngredientRepository implements IngredientRepository {
    private final static String GET_INGREDIENT_BY_ID = "select id, name, type, from Ingredient where id=?";
    private final static String SET_INGREDIENT = "insert into Ingredient (id, name, type) values (?,?,?)";
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query(GET_INGREDIENT_BY_ID,
                this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject(GET_INGREDIENT_BY_ID,
                new RowMapper<Ingredient>() {
                    @Override
                    public Ingredient mapRow(ResultSet rs, int i) throws SQLException {
                        return new Ingredient(
                                rs.getString("id"),
                                rs.getString("name"),
                                Ingredient.Type.valueOf(rs.getString("type"))
                        );
                    }
                }, id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update(SET_INGREDIENT,
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type"))
        );
    }
}
