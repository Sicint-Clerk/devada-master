<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
	<div style="text-align: center;">
	
		<form id="form2" method="POST" action="saveSubCategory">
		
		<label for="mainCategory">Choose Main Category:</label>
		
		<select name="mainCategory" id="mainCategoryId">
		  <c:forEach items="${mainCategoryList}" var="category">
        	<option value="${category.id}"> ${category.mainCategoryName} </option>
    	  </c:forEach>
		</select>
		<br>
	    <br>
	    
	    Enter Sub Category Name: <input type="text" name="subCategoryName">
	    <br>
	    <br>
	    <button type="submit" value="Submit">Add</button>
	         
	    </form>
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>