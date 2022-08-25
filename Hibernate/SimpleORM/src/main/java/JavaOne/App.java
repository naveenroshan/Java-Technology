package JavaOne;

import JavaOne.Alien;
import JavaOne.AlienName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {

        AlienName an = new AlienName();

        an.setFname("navin");
        an.setLname("roshan");
        an.setMname("ram");

        // JavaOne.Alien navin = null;

        Alien navin =new Alien();
        navin.setaId(101);
        navin.setaName(an);
        navin.setaColor("yellow");

        Configuration  cfg = new Configuration().configure("/resources/hibernate.cfg.xml").addAnnotatedClass(Alien.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

        SessionFactory sf = cfg.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        //create a record in DB
        session.save(navin);

        // get the value from DB
        // navin = (JavaOne.Alien) session.get(JavaOne.Alien.class, 101);

       tx.commit();

       System.out.println(navin);
    }
}
