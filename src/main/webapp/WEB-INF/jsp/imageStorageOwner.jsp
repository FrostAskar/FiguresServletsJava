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
        <h1>My figures</h1>
        <header>
            <form action="/mystorage" method="post">
                <input type="search" name="figureSearch" id="figureSearch" placeholder="Search figure">
                <input type="submit" value="search" id="search">
            </form>

            <nav>
                <a href="/draw">Draw figures</a><br>
                <a href="/storage">All figures</a><br>
            </nav>
        </header>

        <table>

            <tr>
                <th>Name</th>
                <th>User</th>
                <th>Preview</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${figures}" var="figure">
                <tr>
                    <td class="displayName">
                        ${figure.name}
                    </td>
                    <td class="displayOwner">
                        ${figure.owner}
                    </td>
                    <td class="displayButton">
                        <form action="/preview" method="post">
                            <input type="hidden" name="figureId" value="${figure.id}">
                            <input type="submit" value="preview" id="preview">
                        </form>
                    </td>
                    <td class="displayButton">
                        <form action="/delete" method="post" onsubmit="return confirm('Are you sure you want to delete this item?')">
                            <input type="hidden" name="figureId" value="${figure.id}">
                            <input type="submit" value="delete" id="delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
