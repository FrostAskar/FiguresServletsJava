<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body>
    
    <h1>Draw polygons!</h1>

    <nav>
        <a href="/storage">All Figures</a>
        <a href="/mystorage">My Figures</a>
    </nav>

    <div id="drawContainer">
        <canvas id="polygonCanvas" width="1024" height="768"></canvas>

        <form action="/draw" method="post" id="drawForm">
            <label for="figureName">Name: </label>
            <input type="text" name="figureName" id="figureName">
            <fieldset>
                <legend>Coordinates</legend>
                <label for="figureX">X: </label>
                <input type="number" name="figureX" id="figureX" min="0" max="1024" required onchange="draw(document.getElementById('figureForm').value,
                                                                                                                Number(document.getElementById('figureX').value),
                                                                                                                Number(document.getElementById('figureY').value),
                                                                                                                Number(document.getElementById('figureSize').value),
                                                                                                                document.getElementById('figureColor').value);">
                <label for="figureY">Y: </label>
                <input type="number" name="figureY" id="figureY" min="0" max="768" required onchange="draw(document.getElementById('figureForm').value,
                                                                                                            Number(document.getElementById('figureX').value),
                                                                                                            Number(document.getElementById('figureY').value),
                                                                                                            Number(document.getElementById('figureSize').value),
                                                                                                            document.getElementById('figureColor').value);">
            </fieldset>
            <label for="figureForm">Form: </label>
            <select name="figureForm" id="figureForm" onchange="draw(document.getElementById('figureForm').value,
                                                                        Number(document.getElementById('figureX').value),
                                                                        Number(document.getElementById('figureY').value),
                                                                        Number(document.getElementById('figureSize').value),
                                                                        document.getElementById('figureColor').value);">
                <option value="Circle">Circle</option>
                <option value="Square">Square</option>
                <option value="Triangle">Triangle</option>
                <option value="Pentagon">Pentagon</option>
                <option value="7-pointed-star">7 pointed-star</option>
            </select>
            <label for="figureSize">Size: </label>
            <input type="range" name="figureSize" id="figureSize" min="0" max="200" onchange="draw(document.getElementById('figureForm').value,
                                                                                                    Number(document.getElementById('figureX').value),
                                                                                                    Number(document.getElementById('figureY').value),
                                                                                                    Number(document.getElementById('figureSize').value),
                                                                                                    document.getElementById('figureColor').value);">
            <label for="figureColor">Color: </label>
            <select name="figureColor" id="figureColor" onchange="draw(document.getElementById('figureForm').value,
                                                                        Number(document.getElementById('figureX').value),
                                                                        Number(document.getElementById('figureY').value),
                                                                        Number(document.getElementById('figureSize').value),
                                                                        document.getElementById('figureColor').value);">
                <option value="Black">Black</option>
                <option value="Green">Green</option>
                <option value="Red">Red</option>
                <option value="Blue">Blue</option>
                <option value="Yellow">Yellow</option>
                <option value="Gray">Gray</option>
            </select>
            <input type="submit" value="Submit" id="formSubmit">
        </form>
    </div>
    <script src="/script/draw.js"></script>
</body>
</html>