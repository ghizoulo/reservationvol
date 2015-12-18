package reservation.presentation;

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
import reservation.model.InfoEscale;
import reservation.model.TypeClasse;
import reservation.model.Vol;

@Controller
@RequestMapping(value = "/vol")
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

	@RequestMapping(path = "/vol/add", method = RequestMethod.POST)
	public ModelAndView addVol(Model model, @RequestParam String dateDepart, @RequestParam String dateArrivee,
			@RequestParam String heureDepart, @RequestParam String heureArrivee, @RequestParam int aeroportDepartid,
			@RequestParam int aeroportArriveeid, @RequestParam int compagnieid, @RequestParam boolean open,
			@RequestParam String heureArriveeEscale, @RequestParam String heureDepartEscale,
			@RequestParam int aeroportEscale, @RequestParam int prixclasse1,
			@RequestParam int prixclasse2, @RequestParam int prixclasse3, @RequestParam int prixclasse4)throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date datedepart = formatter.parse(dateDepart);
		Date datearrivee = formatter.parse(dateArrivee);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		System.out.println(heureDepart);
		System.out.println(sdf.parse(heureDepart));
		Date hDepart = sdf.parse(heureDepart);
		Date hArrive = sdf.parse(heureArrivee);
		try {
			//instanciation des classes 
			Compagnie compagnie = new Compagnie();
			Aeroport aeroportdepart = new Aeroport();
			Aeroport aeroportarrivee = new Aeroport();
			Aeroport aeroportescale = new Aeroport();
			//initialisation des classes
			compagnie = serviceCompagnie.getCompagnieById(compagnieid);
			aeroportdepart = serviceAeroport.getAeroportById(aeroportDepartid);
			aeroportarrivee = serviceAeroport.getAeroportById(aeroportArriveeid);
			// creer un vol
			Vol a = new Vol(datedepart, datearrivee, hDepart, hArrive, false, open, aeroportdepart,
					aeroportarrivee, compagnie);
			//ajout du vol
			serviceVol.add(a);
			//ajout des classes
			serviceClasse.add(new Classe(TypeClasse.Economique, prixclasse1, false, a));
			serviceClasse.add(new Classe(TypeClasse.Premium, prixclasse2, false, a));
			serviceClasse.add(new Classe(TypeClasse.Affaire, prixclasse3, false, a));
			serviceClasse.add(new Classe(TypeClasse.Premiere, prixclasse4, false, a));
			//ajout de l'escale
			//tester si les champs de escale sont empty cad vol sans escale

			if(heureArriveeEscale == "" && heureDepartEscale ==""){
				System.out.println("khawya");
				
				
			}else{
			aeroportescale = serviceAeroport.getAeroportById(aeroportEscale);
			serviceEscale.add(new InfoEscale(heureArriveeEscale, heureDepartEscale, a, aeroportescale));
			// serviceClasse.add(C);
			}

			ArrayList<Vol> listes = new ArrayList<>();
			for (Vol vol : serviceVol.list()) {
				if (!vol.isDeleted()) {
					listes.add(vol);
				}
			}

			model.addAttribute("listeVol", listes);
			return new ModelAndView("vol");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		// return null;
		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listVol(Model model) throws Exception {
		
		//on teste si la liste des vols est vide si oui
		//on charge la liste des aeroports et de compagnie
		//pour l'utiliser dans l'ajout d'un nouveau vol
		// et on returne vol.jsp
		if(serviceVol.list().isEmpty()){
			ArrayList<Aeroport> listesAeroport = new ArrayList<>();
			for (Aeroport aeroport : serviceAeroport.list()) {
	
				if (!aeroport.isDeleted()) {
					listesAeroport.add(aeroport);
				}
			}
			ArrayList<Compagnie> listesCompagnie = new ArrayList<>();
			for (Compagnie compagnie : serviceCompagnie.list()) {
				if (!compagnie.isDeleted()) {
					listesCompagnie.add(compagnie);
				}
			}
			model.addAttribute("listeCompagnie", listesCompagnie);
			model.addAttribute("listeAeroport", listesAeroport);
			return new ModelAndView("vol");
		}
		else{
			//sinon la liste des vols, des aeroports et des compagnies
			// sont chargé pour les afficher
			// la vue vol.jsp est returné
			try {
				ArrayList<Vol> listes = new ArrayList<>();
				for (Vol vol : serviceVol.list()) {
					if (!vol.isDeleted()) {
						listes.add(vol);
					}
				}
				ArrayList<Aeroport> listesAeroport = new ArrayList<>();
				for (Aeroport aeroport : serviceAeroport.list()) {
		
					if (!aeroport.isDeleted()) {
						listesAeroport.add(aeroport);
					}
				}
				ArrayList<Compagnie> listesCompagnie = new ArrayList<>();
				for (Compagnie compagnie : serviceCompagnie.list()) {
					if (!compagnie.isDeleted()) {
						listesCompagnie.add(compagnie);
					}
				}
				model.addAttribute("listeCompagnie", listesCompagnie);
				model.addAttribute("listeAeroport", listesAeroport);
				model.addAttribute("listeVol", listes);
				return new ModelAndView("vol");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("erreeeeu");
			}
		}
		return null;
	}
	@RequestMapping(path = "ListForm", method = RequestMethod.POST)
	public ModelAndView listInForm(Model model) throws Exception {
		
		System.out.println("focntion list form");
		//on teste si la liste des vols est vide si oui
		//on charge la liste des aeroports et de compagnie
		//pour l'utiliser dans l'ajout d'un nouveau vol
		// et on returne vol.jsp
		if(serviceVol.list().isEmpty()){
			ArrayList<Aeroport> listesAeroport = new ArrayList<>();
			for (Aeroport aeroport : serviceAeroport.list()) {
	
				if (!aeroport.isDeleted()) {
					listesAeroport.add(aeroport);
				}
			}
			ArrayList<Compagnie> listesCompagnie = new ArrayList<>();
			for (Compagnie compagnie : serviceCompagnie.list()) {
				if (!compagnie.isDeleted()) {
					listesCompagnie.add(compagnie);
				}
			}
			model.addAttribute("listeCompagnie", listesCompagnie);
			model.addAttribute("listeAeroport", listesAeroport);
			System.out.println("avant addVol");
			return new ModelAndView("addVol");
		}
		else{
			//sinon la liste des vols, des aeroports et des compagnies
			// sont chargé pour les afficher
			// la vue vol.jsp est returné
			try {
				ArrayList<Vol> listes = new ArrayList<>();
				for (Vol vol : serviceVol.list()) {
					if (!vol.isDeleted()) {
						listes.add(vol);
					}
				}
				ArrayList<Aeroport> listesAeroport = new ArrayList<>();
				for (Aeroport aeroport : serviceAeroport.list()) {
		
					if (!aeroport.isDeleted()) {
						listesAeroport.add(aeroport);
					}
				}
				ArrayList<Compagnie> listesCompagnie = new ArrayList<>();
				for (Compagnie compagnie : serviceCompagnie.list()) {
					if (!compagnie.isDeleted()) {
						listesCompagnie.add(compagnie);
					}
				}
				model.addAttribute("listeCompagnie", listesCompagnie);
				model.addAttribute("listeAeroport", listesAeroport);
				model.addAttribute("listeVol", listes);
				System.out.println("avant: add Vooool");
				return new ModelAndView("addVol");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("erreeeeu");
				return null;
			}
		}
	}
	

	@RequestMapping(path = "delete", method = RequestMethod.GET)
	public ModelAndView deleteVol(Model model, @RequestParam int id) {
		try {
			serviceVol.delete(id);

			ArrayList<Vol> listes = new ArrayList<>();
			for (Vol vol : serviceVol.list()) {
				if (!vol.isDeleted()) {
					listes.add(vol);
					System.out.println("Supprimer");
				}
			}

			model.addAttribute("listeVol", listes);
			return new ModelAndView("vol");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	@RequestMapping(path="updatUp", method = RequestMethod.GET)
	public ModelAndView updateVolUp(Model model,@RequestParam int id) {
	    try {
	    	System.out.println("je suis dans la fonction update");
	    	Vol a =new Vol();
	    	a = serviceVol.getVolById(id);
	    	a.setOpen(true);
	    	serviceVol.update(a);
		    ArrayList<Vol> listes = new ArrayList<>();
			for (Vol vol : serviceVol.list()) {
				if (!vol.isDeleted()) {
					listes.add(vol);
				}
			}

			model.addAttribute("listeVol", listes);
			return new ModelAndView("vol");
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	@RequestMapping(path="updatDown", method = RequestMethod.GET)
	public ModelAndView updateVolDown(Model model,@RequestParam int id) {
	    try {
	    	System.out.println("je suis dans la fonction update");
	    	Vol a =new Vol();
	    	a = serviceVol.getVolById(id);
	    	a.setOpen(false);
	    	serviceVol.update(a);
		    ArrayList<Vol> listes = new ArrayList<>();
			for (Vol vol : serviceVol.list()) {
				if (!vol.isDeleted()) {
					listes.add(vol);
				}
			}

			model.addAttribute("listeVol", listes);
			return new ModelAndView("vol");
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	

}
