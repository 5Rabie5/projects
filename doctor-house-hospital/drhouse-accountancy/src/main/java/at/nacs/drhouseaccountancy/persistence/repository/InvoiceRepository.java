package at.nacs.drhouseaccountancy.persistence.repository;

import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
  Optional<Invoice> getByPatient(Patient patient);
}
