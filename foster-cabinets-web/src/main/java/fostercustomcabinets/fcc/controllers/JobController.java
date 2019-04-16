package fostercustomcabinets.fcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController
{
	@RequestMapping({"/jobs","jobs/index","/jobs/index.html"})
	public String jobList(){
		return "jobs/index";
	}
}
