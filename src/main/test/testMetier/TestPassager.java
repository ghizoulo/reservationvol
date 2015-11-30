package testMetier;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import reservation.metier.PassagerManager;
import reservation.model.Passager;

public class TestPassager {

	ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception{
		ctx =  new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
	}
	
	@Test 
	public void test_metier(){
		PassagerManager passagerMetier = (PassagerManager) ctx.getBean("passagerServiceImpl");
		try {
				//recuperer la liste des passagers
			//List<Passager> before_insert = passagerMetier.list();
				//ajouter une nouvelle passager
			passagerMetier.add(new Passager("Ghiz","lotfi", false));
//			passagerMetier.add(new Passager(5000, TypePassager.PassagerAccident, false));
				//modifier une passager
			//passagerMetier.update(new Passager(2,5800,TypePassager.PassagerMalade, false));
				//supprimer une passager
			//passagerMetier.delete(1);
				//rechercher une passager by id
			Passager passager = passagerMetier.getPassagerById(1);
				//recuperer la nouvelle liste d'passager
			List<Passager> after_insert = passagerMetier.list();
				//verifie si l'passager recherché est bien trouvé
			assertTrue("get Passager by id", passager != null);
				//vérifie si la liste d'passager récupérée au début + 1 est = à la nouvelle liste
			assertTrue(after_insert.size()==1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
