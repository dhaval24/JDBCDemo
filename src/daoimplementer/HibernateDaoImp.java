package daoimplementer;

import jdk.nashorn.internal.scripts.JO;
import org.dhaval.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by Dhaval on 4/10/2016.

 */
@Repository
public class HibernateDaoImp implements ApplicationContextAware {

    @Autowired
    private SessionFactory sessionFactory;
    private ApplicationContext context;
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public void getCircleCount(){
//        String hql = "SELECT COUNT(*) FROM Circle";
//        Query query = getSessionFactory().openSession().createQuery(hql);
//        return (Long)query.uniqueResult();
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Circle circle = (Circle)session.get(Circle.class, 1);
        System.out.println(circle.getName());
        session.getTransaction().commit();
        session.close();
    }

    public void insertCircle(){
        System.out.println("Enter circle name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Circle circle = context.getBean("circle", Circle.class);
        System.out.println(name);
        circle.setName(name);
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(circle);
        session.getTransaction().commit();
        session.close();
    }

    public void addUser(){
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            User user = context.getBean("user", User.class);
            Address address = context.getBean("address", Address.class);
            address.setCity("Chicago");
            address.setCountry("USA");
            address.setPin(12345);
            address.setState("il");
            address.setStreet("1039 s oakley");
            Address address1 = context.getBean("address", Address.class);
            address1.setCity("Los Angles");
            address1.setCountry("USA");
            address1.setPin(65151);
            address1.setState("CA");
            address1.setStreet("9 T oakley");
            user.getListOfAddress().add(address);
            user.getListOfAddress().add(address1);
            user.setFirstName("Dhaval");
            user.setLastName("Doshi");
            user.setPasword("abcd");
            user.setUser_name("dhaval24");
            Vehicle vehicle = context.getBean("vehicle", Vehicle.class);
            vehicle.setVehicle_Name("Maruti");
            Vehicle vehicle1 = context.getBean("vehicle", Vehicle.class);
            vehicle1.setVehicle_Name("Honda");
//            user.getVehicleList().add(vehicle);
//            user.getVehicleList().add(vehicle1);
//            vehicle.setUser(user);
//            vehicle1.setUser(user);
            Collection<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(vehicle);
            vehicles.add(vehicle1);
            user.assignUser(user, vehicles);
            RentedVehicle rvehicle = context.getBean("rentedVehicle", RentedVehicle.class);
            rvehicle.setName("Camry");
            RentedVehicle rvehicle1 = context.getBean("rentedVehicle", RentedVehicle.class);
            rvehicle1.setName("Lamborghini");
            user.getRentedVehicleList().add(rvehicle);
            rvehicle.getUserList().add(user);
            user.getRentedVehicleList().add(rvehicle1);
            rvehicle1.getUserList().add(user);

            session.save(rvehicle);
            session.save(rvehicle1);
            session.save(user);
            session.save(vehicle);
            session.save(vehicle1);

            session.getTransaction().commit();
        }
        catch (TransactionException txe){
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }

    public void addOccupation(){

        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Occupation occupation = context.getBean("occupation", Occupation.class);
            occupation.setName("Software developer");

            Job job = context.getBean("job", Job.class);
            job.setName("Techical Staff");
            job.setSalaryPerAnnum(800000);

            Business business = context.getBean("business", Business.class);
            business.setName("Trader");
            business.setRevenuePerAnnum(10000000);

            session.save(occupation);
            session.save(job);
            session.save(business);
            session.getTransaction().commit();
        }catch (TransactionException tx){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
}