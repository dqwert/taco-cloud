package dev.wangqin.tacocloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* On its own, `@Controller` doesn't do much.
 * Its primary purpose is to identify this class as a component for component scanning.
 *
 * In fact, a handful of other annotations (including `@Component`, `@Service`, and `@Repository`)
 * serves a purpose that similar to `@Controller`.
 * You could have just as effectively annotated `HomeController` with any of those other annotations,
 * and it would have still worked the same.
 * The choice of `@Controller` is, however, more descriptive of this component's role in the application.
 */
@Controller
public class HomeController {

  @GetMapping("/")
  public String home() {
    // return `home` view without populating any data; returned String will be interpreted as the logical name of a view
    return "home";
  }
}
