package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.logic.Nurse;
import at.nacs.drhousebeds.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class BedsEndPoint {

    private final Nurse nurse;

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        nurse.treat(patient);
        return patient;
    }
}
