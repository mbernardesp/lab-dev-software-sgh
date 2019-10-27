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

            User not logged in. Click <a href="${pageContext.request.contextPath}">here</a> to login!

        </div> 


        <!--if-->    
        <c:if test="${not empty contato.email}">
            <a href="mailto:${contato.email}">${contato.email}</a>
        </c:if>


        <!--switch case-->                
        <c:choose>
            <c:when test="${not empty contato.email}">
                <a href="mailto:${contato.email}">${contato.email}</a>
            </c:when>
            <c:otherwise>
                E-mail não informado
            </c:otherwise>
        </c:choose>    


        <!--taglib para datas, adicionar a tag e depois formatar-->
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <fmt:formatDate value="${contato.dataNascimento.time}"
                        pattern="dd/MM/yyyy" />

        <!--Outras taglibs-->

        <!--
        Para saber mais: Outras tags
        A JSTL possui além das tags que vimos aqui, muitas outras, e para diversas finalidades. Abaixo está um resumo com algumas das outras tags da JSTL:

            c:catch - bloco do tipo try/catch
            c:forTokens - for em tokens (ex: "a,b,c" separados por vírgula)
            c:out - saída
            c:param - parâmetro
            c:redirect - redirecionamento
            c:remove - remoção de variável
            c:set - criação de variável
        -->

    </body>
</html>
