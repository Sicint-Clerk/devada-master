<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
	<div style="text-align: center;">
		<label for="mainservice">Choose Main Service:</label>
		<select name="mainservice" id="mainservice">
		  <option value="volvo">Volvo</option>
		  <option value="saab">Saab</option>
		  <option value="mercedes">Mercedes</option>
		  <option value="audi">Audi</option>
		</select>
		
		<br>
	    <br>
	    
		<form id="form2">
	         Enter Sub Service Name: <input type="text" name="subservicename">
	         <br>
	         <br>
	         <button type="submit" form="form2" value="Submit">Add</button>
	         
	     </form>
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>