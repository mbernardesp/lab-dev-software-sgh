<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html lang="en">

    <head>
        <title>SGH</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </head>

    <body class="text-center">
        <div class="container">

            <div class="form-group">

                <form:form class="form-signin" method="post" modelAttribute="login" action="${pageContext.request.contextPath}/login/verify" >

                    <img class="mb-4" src="${pageContext.request.contextPath}/resources/images/logo.png" alt="" width="128" height="128">

                    <h1 class="h3 mb-3 font-weight-normal">Login</h1>

                    <spring:bind path="user">
                        <div class="form-group ${status.error ? 'has-error' : ''} text-left">
                            <form:input path="user" type="text" class="form-control" id="user" placeholder="User" />
                            <form:errors path="user" class="control-label" />        
                        </div>
                    </spring:bind>

                    <spring:bind path="pass">
                        <div class="form-group ${status.error ? 'has-error' : ''} text-left">
                            <form:input path="pass" type="password" class="form-control" id="pass" placeholder="Pass" />
                            <form:errors path="pass" class="control-label" />        
                        </div>
                    </spring:bind>
                    
                    <hr>
                    
                    <spring:bind path="msg">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:hidden path="msg" /> <!form:input path="msg" type="text" class="form-control" id="msg" placeholder="Msg" /-->
                            <form:errors path="msg" class="control-label" />        
                        </div>
                    </spring:bind>      
                    

                    <div class="form-group">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Enter</button>
                    </div>

                </form:form>                

            </div> 
        </div> 
    </body>
</html>
