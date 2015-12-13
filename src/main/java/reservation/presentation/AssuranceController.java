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

import reservation.metier.AssuranceManager;
import reservation.model.Assurance;
import reservation.model.TypeAssurance;


@Controller
@RequestMapping(value="/assurance")
public class AssuranceController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	AssuranceManager service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listAssurance(Model model) throws Exception {
		if(service.list().isEmpty()){
			System.out.println("is empty");
			return new ModelAndView("assurance");
		}
		else{
			try {
		    	ArrayList<Assurance> listes = new ArrayList<>();
				  for(Assurance assurance:service.list()){
					 if(!assurance.isDeleted()){
						  listes.add(assurance);
					 }
				  }
				  model.addAttribute("listeAssurance",listes);
				  System.out.println("is not empty "+listes.size());
				  return new ModelAndView("assurance");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("erreeeeu");
			}
		}
		return null; 
	}
	
	@RequestMapping(path="add", method = RequestMethod.POST)
	public ModelAndView addAssurance(Model model,@RequestParam TypeAssurance type,
									@RequestParam int tarif ) {
	    try {
		    Assurance a= new Assurance(tarif, type, false);
		    service.add(a);
		    System.out.println("ana f ajouté");
		    ArrayList<Assurance> listes = new ArrayList<>();
			  for(Assurance assurance:service.list()){
				 if(!assurance.isDeleted()){
					  listes.add(assurance);  
				 }
			  }
			    
			  model.addAttribute("listeAssurance",listes);
			  return new ModelAndView("assurance");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	
	@RequestMapping(path="update", method = RequestMethod.POST)
	public ModelAndView updateAssurance(Model model,@RequestParam int id,@RequestParam TypeAssurance type,
									@RequestParam int tarif ) {
	    try {
	    	System.out.println("avant modification");
		    Assurance a= new Assurance(id,tarif, type, false);
		    service.update(a);
		    System.out.println("bien modifier");
		    ArrayList<Assurance> listes = new ArrayList<>();
			  for(Assurance assurance:service.list()){
				 if(!assurance.isDeleted()){
					  listes.add(assurance);  
				 }
			  }
			    
			  model.addAttribute("listeAssurance",listes);
			  return new ModelAndView("assurance");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	
	@RequestMapping(path="delete", method = RequestMethod.GET)
	public ModelAndView deleteAssurance(Model model,@RequestParam int id) {
	    try {
	    	service.delete(id);
		   // Assurance a=service.getAssuranceById(id);
		    //boolean b =a.isDeleted();
		  // System.out.println(b);
	    	ArrayList<Assurance> listes = new ArrayList<>();
		  for(Assurance assurance:service.list()){
			  if(!assurance.isDeleted()){
				  listes.add(assurance);
				  System.out.println("Supprimer");
			  }
		  }
		    
		    model.addAttribute("listeAssurance",listes);
		    return new ModelAndView("assurance");
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}


	
	
}

