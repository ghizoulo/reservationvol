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

import reservation.metier.AeroportManager;
import reservation.metier.ClasseManager;
import reservation.metier.CompagnieManager;
import reservation.metier.InfoEscaleManager;
import reservation.metier.VolManager;
import reservation.model.Classe;

@Controller
public class ListeVolesCherchesController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	VolManager serviceVoll;
	@Autowired
	AeroportManager serviceAeroportt;
	
	@Autowired
	CompagnieManager serviceCompagniee;
	
	@Autowired
	InfoEscaleManager serviceEscalee;
	
	@Autowired
	ClasseManager serviceClasse;
	
	@RequestMapping(path = "listeVolesCherchers", method = RequestMethod.POST)
	public ModelAndView sommePrix(Model model,HttpSession session, @RequestParam int idVolDepart, @RequestParam int idVolRetour) {
				
				session.setAttribute("idVolDepart", idVolDepart);
				session.setAttribute("idVolRetour", idVolRetour);
				System.out.println(session.getAttribute("classe"));
					try {
						for (Classe classe : serviceClasse.list()) {
							if (classe.getVol().getId()==idVolDepart && classe.getNomClasse().toString().equals(session.getAttribute("classe"))) {
								session.setAttribute("prixDepart", classe.getPrix());
							}
							if (classe.getVol().getId()==idVolRetour && classe.getNomClasse().toString().equals(session.getAttribute("classe"))) {
								session.setAttribute("prixRetour", classe.getPrix());
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			return new ModelAndView("infoPassager");
	}
	
}
