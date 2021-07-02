package dev.wangqin.tacocloud.web;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/* `Model` is an object that ferries data between a controller and whatever view is charged with rendering that data.
 * Ultimately, data that's placed in `Model` attributes is copied into the servlet request attributes,
 * where the view can find them adn use them to render a page in the user's browser.
*/
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dev.wangqin.tacocloud.Ingredient;
import dev.wangqin.tacocloud.Ingredient.Type;
import dev.wangqin.tacocloud.TacoOrder;
import dev.wangqin.tacocloud.Taco;
import dev.wangqin.tacocloud.data.IngredientRepository;


/* `@Controller` serves to identify this class as a controller and to mark it as a candidate for component scanning,
 * so that Spring will discover it and automatically create an instance of `DesignTacoController`
 * as a bean in the Spring application context.
 */
@Controller
/* The `@RequestMapping` annotation applied at the class level specifies the kind of requests that this controller handles.
 * In this case, it specifies that `DesignTacoController` will handle requests whose path begins with `/design`.
 */
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
/* Upon a GET request with `/design`, the `DesignTacoController`'s `showDesignForm()` and `addIngredientToModel()` would engaged,
 * placing ingredients and an empty `Taco` into the model before passing the request on to the view.
 */
public class DesignTacoController {

  private final IngredientRepository ingredientRepo;

  @Autowired
  public DesignTacoController(IngredientRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }

  /* Because of `@ModelAttribute`, this method will also be invoked when a request is handled and
   * will construct a list of `ingredient` objects to be put into the model.
   */
  @ModelAttribute
  public void addIngredientToModel(Model model) {
    List<Ingredient> ingredients = new ArrayList<>();
    ingredientRepo.findAll().forEach(i -> ingredients.add(i));

    Type[] types = Ingredient.Type.values();

    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
    }
  }

  @ModelAttribute(name = "tacoOrder")
  public TacoOrder order() {
    return new TacoOrder();
  }

  @ModelAttribute(name = "taco")
  public Taco taco() {
    return new Taco();
  }

  /* `@GetMapping`, paired with the class-level `@RequestMapping`, specifies that when
   * an HTTP GET request is received for `/design`, `showDesignForm()` will be called to handle the request.
   */
  @GetMapping
  public String showDesignForm(Model model) {
    return "design";  // `design` is the logical name of the view that will be used to render the model to the browser
  }

  private Iterable<Ingredient> filterByType(
     List<Ingredient> ingredients, Type type) {
    return ingredients
       .stream()
       .filter(x -> x.getType().equals(type))
       .collect(Collectors.toList());
  }

  @PostMapping
  /* The `@Valid` annotation tells Spring MVC to perform validation on the submitted `Taco` object
   * after it's bound to the submitted from data and before the `processTaco()` method is called.
   * If there are any validation errors, the details of those errors will be captured in an `Errors` object that's passed into `processTaco()`.
   * The first few lines of `processTaco()` consult the `Errors` object, asking its `hasErrors()` method if there are any validation errors.
   * If there are, the method concludes without processing the `Taco` and returns the `"design"` view name so that the form is redisplayed.
   */
  public String processTaco(@Valid @ModelAttribute("taco") Taco taco,
                            @ModelAttribute TacoOrder tacoOrder,
                            Model model,
                            Errors errors) {
    if (errors.hasErrors()) {
      return "design";
    }

    tacoOrder.addTaco(taco);

    /* prefixed with `"redirect"`, indicating that after `processTaco()` completes,
     * the user's browser should be redirected to the relative path "orders/current"
     */
    return "redirect:/orders/current";
  }
}
