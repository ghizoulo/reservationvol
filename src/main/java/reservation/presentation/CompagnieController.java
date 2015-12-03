package reservation.presentation;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import reservation.metier.CompagnieManager;
import reservation.model.Compagnie;


@Controller
@RequestMapping(value="/compagnie")
public class CompagnieController {
protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	CompagnieManager service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listCompagnie(Model model) {
	    try {
	    	//Assurance a = new Assurance();
	    	//System.out.println(a.isDeleted());
	    	
	    	ArrayList<Compagnie> listes = new ArrayList<>();
			  for(Compagnie compagnie:service.list()){
				  if(!compagnie.isDeleted()){
					  listes.add(compagnie);
					  System.out.println("Supprimer");
				  }
			  }  
			  model.addAttribute("listeCompagnie",listes);
	    	  return new ModelAndView("compagnie");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null; 
	}
	
	@RequestMapping(path="add", method = RequestMethod.POST)
	public ModelAndView addCompagnie(Model model,@RequestParam String nom) {
	    try {
		    Compagnie a= new Compagnie(nom, false);
		    service.add(a);
		    ArrayList<Compagnie> listes = new ArrayList<>();
			  for(Compagnie compagnie:service.list()){
				  if(!compagnie.isDeleted()){
					  listes.add(compagnie);
					  
				  }
			  }
			    
			  model.addAttribute("listeCompagnie",listes);
		    return new ModelAndView("compagnie");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	
	@RequestMapping(path="delete", method = RequestMethod.GET)
	public ModelAndView deleteCompagnie(Model model,@RequestParam int id) {
	    try {
	    	service.delete(id);
		   // Assurance a=service.getAssuranceById(id);
		    //boolean b =a.isDeleted();
		  // System.out.println(b);
	    	ArrayList<Compagnie> listes = new ArrayList<>();
			  for(Compagnie compagnie:service.list()){
				  if(!compagnie.isDeleted()){
					  listes.add(compagnie); 
				  }
			  }  
			  model.addAttribute("listeCompagnie",listes);
		    return new ModelAndView("compagnie"); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}

}
