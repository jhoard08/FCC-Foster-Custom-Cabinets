package fostercustomcabinets.fcc.services.map;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.model.Material;
import fostercustomcabinets.fcc.services.MaterialService;
import fostercustomcabinets.fcc.services.MaterialTypeService;
import org.springframework.stereotype.Service;
import fostercustomcabinets.fcc.services.JobService;
import java.util.Set;

@Service
public class JobServiceMap extends AbstractMapService<Job, Long> implements JobService
{
	private final MaterialTypeService materialTypeService;
	private final MaterialService materialService;

	public JobServiceMap(MaterialTypeService materialTypeService, MaterialService materialService) {
		this.materialTypeService = materialTypeService;
		this.materialService = materialService;
	}

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
	public Job save(Job object) {

		if (object != null) {
			if(object.getMaterials() != null){
				object.getMaterials().forEach(material -> {
					if(material.getMaterialType() != null){
						if(material.getMaterialType().getId() == null){
							material.setMaterialType(materialTypeService.save(material.getMaterialType()));
						}
					}else{
						throw new RuntimeException("Material Type is required");
					}
					if(material.getId() == null){
						Material savedMaterial = materialService.save(material);
						material.setId(savedMaterial.getId());
					}
				});
			}
			return super.save(object);
		} else {
			return null;

		}
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
