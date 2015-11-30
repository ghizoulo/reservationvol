package testMetier;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import reservation.metier.AssuranceManager;
import reservation.model.Assurance;
import reservation.model.TypeAssurance;

public class TestAssurance {

	ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception{
		ctx =  new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
	}
	
	@Test 
	public void test_metier(){
		AssuranceManager assuranceMetier = (AssuranceManager) ctx.getBean("assuranceServiceImpl");
		
		try {
				//recuperer la liste des assurances
			List<Assurance> before_insert = assuranceMetier.list();
				//ajouter une nouvelle assurance
			assuranceMetier.add(new Assurance(5000, TypeAssurance.AssuranceAccident, false));
				//modifier une assurance
			assuranceMetier.update(new Assurance(2,5800,TypeAssurance.AssuranceMalade, false));
				//supprimer une assurance
			assuranceMetier.delete(1);
				//rechercher une assurance by id
			Assurance assurance = assuranceMetier.getAssuranceById(4);
				//recuperer la nouvelle liste d'assurance
			List<Assurance> after_insert = assuranceMetier.list();
				//verifie si l'assurance recherché est bien trouvé
			assertTrue("get Assurance by id", assurance != null);
				//vérifie si la liste d'assurance récupérée au début + 1 est = à la nouvelle liste
			assertTrue(before_insert.size()+1==after_insert.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
