package fostercustomcabinets.fcc.repositories;

import fostercustomcabinets.fcc.model.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {

    Job findByLastName(String lastName);
}
