package services.map;

import model.Laborer;
import services.CrudService;

import java.util.Set;

public class LaborerServiceMap extends AbstractMapService<Laborer, Long> implements CrudService<Laborer, Long>
{
	@Override
	public Set<Laborer> findAll()
	{
		return super.findAll();
	}

	@Override
	public void delete(Laborer object)
	{
		super.delete(object);
	}

	@Override
	public Laborer save(Laborer object)
	{
		return super.save(object.getId(), object);
	}

	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}

	@Override
	public Laborer findById(Long id)
	{
		return super.findById(id);
	}
}
