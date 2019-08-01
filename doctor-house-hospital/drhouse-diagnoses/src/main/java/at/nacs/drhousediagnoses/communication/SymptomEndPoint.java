package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.logic.Assistant;
import at.nacs.drhousediagnoses.persistence.domain.Symptom;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/symptoms")
@RequiredArgsConstructor

public class SymptomEndPoint {

  private final RestTemplate restTemplate;
  private final Assistant assistant;

  @GetMapping("update")
  public Symptom[] get() {
//        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im4ucmFiaWV0YXJib3VzaEBnbWFpbC5jb20iLCJyb2xlIjoiVXNlciIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL3NpZCI6IjQ4MTIiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3ZlcnNpb24iOiIyMDAiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL2xpbWl0IjoiOTk5OTk5OTk5IiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9tZW1iZXJzaGlwIjoiUHJlbWl1bSIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbGFuZ3VhZ2UiOiJlbi1nYiIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvZXhwaXJhdGlvbiI6IjIwOTktMTItMzEiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL21lbWJlcnNoaXBzdGFydCI6IjIwMTktMDMtMTkiLCJpc3MiOiJodHRwczovL3NhbmRib3gtYXV0aHNlcnZpY2UucHJpYWlkLmNoIiwiYXVkIjoiaHR0cHM6Ly9oZWFsdGhzZXJ2aWNlLnByaWFpZC5jaCIsImV4cCI6MTU1NDg1OTYxOCwibmJmIjoxNTU0ODUyNDE4fQ.oS4E7K9T9xiBNRkH3Qy_QRdJPX7Mz58dBd64Li2Khhw";

    String token = restTemplate.postForObject("https://sandbox-authservice.priaid.ch/login", null, String.class);
    Symptom[] symptoms = restTemplate.getForObject("https://sandbox-healthservice.priaid.ch/symptoms?token=" + token + "&format=json&language=en-gb", Symptom[].class);
    assistant.store(symptoms);
    return symptoms;
  }

  @GetMapping
  public List<Symptom> getall() {
    return assistant.getAll();
  }

}
