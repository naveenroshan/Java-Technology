package JavaTwo;

import JavaOne.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {
    	
        Laptop laptop = new Laptop();

        laptop.setLid(101);
        laptop.setLname("Dell");

        Student student = new Student();
        
        student.setName("navin");
        student.setRollno(1);
        student.setMarks(50);
        
        student.getLaptop().add(laptop);
        
        laptop.getStudent().add(student);

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

        SessionFactory sf = cfg.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(laptop);
        session.save(student);

        tx.commit();
    }
}
