package fostercustomcabinets.fcc.controllers;

import fostercustomcabinets.fcc.services.LaborerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LaborersController
{
	private final LaborerService laborerService;

	public LaborersController(LaborerService laborerService) {
		this.laborerService = laborerService;
	}

	@RequestMapping({"/laborers", "/laborers/index", "/laborers/index.html","/laborers.html"})
	public String listLaborers(Model model){

		model.addAttribute("laborers", laborerService.findAll());

		return "laborers/index";
	}
}
