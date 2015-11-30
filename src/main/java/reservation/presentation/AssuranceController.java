package reservation.presentation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import reservation.metier.AssuranceManager;

@Controller
public class AssuranceController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	AssuranceManager service;
	
	@RequestMapping(value="assurance", method = RequestMethod.GET)
	public String test(Model model) {
	    try {
			String greetings = "Greetings, Spring MVC!";
			model.addAttribute("message", greetings);
			return "assurance";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
}
