package com.example.springbootprojectjdo;

import org.datanucleus.api.jdo.JDOPersistenceManagerFactory;
import org.datanucleus.metadata.PersistenceUnitMetaData;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.jdo.metadata.DatastoreIdentityMetadata;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            Properties properties = new Properties();
            properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
            properties.setProperty("javax.jdo.option.ConnectionURL", "appengine");
            properties.setProperty("javax.jdo.option.NontransactionalRead", "true");
            properties.setProperty("javax.jdo.option.NontransactionalWrite", "true");
            properties.setProperty("javax.jdo.option.RetainValues", "true");
            properties.setProperty("datanucleus.appengine.autoCreateDatastoreTxns", "true");
            properties.setProperty("datanucleus.appengine.singletonPMFForName", "true");

            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(properties);
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

        resp.getWriter().println("Hello world from Student servlet!!! new updated!!!");
    }
}
