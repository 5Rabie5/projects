package at.nacs.drhousepharmacy.communication;

import at.nacs.drhousepharmacy.logic.Apothecary;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.repository.PharmacyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PharmacyEndPointTest {

    @Autowired
    TestRestTemplate restTemplate;
    @SpyBean
    Apothecary apothecary;
    @MockBean
    PharmacyRepository pharmacyRepository;

    @Test
    void post() {
        Patient patient = Patient.builder().diagnosis("loups").build();
        String url = "/patients";
        restTemplate.postForObject(url, patient, Patient.class);
        verify(apothecary).handel(any());
    }
}