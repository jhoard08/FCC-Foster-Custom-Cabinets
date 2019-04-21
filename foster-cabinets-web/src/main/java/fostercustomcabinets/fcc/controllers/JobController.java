package fostercustomcabinets.fcc.controllers;

import fostercustomcabinets.fcc.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/jobs")
@Controller
public class JobController
{
	private final JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@RequestMapping({"","/","/jobs","/jobs/index","/jobs/index.html"})
	public String jobList(Model model){

		model.addAttribute("jobs", jobService.findAll());

		return "jobs/index";
	}
}
