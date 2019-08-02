package at.nacs.encoder;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties("security")
public class RestTemplateConfiguration {

  @Setter
  private String username;
  @Setter
  private String password;

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplateBuilder()
        .basicAuthentication(username, password)
        .build();
  }

  @Bean
  RestTemplate restTemplateInsecure() {
    return new RestTemplate();
  }

}
