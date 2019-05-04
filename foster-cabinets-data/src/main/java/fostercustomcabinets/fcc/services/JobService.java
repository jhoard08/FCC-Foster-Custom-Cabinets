package fostercustomcabinets.fcc.services;

import fostercustomcabinets.fcc.model.Job;

import java.util.List;

public interface JobService extends CrudService<Job, Long>
{
	Job findByLastName(String lastName);

	List<Job> findAllByLastNameLike(String lastName);


}
