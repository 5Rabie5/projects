package at.nacs.drhouseaccountancy.communication.endpoint;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountEndPoints {

  private final Accountant accountant;

  @PostMapping("/patients")
  Patient post(@RequestBody PatientDTO patientDTO) {

    return accountant.account(patientDTO);
  }

  @GetMapping("/invoices")
  List<Invoice> displlayAllInvoices() {

    return accountant.displlyAllInvoice();
  }

  @PutMapping("/invoices/{id}/paid")
  void setAspaid(@PathVariable Long id) {

    accountant.setAspaid(id);
  }
}


