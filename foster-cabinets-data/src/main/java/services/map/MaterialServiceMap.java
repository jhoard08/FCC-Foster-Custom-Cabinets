package services.map;

import model.Material;
import services.CrudService;

import java.util.Set;

public class MaterialServiceMap extends AbstractMapService<Material, Long> implements CrudService<Material, Long>
{

	@Override public Set<Material> findAll()
	{
		return super.findAll();
	}

	@Override public void deleteById(Long id)
	{
		super.deleteById(id);
	}

	@Override public void delete(Material object)
	{
		super.delete(object);
	}

	@Override public Material save(Material object)
	{
		return super.save(object.getId(), object);
	}

	@Override public Material findById(Long id)
	{
		return super.findById(id);
	}
}
