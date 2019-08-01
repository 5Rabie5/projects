package at.nacs.administration.view.controller;

import at.nacs.administration.communication.AccountantClient;
import at.nacs.administration.view.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoicesController {
  private final AccountantClient accountantClient;

  @ModelAttribute("invoice")
  Invoice invoice() {
    return new Invoice();
  }

  @ModelAttribute("invoices")
  Invoice[] invoices() {
    return accountantClient.getAll();
  }

  @GetMapping
  String page() {
    return "invoices";
  }

  @PostMapping("/paid")
  String post(@RequestParam Long id) {
    accountantClient.post(id);
    return "redirect:/invoices";
  }

}
