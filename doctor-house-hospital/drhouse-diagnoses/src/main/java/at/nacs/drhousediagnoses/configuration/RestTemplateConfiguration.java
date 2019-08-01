package at.nacs.drhousediagnoses.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

  @Bean
  RestTemplate restTemplate() {


    RestTemplateBuilder builder = new RestTemplateBuilder();
    builder.basicAuthentication("n.rabietarboush@gmail.com", "Yy8t3Z5Rer2E6Xqz4");

    return builder.build();
  }
}
