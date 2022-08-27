package JavaFour;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

        SessionFactory sf = cfg.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        //using HQL query
        Query q = session.createQuery("from Student where marks > 50");
        List<Student> students = q.list();

        for (Student s : students){
            System.out.println(s);
        }

        Query q2 = session.createQuery("select rollno,name,marks from Student");
        List<Objects[]> students2 =(List<Objects[]>) q2.list();

        for (Objects [] student2: students2){
            System.out.println(student2[0] + ":" + student2[1] + ":" + student2[2]);
        }

        Query q3 = session.createQuery("select rollno,name,marks from Student s where s.marks > 70 ");
        List<Objects[]> students3 =(List<Objects[]>) q3.list();

        for (Objects [] student3: students3){
            System.out.println(student3[0] + ":" + student3[1] + ":" + student3[2]);
        }

        // creating SQL query
        SQLQuery query = session.createSQLQuery("select * from Student where marks > 50");
        query.addEntity(Student.class);
        List<Student> sqlStudent = query.list();
        for (Student o : sqlStudent){
            System.out.println(o);
        }

//        Random r = new Random();
//
//        for (int i=1; i <= 50; i++){
//            Student s = new Student();
//            s.setRollno(i);
//            s.setName("name" + i);
//            s.setMarks(r.nextInt(100));
//            session.save(s);
//        }

        tx.commit();
    }
}
