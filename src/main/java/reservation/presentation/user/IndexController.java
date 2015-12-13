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
	@RequestMapping(path = "chercherSimple",method = RequestMethod.POST)
	public ModelAndView chercherVol(Model model, @RequestParam int idAeroportDepart, 
												 @RequestParam int idAeroportArrivee, 
												 @RequestParam String escale,
												 @RequestParam String dateDepart,
												 @RequestParam String classe,
												 @RequestParam int compagnie) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date datee = formatter.parse(dateDepart);

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
				
				for (Vol vol : serviceVol.list())
				{
					if (!vol.isDeleted() && vol.isOpen() 
							 && vol.getCompagnie().getId()== compagnie
							/*&& vol.getAeroportDepart().equals(AeroportDepart) 
							&& vol.getAeroportArrivee().equals(AeroportArrivee)*/)
						{	System.out.println("contient la classe");
							//verifier si le vol contient la classe demandée
							for (Classe clas : vol.getClasses())
							{
								if(clas.getNom().equals(classe))
									{listeVoles.add(vol); }
							}
						}
				} System.out.println("liste des voles de la recherche :");
				for (Vol vo : listeVoles)
				{
					
					System.out.println(vo.getId());
				}
				model.addAttribute("listeVol", listeVoles);
				
				return new ModelAndView("user/index");
				
			} catch (Exception e) 
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("erreeeeu");
			  }
		return null;
	}
	
	//pour remplir les dropdown list
	@RequestMapping(value="/index")
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
			return new ModelAndView("user/index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}

}
