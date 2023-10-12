import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Users users = new Users("Abhishek","12345","abhi");
			session.beginTransaction();
			session.save(users);
			session.getTransaction().commit();
			System.out.println("Completed!!!");
			
		} finally {
			session.close();
		}
	}

}
