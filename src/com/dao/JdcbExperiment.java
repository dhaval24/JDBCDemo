package com.dao;

import daoimplementer.HibernateDaoImp;
import daoimplementer.SimpleJdbcDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dhaval on 4/8/2016.
 */
public class JdcbExperiment {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        DAOImpl dao = context.getBean("DAOImpl", DAOImpl.class);
//        //Circle circle = dao.getCircle(1);
//        //System.out.println(circle.getName());
//        System.out.println(dao.getCircleCount());
//        System.out.println(dao.getCircleById(1).getName());
//        dao.insertCircle(new Circle(3, "Third Circle"));
//        List<Object> total = new ArrayList<>(dao.getAllCircles());
//        for(Object o:total){
//            System.out.println(((Circle)o).getName());
//        }
//            SimpleJdbcDaoImpl dao = context.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
//            System.out.println(dao.getCircleCount());
        HibernateDaoImp dao = context.getBean("hibernateDaoImp", HibernateDaoImp.class);
        //dao.getCircleCount();
        //dao.addUser();
        dao.addOccupation();
        //dao.insertCircle();

    }
}
