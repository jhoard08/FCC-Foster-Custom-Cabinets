package fostercustomcabinets.fcc.controllers;

import fostercustomcabinets.fcc.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/jobs")
@Controller
public class JobController
{
	private final JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@RequestMapping({"","/","/index","/index.html"})
	public String jobList(Model model){

		model.addAttribute("jobs", jobService.findAll());

		return "jobs/index";
	}

	@RequestMapping("/find")
	public String findJobs(){
		return "notimplemented";
	}

	@GetMapping("/{jobId}")
    public ModelAndView showJob(@PathVariable Long jobId){
	    ModelAndView mav = new ModelAndView("jobs/jobDetails");
	    mav.addObject(jobService.findById(jobId));
	    return mav;
    }

}
