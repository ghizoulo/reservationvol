package testMetier;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import reservation.metier.ClientManager;
import reservation.model.Client;

public class TestClient {

ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception{
		ctx =  new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
	}
	
	@Test 
	public void test_metier(){
		ClientManager clientMetier = (ClientManager) ctx.getBean("clientServiceImpl");
		try {
				//recuperer la liste des clients
			List<Client> before_insert = clientMetier.list();
				//ajouter une nouvelle client
			//clientMetier.add(new Client("Lotfi","Ghizlane","0649393622","Casablanca","ghizlanelotfi@gmail.com",false));
			//clientMetier.add(new Client("Karazi","MEryam","0655393675","Meknes","meryam1992@gmail.com",false));
				//modifier une client
			//clientMetier.update(new Client(8,"Karazi","Meryam","0655393675","Meknes","meryam1992@gmail.com",false));
				//supprimer une client
			clientMetier.delete(8);
				//rechercher une client by id
			//Client client = clientMetier.getClientById(2);
				//recuperer la nouvelle liste d'client
			List<Client> after_insert = clientMetier.list();
				//verifie si l'client recherché est bien trouvé
			//assertTrue("get Client by id", client != null);
				//vérifie si la liste d'client récupérée au début + 1 est = à la nouvelle liste
			assertTrue(before_insert.size()+1==after_insert.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
