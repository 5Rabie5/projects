package at.nacs.drhousepharmacy.communication;

import at.nacs.drhousepharmacy.logic.Apothecary;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PharmacyEndPoint {

    private final Apothecary apothecary;

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        apothecary.handel(patient);
        return patient;
    }
}
