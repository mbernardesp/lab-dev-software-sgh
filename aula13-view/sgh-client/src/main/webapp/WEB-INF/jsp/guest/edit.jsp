<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <h1>Guest Registration</h1>

    <div class="form-group">

        <form:form method="post" modelAttribute="guest" action="${pageContext.request.contextPath}/guest/save" >

            <form:hidden path="id" />

            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="name" type="text" class="form-control" id="name" placeholder="Name" />
            </div>

            <div class="form-group">
                <label for="age">Age</label>
                <form:input path="age" type="text" class="form-control" id="age" placeholder="Age" />
            </div>

            <div class="form-group">
                <label for="phone">Phone</label>
                <form:input path="phone" type="text" class="form-control" id="phone" placeholder="(35) 3471-9500" />
            </div>

            <div class="form-group">
                <button class="btn btn-primary" type="submit">Save</button>
                <a class="btn btn-info" href="${pageContext.request.contextPath}/guest/list">Cancel</a>
            </div>

        </form:form>
    </div> 


</div> 

<jsp:include page="../fragments/footer.jsp" />