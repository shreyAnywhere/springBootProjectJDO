package com.example.springbootprojectjdo;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.apphosting.api.DatastorePb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity e = new Entity("Student");
        e.setProperty("name", "abc");
        e.setProperty("email", "abc@gmail.com");
        e.setProperty("age", 30);
        ds.put(e);

        resp.getWriter().println("Hello world from Student servlet!!!");
    }
}
