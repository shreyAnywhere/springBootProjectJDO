package com.example.springbootprojectjdo;

import org.datanucleus.api.jdo.JDOPersistenceManagerFactory;
import org.datanucleus.metadata.PersistenceUnitMetaData;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
//        Entity e = new Entity("Student");
//        e.setProperty("name", "abc");
//        e.setProperty("email", "abc@gmail.com");
//        e.setProperty("age", 30);
//        ds.put(e);
        try{
            PersistenceUnitMetaData pumd = new PersistenceUnitMetaData("dynamic-unit", "RESOURCE_LOCAL", null);
            PersistenceManagerFactory pmf = new JDOPersistenceManagerFactory(pumd, null);
            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            tx.begin();
            StudentDetails object = new StudentDetails();
            object.setName("abc");
            object.setEmail("abc@gmail.com");
            object.setAge(30);
            object.setDob(LocalDate.parse("2021-01-07"));
            pm.makePersistent(object);
            tx.commit();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        resp.getWriter().println("Hello world from Student servlet!!!");
    }
}
