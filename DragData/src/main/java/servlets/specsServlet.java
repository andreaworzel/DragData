package servlets;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import database.DBConnector;

public class specsServlet extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        ResultSet resultSet = null;

        try {
            Connection conn = new DBConnector().getConn();
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM specs");
            writer.println("All specs data: ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("jets"));
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
        String sqlSpecs = "INSERT INTO specs (jets, shift_points, launch_rpm, back_tire_pressure, fuel, specs_notes) VALUES (?,?,?,?,?,?)";

        String jets = request.getParameter("jets");
        String shiftPoints = request.getParameter("shiftPoints");
        float launchRPM = Float.parseFloat(request.getParameter("launchRPM"));
        float tirePressure = Float.parseFloat(request.getParameter("tirePressure"));
        String fuel = request.getParameter("fuel");
        String specsNotes = request.getParameter("specsNotes");


        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.prepareStatement(sqlSpecs);
            statement.setString(1, jets);
            statement.setString(2, shiftPoints);
            statement.setFloat(3, launchRPM);
            statement.setFloat(4, tirePressure);
            statement.setString(5, fuel);
            statement.setString(6, specsNotes);

            int i = statement.executeUpdate();
            writer.println(i + " records inserted");

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }

        try {
            Connection conn = new DBConnector().getConn();

            Statement myStmt = conn.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from specs");

            while (myRs.next()) {
                writer.println(myRs.getString("jets") + ", " + myRs.getString("shift_points") + ", " + myRs.getFloat("launch_rpm") + ", " + myRs.getFloat("back_tire_pressure") + ", " + myRs.getString("fuel") + ", " + myRs.getString("specs_notes"));
            }
        } catch (SQLException x) {
            System.out.println(x.getErrorCode());
        }

    }
}
