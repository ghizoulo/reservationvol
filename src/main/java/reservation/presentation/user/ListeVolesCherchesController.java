package reservation.presentation.user;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import reservation.metier.AeroportManager;
import reservation.metier.ClasseManager;
import reservation.metier.CompagnieManager;
import reservation.metier.InfoEscaleManager;
import reservation.metier.VolManager;
import reservation.model.Aeroport;
import reservation.model.Compagnie;

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
	ClasseManager serviceClassee;
	
}
