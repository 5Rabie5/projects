package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AccountantTest {

  @Autowired
  Accountant accountant;
  @Autowired
  PatientRepository patientRepository;
  @Autowired
  InvoiceRepository invoiceRepository;


  @BeforeEach
  void befor() {
    invoiceRepository.deleteAll();
    patientRepository.deleteAll();
    PatientDTO patientDTO1 = PatientDTO.builder().id("p1").medicine("analgesic2").build();
    PatientDTO patientDTO2 = PatientDTO.builder().id("p2").treatment("analgesic").build();

    accountant.account(patientDTO1);
    accountant.account(patientDTO2);
  }

  @Test
  void account() {

    Double expctedCostFromPharmacyApp = 20.0;
    Double expctedCostFromBedsApp = 10.0;

    Patient patient1 = patientRepository.findPatientByUuid("p1").orElse(null);
    Patient patient2 = patientRepository.findPatientByUuid("p2").orElse(null);
    Invoice invoice1 = invoiceRepository.getByPatient(patient1).orElse(null);
    Invoice invoice2 = invoiceRepository.getByPatient(patient2).orElse(null);

    assertThat(invoice1.getCost()).isEqualTo(expctedCostFromPharmacyApp);
    assertThat(invoice2.getCost()).isEqualTo(expctedCostFromBedsApp);
  }

  @Test
// this test didn't pass
  void setAspaid() {
    Patient patient1 = patientRepository.findPatientByUuid("p1").orElse(null);
    Invoice invoice1 = invoiceRepository.getByPatient(patient1).orElse(null);

    accountant.setAspaid(invoice1.getId());

    assertThat(invoice1.isPaid());
  }

  @Test
  void testInvoiceIsCreatedCorrectly() {
    //accountant.createInvoice()
  }
}


