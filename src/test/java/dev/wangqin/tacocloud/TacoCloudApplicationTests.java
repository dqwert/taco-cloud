package dev.wangqin.tacocloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/* This test class does perform an essential check to ensure
 * that the Spring application context can be loaded successfully.
 */

/* The `@SpringBootTest` annotation tells JUnit to bootstrap the test with Spring Boot capabilities.
 * Annotated with `@ExtendWith(SpringExtension.class)`, to add Spring testing capabilities to JUnit 5.
 */
@SpringBootTest
class TacoCloudApplicationTests {

  @Test
  void contextLoads() {
  }

}
