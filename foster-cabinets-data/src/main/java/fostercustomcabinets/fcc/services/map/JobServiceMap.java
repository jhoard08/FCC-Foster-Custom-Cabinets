package fostercustomcabinets.fcc.services.map;

import fostercustomcabinets.fcc.model.Job;
import org.springframework.stereotype.Service;
import fostercustomcabinets.fcc.services.JobService;
import java.util.Set;

@Service
public class JobServiceMap extends AbstractMapService<Job, Long> implements JobService
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

	@Override
	public Job findByLastName(String lastName) {
		return null;
	}
}
