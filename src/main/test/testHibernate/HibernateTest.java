package testHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import reservation.metier.AeroportManager;
import reservation.model.Aeroport;

public class HibernateTest {

	public static void main(String[] args) {
		ApplicationContext ctx =  new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
		AeroportManager AeroportDao = (AeroportManager) ctx.getBean("aeroportServiceImpl");
		      
		      Aeroport aeroport = new Aeroport("ChicagoAer", "Chicago", false);
		     
		      try {
				AeroportDao.add(aeroport);
			} catch (Exception e) {
				e.printStackTrace();
			}

		      System.out.println("Aeroport inserted!");
//		      
//		      user = userManager.getUser("johndoe");
//		      
//		      System.out.println("\nUser fetched by username!"
//		        + "\nId: " + user.getId()
//		        + "\nUsername: " + user.getUsername()
//		        + "\nName: " + user.getName());
//		      
//		      user = userManager.getUserById(user.getId());
//		      
//		      System.out.println("\nUser fetched by ID!"
//		        + "\nId: " + user.getId()
//		        + "\nUsername: " + user.getUsername()
//		        + "\nName: " + user.getName());
//		      
//		      List<User> users = userManager.getUsers();
//		      
//		      System.out.println("\nUser list fetched!"
//		          + "\nUser count: " + users.size());

	}

}
