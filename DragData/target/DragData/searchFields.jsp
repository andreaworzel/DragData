<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*;" %>


<!DOCTYPE html>
<html>
<head>
    <title>SEARCH</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header id="main-header">
    <div class="container">
        <h1><span style="background-color: black">DRAG.DATA</span></h1>
        <H4><span style="background-color: black">SEARCH</span></H4>
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
        <%! String driverName = "com.mysql.jdbc.Driver";%>
                <%!String url = "jdbc:mysql://localhost:3306/project";%>
                <%!String user = "root";%>
                <%!String psw = "rikamaloney2012";%>
                <%
                Connection con = null;
                PreparedStatement ps = null;
                String[] results = request.getParameterValues("checks");
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

        <div>
              <label><span style="background-color: black">TRACK LENGTH:</span></label>
              <select name="track length">
                   <option value="1/8 M">1/8 M</option>
                   <option value="1/4 M">1/4 M</option>
              </select>
        </div>