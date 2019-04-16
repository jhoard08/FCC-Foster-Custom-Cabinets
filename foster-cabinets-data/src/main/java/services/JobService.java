package services;

import model.Job;



public interface JobService extends CrudService<Job, Long>
{
	Job findByLastName(String lastName);
}
