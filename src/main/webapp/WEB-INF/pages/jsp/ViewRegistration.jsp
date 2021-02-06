<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Registration | Barot Yuva Ekta</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Favicon -->   
<link href="<%=request.getContextPath()%>/resources/favicon.png" rel="shortcut icon" type="image/x-icon" />

<!-- Stylesheets -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/reset.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/animate.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/magnific-popup.css"/> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css?ver=10"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/form.css?ver=1"/>
    
<!-- Google Web fonts -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

<!-- Font icons -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/icon-fonts/font-awesome-4.5.0/css/font-awesome.min.css"/>

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>
<body>

<%@ page import = "java.util.ResourceBundle" %>
<% ResourceBundle resource = ResourceBundle.getBundle("messages",Locale.getDefault());%>
    <div id="preloader">
    	<div class="spinner">
            <div class="uil-ripple-css" style="transform:scale(0.29);"><div></div><div></div></div>
        </div>
    </div>


    <nav>
        <div class="row">
            <div class="container">
                <div class="logo">
                    <a href='/' title='Logo'><img src="<%=request.getContextPath()%>/resources/images/logo-200.png?v=1"></a>
                </div>
                <div class="responsive"><i data-icon="m" class="icon fa fa-bars"></i></div>
                <ul class="nav-menu">
                    <li><a href="/" class="smoothScroll">Home</a><span></span></li>
                    <li><a href="/#about" class="smoothScroll">About</a><span></span></li>
                    <li><a href="/#gallery" class="smoothScroll">Gallery</a><span></span></li>
                    <li><a href="/#contact" class="smoothScroll">Contact</a></li>
                    <li><a href="/registration" class="smoothScroll">Registration</a></li>
                    <li><a href="/marrigereg" class="smoothScroll">Marriage Registration</a></li>
                    <li><a href="/login" class="smoothScroll">Login</a></li> <c:if test="${sessionScope.loginUserRole != null }">
                    	<li><a href="/admin/loadApprovedList" class="smoothScroll">Dashboard</a></li>
                    </c:if>
                     <c:if test="${sessionScope.loginUserRole == null }">
                    	<li><a href="/login" class="smoothScroll">Login</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
    
    
    <!--HOME-->
	<section class="home inner_page_banner"> 
		<div class="home-content">
			<h1 class=""><%=resource.getString("title")%></h1>
		</div>
		<div class="home-video">
			<div class="player" style="display:block;height:100%; background: rgba(0,0,0,0.5);overflow:hidden">
				<img src="" />
			</div>
		</div>
	</section>
   
    <!--form-->
    <section class="about form-sections" >
		<div class="container"> 
			<div class="row">
				<div class="col-md-12">
					<form>
						<div class="user_prof_form ">
							<fieldset class="bg-fff distributor-form">
								<div class="flex_form clearfix">
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("name")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.name}
										</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("birthDate")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.birthDate}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("fatherName")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.fatherName}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("motherName")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.motherName}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("mosan")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.mosan}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("presentAddress")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.presentAddress}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("phone")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.phone}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("mobile")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.mobile}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("education")%> :</span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.education}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("bloodGroup")%> :</span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.bloodGroup}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("work")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.work}
										</div>
									</div>
									
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("permanentAddress")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.permanentAddress}
										</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("vas")%></span>
											<span class="eng"></span>
										</div>
										${personInformations.vas}
									</div>
								
								</div>
							</fieldset>
						</div>				
						
						<div class="table_section">
							<div class="flex_form clearfix form-table form_table">
								<div class="headline1"><%=resource.getString("familyInfo")%></div>
								<table class="table table-bordered">
									<thead>
										<tr class="active">
											<th width=""><%=resource.getString("memberName")%></th>
											<th width="70px"><%=resource.getString("age")%></th>
											<th width="120px"><%=resource.getString("relation")%></th>
											<th width="120px"><%=resource.getString("education")%></th>
											<th width="120px"><%=resource.getString("profession")%></th>
											<th width="70px"><%=resource.getString("married")%> /<br><%=resource.getString("unmarried")%> </th>
											<th width="70px"><%=resource.getString("bloodGroup")%></th>
										</tr>
									</thead>
									<tbody>
									
										<c:forEach var="perInfo" items="${familyInfo}">
										<tr>
											<td data-title="">
												${perInfo.memberName}
											</td>
											<td data-title="">
												${perInfo.age}
											</td>
											<td data-title="">
												${perInfo.relation}
											</td>
											<td data-title="">
												${perInfo.education}
											</td>
											<td data-title="">
												${perInfo.profession}
											</td>
											<td data-title="">
												<div class="radio radio-primary radio-inline">
													<c:choose>
													  <c:when test="${perInfo.married eq 'Y'}">
													    <%=resource.getString("married")%>
													  </c:when>
													  <c:otherwise>
													   <%=resource.getString("unmarried")%>
													  </c:otherwise>
													</c:choose>
												</div>
											</td>
											<td data-title="">
												${perInfo.bloodGroup}
											</td>
										</tr>
										</c:forEach>
									</tbody>
								</table>									
							</div>

						</div>
						
					</form>
					
				</div>
			</div>
		</div> <!-- Container end -->
	</section>
  
    
   <!--  <section class="contact padB90 gray-bg container-fluid" id="contact">
        <div class="container">
            <div class="section-title">
                <h2>GET IN TOUCH</h2>
                <p>If you would like to find out more about how We can help you,<br/>  Please give us miss call or drop me an email.</p>
            </div>
            Contact Info
            <div class="row">
                <div class="col-md-offset-2 col-md-8 contact-information">
                    <div class="col-md-4 col-sm-4 col-xs-12 contact-info wow fadeInUp" data-wow-delay="0.4s">
                        <i class="fa fa-phone" aria-hidden="true"></i>
                        <p><span class='small-text'>(+91)</span> 123 456 7890 </p>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-12 contact-info wow fadeInUp" data-wow-delay="0.6s">
                        <i class="fa fa-map-marker" aria-hidden="true"></i>
                        <p>A/123 xyz society, xyz apartment, <br/>xyz area , Ahmedabad-380015</p>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-12 contact-info wow fadeInUp" data-wow-delay="0.8s">
                        <i class="fa fa-envelope" aria-hidden="true"></i>
                        <p>contact@xyz.com </p>
                    </div>
                </div> information end
               
            </div>    
        </div>
    </section> -->
    <footer class="marT0">
        <div class="container">
            <div class="social">
                <a href='javascript:void(0)' target='_blank'><i class="fa fa-facebook" aria-hidden="true"></i>  </a>
                <a href='javascript:void(0)' target='_blank'><i class="fa fa-twitter" aria-hidden="true"></i>  </a>
                <a href='javascript:void(0)' target='_blank'><i class="fa fa-instagram" aria-hidden="true"></i>  </a>
                <a href='javascript:void(0)' target='_blank'><i class="fa fa-linkedin" aria-hidden="true"></i>  </a>
            </div>
            <p>Copyright &copy; 2018-2019 <a href='/'>http://devdagam.com/</a>, All rights Reserved. </p>
        </div>
    </footer>
    
<script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script><!-- jQuery library -->
<script src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/isotope.pkgd.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/typed.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.magnific-popup.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/main.js?ver=4"></script>
<script src="<%=request.getContextPath()%>/resources/devada.js"></script>
</body>
</html>