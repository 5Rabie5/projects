package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.persistence.domain.Symptom;
import at.nacs.drhousediagnoses.persistence.repository.SymptomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Assistant {
  private final SymptomRepository symptomRepository;


  public void store(Symptom[] symptoms) {
    symptomRepository.saveAll(Arrays.asList(symptoms));
  }

  public List<Symptom> getAll() {
    return symptomRepository.findAll();
  }
}
