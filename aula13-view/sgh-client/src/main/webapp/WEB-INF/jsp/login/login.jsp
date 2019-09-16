<!DOCTYPE HTML>
<html lang="en">

    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <head>
        <title>SGH</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">

            <h1>Guest Login</h1>

            <div class="form-group">


                <!--code-->
                <form:form method="post" modelAttribute="login" action="${pageContext.request.contextPath}/login/verify" >
                    
                    <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">

                    <spring:bind path="user">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="control-label">Name</label>
                            <form:input path="user" type="text" class="form-control" id="user" placeholder="User" />
                            <form:errors path="user" class="control-label" />        
                        </div>
                    </spring:bind>

                    <spring:bind path="pass">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="control-label">Pass</label>
                            <form:input path="pass" type="password" class="form-control" id="pass" placeholder="Pass" />
                            <form:errors path="pass" class="control-label" />        
                        </div>
                    </spring:bind>

                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">Save</button>
                        <a class="btn btn-info" href="${pageContext.request.contextPath}/guest/list">Cancel</a>
                    </div>

                </form:form>                

























            </div> 
        </div> 
    </body>
</html>
