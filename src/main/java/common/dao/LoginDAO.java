package common.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import common.entity.User;


public class LoginDAO {
	private static final String PERSISTENCE_UNIT_NAME = "Users";
    private static EntityManagerFactory factory;
    
	@SuppressWarnings("unchecked")
	public static boolean validate(String user, String password) {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        boolean ret = true;
		try {
			// Select del usuario
	        Query q = em.createQuery("SELECT u FROM User u");
	        List<User> userList = q.getResultList();
	        
			if (userList.isEmpty()) {
				// Create new user
				em.getTransaction().begin();
				User u = new User();
				u.setLogin(user);
				u.setPassword(password);
				em.persist(user);
				em.getTransaction().commit();
				
			}else{
				User u = userList.get(0);
				if(!u.getPassword().equals(password)){
					ret = false;
				}
			}
		} catch (Exception ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			em.close();
		}
		return ret;
	}
}