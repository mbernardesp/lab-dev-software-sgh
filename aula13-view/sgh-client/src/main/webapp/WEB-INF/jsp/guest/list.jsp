<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <h1>Guest List</h1>

    <div id="top" class="row">
        <div class="col-sm-6">

            <div class="input-group h2">
                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar">
                <span class="input-group-btn">
                    <button class="btn btn-primary" type="submit">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </span>
            </div>

        </div>
        <div class="col-sm-6">
            <a class="btn btn-primary pull-right h2" href="${pageContext.request.contextPath}/guest/edit">Add</a>
        </div>
    </div>

    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>IdRoom</th>
            <th>Name</th>
            <th>Age</th>
            <th>Phone</th>
            <th>Actions</th>

        </tr>
        <c:forEach  items="${guestList}" var ="guest">
            <tr>
                <td>${guest.id}</td>
                <td>${guest.idRoom}</td>
                <td>${guest.name}</td>
                <td>${guest.age}</td>
                <td>${guest.phone}</td>
                <td>
                    <a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/guest/edit?id=${guest.id}">Edit</a>
                    <a class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/guest/delete?id=${guest.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragments/footer.jsp" />