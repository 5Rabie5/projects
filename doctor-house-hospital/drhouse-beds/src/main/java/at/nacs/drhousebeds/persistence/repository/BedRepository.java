package at.nacs.drhousebeds.persistence.repository;

import at.nacs.drhousebeds.persistence.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BedRepository extends MongoRepository<Patient,String> {
}
