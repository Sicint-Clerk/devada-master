<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
 
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh" crossorigin="anonymous"></script>
  
	<div class="containerasc">
		<form id="form2" method="POST" action="saveSubCategory">
			<p class="textsizesc"><b>Add Sub Category</b></p>
			<br>
		<label for="mainCategory" class="textsizesc"><b>Choose Main Category:</b>&nbsp;</label>
		
		<select name="mainCategory" id="mainCategoryId" class="selectsize">
<!-- 		<option value=''> Select </option> -->
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
	
	<br>
	<br>
	<br>
	
	<main role="main" class="container">
		<table class="table table-striped table-bordered" id="table1">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Main Category</th>
					<th scope="col">Sub Category</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${subCategoryList}" var="subcategory">
					<tr>
						<td > ${subcategory.mainCategoryId} </td>
						<td > ${subcategory.subCategoryName } </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	
	<script src="<%=request.getContextPath()%>/resources/admin/js/bstable.js"></script>
	
	<script>
		// Basic example
		var example1 = new BSTable("table1");
		example1.init();

	

		function dynamicTableValuesExample() {
			// Generate new values for the table and show how BSTable updates
			let names = ['Matt', 'John', 'Billy', 'Erica', 'Sammy', 'Tom', 'Tate', 'Emily', 'Mike', 'Bob'];
			let numberOfRows = Math.floor(Math.random() * 10);

			document.getElementById("table3-body").innerHTML = '';	// Clear current table
			for(let i = 0; i < numberOfRows; i++) {
				let randomNameIndex = Math.floor(Math.random() * 10);

				let row = document.createElement("tr");
				row.innerHTML = `<th scope="row">` + i + `</th><td>Value</td><td>` + names[randomNameIndex] + `</td><td>@twitter</td>`;
				document.getElementById("table3-body").append(row);
			}

			example3.refresh();
		}

	</script>

<jsp:include page="footer.jsp"></jsp:include>