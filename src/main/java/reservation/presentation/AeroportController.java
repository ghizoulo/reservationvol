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

import reservation.metier.AeroportManager;
import reservation.metier.AssuranceManager;
import reservation.model.Aeroport;
import reservation.model.Assurance;
import reservation.model.TypeAssurance;


@Controller
@RequestMapping(value="/aeroport")
public class AeroportController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	AeroportManager serviceAeroport;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listAeroport(Model model) {
	    try {
	    	ArrayList<Aeroport> listes = new ArrayList<>();
			  for(Aeroport aeroport:serviceAeroport.list()){
				 if(!aeroport.isDeleted()){
					  listes.add(aeroport);
				 }
			  }
			    
			  model.addAttribute("listeAeroport",listes);
			  return new ModelAndView("aeroport");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null; 
	}
	
	@RequestMapping(path="add", method = RequestMethod.POST)
	public ModelAndView addAeroport(Model model,@RequestParam String nom,
									@RequestParam String ville ) {
	    try {
		    Aeroport a= new Aeroport(nom, ville, false);
		    serviceAeroport.add(a);
		   ArrayList<Aeroport> listes = new ArrayList<>();
			  for(Aeroport aeroport:serviceAeroport.list()){
				 if(!aeroport.isDeleted()){
					  listes.add(aeroport);  
				 }
			  }
			    
			  model.addAttribute("listeAeroport",listes);
			  return new ModelAndView("aeroport");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	
	@RequestMapping(path="update", method = RequestMethod.POST)
	public ModelAndView updateAeroport(Model model,@RequestParam String nom,
									@RequestParam String ville ) {
	    try {
	    	System.out.println("avant modification");
		    Aeroport a= new Aeroport(1,nom, ville, false);
		    serviceAeroport.update(a);
		    System.out.println("bien modifier");
		    ArrayList<Aeroport> listes = new ArrayList<>();
			  for(Aeroport aeroport:serviceAeroport.list()){
				 if(!aeroport.isDeleted()){
					  listes.add(aeroport);  
				 }
			  }
			    
			  model.addAttribute("listeAeroport",listes);
			  return new ModelAndView("aeroport");
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
	    	serviceAeroport.delete(id);
		   // Assurance a=service.getAssuranceById(id);
		    //boolean b =a.isDeleted();
		  // System.out.println(b);
	    	ArrayList<Aeroport> listes = new ArrayList<>();
		  for(Aeroport aeroport:serviceAeroport.list()){
			  if(!aeroport.isDeleted()){
				  listes.add(aeroport);
				  System.out.println("Supprimer");
			  }
		  }
		    
		    model.addAttribute("listeAeroport",listes);
		    return new ModelAndView("aeroport");
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}


	
	
}

