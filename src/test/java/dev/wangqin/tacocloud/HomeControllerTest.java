package dev.wangqin.tacocloud;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/* Instead of `@SpringBootTest` markup, HomeControllerTest is annotated with `@WebMvcTest`.
 * This is a special test annotation provided by Spring Boot that arranges for the test to run
 * in the context of a Spring MVC application.
 * More specifically, in this case, it arranges for HomeController to be registered in Spring MVC
 * so that you can throw requests against it.
 *
 * `@WebMvcTest` also set up Spring support for testing Spring MVC. Although it could be made to start a server,
 * mocking the mechanics of Spring MVC is sufficient for your purposes.
 * The test class is injected with a `MockMvc` object for the test to drive the mockup.
 */
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testHomePage() throws Exception {
    mockMvc.perform(get("/"))
       .andExpect(status().isOk())
       .andExpect(view().name("home"))
       .andExpect(content().string(containsString("Welcome to...")));
  }
}
