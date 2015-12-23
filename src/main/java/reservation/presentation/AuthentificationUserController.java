package reservation.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reservation.metier.ClientManager;
import reservation.metier.ReservationManager;

import reservation.model.Client;
import reservation.model.Reservation;

@Controller
public class AuthentificationUserController {
//authentificationUser
	
	@Autowired
	ClientManager serviceClient;
	@Autowired
	ReservationManager serviceReservation;
	
	@RequestMapping(path = "authentificationUser", method = RequestMethod.POST)
	public ModelAndView authentifate(Model model, @RequestParam String username,@RequestParam String psw )
	{
		System.out.println(psw);
		System.out.println(username); 
		int password; 
		password = Integer.parseInt(psw);
		System.out.println("psw"+psw);
		System.out.println("password"+password);
		System.out.println("username"+username);
		 
		try {
			for(Client client : serviceClient.list())
			{
				if(client.getMail().equals(username)) //correspondance du mail
				{
					for(Reservation reservation : serviceReservation.list())
					{
						if( reservation.getNumero()== password)  //correspondance du num de reservation
						{
							System.out.println("ddddddddddd");
							return new ModelAndView("validation");
						}
						else{  //si le num de reservation ne correspond pas
							model.addAttribute("msg_erreur","Votre numero de reservation n'est pas valide, réessayez");
							return new ModelAndView("authentificationUser");
						}
					}
				}
				else {   //si le mail n'existe pas
					model.addAttribute("msg_erreur","Ce mail n'existe pas, entrez une adresse valide!");
					return new ModelAndView("authentificationUser");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("authentificationUser");
		
	}
	
}
