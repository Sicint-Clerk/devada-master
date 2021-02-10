<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>Forms | Admin</title>

<link href="<%=request.getContextPath()%>/resources/admin/vendor/bootstrap/css/bootstrap.min.css"	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/admin/vendor/datatables/dataTables.bootstrap4.css"	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/admin/css/sb-admin.css"	rel="stylesheet">


</head>

<style>

/* addSubCategory and addMainCategory css */
.containerasc{
	text-align: center;
}

.selectsize{
	width: 200px;
	border:2px solid black;
}

.textsizesc{
	font-size:30px;
}

.btnadd{
	height:35px;
    width:80px;
    font-size:20px;
}

.inputcate{
	border:2px solid black;
}
/* addSubCategory and addMainCategory css */
.dropbtn {
	background-color:#212529;
    padding: 16px;
    font-size: 16px;
    border: none;
	color:white;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: lightgrey;
    min-width: 200px;
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: white;}
.dropdown:hover .dropdown-content {display: block;}
.dropdown:hover  {background-color: grey;}


</style>


<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="/">Barot Samaj</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<div
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"></div>
		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">

			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<div class="dropdown-item" href="javascript:void">Hi,
						${sessionScope.loginUserName}</div>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/changePassword">Change Password</a>
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>
	</nav>
	
	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<c:if test="${sessionScope.loginUserRole eq 'admin'}">
				<li class="nav-item active"><a class="nav-link"
					href="/admin/loadList"> <i class="fas fa-fw fa-table"></i> <span>Application</span></a></li>
			</c:if>
			<!--  -->
			<li class="nav-item active"><a class="nav-link"	href="/admin/loadMarriageList"> <i class="fas fa-fw fa-table"></i>Marriage Data <span></span></a></li>
			<li class="nav-item active"><a class="nav-link"	href="/admin/loadApprovedList"> <i class="fas fa-fw fa-table"></i><span>Approved Data</span></a></li>
			<c:if test="${sessionScope.loginUserRole eq 'admin'}">
				<li class="nav-item active"><a class="nav-link"	href="/admin/uploadAds"> <i class="fas fa-fw fa-table"></i><span>Upload Ads</span></a></li>	
			</c:if>	
				
			
			<li class="nav-item active" >
				<div class="dropdown">
				<button class="dropbtn" ><i class="fas fa-fw fa-table"></i>Add Category</button>
				<div class="dropdown-content">
				
				
				<a href="/admin/addMainCategory">Add Main Category</a>
				<a href="/admin/addSubCategory">Add Sub Category</a>
				 
				</div>
				</div>
			</li>		
			
		</ul>
		
		<div id="content-wrapper">
			<div class="container-fluid">
				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Application</li>
				</ol>
				
		