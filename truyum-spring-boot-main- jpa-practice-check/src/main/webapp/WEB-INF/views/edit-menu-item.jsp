<%@ include file="/WEB-INF/views/nav.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<h2 class="body-text-heading">Edit Menu Item</h2>
	<br>
	<br>
	<div class="row justify-content-md-center" >
	<form:form method="POST" modelAttribute="menuItem"
		action="/edit-menu-item" class="form-group">
		<form:hidden path = "id" value="${menuItem.id}"/>
		<form:label path="name" name="">Name</form:label>
		<form:input path="name" type="text" />
		<form:errors path="name" style="color:red;"></form:errors>	
		<br>
		<form:label path="price">Price (Rs.)</form:label>
		<form:input path="price" type="text" />
		<form:errors path="price" style="color:red;"></form:errors>
		<br>


		<form:label path="active">Active</form:label>
		<form:radiobutton path="active" value="Yes" />Yes
				<form:radiobutton path="active" value="No" />No
				<br>
		<form:label path="dateOfLaunch">Date Of Launch</form:label>
		<form:input path="dateOfLaunch" />
		<form:errors path="dateOfLaunch" style="color:red;"></form:errors>
		<br>
		<form:label path="category">Category</form:label>
		<form:select path="category" items="${categoryList}"></form:select>
		<br>
		<form:label path="freeDelivery">Free Delivery</form:label>
		<form:checkbox path="freeDelivery" />
		<br>
		<input type="submit" value="Save" id="submit" class="btn btn-success"/>

	</form:form>
</div>
<div class="footer">
<footer class="d-flex justify-content-around">
	<label class="copyright">Copyright � 2020</label>
</footer>
</div>
</body>
</html>