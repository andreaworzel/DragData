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
        <form action="index.php" method="POST">
            <h3>GENERAL</h3>
            <div>
                <label><span style="background-color: black">DATE:</span></label>
                <input type="date" name="date">

                <h3>WEATHER</h3>

                                <div>
                                    <label><span style="background-color: black">TRACK TEMP:</span></label>
                                    <input type="text" name="track temp">
                                </div>

                <button type = "submit"> submit </button>