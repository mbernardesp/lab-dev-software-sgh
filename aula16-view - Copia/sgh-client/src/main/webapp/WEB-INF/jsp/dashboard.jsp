<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="fragments/header.jsp" />

<div class="container">
    <h1>Dashboard</h1>
    <span>${msg}</span>
    
    <br/>
    <br/>

    <form method="POST" action="${pageContext.request.contextPath}/dashboard/upload" enctype="multipart/form-data">
        <input type="file" name="file" /><br/><br/>
        <input type="submit" value="Submit" />
    </form>

    <!--img class="mb-4" src="{pageContext.request.contextPath}/dashboard/download/img.png" alt="" width="128" height="128"-->
    <!--img src="data:image/jpg;base64,${base64Image}" width="240" height="300"/-->
    <img src="data:image/png;base64,${base64Image}" width="240" height="300"/>

</div>

<jsp:include page="fragments/footer.jsp" />