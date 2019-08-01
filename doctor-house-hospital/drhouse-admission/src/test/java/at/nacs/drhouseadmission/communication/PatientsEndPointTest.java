package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndPointTest {

    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    DiagnosesClient diagnosesClient;
    String url = "/patients";

    @Test
    void post() {

        Patient patient = Patient.builder().name("Alex").symptoms("sneeze").build();
        Patient response = restTemplate.postForObject(url, patient, Patient.class);

        assertThat(response.getName()).isEqualTo("Alex");
        assertThat(response.getSymptoms()).isEqualTo("sneeze");
        assertThat(response.getId()).isNotEmpty();
    }
}