package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class PharmacyClient {

    private final RestTemplate restTemplate;

//    @Value("${Pharmacy.server.url}")
//    private String url;

    public Patient forward(Patient patient) {
        restTemplate.postForObject("http://localhost:9004/patients", patient, Patient.class);
        return patient;
    }
}
