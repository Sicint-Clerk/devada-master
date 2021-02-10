<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
	<div class="containerasc">
	
		<form id="form2" method="POST" action="saveSubCategory">
			<p class="textsizesc"><b>Add Sub Category</b></p>
			<br>
		<label for="mainCategory" class="textsizesc"><b>Choose Main Category:</b>&nbsp;</label>
		
		<select name="mainCategory" id="mainCategoryId" class="selectsize">
		  <c:forEach items="${mainCategoryList}" var="category">
        	<option class="textsizesc" value="${category.id}"> ${category.mainCategoryName} </option>
    	  </c:forEach>
		</select>
		<br>
	    <br>
	    
	    <b class="textsizesc">Enter Sub Category Name:</b>&nbsp;&nbsp;&nbsp; 
	    <input class="inputcate" type="text" name="subCategoryName" size="30">
	    <br>
	    <br><br>
	    <button type="submit" value="Submit" class="btnadd">Add</button>
	         
	    </form>
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>