package reservation.presentation;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;
import reservation.metier.AeroportManager;
import reservation.metier.ClasseManager;
import reservation.metier.CompagnieManager;
import reservation.metier.InfoEscaleManager;
import reservation.metier.VolManager;
import reservation.model.Aeroport;
import reservation.model.Classe;
import reservation.model.Compagnie;
import reservation.model.InfoEscale;
import reservation.model.Vol;

@Controller
@RequestMapping(value="/vol")
public class VolController {
	
protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	VolManager serviceVol;
	@Autowired
	CompagnieManager serviceCompagnie;
	@Autowired
	AeroportManager serviceAeroport;
	@Autowired
	InfoEscaleManager serviceEscale;
	@Autowired
	ClasseManager serviceClasse;
	
	@RequestMapping(path="add", method = RequestMethod.POST)
	public ModelAndView addVol(Model model,@RequestParam String dateDepart,
			                               @RequestParam String dateArrivee,@RequestParam  String heureDepart,
			                               @RequestParam String heureArrivee,@RequestParam int aeroportDepartid,
			                               @RequestParam int aeroportArriveeid,
			                               @RequestParam int compagnieid,@RequestParam boolean open,
			                               @RequestParam String heureArriveeEscale,@RequestParam String heureDepartEscale,
			                               @RequestParam int aeroportEscale) throws Exception{
		                                   //@RequestParam String Économique,
			                               //@RequestParam String Premium,@RequestParam String Affaires,@RequestParam String Première,
			                               //@RequestParam int prixclasse1,@RequestParam int prixclasse2,
			                               //@RequestParam int prixclasse3,@RequestParam int prixclasse4
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date datedepart = formatter.parse(dateDepart);
		Date datearrivee= formatter.parse(dateArrivee);
	      try { 
	    	  Compagnie compagnie= new Compagnie(); 
	    	  compagnie=serviceCompagnie.getCompagnieById(compagnieid);
	    	 Aeroport aeroportdepart= new Aeroport();
	    	 Aeroport aeroportarrivee= new Aeroport();
	    	 Aeroport aeroportescale= new Aeroport();
	    	 aeroportdepart=serviceAeroport.getAeroportById(aeroportDepartid);
	    	  aeroportarrivee=serviceAeroport.getAeroportById(aeroportArriveeid);
	    	  aeroportescale=serviceAeroport.getAeroportById(aeroportEscale);
	    	 Vol a= new Vol(datedepart, datearrivee, heureDepart, heureArrivee,false,open,aeroportdepart,aeroportarrivee,compagnie);
	    	 InfoEscale E= new InfoEscale(heureArriveeEscale, heureDepartEscale, a, aeroportescale);
	    	 
	    	// Classe C = new Classe(Économique,prixclasse1,false,a);
	    	 serviceVol.add(a);
	    	 serviceEscale.add(E);
	    	// serviceClasse.add(C);
		
		    ArrayList<Vol> listes = new ArrayList<>();
			  for(Vol vol:serviceVol.list()){
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
		//return null;
		return null;}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listVol(Model model) throws Exception {
	    try {
	    	//Assurance a = new Assurance();
	    	//System.out.println(a.isDeleted());
	    	
	    	ArrayList<Vol> listes = new ArrayList<>();
			  for(Vol vol:serviceVol.list()){
				//  System.out.println(vol.getHeureDepart());
				  
				if(!vol.isDeleted()){
					 listes.add(vol);
				 }
			  }
			  ArrayList<Aeroport> listesAeroport = new ArrayList<>();
			  for(Aeroport aeroport:serviceAeroport.list()){
				  
				 if(!aeroport.isDeleted()){
					 listesAeroport.add(aeroport);
					  //System.out.println("Supprimer");
				 }
			  }
			  ArrayList<Compagnie> listesCompagnie = new ArrayList<>();
			  for(Compagnie compagnie:serviceCompagnie.list()){
				  
				 if(!compagnie.isDeleted()){
					 listesCompagnie.add(compagnie);
				 }
			  }
			  model.addAttribute("listeCompagnie",listesCompagnie);
			  model.addAttribute("listeAeroport",listesAeroport);  
			  model.addAttribute("listeVol",listes);
			  return new ModelAndView("vol");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null; 
	}

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
	}*/
	
	@RequestMapping(path="delete", method = RequestMethod.GET)
	public ModelAndView deleteVol(Model model,@RequestParam int id) {
	    try {
	    	serviceVol.delete(id);
		  
	    	ArrayList<Vol> listes = new ArrayList<>();
		  for(Vol vol:serviceVol.list()){
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
	}

}
