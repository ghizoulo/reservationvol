package reservation.presentation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

import reservation.metier.AeroportManager;
import reservation.metier.ClasseManager;
import reservation.metier.CompagnieManager;
import reservation.metier.DashboardManager;
import reservation.metier.InfoEscaleManager;
import reservation.metier.ReservationManager;
import reservation.metier.VolManager;
import reservation.model.Aeroport;
import reservation.model.Classe;
import reservation.model.Compagnie;
import reservation.model.InfoEscale;
import reservation.model.Reservation;
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
	
	@Autowired
	ReservationManager serviceReservation;
	
	@Autowired
	InfoEscaleManager serviceInfoEscale;
	
	@Autowired
	DashboardManager serviceDashboard;
	
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
	
	@RequestMapping(path="dashboard.htm", method= RequestMethod.GET)
    public ModelAndView showWelcome(Model model){
        logger.info("WelcomeController: returning welcome view");
        
		DateTime dateToday = new DateTime();
        try {
			for(Reservation reserv: serviceReservation.list()){
				Date dt= reserv.getDate();
				DateTime dtOrg = new DateTime(dt);
				DateTime dtPlusOne = dtOrg.plusDays(15);
				String dateReservation = dtPlusOne.toString( "yyyy-MM-dd");
				String dateSystem = dateToday.toString( "yyyy-MM-dd");
//				System.out.println(dtPlusOne.toString( "yyyy-MM-dd")); 
//				System.out.println("time is " + dtPlusOne+"hhhh"+dateToday);
				if(dateReservation.equals(dateSystem))
				{
					System.out.println("envoi mail");
					send_mail(reserv.getClient().getMail(), reserv.getId());
				}
				else{
					System.out.println("pas encore");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        model.addAttribute("NbrAeroports", serviceDashboard.getAeroportsNbr());
        model.addAttribute("NbrAssurances", serviceDashboard.getAssurancesNbr());
        model.addAttribute("NbrCompagnies", serviceDashboard.getCompagniesNbr());
        model.addAttribute("NbrReservations", serviceDashboard.getReservationsNbr());
        model.addAttribute("NbrVols", serviceDashboard.getVolsNbr());
        return new ModelAndView("dashboard");
    }
	
	@RequestMapping(path = "chercherSimple",method = RequestMethod.POST)
	public ModelAndView chercherVolAlleeSimple(Model model,HttpSession session, 
													@RequestParam int idAeroportDepart, 
												 @RequestParam int idAeroportArrivee, 
												 @RequestParam String escale,
												 @RequestParam String dateDepart,
												 @RequestParam String classe,
												 @RequestParam int compagnie) {
		try {
			System.out.println(escale);
			boolean escaleb=false;
			if(escale.equals("Oui")) { escaleb=true; session.setAttribute("escale", "oui");}
				Aeroport AeroportDepart=null;
				Aeroport AeroportArrivee=null;
				ArrayList<Vol> listeVolesDepart = new ArrayList<>();
				ArrayList<Classe> listeClassesDepart = new ArrayList<>();
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
				LocalSearchVol(compagnie,AeroportDepart,AeroportArrivee,listeVolesDepart,listeClassesDepart,classe, dateDepart, escaleb);
				
				//renvoie de elem
				model.addAttribute("listeVolesDepart", listeVolesDepart);
				model.addAttribute("listeClassesDepart", listeClassesDepart);
				model.addAttribute("depart", AeroportDepart.getNom());
				model.addAttribute("destination", AeroportArrivee.getNom());
				model.addAttribute("escale", escale);
				model.addAttribute("dateDepart", dateDepart);
				model.addAttribute("dateRetour", "--");
				model.addAttribute("classe", classe);
				model.addAttribute("compagnie", compagnie);

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
	public ModelAndView chercherVolAlleeretour(Model model,HttpSession session, 
												 @RequestParam int idAeroportDepart, 
												 @RequestParam int idAeroportArrivee, 
												 @RequestParam String escale,
												 @RequestParam String dateDepart,
												 @RequestParam String dateRetour,
												 @RequestParam String classe,
												 @RequestParam int compagnie) {
		try {
			boolean escaleb=false;
			if(escale.equals("Oui")) { escaleb=true; session.setAttribute("escale", "Oui");}
				Aeroport AeroportDepart=null;
				Aeroport AeroportArrivee=null;
				ArrayList<Vol> listeVolesDepart = new ArrayList<>();
				ArrayList<Vol> listeVolesRetour = new ArrayList<>();
				ArrayList<Classe> listeClassesDepart = new ArrayList<>();
				ArrayList<Classe> listeClassesRetour = new ArrayList<>();
				
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
				LocalSearchVol(compagnie,AeroportDepart,AeroportArrivee,listeVolesDepart,listeClassesDepart,classe,dateDepart, escaleb);
				
				//call of fct local search des voles pour remplir voles Arrivee
				LocalSearchVol(compagnie,AeroportArrivee,AeroportDepart,listeVolesRetour,listeClassesRetour,classe, dateRetour, escaleb);
				
				model.addAttribute("listeVolesDepart", listeVolesDepart);
				model.addAttribute("listeVolesRetour", listeVolesRetour);
				model.addAttribute("listeClassesDepart", listeClassesDepart);
				model.addAttribute("listeClassesRetour", listeClassesRetour);
				model.addAttribute("depart", AeroportDepart.getNom());
				model.addAttribute("destination", AeroportArrivee.getNom());
				model.addAttribute("escale", escale);
				model.addAttribute("dateDepart", dateDepart);
				model.addAttribute("dateRetour", dateRetour);
				model.addAttribute("classe", classe);
				model.addAttribute("compagnie", compagnie);
				
				return new ModelAndView("listeVolesCherches");
			} catch (Exception e) 
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("erreeeeu");
			  }
		return null;
	}
	//private void LocalSearchClasses()
	private void LocalSearchVol(int compagnie,Aeroport Aedepart,
								Aeroport Aearrivee, ArrayList<Vol> listeVoles,ArrayList<Classe> listeClasses,
								String classe, String dateDepart,boolean escaleb)
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
						//verifier si le vol contient la classe demandée
					for (Classe clas : serviceClasse.list())
					{
						if(clas.getNomClasse().toString().equals(classe) && clas.getVol().getId()==vol.getId() && !clas.isDeleted())
							{
								if(escaleb==false)
								{
									listeVoles.add(vol);
									listeClasses.add(clas);
								}
								else	
								{
									for(InfoEscale infoEscale: serviceInfoEscale.list())
									{
										if(infoEscale.getVol().equals(vol))
										{
											listeVoles.add(vol);
											listeClasses.add(clas);
										}
									}
								}
							}
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
	@RequestMapping(value="/index")
	public ModelAndView initIndex(Model model) throws Exception {
		try {
			
			
			ArrayList<Aeroport> dropAeroport = new ArrayList<>();
			for (Aeroport aeroport : serviceAeroport.list()) {
				if (!aeroport.isDeleted()) {
					dropAeroport.add(aeroport);
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
	@RequestMapping(value="/loginUser")
	public ModelAndView loginUser(Model model) throws Exception {
		return new ModelAndView("authentificationUser");
		
	}
	
	public void send_mail(String emailClient,int id){
		SendGrid sendgrid = new SendGrid("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");
		
		SendGrid.Email email = new SendGrid.Email();

	    email.addTo("ghizlanelotfi@gmail.com");
	    email.setFrom(emailClient);
	    email.setSubject("Annulation de votre réservation de vol");
	    email.setHtml("Votre réservation a été annulée");
		
		try {
			sendgrid.send(email);
			System.out.println("success");
		} catch (SendGridException e) {
			System.out.println("echec");
			e.printStackTrace();
		}
	}
}
