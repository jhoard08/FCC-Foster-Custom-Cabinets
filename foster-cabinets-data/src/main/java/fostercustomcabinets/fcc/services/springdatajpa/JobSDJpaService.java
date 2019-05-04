package fostercustomcabinets.fcc.services.springdatajpa;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.repositories.JobRepository;
import fostercustomcabinets.fcc.repositories.MaterialRepository;
import fostercustomcabinets.fcc.repositories.MaterialTypeRepository;
import fostercustomcabinets.fcc.services.JobService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class JobSDJpaService implements JobService {

    private final JobRepository jobRepository;
    private final MaterialRepository materialRepository;
    private final MaterialTypeRepository materialTypeRepository;

    public JobSDJpaService(JobRepository jobRepository, MaterialRepository materialRepository,
                           MaterialTypeRepository materialTypeRepository) {
        this.jobRepository = jobRepository;
        this.materialRepository = materialRepository;
        this.materialTypeRepository = materialTypeRepository;
    }

    @Override
    public Job findByLastName(String lastName) {
        return jobRepository.findByLastName(lastName);
    }

    @Override public List<Job> findAllByLastNameLike(String lastName)
    {
        return jobRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Job> findAll() {

        Set<Job> jobs = new HashSet<>();

        jobRepository.findAll().forEach(jobs::add);

        return jobs;
    }

    @Override
    public Job findById(Long aLong) {
        return jobRepository.findById(aLong).orElse(null);
    }

    @Override
    public Job save(Job object) {
        return jobRepository.save(object);
    }

    @Override
    public void delete(Job object) {
        jobRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        jobRepository.deleteById(aLong);
    }
}
