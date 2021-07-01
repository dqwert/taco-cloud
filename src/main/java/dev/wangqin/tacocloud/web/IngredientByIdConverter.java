package dev.wangqin.tacocloud.web;

import java.util.HashMap;
import java.util.Map;

/* A converter is any class that implements Spring's `Converter` interface and implements its `convert()` method to
 * take one value and convert it to another.
 */
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import dev.wangqin.tacocloud.Ingredient;
import dev.wangqin.tacocloud.Ingredient.Type;

/* Annotated with `@Component` to make it discoverable as a bean in the Spring application context.
 * Spring Boot autoconfiguration will discover this, and any other `Converter` beans, and will automatically
 * register them with Spring MVC to be used when conversion of request parameters to bound properties is needed.
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  private Map<String, Ingredient> ingredientMap = new HashMap<>();

  /* The constructor of `IngredientByIdConverter` creates a `Map` keyed on a `String`
   * which is the ingredient ID and whose values are `Ingredient` object.
   */
  public IngredientByIdConverter() {
    ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
    ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
    ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
    ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", Type.PROTEIN));
    ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
    ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Type.VEGGIES));
    ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Type.CHEESE));
    ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
    ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Type.SAUCE));
    ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
  }

  @Override
  public Ingredient convert(String id) {
    return ingredientMap.get(id);
  }
}
