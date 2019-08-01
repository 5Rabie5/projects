package at.nacs.drhouseaccountancy.communication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

  private String id;
  private String name;
  private String symptoms;
  private String diagnosis;
  private String treatment;
  private String medicine;
}
