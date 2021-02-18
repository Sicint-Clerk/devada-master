<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <div id="content-wrapper">
			<div class="container-fluid">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Add Category / Add Main Category</li>
				</ol> 
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh" crossorigin="anonymous"></script>

	<div style="text-align: center;">
<!-- 		<p class="textsizesc"><b>Add Main Category</b></p> -->
		<br>
	      <form id="form1" method="POST" action="saveMainCategory">
	         <b class="textsizesc">Main Category Name:</b>&nbsp;&nbsp;
	         <input class="inputcate" type="text" id="mainCategoryText" name="mainCategoryName" size="30" border="20">
	         <br>
	         <br><br><br>
	         <button type="submit" class="btnadd">Add</button>
	         
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
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${mainCategoryList}" var="maincategory">
					<tr>
						<td > ${maincategory.mainCategoryName} </td>
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