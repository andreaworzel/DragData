package servlets;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import database.DBConnector;

public class trackServlet extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        ResultSet resultSet = null;

        try {
            Connection conn = new DBConnector().getConn();
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM track");
            writer.println("All track names: ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("track_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {

                }
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        PreparedStatement statement = null;
        String sqlTrack = "INSERT INTO track (track_name, length, track_notes) VALUES (?,?,?)";

        String track = request.getParameter("track");
        String trackLength = request.getParameter("track length");
        String trackNotes = request.getParameter("track notes");

        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.prepareStatement(sqlTrack);
            statement.setString(1, track);
            statement.setString(2, trackLength);
            statement.setString(3, trackNotes);

            int i = statement.executeUpdate();
            writer.println(i + " records inserted");

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }

        try {
            Connection conn = new DBConnector().getConn();

            Statement myStmt = conn.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from track");

            while (myRs.next()) {
                writer.println(myRs.getString("track_name") + ", " + myRs.getString("length") + ", " + myRs.getString("track_notes"));
            }
        } catch (SQLException x) {
            System.out.println(x.getErrorCode());
        }


    }
}




