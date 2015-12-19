package reservation.presentation.user;



import javax.servlet.http.HttpSession;

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
import reservation.metier.ReservationManager;
import reservation.metier.SiegeManager;
import reservation.model.Assurance;
import reservation.model.PositionSiege;
import reservation.model.RangSiege;
import reservation.model.Reservation;
import reservation.model.Siege;

@Controller
public class PaiementController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	ReservationManager serviceReservation;
	@Autowired
	AssuranceManager serviceAssurance;
	
	@Autowired
	SiegeManager serviceSiege;
	
	@RequestMapping(path = "confirmation", method = RequestMethod.POST)
	public ModelAndView listerAssurances(Model model, HttpSession session, 
											@RequestParam int idAssuranceA,
											@RequestParam int idAssuranceMo,
											@RequestParam int idAssuranceMa,
											@RequestParam String assurance,
											@RequestParam int baggage,
											@RequestParam String fenetre,
											@RequestParam String position,
											@RequestParam String rang) {
		int idAssurance=0;
		session.getAttribute("idReservationDepart");
		
		int idReservationDepart= (int) session.getAttribute("idReservationDepart");
		int idReservationRetour;
		try {
					//r�cup�rer l'id de l'assurance
					if(assurance.equals("AssuranceMort")) 
					{
						idAssurance= idAssuranceMo;
						System.out.println("assurance de mort");
					}else if(assurance.equals("AssuranceAccident")){
						idAssurance=idAssuranceA;
						System.out.println("assurance accident");
					}else if(assurance.equals("AssuranceMalade"))
					{
						idAssurance=idAssuranceMa;
						System.out.println("assurance maladie");
					}
			//ajouter les info a la reservation du depart
					Reservation reservationDepart = serviceReservation.getReservationById(idReservationDepart);
						//ajouter assurance � la reservation
					Assurance assuranceReservation=serviceAssurance.getAssuranceById(idAssurance);
					reservationDepart.setAssurance(assuranceReservation);
						//cr�er siege
					Siege siege= new Siege();
					//fenetre siege
					boolean fenetr=false;
					if(fenetre.equals("true"))
					{
						 fenetr= true;
					}
					siege.setCote_fenetre(fenetr);
					//position siege
					PositionSiege posi=PositionSiege.valueOf(position);
					System.out.println(posi);
					siege.setPosition(posi);
					//rang siege
					RangSiege ran=RangSiege.valueOf(rang);
					siege.setRang(ran);
					serviceSiege.add(siege); //ajout du siege � la bd
					//siege pret pr etre ajout� sur reservation
					reservationDepart.setSiege(siege);
					//enregistrer le tt 
					serviceReservation.update(reservationDepart);
					
			//ajouter les info � la reservation du retour
					if(session.getAttribute("idReservationRetour").equals("false"))
					{
						System.out.println("Pas de retour");
					}
					else {
						idReservationRetour= (int) session.getAttribute("idReservationRetour");
						Reservation reservationRetour = serviceReservation.getReservationById(idReservationRetour);
						reservationRetour.setAssurance(assuranceReservation);
						reservationRetour.setSiege(siege);
						serviceReservation.update(reservationRetour);
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		System.out.println("rang "+rang);
		System.out.println("idassurance "+idAssurance);
		System.out.println("baggage "+baggage);
		System.out.println("fenetre "+fenetre);
		System.out.println("position "+position);
		System.out.println("assurance name"+assurance);
		return new ModelAndView("validation");

	}
}
