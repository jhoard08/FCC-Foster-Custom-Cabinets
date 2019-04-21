package fostercustomcabinets.fcc.services;

import fostercustomcabinets.fcc.model.Job;


public interface JobService extends CrudService<Job, Long>
{
	Job findByLastName(String lastName);
}
