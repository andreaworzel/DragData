package servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import database.DBConnector;

public class dataSearchServlet extends HttpServlet {
    ///Create an ArrayList to add checked boxes to
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        Connection conn = new DBConnector().getConn();

        String[] results = request.getParameterValues("checks");
        writer.println("<html><head>\n" +
                "    <title>SEARCH</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
                "</head><body>");
        writer.print("<header id=\"main-header\">\n" +
                "    <div class=\"container\">\n" +
                "        <h1><span style=\"background-color: black\">DRAG.DATA</span></h1>\n" +
                "        <H4><span style=\"background-color: black\">SEARCH</span></H4>\n" +
                "    </div>\n" +
                "</header>");
        writer.print("<nav id=\"navbar\">\n" +
                "    <div class=\"container\">\n" +
                "        <ul>\n" +
                "            <li><a href=\"index.jsp\">Home</a></li>\n" +
                "            <li><a href=\"specs.jsp\">Your Specs</a></li>\n" +
                "            <li><a href=\"track.jsp\">Tracks</a></li>\n" +
                "            <li><a href=\"logRun.jsp\">Log Run</a></li>\n" +
                "            <li><a href=\"dataSearch.jsp\">Search Data</a></li>\n" +
                "            <li><a href=\"photos.html\">Photos</a></li>\n" +
                "        </ul>\n" +
                "    </div>\n" +
                "</nav>");
        writer.print("<section id=\"showcase2\">\n" +
                "    <div class=\"container\">\n" +
                "        <br>");
        writer.println("<form action = \"/searchResultsServlet\" method = \"POST\">");


            for (int i = 0; i < results.length; i++) {
            try {


                if (results[i].equals("TRACK NAME:")) {
                    String sql = "SELECT * FROM track";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    writer.println("<label><span style=\"background-color: black\">TRACK NAME:</span></label><select>");
                    while (rs.next()) {
                        String trackName = rs.getString("track_name");
                        writer.print("<option name=\"fields\" value = \"" + trackName + "\">" + trackName + "</option>");
                    }
                    writer.print("</select></br>");

                }
                if (results[i].equals("LENGTH:")) {
                    writer.println("<label><span style=\"background-color: black\">TRACK LENGTH:</span></label><select>");
                    writer.print("<option name = \"fields\" value=\"1/8m\">1/8m</option>");
                    writer.print("<option name  \"fields\" value=\"1/4m\">1/4m</option></select></br>");
                }
                if (results[i].equals("JETS:")) {
                    writer.print("<label><span style=\"background-color: black\">JETS:</span></label>");
                    writer.print("<input type=\"text\" name=\"jets\"></input></br>");
                }
                if (results[i].equals("SHIFT POINTS:")) {
                    writer.print("<label><span style=\"background-color: black\">SHIFT POINTS:</span></label>");
                    writer.print("<input type=\"text\" name=\"shiftPoints\"></input></br>");
                }
                if (results[i].equals("LAUNCH RPM:")) {
                    writer.print("<label><span style=\"background-color: black\">LAUNCH RPM:</span></label>");
                    writer.print("<input type=\"text\" name=\"launchRPM\"></input></br>");
                }
                if (results[i].equals("BACK TIRE PRESSURE:")) {
                    writer.print("<label><span style=\"background-color: black\">BACK TIRE PRESSURE:</span></label>");
                    writer.print("<input type=\"text\" name=\"tirePressure\"></input></br>");
                }
                if (results[i].equals("FUEL:")) {
                    writer.print("<label><span style=\"background-color: black\">FUEL:</span></label>");
                    writer.print("<input type=\"text\" name=\"fuel\"></input></br>");
                }
                if (results[i].equals("REACTION TIME:")) {
                    writer.print("<label><span style=\"background-color: black\">REACTION TIME:</span></label>");
                    writer.print("<input type=\"text\" name=\"reactionTime\"></input></br>");
                }
                if (results[i].equals("60 FT:")) {
                    writer.print("<label><span style=\"background-color: black\">60 FT:</span></label>");
                    writer.print("<input type=\"text\" name=\"60ft\"></input></br>");
                }
                if (results[i].equals("330 FT:")) {
                    writer.print("<label><span style=\"background-color: black\">330 FT:</span></label>");
                    writer.print("<input type=\"text\" name=\"330ft\"></input></br>");
                }
                if (results[i].equals("1/8 ET:")) {
                    writer.print("<label><span style=\"background-color: black\">1/8 ET:</span></label>");
                    writer.print("<input type=\"text\" name=\"1/8et\"></input></br>");
                }
                if (results[i].equals("1/8 MPH:")) {
                    writer.print("<label><span style=\"background-color: black\">1/8 MPH:</span></label>");
                    writer.print("<input type=\"text\" name=\"1/8mph\"></input></br>");
                }
                if (results[i].equals("1000 FT:")) {
                    writer.print("<label><span style=\"background-color: black\">1000 FT:</span></label>");
                    writer.print("<input type=\"text\" name=\"1000ft\"></input></br>");
                }
                if (results[i].equals("1/4 ET:")) {
                    writer.print("<label><span style=\"background-color: black\">1/4 ET:</span></label>");
                    writer.print("<input type=\"text\" name=\"1/4et\"></input></br>");
                }
                if (results[i].equals("1/4 MPH:")) {
                    writer.print("<label><span style=\"background-color: black\">1/4 MPH:</span></label>");
                    writer.print("<input type=\"text\" name=\"1/4mph\"></input></br>");
                }
                if (results[i].equals("TRACK TEMP:")) {
                    writer.print("<label><span style=\"background-color: black\">TRACK TEMP:</span></label>");
                    writer.print("<input type=\"text\" name=\"trackTemp\"></input></br>");
                }
                if (results[i].equals("AIR TEMP:")) {
                    writer.print("<label><span style=\"background-color: black\">AIR TEMP:</span></label>");
                    writer.print("<input type=\"text\" name=\"airTemp\"></input></br>");
                }
                if (results[i].equals("ATMOSPHERE:")) {
                    writer.print("<label><span style=\"background-color: black\">ATMOSPHERE:</span></label>");
                    writer.print("<input type=\"text\" name=\"atmosphere\"></input></br>");
                }
                if (results[i].equals("WIND DIRECTION:")) {
                    writer.print("<label><span style=\"background-color: black\">WIND DIRECTION:</span></label>");
                    writer.print("<select name=\"wind direction\">");
                    writer.print("<option value=\"N/A\">N/A</option>");
                    writer.print("<option value=\"Tail\">Tail</option>");
                    writer.print("<option value=\"Head\">Head</option></select></br>");
                }
                if (results[i].equals("WIND SPEED:")) {
                    writer.print("<label><span style=\"background-color: black\">WIND SPEED:</span></label>");
                    writer.print("<input type=\"text\" name=\"windSpeed\"></input></br>");

                }

            } catch (SQLException s){
                writer.println(s.getErrorCode());
            }
            }


        writer.print("</br><button type=\"submit\">Submit");

        writer.println("</html></body>");
    }
}
