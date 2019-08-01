package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.communication.BedsClient;
import at.nacs.drhousediagnoses.communication.PharmacyClient;
import at.nacs.drhousediagnoses.persistence.domain.Patient;
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
public class DrHouse {

  private final Map<String, Integer> symptomsbank;
  private final Map<Integer, String> diagnosisbank;
  private final BedsClient bedsClient;
  private final PharmacyClient pharmacyClient;

  public Patient diagnosis(Patient patient) {
    doDiagnose(patient);
    forward(patient);
    return patient;
  }

  private void doDiagnose(Patient patient) {
    Integer symptoms = symptomsbank.get(patient.getSymptoms());
    if (symptoms != null) {
      String diagnosis = diagnosisbank.get(symptoms);
      patient.setDiagnosis(diagnosis);
    } else {
      patient.setDiagnosis("lupus");
    }
  }

  private void forward(Patient patient) {
    if (patient.getDiagnosis().equals("lupus")) {
      pharmacyClient.forward(patient);
    } else {
      bedsClient.forward(patient);
    }
  }
}
