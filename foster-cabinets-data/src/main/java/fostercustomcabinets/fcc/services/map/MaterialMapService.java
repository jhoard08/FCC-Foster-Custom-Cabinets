package fostercustomcabinets.fcc.services.map;

import fostercustomcabinets.fcc.model.Material;
import fostercustomcabinets.fcc.services.MaterialService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class MaterialMapService extends AbstractMapService<Material, Long> implements MaterialService
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
		return super.save(object);
	}

	@Override public Material findById(Long id)
	{
		return super.findById(id);
	}

}
