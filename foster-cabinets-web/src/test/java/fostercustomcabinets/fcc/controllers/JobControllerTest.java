package fostercustomcabinets.fcc.controllers;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.services.JobService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;


import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class JobControllerTest {

    @Mock
    JobService jobService;

    @InjectMocks
    JobController controller;

    Set<Job> jobs;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        jobs = new HashSet<>();
        jobs.add(Job.builder().id(1L).build());
        jobs.add(Job.builder().id(2L).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void jobList() throws Exception {
        when(jobService.findAll()).thenReturn(jobs);

        mockMvc.perform(get("/jobs"))
                .andExpect(status().isOk())
                .andExpect(view().name("jobs/index"))
                .andExpect(model().attribute("jobs", hasSize(2)));
    }

    @Test
    void jobListByIndex() throws Exception {
        when(jobService.findAll()).thenReturn(jobs);

        mockMvc.perform(get("/jobs/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("jobs/index"))
                .andExpect(model().attribute("jobs", hasSize(2)));
    }

    @Test
    void findJobs() throws Exception {

        mockMvc.perform(get("/jobs/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));
    }

    @Test
    void displayOwner() throws Exception {
        when(jobService.findById(anyLong())).thenReturn(Job.builder().id(1L).build());

        mockMvc.perform(get("/jobs/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("jobs/jobDetails"))
                .andExpect(model().attribute("job", hasProperty("id", is(1L))));
    }
}