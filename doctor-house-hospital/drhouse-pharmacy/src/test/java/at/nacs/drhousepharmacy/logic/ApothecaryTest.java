package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.communication.AccountancyClient;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.repository.PharmacyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class ApothecaryTest {
    @Autowired
    Apothecary apothecary;
    @MockBean
    PharmacyRepository pharmacyRepository;
    @MockBean
    AccountancyClient accountancyClient;

    @Test
    void handel() {
       Patient patient= Patient.builder().diagnosis("lopus").build();
        apothecary.handel(patient);
        Assertions.assertThat(patient.getMedicine()).isEqualTo("analgesic");
    }
}