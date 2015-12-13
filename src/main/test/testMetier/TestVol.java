package testMetier;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

public class TestVol {
ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception{
		ctx =  new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
	}
	
	@Test 
	public void test_metier(){
		VolManager volMetier = (VolManager) ctx.getBean("volServiceImpl");
		ClasseManager classeMetier = (ClasseManager) ctx.getBean("classeServiceImpl");
		InfoEscaleManager escaleMetier = (InfoEscaleManager) ctx.getBean("infoEscaleServiceImpl");
		CompagnieManager compagnieMetier = (CompagnieManager) ctx.getBean("compagnieServiceImpl");
		AeroportManager aeroportMetier = (AeroportManager) ctx.getBean("aeroportServiceImpl");
		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date datedepart = formatter.parse("14/12/2015");
//		Date datearrivee = formatter.parse("15/12/2015");
//		try {
//			Compagnie compagnie = new Compagnie();
//			Aeroport aeroportdepart = new Aeroport();
//			Aeroport aeroportarrivee = new Aeroport();
//			Aeroport aeroportescale = new Aeroport();
//			//initialisation des classes
//			compagnie = compagnieMetier.getCompagnieById(1);
//			aeroportdepart = aeroportMetier.getAeroportById(1);
//			aeroportarrivee = aeroportMetier.getAeroportById(16);
//			aeroportescale = aeroportMetier.getAeroportById(15);
//			
//			Vol a = new Vol(datedepart, datearrivee, heureDepart, heureArrivee, false, true, aeroportdepart,
//					aeroportarrivee, compagnie);
//			classeMetier.add(new Classe(TypeClasse.Economique, 555, false, a));
//			classeMetier.add(new Classe(TypeClasse.Premium, 555, false, a));
//			classeMetier.add(new Classe(TypeClasse.Affaire, 555, false, a));
//			classeMetier.add(new Classe(TypeClasse.Premiere, 555, false, a));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
