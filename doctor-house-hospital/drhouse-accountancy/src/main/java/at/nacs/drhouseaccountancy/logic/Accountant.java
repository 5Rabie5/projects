package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Kind;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Accountant {

  private final PatientRepository patientRepository;
  private final InvoiceRepository invoiceRepository;

  public Patient account(PatientDTO patientDTO) {
    Optional<Patient> patient = patientRepository.findPatientByUuid(patientDTO.getId());
    if (patient.isEmpty()) {
      storeNewPatient(patientDTO);
    }
    Invoice invoice = createInvoice(patientDTO);
    invoiceRepository.save(invoice);
    return patientRepository.findPatientByUuid(patientDTO.getId()).get();
  }

  private void storeNewPatient(PatientDTO patientDTO) {
    Patient patient = new Patient();
    patient.setName(patientDTO.getName());
    patient.setUuid(patientDTO.getId());
    patientRepository.save(patient);
  }

  Invoice createInvoice(PatientDTO patientDTO) {
    Patient patient = patientRepository.findPatientByUuid(patientDTO.getId()).get();
    Kind kind = getKind(patientDTO);
    String provided = getProvided(patientDTO, kind);

    return Invoice.builder()
                  .patient(patient)
                  .symptoms(patientDTO.getSymptoms())
                  .diagnosis(patientDTO.getDiagnosis())
                  .kind(kind)
                  .provided(provided)
                  .cost(calculateCosts(kind))
                  .paid(false)
                  .timestamp(LocalDateTime.now())
                  .build();
  }

  private Kind getKind(PatientDTO patientDTO) {
    if (patientDTO.getMedicine() == null) {
      return Kind.TREATMENT;
    } else {
      return Kind.MEDICINE;
    }
  }

  private String getProvided(PatientDTO patientDTO, Kind kind) {
    switch (kind) {
      case MEDICINE:
        return patientDTO.getMedicine();
      case TREATMENT:
        return patientDTO.getTreatment();
    }
    throw new IllegalArgumentException("Kind not supported: " + kind);
  }

  private Double calculateCosts(Kind kind) {
    double cost = 0.0;
    switch (kind) {
      case MEDICINE:
        cost = 20.00;
        break;
      case TREATMENT:
        cost = 10.00;
        break;
    }
    return cost;
  }

  public List<Invoice> displlyAllInvoice() {
    return invoiceRepository.findAll();
  }

  public void setAspaid(Long id) {
    Optional<Invoice> oInvoice = invoiceRepository.findById(id);
    if (oInvoice.isEmpty()) {

      return;
    }
    Invoice invoice = oInvoice.get();
    invoice.setPaid(true);
    invoiceRepository.save(invoice);
  }

}
