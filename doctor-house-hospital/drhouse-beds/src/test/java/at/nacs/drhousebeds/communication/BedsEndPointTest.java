package at.nacs.drhousebeds.communication;

import at.nacs.drhousebeds.logic.Nurse;
import at.nacs.drhousebeds.persistence.domain.Patient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment =RANDOM_PORT)
class BedsEndPointTest {

    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    AccountancyClient accountancyClient;
    @SpyBean
    Nurse nurse;

    @Test
    void post() {
        Patient patient = Patient.builder().name("alex").symptoms("rtr").diagnosis("lupos").build();
        String url = "/patients";
        restTemplate.postForObject(url, patient,Patient.class);
        Mockito.verify(nurse).treat(Mockito.any());
    }
}