package dev.wangqin.tacocloud;

import lombok.Data;

/* The `@Data` annotation at the class level is provided by Lombok and tells Lombok to
 * generate all of those missing methods as well as a constructor that accepts all `final` properties as arguments.
 */
@Data
public class Ingredient {

  /* Missing getter and setter methods and `equals()`, `hashCode()`, and `toString()`.
   * Lombok automatically generate those methods at compile-time so that they will be available at runtime.
   */
  private final String id;
  private final String name;
  private final Type type;

  public enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
}
