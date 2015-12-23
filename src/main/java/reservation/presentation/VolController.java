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
import org.springframework.web.servlet.view.RedirectView;

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
//@RequestMapping(value = "/vol")
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

	@RequestMapping(path = "/vol.htm",method = RequestMethod.GET)
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
	
	@RequestMapping(path = "/vol/ListForm.htm", method = RequestMethod.POST)
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
	@RequestMapping(path = "/vol/updateForm.htm", method = RequestMethod.GET)
	public ModelAndView updateForm(Model model, @RequestParam int id) throws Exception {
		
		System.out.println("focntion update form");
		//on teste si la liste des vols est vide si oui
		//on charge la liste des aeroports et de compagnie
		//pour l'utiliser dans l'ajout d'un nouveau vol
		// et on returne vol.jsp
		Vol v = new Vol();
		v = serviceVol.getVolById(id);
		if(serviceClasse.list().isEmpty()){
			return new ModelAndView("vol");
				
		}
		else{
			//sinon la liste des vols, des aeroports et des compagnies
			// sont chargé pour les afficher
			// la vue vol.jsp est returné
			try {
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
				ArrayList<Classe> listesClasse = new ArrayList<>();
				for (Classe classe : serviceClasse.list()) {
		               if (classe.getVol().getId()==id) {
		            	   listesClasse.add(classe);
		            	   }}
				
		            	Date depart=v.getDateDepart();
						System.out.println(depart);
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm");
						//Date datedepart = formatter.parse(depart.toString());
						formatter.format(v.getDateDepart().getTime());
						formatter.format(v.getDateArrivee().getTime());
						System.out.println(formatter.format(v.getDateDepart().getTime()));
						formatter1.format(v.getHeureDepart().getTime());
						formatter1.format(v.getHeureArrivee().getTime());
						System.out.println(formatter1.format(v.getHeureDepart().getTime()));
						model.addAttribute("Vol", v);
						for(Classe classetest :listesClasse ){
							if(classetest.getNomClasse().toString()=="Economique"){
								model.addAttribute("classe1", classetest.getPrix());
								model.addAttribute("idClasse1", classetest.getId());
							}
							if(classetest.getNomClasse().toString()=="Premium"){
								model.addAttribute("classe2", classetest.getPrix());
								model.addAttribute("idClasse2", classetest.getId());
							}
							if(classetest.getNomClasse().toString()=="Affaire"){
								model.addAttribute("classe3", classetest.getPrix());
								model.addAttribute("idClasse3", classetest.getId());
							}
							if(classetest.getNomClasse().toString()=="Premiere"){
								model.addAttribute("classe4", classetest.getPrix());
								model.addAttribute("idClasse4", classetest.getId());
							}
						}
						model.addAttribute("dateDepart",formatter.format(v.getDateDepart().getTime()));
						model.addAttribute("dateArrivee",formatter.format(v.getDateArrivee().getTime()));
						model.addAttribute("heureDepart",formatter1.format(v.getHeureDepart().getTime()));
						model.addAttribute("heureArrivee",formatter1.format(v.getHeureArrivee().getTime()));
						model.addAttribute("listeCompagnie", listesCompagnie);
						model.addAttribute("listeAeroport", listesAeroport);
						model.addAttribute("idVol", id);
						//model.addAttribute("listesClasse", listesClasse);
						
						return new ModelAndView("updateVol");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.info("erreeeeu");
				}
				return null;
			}
	}
	
	@RequestMapping(path = "vol/add.htm", method = RequestMethod.POST)
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
			return new ModelAndView(new RedirectView("/vol.htm", true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		// return null;
		return null;
	}
	@RequestMapping(path = "/vol/update", method = RequestMethod.POST)
	public ModelAndView updateVol(Model model,@RequestParam int id, @RequestParam String dateDepart, @RequestParam String dateArrivee,
			@RequestParam String heureDepart, @RequestParam String heureArrivee, @RequestParam int aeroportDepartid,
			@RequestParam int aeroportArriveeid, @RequestParam int compagnieid, @RequestParam boolean open, @RequestParam int prixclasse1,
			@RequestParam int prixclasse2, @RequestParam int prixclasse3, @RequestParam int prixclasse4,@RequestParam int idClasse1
			,@RequestParam int idClasse2,@RequestParam int idClasse3,@RequestParam int idClasse4)throws Exception {
		
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
			//initialisation des classes
			compagnie = serviceCompagnie.getCompagnieById(compagnieid);
			aeroportdepart = serviceAeroport.getAeroportById(aeroportDepartid);
			aeroportarrivee = serviceAeroport.getAeroportById(aeroportArriveeid);
			// creer un vol
			Vol a = new Vol(id,datedepart, datearrivee, hDepart, hArrive, false, open, aeroportdepart,
					aeroportarrivee, compagnie);
			//update du vol
			serviceVol.update(a);
			//update des classes
			serviceClasse.update(new Classe(idClasse1,TypeClasse.Economique, prixclasse1, false, a));
			serviceClasse.update(new Classe(idClasse2,TypeClasse.Premium, prixclasse2, false, a));
			serviceClasse.update(new Classe(idClasse3,TypeClasse.Affaire, prixclasse3, false, a));
			serviceClasse.update(new Classe(idClasse4,TypeClasse.Premiere, prixclasse4, false, a));
			

			ArrayList<Vol> listes = new ArrayList<>();
			for (Vol vol : serviceVol.list()) {
				if (!vol.isDeleted()) {
					listes.add(vol);
				}
			}

			model.addAttribute("listeVol", listes);
			return new ModelAndView(new RedirectView("/vol.htm", true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		// return null;
		return null;
	}

	@RequestMapping(path = "/vol/delete.htm", method = RequestMethod.GET)
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
			return new ModelAndView(new RedirectView("/vol.htm", true));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	@RequestMapping(path="/vol/updatUp.htm", method = RequestMethod.GET)
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
			return new ModelAndView(new RedirectView("/vol.htm", true));
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	@RequestMapping(path="/vol/updatDown.htm", method = RequestMethod.GET)
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
			return new ModelAndView(new RedirectView("/vol.htm", true));
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	

}
