package fostercustomcabinets.fcc.services.springdatajpa;

import fostercustomcabinets.fcc.model.Material;
import fostercustomcabinets.fcc.repositories.MaterialRepository;
import fostercustomcabinets.fcc.services.MaterialService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class MaterialSDJpaService implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialSDJpaService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Set<Material> findAll() {

        Set<Material> materials = new HashSet<>();

        materialRepository.findAll().forEach(materials::add);

        return materials;
    }

    @Override
    public Material findById(Long aLong) {
        return materialRepository.findById(aLong).orElse(null);
    }

    @Override
    public Material save(Material object) {
        return materialRepository.save(object);
    }

    @Override
    public void delete(Material object) {
        materialRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        materialRepository.deleteById(aLong);
    }
}
