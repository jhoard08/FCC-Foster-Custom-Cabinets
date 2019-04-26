package fostercustomcabinets.fcc.services.springdatajpa;


import fostercustomcabinets.fcc.model.MaterialType;
import fostercustomcabinets.fcc.repositories.MaterialTypeRepository;
import fostercustomcabinets.fcc.services.MaterialTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class MaterialTypeSDJpaService implements MaterialTypeService {

    private final MaterialTypeRepository materialTypeRepository;

    public MaterialTypeSDJpaService(MaterialTypeRepository materialTypeRepository) {
        this.materialTypeRepository = materialTypeRepository;
    }

    @Override
    public Set<MaterialType> findAll() {

        Set<MaterialType> materialTypes = new HashSet<>();
        materialTypeRepository.findAll().forEach(materialTypes::add);
        return materialTypes;
    }

    @Override
    public MaterialType findById(Long aLong) {
        return materialTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public MaterialType save(MaterialType object) {
        return materialTypeRepository.save(object);
    }

    @Override
    public void delete(MaterialType object) {
        materialTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        materialTypeRepository.deleteById(aLong);
    }
}
