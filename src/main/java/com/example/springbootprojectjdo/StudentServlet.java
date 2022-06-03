package com.example.springbootprojectjdo;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.apphosting.api.DatastorePb;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
            StudentDetails object = new StudentDetails();
            object.setName("abc");
            object.setEmail("abc@gmail.com");
            object.setAge(30);
            object.setDob(LocalDate.parse("2021-01-07"));
            PersistenceManager persistenceManager = null;
            persistenceManager.makePersistent(object);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        resp.getWriter().println("Hello world from Student servlet!!!");
    }
}
