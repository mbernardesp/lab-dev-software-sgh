<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <h1>Find Address</h1>

    <div id="top" class="row">
        <div class="col-sm-6">

            <form:form method="post" modelAttribute="search" action="${pageContext.request.contextPath}/service/address" >

                <spring:bind path="content">
                    <div class="input-group h2">
                        <form:input path="content" type="text" class="form-control" id="content" placeholder="Zip code" />
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </span>
                    </div>
                </spring:bind>

            </form:form>

        </div>
    </div>

    <hr>
    <span>${address.cep}</span>
    <br>
    <span>${address.place}</span>   
    <br>
    <span>${address.complement}</span>   
    <br>
    <span>${address.neighborhood}</span>   
    <br>
    <span>${address.locality}</span>   
    <br>
    <span>${address.state}</span>   
    <br>
    <span>${address.unit}</span>   
    <br>
    <span>${address.ibge}</span>   
    <br>
    <span>${address.gia}</span>   
    <hr>
</div>

<jsp:include page="../fragments/footer.jsp" />