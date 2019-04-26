package fostercustomcabinets.fcc.services.springdatajpa;

import fostercustomcabinets.fcc.model.Specialty;
import fostercustomcabinets.fcc.repositories.SpecialtyRepository;
import fostercustomcabinets.fcc.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecailtySDJpaService implements SpecialitiesService {

    private final SpecialtyRepository specialtyRepository;

    public SpecailtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {

        Set<Specialty> specialties = new HashSet<>();

        specialtyRepository.findAll().forEach(specialties::add);

        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
