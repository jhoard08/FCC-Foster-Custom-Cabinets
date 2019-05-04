package fostercustomcabinets.fcc.controllers;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.model.MaterialType;
import fostercustomcabinets.fcc.services.JobService;
import fostercustomcabinets.fcc.services.MaterialService;
import fostercustomcabinets.fcc.services.MaterialTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/jobs/{jobId}")
public class MaterialController {

    private static final String VIEWS_MATERIALS_CREATE_OR_UPDATE_FORM = "materials/createOrUpdateMaterial";
    private final MaterialService materialService;
    private final JobService jobService;
    private final MaterialTypeService materialTypeService;

    public MaterialController(MaterialService materialService, JobService jobService, MaterialTypeService materialTypeService) {
        this.materialService = materialService;
        this.jobService = jobService;
        this.materialTypeService = materialTypeService;
    }


    @ModelAttribute("types")
    public Collection<MaterialType> populateMaterialType(){
        return materialTypeService.findAll();
    }

    @ModelAttribute("job")
    public Job findJob(@PathVariable Long jobId){
        return jobService.findById(jobId);
    }

    @InitBinder("job")
    public void initJobBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }
}
