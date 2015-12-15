package reservation.presentation.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import reservation.metier.AeroportManager;
import reservation.metier.ClasseManager;
import reservation.metier.CompagnieManager;
import reservation.metier.InfoEscaleManager;
import reservation.metier.VolManager;
import reservation.model.Aeroport;
import reservation.model.Classe;
import reservation.model.Compagnie;
import reservation.model.Vol;


@Controller
public class IndexController {
protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	VolManager serviceVol;
	@Autowired
	AeroportManager serviceAeroport;
	
	@Autowired
	CompagnieManager serviceCompagnie;
	
	@Autowired
	InfoEscaleManager serviceEscale;
	
	@Autowired
	ClasseManager serviceClasse;
	
	//pour chercher vol selon critères du formulaire
	/**
	 * @param model
	 * @param idAeroportDepart
	 * @param idAeroportArrivee
	 * @param escale
	 * @param dateDepart
	 * @param classe
	 * @param compagnie
	 * @return
	 */
	/**
	 * @param model
	 * @param idAeroportDepart
	 * @param idAeroportArrivee
	 * @param escale
	 * @param dateDepart
	 * @param classe
	 * @param compagnie
	 * @return
	 */
	@RequestMapping(path = "chercherSimple",method = RequestMethod.POST)
	public ModelAndView chercherVolAlleeSimple(Model model, @RequestParam int idAeroportDepart, 
												 @RequestParam int idAeroportArrivee, 
												 @RequestParam String escale,
												 @RequestParam String dateDepart,
												 @RequestParam String classe,
												 @RequestParam int compagnie) {
		try {
				
				Aeroport AeroportDepart=null;
				Aeroport AeroportArrivee=null;
				ArrayList<Vol> listeVoles = new ArrayList<>();
				for(Aeroport aeroport : serviceAeroport.list() )
				{
					if(aeroport.getId()==idAeroportDepart && !aeroport.isDeleted())
					{
						AeroportDepart=aeroport;
					}
					if(aeroport.getId()==idAeroportArrivee && !aeroport.isDeleted())
					{
						AeroportArrivee=aeroport;
					}
				}
				
				//call of fct local search des voles pour remplir voles depart
				LocalSearchVol(compagnie,AeroportDepart,AeroportArrivee,listeVoles,classe, dateDepart);
				for (Vol vo : listeVoles)
				{System.out.println(vo.getId());}
				//renvoie de elem
				model.addAttribute("listeVol", listeVoles);
				model.addAttribute("depart", AeroportDepart.getNom());
				model.addAttribute("destination", AeroportArrivee.getNom());
				model.addAttribute("escale", escale);
				model.addAttribute("dateDepart", dateDepart);
				model.addAttribute("dateRetour", "--");
				model.addAttribute("classe", classe);

				return new ModelAndView("listeVolesCherches");
				
			} catch (Exception e) 
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("erreeeeu");
			  }
		return null;
	}
	
	//la recherche associée Allée/retour
	@RequestMapping(path = "chercherAlleeRetour",method = RequestMethod.POST)
	public ModelAndView chercherVolAlleeretour(Model model, @RequestParam int idAeroportDepart, 
												 @RequestParam int idAeroportArrivee, 
												 @RequestParam String escale,
												 @RequestParam String dateDepart,
												 @RequestParam String dateRetour,
												 @RequestParam String classe,
												 @RequestParam int compagnie) {
		try {
				Aeroport AeroportDepart=null;
				Aeroport AeroportArrivee=null;
				ArrayList<Vol> listeVolesDepart = new ArrayList<>();
				ArrayList<Vol> listeVolesRetour = new ArrayList<>();
				
				//vérifier que l'aeroport n'est pas deleted
				for(Aeroport aeroport : serviceAeroport.list() )
				{
					if(aeroport.getId()==idAeroportDepart && !aeroport.isDeleted())
					{
						AeroportDepart=aeroport;
					}
					if(aeroport.getId()==idAeroportArrivee && !aeroport.isDeleted())
					{
						AeroportArrivee=aeroport;
					}
				}
				//call of fct local search des voles pour remplir voles depart
				LocalSearchVol(compagnie,AeroportDepart,AeroportArrivee,listeVolesDepart,classe, dateDepart);
				
				//call of fct local search des voles pour remplir voles Arrivee
				LocalSearchVol(compagnie,AeroportArrivee,AeroportDepart,listeVolesRetour,classe, dateRetour);
				
				model.addAttribute("listeVolesDepart", listeVolesDepart);
				model.addAttribute("listeVolesArrivee", listeVolesRetour);
				model.addAttribute("depart", AeroportDepart.getNom());
				model.addAttribute("destination", AeroportArrivee.getNom());
				model.addAttribute("escale", escale);
				model.addAttribute("dateDepart", dateDepart);
				model.addAttribute("dateRetour", dateRetour);
				model.addAttribute("classe", classe);
				return new ModelAndView("listeVolesCherches");
			} catch (Exception e) 
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("erreeeeu");
			  }
		return null;
	}
	private void LocalSearchVol(int compagnie,Aeroport Aedepart,
								Aeroport Aearrivee, ArrayList<Vol> listeVoles,
								String classe, String dateDepart)
	{
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			for (Vol vol : serviceVol.list())
			{
				if (!vol.isDeleted() && vol.isOpen() 
						&& vol.getCompagnie().getId()== compagnie
						&& vol.getAeroportDepart().getId()==(Aedepart.getId()) 
						&& vol.getAeroportArrivee().getId()==(Aearrivee.getId())
						&& formatter.format(vol.getDateDepart().getTime()).equals(dateDepart.toString()))
					{	
						System.out.println("condition date vérifiée");
						//verifier si le vol contient la classe demandée
						for (Classe clas : serviceClasse.list())
						{
							if(clas.getNomClasse().toString().equals(classe) && clas.getVol().getId()==vol.getId())
								{listeVoles.add(vol); }
						}
					}
			}
		}
		catch (Exception e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		  }
	}
	
	//pour remplir les dropdown list
	@RequestMapping(value={"/index", "/chercherSimple"})
	public ModelAndView initIndex(Model model) throws Exception {
		try {
			
			
			ArrayList<Aeroport> dropAeroport = new ArrayList<>();
			for (Aeroport aeroport : serviceAeroport.list()) {
				if (!aeroport.isDeleted()) {
					dropAeroport.add(aeroport);
					System.out.println(aeroport.getNom());
				}
			}
			
			ArrayList<Compagnie> dropCompagnie = new ArrayList<>();
			for (Compagnie compagnie : serviceCompagnie.list()) {

				if (!compagnie.isDeleted()) {
					dropCompagnie.add(compagnie);
				}
			}
			model.addAttribute("listeCompagnie", dropCompagnie);
			model.addAttribute("listeAeroport", dropAeroport);
			return new ModelAndView("indexUser");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}

}
