<!DOCTYPE html>
<html>
<head>
    <title>DataSearch</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header id="main-header">
    <div class="container">
        <h1><span style="background-color: black">DRAG.DATA</span></h1>
        <H4><span style="background-color: black">DATA SEARCH</span></H4>
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
        <h4><span style="background-color: black">Check all of the categories you want to search by: </span></h4>

        <form action="/searchResultsServlet" method="POST">
        <button type="submit"> VIEW All</button></form>

        <form action="/dataSearchServlet" method="POST">
            <span style="background-color: black"><h2>-SEARCH BY-</h2>

            <p>TRACKS</p>

            <input type="checkbox" name="checks" value="TRACK NAME:"> Track name</input>
            <input type="checkbox" name="checks" value="LENGTH:"> Track length</input>

            <p>SPECS</p>

            <input type="checkbox" name="checks" value="JETS:"> Jets </input>
            <input type="checkbox" name="checks" value="SHIFT POINTS:"> Shift points </input>
            <input type="checkbox" name="checks" value="LAUNCH RPM:"> Launch rpm </input>
            <input type="checkbox" name="checks" value="BACK TIRE PRESSURE:"> Back tire pressure </input>
            <input type="checkbox" name="checks" value="FUEL:"> Fuel </input>

            <p>RUN/TUNE RESULTS</p>

            <input type="checkbox" name="checks" value="REACTION TIME:"> Reaction time </input>
            <input type="checkbox" name="checks" value="60 FT:"> 60 ft </input>
            <input type="checkbox" name="checks" value="330 FT:"> 330 ft </input>
            <input type="checkbox" name="checks" value="1/8 ET:"> 1/8 et </input>
            <input type="checkbox" name="checks" value="1/8 :MPH"> 1/8 mph </input>
            <input type="checkbox" name="checks" value="1000 FT:"> 1000 ft </input>
            <input type="checkbox" name="checks" value="1/4 ET:"> 1/4 et </input>
            <input type="checkbox" name="checks" value="1/4 MPH:"> 1/4 mph </input>

            <p>WEATHER</p>
            <input type="checkbox" name="checks" value="TRACK TEMP:"> Track temp </input>
            <input type="checkbox" name="checks" value="AIR TEMP:"> Air temp </input>
            <input type="checkbox" name="checks" value="ATMOSPHERE:"> Atmosphere </input>
            <input type="checkbox" name="checks" value="WIND DIRECTION:"> Wind direction </input>
            <input type="checkbox" name="checks" value="WIND SPEED:"> Wind Speed </input>
        </span>

        <br><br>
        <button>Fields</button></form></div><br><br>


</section>
</body>
</html>