package fostercustomcabinets.fcc.controllers;

import fostercustomcabinets.fcc.model.Job;
import fostercustomcabinets.fcc.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/jobs")
@Controller
public class JobController
{
	private final JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}


	@RequestMapping("/find")
	public String findJobs(Model model){
		model.addAttribute("job", Job.builder().build());
		return "jobs/findJobs";
	}

	@GetMapping
	public String processFindForm(Job job, BindingResult result, Model model){
		if(job.getLastName() == null){
			job.setLastName("");
		}

		List<Job> results = jobService.findAllByLastNameLike("%" + job.getLastName() + "%");

		if(results.isEmpty()){
			// no jobs found
			result.rejectValue("lastName", "notFound", "not found");
			return "jobs/findJobs";
		}else if(results.size() == 1){
			// 1 job found
			job = results.get(0);
			return "redirect:/jobs/" + job.getId();
		}else{
			// multiple jobs found
			model.addAttribute("selections", results);
			return "jobs/jobsList";
		}
	}

	@GetMapping("/{jobId}")
    public ModelAndView showJob(@PathVariable Long jobId){
	    ModelAndView mav = new ModelAndView("jobs/jobDetails");
	    mav.addObject(jobService.findById(jobId));
	    return mav;
    }

}
