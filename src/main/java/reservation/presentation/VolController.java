package reservation.presentation;

import java.sql.Time;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reservation.metier.VolManager;
import reservation.model.InfoEscale;

@Controller
@RequestMapping(value="/vol")
public class VolController {
	
protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	VolManager serviceVol;
	
	@Autowired
	InfoEscale serviceEscale;
	
	@RequestMapping(path="add", method = RequestMethod.POST)
	public ModelAndView addVol(Model model,@RequestParam Date dateDepart,@RequestParam Date dateArrivee,
			                               @RequestParam Time heureDepart,@RequestParam Time heureArrivee) {
	    //try {
		  //  Vol a= new Vol(dateDepart, dateArrivee, heureDepart, heureArrivee,false, true);
		    //service.add(a);
		    System.out.println("ana f ajouté");
		    //ArrayList<Vol> listes = new ArrayList<>();
			 // for(Vol vol:service.list()){
				// if(!vol.isDeleted()){
					//  listes.add(vol);  
				 //}
			  //}
			    
			  //model.addAttribute("listeVol",listes);
			  return new ModelAndView("vol");
		//} catch (Exception e) {
			//// TODO Auto-generated catch block
			//e.printStackTrace();
			//logger.info("erreeeeu");
		//}
		//return null;
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listVol(Model model) {
	    //try {
	    	//Assurance a = new Assurance();
	    	//System.out.println(a.isDeleted());
	    	
	    	//ArrayList<Vol> listes = new ArrayList<>();
			  //for(Vol vol:service.list()){
				// if(!vol.isDeleted()){
					//  listes.add(vol);
					  //System.out.println("Supprimer");
				 //}
			  //}
			    
			  //model.addAttribute("listeVol",listes);
			  return new ModelAndView("vol");
	//	} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			//logger.info("erreeeeu");
		//}
		//return null; 
	}
	
//	@RequestMapping(path="add", method = RequestMethod.POST)
//	public ModelAndView addVol(Model model,@RequestParam Date dateDepart,@RequestParam Date dateArrivee,@RequestParam Time heureDepart,@RequestParam Time heureArrivee,
//			                                @RequestParam boolean open,@RequestParam Aeroport aeroportDepart,@RequestParam Aeroport aeroportArrivee,
//			                                @RequestParam Compagnie compagnie) {
//	    try {
//		    Vol a= new Vol(dateDepart, dateArrivee, heureDepart, heureArrivee, false, open, aeroportDepart, aeroportArrivee, compagnie);
//		    service.add(a);
//		    System.out.println("ana f ajouté");
//		    ArrayList<Vol> listes = new ArrayList<>();
//			  for(Vol vol:service.list()){
//				 if(!vol.isDeleted()){
//					  listes.add(vol);  
//				 }
//			  }
//			    
//			  model.addAttribute("listeVol",listes);
//			  return new ModelAndView("vol");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			logger.info("erreeeeu");
//		}
//		return null;
//	}
	/*
	@RequestMapping(path="update", method = RequestMethod.POST)
	public ModelAndView updateVol(Model model,@RequestParam(value="type") TypeAssurance type2,
									@RequestParam int tarif ) {
	    try {
	    	System.out.println("avant modification");
		  //  Vol a= new Vol(tarif, type2, false);
		    service.update(a);
		    System.out.println("bien modifier");
		    ArrayList<Vol> listes = new ArrayList<>();
			  for(Vol vol:service.list()){
				 if(!vol.isDeleted()){
					  listes.add(vol);  
				 }
			  }
			    
			  model.addAttribute("listeVol",listes);
			  return new ModelAndView("vol");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	
	@RequestMapping(path="delete", method = RequestMethod.GET)
	public ModelAndView deleteVol(Model model,@RequestParam int id) {
	    try {
	    	service.delete(id);
		   // Assurance a=service.getAssuranceById(id);
		    //boolean b =a.isDeleted();
		  // System.out.println(b);
	    	ArrayList<Vol> listes = new ArrayList<>();
		  for(Vol vol:service.list()){
			  if(!vol.isDeleted()){
				  listes.add(vol);
				  System.out.println("Supprimer");
			  }
		  }
		    
		    model.addAttribute("listeVol",listes);
		    return new ModelAndView("vol");
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null; 
	}*/

}
