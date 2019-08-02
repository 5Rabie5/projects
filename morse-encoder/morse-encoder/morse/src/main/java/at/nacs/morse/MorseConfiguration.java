package at.nacs.morse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("translation")
public class MorseConfiguration {

  @Getter
  @Setter
  private Map<String, String> morse;

  @Bean
  Map<String, String> morse() {
    return morse;
  }
}
