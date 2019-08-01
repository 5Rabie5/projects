package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountancyClient {
private final RestTemplate restTemplate;

    public void foword(Patient patient) {
        restTemplate.postForObject("http://localhost:9005/patients",patient,Patient.class);
    }
}
