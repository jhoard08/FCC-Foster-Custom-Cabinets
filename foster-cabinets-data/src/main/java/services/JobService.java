package services;

import model.Job;

import java.util.Set;

public interface JobService
{
	Job findByLastName(String lastName);

	Job findById(Long id);

	Job save(Job job);

	Set<Job> findAll();
}
