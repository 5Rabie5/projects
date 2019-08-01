package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.communication.AccountancyClient;
import at.nacs.drhousebeds.persistence.domain.Patient;
import at.nacs.drhousebeds.persistence.repository.BedRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
@Service
@RequiredArgsConstructor
@ConfigurationProperties("info")
@Setter
@Getter
public class Nurse {

  private final Map<String, String> tretmentsbank;
  private final BedRepository bedRepository;
  private final AccountancyClient accountancyClient;

  public Patient treat(Patient patient) {
    provideTreatment(patient);
    bedRepository.save(patient);
    accountancyClient.foword(patient);
    return patient;
  }

  private void provideTreatment(Patient patient) {
    String treatment = tretmentsbank.get(patient.getDiagnosis());
    patient.setTreatment(treatment);
  }
}
