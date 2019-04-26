package fostercustomcabinets.fcc.services.map;

import fostercustomcabinets.fcc.model.MaterialType;
import fostercustomcabinets.fcc.services.MaterialTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@Profile({"default","map"})
public class MaterialTypeMapService extends AbstractMapService<MaterialType, Long> implements MaterialTypeService {
    @Override
    public Set<MaterialType> findAll() {
        return super.findAll();
    }

    @Override
    public MaterialType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public MaterialType save(MaterialType object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(MaterialType object) {
        super.delete(object);
    }

}
