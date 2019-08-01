package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.persistence.domain.Patient;
import at.nacs.drhousediagnoses.logic.DrHouse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final DrHouse drHouse;

    @PostMapping
    public Patient post(@RequestBody Patient patient) {
        drHouse.diagnosis(patient);
        return patient;
    }
}
