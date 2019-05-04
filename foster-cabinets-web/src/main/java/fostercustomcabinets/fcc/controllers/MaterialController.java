package fostercustomcabinets.fcc.controllers;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.model.Material;
import fostercustomcabinets.fcc.model.MaterialType;
import fostercustomcabinets.fcc.services.JobService;
import fostercustomcabinets.fcc.services.MaterialService;
import fostercustomcabinets.fcc.services.MaterialTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/jobs/{jobId}")
public class MaterialController {

    private static final String VIEWS_MATERIALS_CREATE_OR_UPDATE_FORM = "materials/createOrUpdateMaterialForm";
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

    @GetMapping("/materials/new")
    public String initCreationForm(Job job, Model model) {
        Material material = new Material();
        job.getMaterials().add(material);
        model.addAttribute("material", material);
        return VIEWS_MATERIALS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/materials/new")
    public String processCreationForm(Job job, @Valid Material material, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(material.getName()) && material.isNew() && job.getMaterial(material.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        job.getMaterials().add(material);
        if (result.hasErrors()) {
            model.put("material", material);
            return VIEWS_MATERIALS_CREATE_OR_UPDATE_FORM;
        } else {
            materialService.save(material);

            return "redirect:/jobs/" + job.getId();
        }
    }

    @GetMapping("/materials/{materialId}/edit")
    public String initUpdateForm(@PathVariable Long materialId, Model model) {
        model.addAttribute("material", jobService.findById(materialId));
        return VIEWS_MATERIALS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/materials/{materialId}/edit")
    public String processUpdateForm(@Valid Material material, BindingResult result, Job job, Model model) {
        if (result.hasErrors()) {
            material.setJob(job);
            model.addAttribute("material", material);
            return VIEWS_MATERIALS_CREATE_OR_UPDATE_FORM;
        } else {
            job.getMaterials().add(material);
            materialService.save(material);
            return "redirect:/jobs/" + job.getId();
        }
    }

}
