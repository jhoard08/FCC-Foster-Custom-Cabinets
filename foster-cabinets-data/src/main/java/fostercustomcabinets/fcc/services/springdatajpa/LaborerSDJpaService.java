package fostercustomcabinets.fcc.services.springdatajpa;

import fostercustomcabinets.fcc.model.Laborer;
import fostercustomcabinets.fcc.repositories.LaborerRepository;
import fostercustomcabinets.fcc.services.LaborerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class LaborerSDJpaService implements LaborerService {

    private final LaborerRepository laborerRepository;

    public LaborerSDJpaService(LaborerRepository laborerRepository) {
        this.laborerRepository = laborerRepository;
    }

    @Override
    public Set<Laborer> findAll() {

        Set<Laborer> laborers = new HashSet<>();

        laborerRepository.findAll().forEach(laborers::add);

        return laborers;
    }

    @Override
    public Laborer findById(Long aLong) {
        return laborerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Laborer save(Laborer object) {
        return laborerRepository.save(object);
    }

    @Override
    public void delete(Laborer object) {
        laborerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        laborerRepository.deleteById(aLong);
    }
}
