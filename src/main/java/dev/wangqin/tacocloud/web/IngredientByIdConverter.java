package dev.wangqin.tacocloud.web;

import java.util.HashMap;
import java.util.Map;

/* A converter is any class that implements Spring's `Converter` interface and implements its `convert()` method to
 * take one value and convert it to another.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import dev.wangqin.tacocloud.Ingredient;
import dev.wangqin.tacocloud.Ingredient.Type;
import dev.wangqin.tacocloud.data.IngredientRepository;

/* Annotated with `@Component` to make it discoverable as a bean in the Spring application context.
 * Spring Boot autoconfiguration will discover this, and any other `Converter` beans, and will automatically
 * register them with Spring MVC to be used when conversion of request parameters to bound properties is needed.
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  private IngredientRepository ingredientRepo;

  @Autowired
  public IngredientByIdConverter(IngredientRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }

  @Override
  public Ingredient convert(String id) {
    return ingredientRepo.findById(id).orElse(null);
  }
}
