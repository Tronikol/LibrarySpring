package tronikol.projects.Library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("tronikol.projects.Library")
@EnableWebMvc
public class SpringConfig {
}
