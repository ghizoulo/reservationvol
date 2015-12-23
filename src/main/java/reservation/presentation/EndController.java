package reservation.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EndController {
	
	
	@RequestMapping(path = "end")
	public ModelAndView initIndex(Model model) throws Exception
	{
		return new ModelAndView("end");
	}
}
