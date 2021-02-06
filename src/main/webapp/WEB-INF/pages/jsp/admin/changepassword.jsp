<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Barot Samaj - Change Password</title>

<!-- Bootstrap core CSS-->
<link href="<%=request.getContextPath()%>/resources/admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="<%=request.getContextPath()%>/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="<%=request.getContextPath()%>/resources/admin/css/sb-admin.css" rel="stylesheet">
<% ResourceBundle resource = ResourceBundle.getBundle("messages");%>
</head>

<body class="bg-dark">

	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Change Password</div>
			<div class="card-body">
				<form>
					<div class="form-group">
						<div class="form-label-group">
							<input type="password" id="userName" class="form-control"
								placeholder="Old Password" required="required"
								autofocus="autofocus"> <label for="inputEmail">Old Password</label>
								<span id="passwordValidation" class="guj" style="color: red;display: none"><%=resource.getString("passwordValidation")%></span>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="password" id="newPassword" class="form-control"
								placeholder="Password" required="required"> <label
								for="inputPassword">New Password</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="password" id="cnfPassword" class="form-control"
								placeholder="Enter Your Password" required="required"> <label
								for="inputPassword">Confirm Password</label>
						</div>
						
						<span id="newAndCnf" class="guj" style="color: red;display: none"><%=resource.getString("newAndCnf")%></span>
					</div>
					<a class="btn btn-primary btn-block" href="#" onclick="changePassword()">Change Password</a>
				</form>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="<%=request.getContextPath()%>/resources/admin/vendor/jquery/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="<%=request.getContextPath()%>/resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/devada.js"></script>
</body>

</html>
