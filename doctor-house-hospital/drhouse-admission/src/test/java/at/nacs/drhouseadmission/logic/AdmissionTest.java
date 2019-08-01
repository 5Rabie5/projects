package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.communication.DiagnosesClient;
import at.nacs.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {

    @Autowired
    Admission admission;
    @MockBean
    DiagnosesClient diagnosesClient;

    @Test
    void admit() {
        Patient patient = Patient.builder().name("Alex").symptoms("sneeze").build();
        Patient acuall = admission.admit(patient);

        assertThat(acuall.getName()).isEqualTo("Alex");
        assertThat(acuall.getSymptoms()).isEqualTo("sneeze");
        assertThat(acuall.getId()).isNotEmpty();
    }
}