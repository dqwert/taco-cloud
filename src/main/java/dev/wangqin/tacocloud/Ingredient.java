package dev.wangqin.tacocloud;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/* The `@Data` annotation at the class level is provided by Lombok and tells Lombok to
 * generate all of those missing methods as well as a constructor that accepts all `final` properties as arguments.
 */
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient implements Persistable<String> {

  /* Missing getter and setter methods and `equals()`, `hashCode()`, and `toString()`.
   * Lombok automatically generate those methods at compile-time so that they will be available at runtime.
   */

  @Id
  private String id;

  private String name;
  private Type type;

  @Override
  public boolean isNew() {
    return true;
  }

  public enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
}
