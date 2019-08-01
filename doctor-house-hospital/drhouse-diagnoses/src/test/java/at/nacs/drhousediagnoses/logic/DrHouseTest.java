package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.communication.BedsClient;
import at.nacs.drhousediagnoses.communication.PharmacyClient;
import at.nacs.drhousediagnoses.persistence.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class DrHouseTest {

    @Autowired
    DrHouse drHouse;
    @MockBean
    BedsClient bedsClient;
    @MockBean
    PharmacyClient pharmacyClient;

    @Test
    void diagnosis() {

        Patient patient = Patient.builder().name("Alex").symptoms("yyy").build();
        drHouse.diagnosis(patient);

        assertThat(patient.getDiagnosis()).isEqualTo("lupus");
    }
}