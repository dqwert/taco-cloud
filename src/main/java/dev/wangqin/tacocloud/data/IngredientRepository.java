package dev.wangqin.tacocloud.data;

import org.springframework.data.repository.CrudRepository;

import dev.wangqin.tacocloud.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
  /* `CurdRepository` already defines the methods you need, there's no need to explicitly define them.
   */
//  Iterable<Ingredient> findAll();
//
//  Optional<Ingredient> findById(String id);
//
//  Ingredient save(Ingredient ingredient);
}
