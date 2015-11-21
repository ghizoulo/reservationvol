package testMetier;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import reservation.metier.CompagnieManager;
import reservation.model.Compagnie;

public class TestCompagnie {

ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception{
		ctx =  new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
	}
	
	@Test 
	public void test_metier(){
		CompagnieManager compagnieMetier = (CompagnieManager) ctx.getBean("compagnieServiceImpl");
		try {
				//recuperer la liste des compagnies
			List<Compagnie> before_insert = compagnieMetier.list();
				//ajouter une nouvelle compagnie
			compagnieMetier.add(new Compagnie("Royal air maroc",false));
			compagnieMetier.add(new Compagnie("Royal air France",false));
				//modifier une compagnie
			compagnieMetier.update(new Compagnie(1,"Royal Air Maroc", false));
				//supprimer une compagnie
			compagnieMetier.delete(2);
				//rechercher une compagnie by id
			Compagnie compagnie = compagnieMetier.getCompagnieById(1);
				//recuperer la nouvelle liste d'compagnie
			List<Compagnie> after_insert = compagnieMetier.list();
				//verifie si l'compagnie recherché est bien trouvé
			assertTrue("get Compagnie by id", compagnie != null);
				//vérifie si la liste d'compagnie récupérée au début + 1 est = à la nouvelle liste
			assertTrue(before_insert.size()+1==after_insert.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
