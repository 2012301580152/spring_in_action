package cn.coder.tacos.jpaRepository;

import cn.coder.tacos.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}