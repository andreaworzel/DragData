<!DOCTYPE html>
<html>
<head>
    <title>LogRun</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<form action="/trackServlet" method = "POST">
<header id="main-header">
    <div class="container">
        <h1><span style="background-color: black">DRAG.DATA</span></h1>
        <H4><span style="background-color: black">TRACKS</span></H4>
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
            <h3>TRACK INFO</h3>

            <div>
                <label><span style="background-color: black">TRACK NAME:</span></label>
                <input type="text" name="track">
            </div>
            <div>
                <div>
                    <label><span style="background-color: black">TRACK LENGTH:</span></label>
                    <select name="track length">
                        <option value="1/8 M">1/8 M</option>
                        <option value="1/4 M">1/4 M</option>
                    </select>
                </div>

                <div>
                    <label><span style="background-color: black">TRACK NOTES:</span></label>
                         <textarea name="track notes"></textarea>
                </div>
                <br>
                <button>Submit Track</button>
                <br><br><br>

                </div></div></div></div></form></div>
</section>
</form>
</body>
</html>