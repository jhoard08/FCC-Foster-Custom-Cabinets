package fostercustomcabinets.fcc.controllers;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.model.MaterialType;
import fostercustomcabinets.fcc.services.JobService;
import fostercustomcabinets.fcc.services.MaterialService;
import fostercustomcabinets.fcc.services.MaterialTypeService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MaterialControllerTest {

    @Mock
    MaterialService materialService;

    @Mock
    JobService jobService;

    @Mock
    MaterialTypeService materialTypeService;

    @InjectMocks
    MaterialController materialController;

    MockMvc mockMvc;

    Job job;
    Set<MaterialType> materialTypes;

    @BeforeEach
    void setup(){
        job = Job.builder().id(1L).build();

        materialTypes = new HashSet<>();
        materialTypes.add(MaterialType.builder().id(1L).name("Maple").build());
        materialTypes.add(MaterialType.builder().id(2L).name("Cherry").build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(materialController)
                .build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(jobService.findById(anyLong())).thenReturn(job);
        when(materialTypeService.findAll()).thenReturn(materialTypes);

        mockMvc.perform(get("/jobs/1/materials/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("job"))
                .andExpect(model().attributeExists("material"))
                .andExpect(view().name("materials/createOrUpdateMaterialForm"));
    }

    @Test
    void processCreationForm() throws Exception {
        when(jobService.findById(anyLong())).thenReturn(job);
        when(materialTypeService.findAll()).thenReturn(materialTypes);

        mockMvc.perform(post("/jobs/1/materials/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/jobs/1"));

        verify(materialService).save(any());

    }

    @Test
    void initUpdateForm() throws Exception {
        when(jobService.findById(anyLong())).thenReturn(job);
        when(materialTypeService.findAll()).thenReturn(materialTypes);
        //when(materialService.findById(anyLong())).thenReturn(Material.builder().id(2L).build());

        mockMvc.perform(get("/jobs/1/materials/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("job"))
                .andExpect(model().attributeExists("material"))
                .andExpect(view().name("materials/createOrUpdateMaterialForm"));
    }

    @Test
    void processUpdateForm() throws Exception {
        when(jobService.findById(anyLong())).thenReturn(job);
        when(materialTypeService.findAll()).thenReturn(materialTypes);

        mockMvc.perform(post("/jobs/1/materials/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/jobs/1"));

        verify(materialService).save(any());
    }

    @Test
    void populatePetTypes() {
        //todo impl
    }

    @Test
    void findOwner() {
        //todo impl
    }

    @Test
    void initOwnerBinder() {
        //todo impl
    }
}