package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.persistence.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    BedsClient bedsClient;
    @MockBean
    PharmacyClient pharmacyClient;
    String url = "/patients";

    @Test
    void estimateLupus() {

        Patient patient = Patient.builder().name("Alex").symptoms("sneeze").build();
        Patient response = restTemplate.postForObject(url, patient, Patient.class);

        assertThat(response.getName()).isEqualTo("Alex");
        assertThat(response.getSymptoms()).isEqualTo("sneeze");
        assertThat(response.getDiagnosis()).isEqualTo("lupus");
    }

    @Test
    void findDiagnosis() {

        Patient patient = Patient.builder().name("Alex").symptoms("aphthousUlcers").build();
        Patient response = restTemplate.postForObject(url, patient, Patient.class);

        assertThat(response.getName()).isEqualTo("Alex");
        assertThat(response.getSymptoms()).isEqualTo("aphthousUlcers");
        assertThat(response.getDiagnosis()).isEqualTo("Internists");
    }
}