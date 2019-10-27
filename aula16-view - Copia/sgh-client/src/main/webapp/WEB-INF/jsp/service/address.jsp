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
                            <button class="btn btn-warning" type="submit" id="load" data-loading-text="<i class='fa fa-spinner fa-spin'></i> Load ">Find address
                                <!--span class="glyphicon glyphicon-search"></span-->
                            </button>
                        </span>
                    </div>
                </spring:bind>

            </form:form>

        </div>
    </div>

    <table class="table table-striped">
        <tr>
            <th>Zip code</th>
            <th>Place</th>
            <th>Complement</th>
            <th>Neighborhood</th>
            <th>locality</th>
            <th>State</th>
            <th>Unit</th>
            <th>Ibge</th>
            <th>Gia</th>

        </tr>
        <tr>
            <td>${address.cep}</td>
            <td>${address.place}</td>
            <td>${address.complement}</td>
            <td>${address.neighborhood}</td>
            <td>${address.locality}</td>
            <td>${address.state}</td>
            <td>${address.unit}</td>
            <td>${address.ibge}</td>
            <td>${address.gia}</td>
        </tr>
    </table>

</div>

<script>
    $('.btn').on('click', function () {
        var $this = $(this);
        $this.button('loading');
        setTimeout(function () {
            $this.button('reset');
        }, 8000);
    });
</script>

<jsp:include page="../fragments/footer.jsp" />