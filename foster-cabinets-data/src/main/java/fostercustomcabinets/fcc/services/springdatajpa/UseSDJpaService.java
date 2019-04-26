package fostercustomcabinets.fcc.services.springdatajpa;

import fostercustomcabinets.fcc.model.Use;
import fostercustomcabinets.fcc.repositories.UseRepository;
import fostercustomcabinets.fcc.services.UseService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class UseSDJpaService implements UseService {

    private final UseRepository useRepository;

    public UseSDJpaService(UseRepository useRepository) {
        this.useRepository = useRepository;
    }

    @Override
    public Set<Use> findAll() {

        Set<Use> uses = new HashSet<>();

        useRepository.findAll().forEach(uses::add);

        return uses;
    }

    @Override
    public Use findById(Long aLong) {
        return useRepository.findById(aLong).orElse(null);
    }

    @Override
    public Use save(Use object) {
        return useRepository.save(object);
    }

    @Override
    public void delete(Use object) {
        useRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        useRepository.deleteById(aLong);
    }
}
