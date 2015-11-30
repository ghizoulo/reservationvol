package testMetier;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import reservation.metier.AeroportManager;
import reservation.model.Aeroport;

public class TestAeroport {

	ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception{
		ctx =  new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
	}
	
	@Test 
	public void test_metier(){
		AeroportManager aeroportMetier = (AeroportManager) ctx.getBean("aeroportServiceImpl");
		try {
				//recuperer la liste des aeroports
			//List<Aeroport> before_insert = aeroportMetier.list();
				//ajouter une nouvelle aeroport
			aeroportMetier.add(new Aeroport("Aeroport casablanca","Casablanca",false));
				//modifier une aeroport
			aeroportMetier.add(new Aeroport("Aeroport Paris","Paris", false));
				//supprimer une aeroport
			//aeroportMetier.delete(1);
				//rechercher une aeroport by id
			Aeroport aeroport = aeroportMetier.getAeroportById(1);
				//recuperer la nouvelle liste d'aeroport
			List<Aeroport> after_insert = aeroportMetier.list();
				//verifie si l'aeroport recherché est bien trouvé
			assertTrue("get Aeroport by id", aeroport != null);
				//vérifie si la liste d'aeroport récupérée au début + 1 est = à la nouvelle liste
			assertTrue(after_insert.size()==2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
