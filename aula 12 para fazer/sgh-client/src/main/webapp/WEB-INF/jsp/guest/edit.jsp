<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>SGH</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <h1>Guest List</h1>

        <br/><br/>
        <div>
            <table>
                <tr>
                    <th>Id</th>
                    <th>IdRoom</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>phone</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach  items="${guestList}" var ="guest">
                    <tr>
                        <td>${guest.id}</td>
                        <td>${guest.idRoom}</td>
                        <td>${guest.name}</td>
                        <td>${guest.age}</td>
                        <td>${guest.phone}</td>
                        <td>Edit</td>
                        <td>Delete</td>
                    </tr>
                </c:forEach>
            </table>
        </div> 

    </body>

</html>
