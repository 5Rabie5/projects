package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import at.nacs.drhouseadmission.logic.Admission;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndPoint {

    private final Admission admission;

    @PostMapping
    public Patient post(@RequestBody Patient patient) {
        patient = admission.admit(patient);
        return patient;
    }
}
