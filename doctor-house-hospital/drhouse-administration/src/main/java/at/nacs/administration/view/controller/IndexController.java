package at.nacs.administration.view.controller;

import at.nacs.administration.communication.AdmissionClient;
import at.nacs.administration.communication.SymptomClient;
import at.nacs.administration.view.model.Patient;
import at.nacs.administration.view.model.Symptom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {
  private final AdmissionClient admissionClient;
  private final SymptomClient symptomClient;

  @ModelAttribute("patient")
  Patient patient() {
    return new Patient();
  }

  @ModelAttribute("symptom")
  Symptom symptom() {
    return new Symptom();
  }

  @ModelAttribute("symptoms")
  List<String> symptoms() {
    return symptomClient.getSymtomNames();
  }

  @GetMapping
  String page() {
    return "index";
  }

  @PostMapping
  String post(@Valid Patient patient, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return page();
    }

    admissionClient.post(patient);
    return "redirect:/";
  }
}
