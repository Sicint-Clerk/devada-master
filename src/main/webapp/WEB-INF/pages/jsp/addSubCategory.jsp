<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	
<!-- 	<select id="food" name="fooditems"> -->
<%--     <c:forEach items="${foods}" var="food"> --%>
<%--         <option value="${food.key}"> --%>
<%--             ${food.value} --%>
<!--         </option> -->
<%--     </c:forEach> --%>
<!-- 	</select> -->
  
	<div style="text-align: center;">
	
		<form id="form2" method="POST" action="saveSubCategory">
		
		<label for="mainCategory">Choose Main Category:</label>
		
		<select name="mainCategory" id="mainCategory">
<!-- 			<option> Select Main Category </option> -->
		  <c:forEach items="${mainCategoryList}" var="category">
        	<option> ${category.maincategoryname} </option>
    	  </c:forEach>
		</select>
		
		
<!-- 		<select name="mainCategory" id="mainCategory"> -->
<!-- 		  <option value="volvo">Volvo</option> -->
<!-- 		  <option value="saab">Saab</option> -->
<!-- 		  <option value="mercedes">Mercedes</option> -->
<!-- 		  <option value="audi">Audi</option> -->
<!-- 		</select> -->
		
		<br>
	    <br>
	    
	         Enter Sub Category Name: <input type="text" name="subCategoryName">
	         <br>
	         <br>
	         <button type="submit" value="Submit">Add</button>
	         
	     </form>
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>