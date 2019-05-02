package fostercustomcabinets.fcc.services.map;

import fostercustomcabinets.fcc.model.Job;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JobMapServiceTest {

    JobMapService jobMapService;

    final Long jobId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        jobMapService = new JobMapService(new MaterialTypeMapService(), new MaterialMapService());

        jobMapService.save(Job.builder().id(jobId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Job> jobSet = jobMapService.findAll();

        assertEquals(1, jobSet.size());
    }

    @Test
    void delete() {
        jobMapService.delete(jobMapService.findById(jobId));

        assertEquals(0, jobMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Job job2 = Job.builder().id(id).build();

        Job savedJob = jobMapService.save(job2);

        assertEquals(id, savedJob.getId());

    }

    @Test
    void saveNoId() {
        Job savedJob = jobMapService.save(Job.builder().build());

        assertNotNull(savedJob);
        assertNotNull(savedJob.getId());

    }

    @Test
    void deleteById() {
        jobMapService.deleteById(jobId);

        assertEquals(0, jobMapService.findAll().size());
    }

    @Test
    void findById() {
        Job job = jobMapService.findById(jobId);

        assertEquals(jobId, job.getId());
    }

    @Test
    void findByLastName() {
        Job smith = jobMapService.findByLastName(lastName);

        assertNotNull(smith);

        assertEquals(jobId, smith.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Job smith = jobMapService.findByLastName("foo");

        assertNull(smith);

    }
}