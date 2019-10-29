<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html lang="en">

    <head>
        <title>SGH</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"/>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">

                <div class="navbar-header">
                    <a class="navbar-brand" href="#">SGH</a>
                </div>

                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>

                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Guest<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/guest/list">List</a></li>
                            <li><a href="${pageContext.request.contextPath}/guest/edit">Add</a></li>
                        </ul>
                    </li>

                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Room<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">List</a></li>
                            <li><a href="#">Add</a></li>
                        </ul>
                    </li>

                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Product<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">List</a></li>
                            <li><a href="#">Add</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Check-In</a></li>
                    <li><a href="#">Check-Out</a></li>

                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Services<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/service/address">Find address</a></li>
                        </ul>
                    </li>

                </ul>

                <span class="navbar-text" style="color:#bfff00;"> | Welcome! <c:out value='${sessionScope.user}'/></span>

            </div>
        </nav>  