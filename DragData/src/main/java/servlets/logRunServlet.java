///ADD TRACK ID TO RUN TUNE TABLE INSERTS

package servlets;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import database.DBConnector;

public class logRunServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        ResultSet resultSet = null;

        try {
            Connection conn = new DBConnector().getConn();
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM run_tune");
            writer.println("All data from run_tune: ");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("r_t"));
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
        Connection conn = new DBConnector().getConn();
        PreparedStatement statement = null;


        String sqlrunTune = "INSERT INTO run_tune (r_t, sixty, three_thirty, eigth_et, eigth_mph, thousand, quarter_et, quarter_mph, the_date, tuning_notes, track_temp, air_temp, atmosphere, wind_direction, wind_speed, specs_id, track_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Float rT = Float.parseFloat(request.getParameter("reactionTime"));
        Float ft60 = Float.parseFloat(request.getParameter("60ft"));
        Float ft330 = Float.parseFloat(request.getParameter("330ft"));
        Float eigthET = Float.parseFloat(request.getParameter("1/8m"));
        Float eigthMPH = Float.parseFloat(request.getParameter("1/8M MPH"));
        Float ft1000 = Float.parseFloat(request.getParameter("1000ft"));
        Float quarterET = Float.parseFloat(request.getParameter("1/4m"));
        Float quarterMPH = Float.parseFloat(request.getParameter("1/4m mph"));
        Date myDate = Date.valueOf(request.getParameter("date"));
        String tuningNotes = request.getParameter("tuning notes");
        Float trackTemp = Float.parseFloat(request.getParameter("track temp"));
        Float airTemp = Float.parseFloat(request.getParameter("air temp"));
        Float atmosphere = Float.parseFloat(request.getParameter("atmosphere"));
        String windDirection = request.getParameter("wind direction");
        Float windSpeed = Float.parseFloat(request.getParameter("wind speed"));
        String trackName = request.getParameter("trackName"); ////?????????

        try {
            Statement trackIdStatement = conn.createStatement();
            ResultSet getTrackID = trackIdStatement.executeQuery("select * from track");

            int trackId = 0;

            while (getTrackID.next()){
                if (getTrackID.getString("track_name").equals(trackName)) {
                    trackId = (getTrackID.getInt("id"));
                }
            }

            Statement specsStatement = conn.createStatement();
            ResultSet getSpecsId = specsStatement.executeQuery("select id from specs");

            int latestSpecsId = 0;
            //int trackId = 0;
            while (getSpecsId.next()) {
                latestSpecsId = (getSpecsId.getInt("id"));
            }



            statement = conn.prepareStatement(sqlrunTune);
            statement.setFloat(1, rT);
            statement.setFloat(2, ft60);
            statement.setFloat(3, ft330);
            statement.setFloat(4, eigthET);
            statement.setFloat(5, eigthMPH);
            statement.setFloat(6, ft1000);
            statement.setFloat(7, quarterET);
            statement.setFloat(8, quarterMPH);
            statement.setDate(9, myDate);
            statement.setString(10, tuningNotes);
            statement.setFloat(11, trackTemp);
            statement.setFloat(12, airTemp);
            statement.setFloat(13, atmosphere);
            statement.setString(14, windDirection);
            statement.setFloat(15, windSpeed);
            statement.setInt(16, latestSpecsId);
            statement.setInt(17, trackId);

            int i = statement.executeUpdate();
            writer.println(i + " records inserted");

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }

        try {
            Statement myStmt = conn.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from run_tune");

            while (myRs.next()) {
                writer.println(myRs.getFloat("r_t") + ", " + myRs.getFloat("sixty") + ", " + myRs.getFloat("three_thirty") + ", " + myRs.getFloat("eigth_et") + ", " + myRs.getFloat("eigth_mph") + ", " + myRs.getFloat("thousand") + ", " + myRs.getFloat("quarter_et") + ", " + myRs.getFloat("quarter_mph") + ", " + myRs.getDate("the_date") + ", " + myRs.getString("tuning_notes") + ", " + myRs.getFloat("track_temp") + ", " + myRs.getFloat("air_temp") + ", " + myRs.getFloat("atmosphere")+ ", " + myRs.getString("wind_direction") + ", " + myRs.getFloat("wind_speed") + ", " + myRs.getInt("specs_id") + ", " + myRs.getInt("track_id"));
            }
        } catch (SQLException x) {
            System.out.println(x.getErrorCode());
        }

    }
}





