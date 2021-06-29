package dev.wangqin.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/* The `@SpringBootApplication` annotation clearly signifies that this is a Spring Boot application.
 * It is a composite annotation that combines three other annotations:
 *   - `@SpringBootConfiguration` -- Designates this class as a configuration class.
 *   - `@EnableAutoConfiguration` -- Enables Spring Boot automatic configuration
 *   - `@ComponentScan` -- Enables component scanning
 */
@SpringBootApplication
public class TacoCloudApplication {

  public static void main(String[] args) {
    /* The `main()` method calls a stetic `run()` method on the SpringApplication class,
     * which performs the actual bootsrapping of the application, creating the Spring context.
     * The two parameters paased to the `run()` method are a configuration class and the command-line arguments.
     */
    SpringApplication.run(TacoCloudApplication.class, args);
  }

}
