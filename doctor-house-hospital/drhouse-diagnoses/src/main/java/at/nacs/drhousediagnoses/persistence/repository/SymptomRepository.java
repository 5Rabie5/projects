package at.nacs.drhousediagnoses.persistence.repository;

import at.nacs.drhousediagnoses.persistence.domain.Symptom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SymptomRepository extends MongoRepository<Symptom,String> {
//    boolean existsByApiId(String apiId);
}
