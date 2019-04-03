<!DOCTYPE html>
<html>
<head>
    <title>Specs</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header id="main-header">
    <div class="container">
        <h1><span style="background-color: black">DRAG.DATA</span></h1>
        <H4><span style="background-color: black">SPECS</span></H4>
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
        <form action="/specsServlet" method="POST">
            <h3>CURRENT SPECS</h3>

                <div>
                    <label><span style="background-color: black">JETS:</span></label>
                    <input type="text" name="jets">
                </div>

                <div>
                    <label><span style="background-color: black">SHIFT POINTS:</span></label>
                    <input type="text" name="shiftPoints">
                </div>

                <div>
                    <label><span style="background-color: black">LAUNCH RPM:</span></label>
                    <input type="text" name="launchRPM">
                </div>

                <div>
                    <label><span style="background-color: black">BACK TIRE PRESSURE:</span></label>
                    <input type="text" name="tirePressure">
                </div>

                <div>
                    <label><span style="background-color: black">FUEL:</span></label>
                    <input type="text" name="fuel">
                </div>

                <div>
                    <label><span style="background-color: black">SPECS NOTES:</span></label>
                         <textarea name="specsNotes"></textarea>
                </div>
                <br>
                <button>Submit Specs</button>
                <br><br><br>

        </form>
    </div>

</section>
</form>
</body>
</html>