<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*;" %>

<!DOCTYPE html>
<html>
<head>
    <title>LogRun</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<form action="/logRunServlet" method = "POST">
<header id="main-header">
    <div class="container">
        <h1><span style="background-color: black">DRAG.DATA</span></h1>
        <H4><span style="background-color: black">LOG RUN</span></H4>
    </div>
</header>

<nav id="navbar">
    <div class="container">
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="specs.jsp">Your Specs</a></li>
            <li><a href="track.jsp">Tracks</a></li>
            <li><a href="logRun.jsp">Log Run</a></li>
            <li><a href="dataSearch.jsp">Search Data</a></li>
            <li><a href="photos.html">Photos</a></li>
        </ul>
    </div>
</nav>

<section id="showcase2">
    <div class="container">
        <br>
        <form action="process.php" method="POST">
            <h3>GENERAL</h3>
            <div>
                <label><span style="background-color: black">DATE:</span></label>
                <input type="date" name="date">

            </div>

        <%! String driverName = "com.mysql.jdbc.Driver";%>
        <%!String url = "jdbc:mysql://localhost:3306/project";%>
        <%!String user = "root";%>
        <%!String psw = "rikamaloney2012";%>
        <%
        Connection con = null;
        PreparedStatement ps = null;
        try
        {
        Class.forName(driverName); ///?
        con = DriverManager.getConnection(url,user,psw);
        String sql = "SELECT * FROM track";
        ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        %>
        <label><span style="background-color: black">TRACK:</span></label>
        <select>
        <%
        while(rs.next())
        {
        String trackName = rs.getString("track_name");
        %>
        <option value="<%=trackName %>"><%=trackName %></option>
        <%
        }
        %>
        </select>
        <%
        }
        catch(SQLException sqe)
        {
        out.println(sqe);
        }
        %>

                <h3>WEATHER</h3>

                <div>
                    <label><span style="background-color: black">TRACK TEMP:</span></label>
                    <input type="text" name="track temp">
                </div>
                <div>

                    <div>
                        <label><span style="background-color: black">ATMOSPHERE:</span></label>
                        <input type="text" name="atmosphere">
                    </div>
                    <div>

                        <div>
                            <label><span style="background-color: black">AIR TEMP:</span></label>
                            <input type="text" name="air temp">
                        </div>
                        <div>

                            <div>
                                <label><span style="background-color: black">WIND DIRECTION:</span></label>
                                <select name="wind direction">
                                    <option value="N/A">N/A</option>
                                    <option value="Tail">Tail</option>
                                    <option value="Head">Head</option>

                                </select>

                                <div>
                                    <label><span style="background-color: black">WIND SPEED:</span></label>
                                    <input type="text" name="wind speed">
                                </div>
                            </div>
                            <h3>TIME SLIP</h3>

                            <div>
                                <label><span style="background-color: black">REACTION TIME:</span></label>
                                <input type="text" name="reactionTime">
                            </div>
                            <div>
                                <label><span style="background-color: black">60FT:</span></label>
                                <input type="text" name="60ft">
                            </div>
                            <div>
                                <label><span style="background-color: black">330FT:</span></label>
                                <input type="text" name="330ft">
                            </div>
                            <div>
                                <label><span style="background-color: black">1/8M:</span></label>
                                <input type="text" name="1/8m">
                            </div>
                            <div>
                                <label><span style="background-color: black">1/8M MPH:</span></label>
                                <input type="text" name="1/8M MPH">
                            </div>
                            <div>
                                <label><span style="background-color: black">1000FT:</span></label>
                                <input type="text" name="1000ft">
                            </div>
                            <div>
                                <label><span style="background-color: black">1/4M:</span></label>
                                <input type="text" name="1/4m">
                            </div>
                            <div>
                                <label><span style="background-color: black">1/4M MPH:</span></label>
                                <input type="text" name="1/4m mph">
                            </div>
                            <div>
                                <label><span style="background-color: black">TUNING NOTES:</span></label>
                                <textarea name="tuning notes"></textarea>
                            </div>
                            <br>
                            <button>LOG RUN</button>
                            <br><br><br>

                        </div></div></div></div></form></div>
</section>
</form>
</body>
</html>