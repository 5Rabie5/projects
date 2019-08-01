package at.nacs.drhousepharmacy.persistence.repository;

import at.nacs.drhousepharmacy.persistence.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PharmacyRepository extends MongoRepository<Patient, String> {
}
