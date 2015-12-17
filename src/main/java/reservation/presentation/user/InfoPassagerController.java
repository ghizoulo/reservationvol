package reservation.presentation.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import reservation.metier.ClientManager;
import reservation.metier.PassagerManager;
import reservation.metier.ReservationManager;
import reservation.metier.VolManager;
import reservation.model.Client;
import reservation.model.Passager;
import reservation.model.Reservation;
import reservation.validators.PassagerClient;
@Controller
public class InfoPassagerController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	PassagerManager servicePassager;
	@Autowired
	ClientManager serviceClient;
	@Autowired
	VolManager serviceVol;
	@Autowired
	ReservationManager serviceReservation;
	
	@RequestMapping(path = "infoPassager", method = RequestMethod.POST)
	public ModelAndView deleteVol(@Valid PassagerClient passagerClient, BindingResult result,Model model,HttpSession session) {
		if (result.hasErrors()) {
			return new ModelAndView("infoPassager");
        }
		int lower = 1; 
		int higher = 1000000000; 

		int numReserv = (int)(Math.random() * (higher+1-lower)) + lower; 
		System.out.println(numReserv);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateToday = new Date();
		
		//ajouter les informations du formulaire � la base de donn�e
		try {
			
			//new passager
			Passager passager= new Passager();
			passager.setNom(passagerClient.getNomP());
			passager.setPrenom(passagerClient.getPrenomP());
			passager.setDateExpiration(formatter.parse(passagerClient.getDateExpiration()));
			passager.setDeleted(false);
			passager.setNationalite(passagerClient.getNationalite());
			passager.setNum_passport(passagerClient.getNum_passport());
			servicePassager.add(passager);
			
			//new Client
			Client client= new Client();
			client.setNom(passagerClient.getNomC());
			client.setPrenom(passagerClient.getPrenomC());
			client.setAdresse(passagerClient.getAdresseC());
			client.setDeleted(false);
			client.setMail(passagerClient.getMailC());
			client.setTelephone(passagerClient.getTelephoneC());
			serviceClient.add(client);
			
			//new reservation
			Reservation reservationDepart= new Reservation();
			reservationDepart.setDate(dateToday); 	//date de la reservation
			reservationDepart.setClient(serviceClient.getClientById(client.getId())); 			//client de la reservation
			reservationDepart.setPassager(servicePassager.getPassagerById(passager.getId())); 	//passager de la resrevation	
			int idVolDepart= (int) session.getAttribute("idVolDepart");							
			int idVolRetour= (int) session.getAttribute("idVolRetour");
			reservationDepart.setNumero(numReserv);
			reservationDepart.setVol(serviceVol.getVolById(idVolDepart));						//vol de l resrevation
			serviceReservation.add(reservationDepart);
			
			//si u vol de reservation est choisi on va remplir une reservation de retour vc les mm num reservation et mm client et passager
			if(idVolRetour!=0)
			{
				//
				Reservation reservationRetour=new Reservation();
				reservationRetour.setDate(dateToday); 	//date de la reservation
				reservationRetour.setClient(serviceClient.getClientById(client.getId())); 			//client de la reservation
				reservationRetour.setPassager(servicePassager.getPassagerById(passager.getId())); 	//passager de la resrevation
				reservationRetour.setNumero(numReserv);
				reservationRetour.setVol(serviceVol.getVolById(idVolRetour));						//vol de la resrevation
				serviceReservation.add(reservationRetour);
			}
			
			return new ModelAndView("Paiement");
		}
		
		catch(Exception e){
			
		}
		return new ModelAndView("Paiement");
	}
}