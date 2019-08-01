package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.communication.AccountancyClient;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Apothecary {

    private final PharmacyRepository pharmacyRepository;
    private final AccountancyClient accountancyClient;

    public Patient handel(Patient patient) {
        provideMedicine(patient);
        pharmacyRepository.save(patient);
        accountancyClient.foword(patient);
        return patient;
    }

    private void provideMedicine(Patient patient) {
        patient.setMedicine("analgesic");
    }
}
