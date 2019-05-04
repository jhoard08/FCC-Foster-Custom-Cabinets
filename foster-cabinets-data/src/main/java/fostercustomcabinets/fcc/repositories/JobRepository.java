package fostercustomcabinets.fcc.repositories;

import fostercustomcabinets.fcc.model.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {

    Job findByLastName(String lastName);

    List<Job> findAllByLastNameLike(String lastName);
}
