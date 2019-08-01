package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.communication.AccountancyClient;
import at.nacs.drhousebeds.persistence.domain.Patient;
import at.nacs.drhousebeds.persistence.repository.BedRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class NurseTest {

    @Autowired
    Nurse nurse;
    @MockBean
    BedRepository bedRepository;
    @MockBean
    AccountancyClient accountancyClient;

    @Test
    void treat() {
        Patient patient = Patient.builder().diagnosis("internists").build();
        nurse.treat(patient);
        assertThat(patient.getTreatment()).isEqualTo("antibiotic");
    }
}