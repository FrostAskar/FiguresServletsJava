<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Preview</title>
        <link rel="stylesheet" href="/style/style.css">
    </head>
    <body>

        <h1>Preview</h1>
        <nav>
            <a href="/storage">Return</a>
        </nav>
        <div id="previewCanvas">
            <canvas id="polygonCanvas" width="1024" height="768"></canvas>
        </div>

        <script src="/script/draw.js"></script>
        <script>
            draw("${figureForm}", Number(${figureX}), Number(${figureY}), Number(${figureSize}), "${figureColor}");
        </script>
    </body>
</html>