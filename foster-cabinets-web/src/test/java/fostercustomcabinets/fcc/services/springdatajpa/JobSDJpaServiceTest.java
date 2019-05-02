package fostercustomcabinets.fcc.services.springdatajpa;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.repositories.JobRepository;
import fostercustomcabinets.fcc.repositories.MaterialRepository;
import fostercustomcabinets.fcc.repositories.MaterialTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JobSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    JobRepository jobRepository;

    @Mock
    MaterialRepository materialRepository;

    @Mock
    MaterialTypeRepository materialTypeRepository;

    @InjectMocks
    JobSDJpaService service;

    Job returnJob;

    @BeforeEach
    void setUp() {
        returnJob = Job.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        Job returnJob = Job.builder().id(1L).lastName(LAST_NAME).build();

        when(jobRepository.findByLastName(any())).thenReturn(returnJob);

        Job smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        verify(jobRepository).findByLastName(any());

    }

    @Test
    void findAll() {
        Set<Job> returnJobsSet = new HashSet<>();
        returnJobsSet.add(Job.builder().id(1L).build());
        returnJobsSet.add(Job.builder().id(2L).build());

        when(jobRepository.findAll()).thenReturn(returnJobsSet);

        Set<Job> jobs = service.findAll();

        assertNotNull(jobs);
        assertEquals(2, jobs.size());
    }

    @Test
    void findById() {
        when(jobRepository.findById(anyLong())).thenReturn(Optional.of(returnJob));

        Job job = service.findById(1L);

        assertNotNull(job);
    }

    @Test
    void findByIdNotFound() {
        when(jobRepository.findById(anyLong())).thenReturn(Optional.empty());

        Job job = service.findById(1L);

        assertNull(job);
    }

    @Test
    void save() {
        Job jobToSave = Job.builder().id(1L).build();

        when(jobRepository.save(any())).thenReturn(returnJob);

        Job savedJob = service.save(jobToSave);

        assertNotNull(savedJob);

        verify(jobRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnJob);

        verify(jobRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(jobRepository).deleteById(anyLong());
    }
}