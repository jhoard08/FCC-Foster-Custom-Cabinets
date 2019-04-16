package services.map;

import model.Job;
import services.CrudService;

import java.util.Set;

public class JobServiceMap extends AbstractMapService<Job, Long> implements CrudService<Job, Long>
{

	@Override
	public Set<Job> findAll()
	{
		return super.findAll();
	}

	@Override
	public void delete(Job object)
	{
		super.delete(object);
	}

	@Override
	public Job save(Job object)
	{
		return super.save(object.getId(), object);
	}

	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}

	@Override
	public Job findById(Long id)
	{
		return super.findById(id);
	}
}
