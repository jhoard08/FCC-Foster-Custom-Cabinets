package fostercustomcabinets.fcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LaborersController
{
	@RequestMapping({"/laborers", "/laborers/index", "/laborers/index.html"})
	public String listLaborers(){
		return "laborers/index";
	}
}
