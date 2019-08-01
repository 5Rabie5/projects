package at.nacs.administration.communication;

import at.nacs.administration.view.model.Symptom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class SymptomClient {
  private final RestTemplate restTemplate;
  @Value("${symptoms.server.url}")
  private String url;

//  public List<Symptom> getAll() {
//    Symptom[] symptoms = restTemplate.getForObject(url, Symptom[].class);
//    return List.of(symptoms);
//  }

  public List<String> getSymtomNames() {
    Symptom[] symptoms = restTemplate.getForObject(url, Symptom[].class);
    return Stream.of(symptoms)
                 .map(Symptom::getName)
                 .collect(toList());
  }
}

