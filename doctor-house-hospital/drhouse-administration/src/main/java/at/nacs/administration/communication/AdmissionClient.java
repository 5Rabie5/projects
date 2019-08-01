package at.nacs.administration.communication;

import at.nacs.administration.view.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AdmissionClient {
  private final RestTemplate restTemplate;
  @Value("${admission.server.url}")
  private String url;

  public void post(Patient patient) {
    restTemplate.postForObject(url, patient, Patient.class);
  }
}
