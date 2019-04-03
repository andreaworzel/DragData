<html>

<head><title>logRun confirmation</head></title>

<body>

    <%
       String date = request.getParameter("date");
       String track = request.getParameter("track");
       String trackLength = request.getParameter("track length");
       String trackTemp = request.getParameter("track temp");
       String atmosphere = request.getParameter("atmosphere");
       String airTemp = request.getParameter("air temp");
       String windDirection = request.getParameter("wind direction");
       String windSpeed = request.getParameter("wind speed");
       String rT = request.getParameter("reactionTime");
       String ft60 = request.getParameter("60ft");
       String ft330 = request.getParameter("330ft");
       String mET18 = request.getParameter("1/8m");
       String mMPH18 = request.getParameter("1/8M MPH");
       String ft1000 = request.getParameter("1000ft");
       String mET14 = request.getParameter("1/4m");
       String mMPH14 = request.getParameter("1/4m mph");
       String tuningNotes = request.getParameter("tuning notes");

    %>
    The run is confirmed:<br/>

     <%=date%> <br/>
     <%=track%> <br/>
     <%=trackLength%> <br/>
     <%=trackTemp%> <br/>
     <%=atmosphere%> <br/>
     <%=airTemp%> <br/>
     <%=windDirection%> <br/>
     <%=windSpeed%> <br/>
     <%=rT%> <br/>
     <%=ft60%> <br/>
     <%=ft330%> <br/>
     <%=mET18%> <br/>
     <%=mMPH18%> <br/>
     <%=ft1000%> <br/>
     <%=mET14%> <br/>
     <%=mMPH14%> <br/>
     <%=tuningNotes%> <br/>



</body>
</html>