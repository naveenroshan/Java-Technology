package JavaThree;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import JavaTwo.Laptop;
import JavaTwo.Student;

public class App {

	public static void main(String[] args) {
		
		CacheExample c = null;
		
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

        SessionFactory sf = cfg.buildSessionFactory(reg);

        Session session1 = sf.openSession();

        Transaction tx = session1.beginTransaction();
        
        Query q1 = session1.createQuery("from CacheExample where aid=101");
        
        c = (CacheExample) session1.get(CacheExample.class, 101);
        System.out.println(c);
        
        tx.commit();
        
        Session session2 = sf.openSession();
        
        Transaction tx2 = session2.beginTransaction();
        
        c = (CacheExample) session2.get(CacheExample.class, 101);
        System.out.println(c);
        
        tx2.commit();
        

	}

}

