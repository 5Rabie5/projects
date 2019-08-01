package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.communication.DiagnosesClient;
import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Admission {

    private final DiagnosesClient diagnosesClient;

    public Patient admit(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        diagnosesClient.forward(patient);
        return patient;
    }
}
