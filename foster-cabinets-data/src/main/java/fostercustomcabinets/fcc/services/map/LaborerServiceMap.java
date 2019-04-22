package fostercustomcabinets.fcc.services.map;

import fostercustomcabinets.fcc.model.Laborer;
import fostercustomcabinets.fcc.model.Specialty;
import fostercustomcabinets.fcc.services.LaborerService;
import fostercustomcabinets.fcc.services.SpecialitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LaborerServiceMap extends AbstractMapService<Laborer, Long> implements LaborerService
{

	private final SpecialitiesService specialitiesService;

	public LaborerServiceMap(SpecialitiesService specialitiesService) {
		this.specialitiesService = specialitiesService;
	}

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
		if(object.getSpecialties().size() > 0){
			object.getSpecialties().forEach(specialty -> {
				if(specialty.getId() == null){
					Specialty savedSpecialty = specialitiesService.save(specialty);
					specialty.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(object);
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
