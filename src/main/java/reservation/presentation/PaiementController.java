package reservation.presentation;



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

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

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
					//récupérer l'id de l'assurance
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
					
						//ajouter assurance à la reservation
					Assurance assuranceReservation=serviceAssurance.getAssuranceById(idAssurance);
					int prixAssurance=assuranceReservation.getTarif();
					reservationDepart.setAssurance(assuranceReservation);
					reservationDepart.setQuantite_bagage(baggage);
					
						//créer siege
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
					session.setAttribute("mdp", reservationDepart.getNumero());
					//rang siege
					RangSiege ran=RangSiege.valueOf(rang);
					siege.setRang(ran);
					serviceSiege.add(siege); //ajout du siege à la bd
					
					//siege pret pr etre ajouté sur reservation
					reservationDepart.setSiege(siege);
					
					//enregistrer le tt 
					serviceReservation.update(reservationDepart);
					int prixDepart=(int) session.getAttribute("prixDepart");
					int prixRetour = 0;
					int prix_total = prixDepart+prixRetour;
					System.out.println("prix total avant ajout des frais"+prix_total);
					
			//ajouter les info à la reservation du retour
					if(session.getAttribute("idReservationRetour").equals("false"))
					{
						prix_total+=baggage+prixAssurance; //si pas de retour , on ajoute les frais de l'assurance et du baggage
						System.out.println("pas de retour");
						session.setAttribute("prix_total", prix_total);
					}
					else {
						prixRetour=(int) session.getAttribute("prixRetour");
						idReservationRetour= (int) session.getAttribute("idReservationRetour");
						Reservation reservationRetour = serviceReservation.getReservationById(idReservationRetour);
						reservationRetour.setAssurance(assuranceReservation);
						reservationRetour.setSiege(siege);
						reservationRetour.setQuantite_bagage(baggage);
						serviceReservation.update(reservationRetour);
						prix_total+=baggage*2+prixAssurance*2; //si avec retour on ajoute le tout deux fois
						System.out.println(" prix après ajout des frais "+prix_total);
						session.setAttribute("prix_total", prix_total);
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
		send_mail((String)session.getAttribute("emailClient"),(int)session.getAttribute("mdp"));
		return new ModelAndView("validation");

	}
	
	public void send_mail(String emailClient,int id){
		SendGrid sendgrid = new SendGrid("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");
		
		SendGrid.Email email = new SendGrid.Email();

	    email.addTo("ghizlanelotfi@gmail.com");
	    email.setFrom(emailClient);
	    email.setSubject("Merci pour votre réservation de vol");
	    email.setHtml("Votre réservation a été bien enregistrée,pour vous authentifier, votre username est votre email, et le mot de "
	    		+ "passe est votre numéro de reservation, gardez le bien:" + id);
		
		try {
			sendgrid.send(email);
			System.out.println("success");
		} catch (SendGridException e) {
			System.out.println("echec");
			e.printStackTrace();
		}
	}
}
