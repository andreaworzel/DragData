package servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import database.DBConnector;

public class searchResultsServlet extends HttpServlet {
    ///Create an ArrayList to add checked boxes to
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.print("Search results under construction!! Come back soon! :)");
    }
}