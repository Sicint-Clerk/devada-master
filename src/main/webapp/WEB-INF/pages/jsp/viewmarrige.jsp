<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Registration | Barot Yuva Ekta</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Favicon -->
<link href="<%=request.getContextPath()%>/resources/favicon.png"
	rel="shortcut icon" type="image/x-icon" />

<!-- Stylesheets -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/reset.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/animate.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/magnific-popup.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css?ver=10" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/form.css?ver=1" />

<!-- Google Web fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">

<!-- Font icons -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/icon-fonts/font-awesome-4.5.0/css/font-awesome.min.css" />

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>
<body>
	<%
	  ResourceBundle resource = ResourceBundle.getBundle("messages");
	%>
	<div id="preloader">
		<div class="spinner">
			<div class="uil-ripple-css" style="transform: scale(0.29);">
				<div></div>
				<div></div>
			</div>
		</div>
	</div>

	<nav>
		<div class="row">
			<div class="container">
				<div class="logo">
					<a href='/' title='Logo'><img
						src="<%=request.getContextPath()%>/resources/images/logo-200.png?v=1"></a>
				</div>
				<div class="responsive">
					<i data-icon="m" class="icon fa fa-bars"></i>
				</div>
				<ul class="nav-menu">
					<li><a href="/" class="smoothScroll">Home</a><span></span></li>
					<li><a href="/#about" class="smoothScroll">About</a><span></span></li>
					<li><a href="/#gallery" class="smoothScroll">Gallery</a><span></span></li>
					<li><a href="/#contact" class="smoothScroll">Contact</a></li>
					<li><a href="/registration" class="smoothScroll">Registration</a></li>
					<li><a href="/marrigereg" class="smoothScroll">Marriage
							Registration</a></li>
					 <c:if test="${sessionScope.loginUserRole != null }">
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
			<h1 class=""><%=resource.getString("unmarried_person_name")%></h1>
		</div>
		<div class="home-video">
			<div class="player"
				style="display: block; height: 100%; background: rgba(0, 0, 0, 0.5); overflow: hidden">
				<img src="" />
			</div>
		</div>
	</section>

	<!--form-->
	<section class="about form-sections">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form>
						<div class="user_prof_form ">
							<fieldset class="bg-fff distributor-form">
								<div class="flex_form clearfix">
									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("dikra_dikri_name")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.name}</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("birthDate")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.birthDate}</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("fatherName")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.fatherName}
										</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("motherName")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.motherName}
										</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("mosan")%></span> <span
												class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.mosan}</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("presentAddress")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.presentAddress}</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("phone")%></span> <span
												class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.phone}</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("mobile")%></span> <span
												class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.mobile}</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("education")%>
												:</span> <span class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.education}</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("bloodGroup")%>
												:</span> <span class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.bloodGroup}
										</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("work")%></span> <span
												class="eng"></span>
										</div>
										<div class="flex_text">${personInformations.work}</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("permanentAddress")%></span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											${personInformations.permanentAddress}</div>
									</div>

									<div class="flex_div">
										<div class="flex_name">
											<span class="guj"><%=resource.getString("vas")%></span> <span
												class="eng"></span>
										</div>
										<div class="flex_text">
											<div class="radio-btns">
												<c:choose>
													<c:when test="${personInformations.vas=='bhanavat'}">
														<%=resource.getString("bhanavat")%>
													</c:when>
													<c:when test="${personInformations.vas=='setavat'}">
														<%=resource.getString("setavat")%>
													</c:when>
													<c:when test="${personInformations.vas=='rudavat'}">
														<%=resource.getString("rudavat")%>
													</c:when>
													<c:otherwise>

													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div>

								</div>
							</fieldset>
						</div>
						<div class="table_section">
							<div class="flex_form clearfix form-table form_table">
								<div class="headline1"><%=resource.getString("married_women")%>
								</div>
								<div class="col-md-12 padd0 double-form-main">
									<div class="col-md-6 double-form">
										<div class="flex_form clearfix">
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("bahen_dikari_name")%></span>
													<span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[0].daughterName}</div>
											</div>
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("bahen_dikari_pita_name")%>
													</span> <span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[0].daughterFather}</div>
											</div>
											<div class="flex_div radio_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("vas")%></span> <span
														class="eng"></span>
												</div>
												<div class="flex_text">
													<div class="radio-btns">
														<c:choose>
															<c:when test="${marriedDaughters[0].vas=='bhanavat'}">
																<%=resource.getString("bhanavat")%>
															</c:when>
															<c:when test="${marriedDaughters[0].vas=='setavat'}">
																<%=resource.getString("setavat")%>
															</c:when>
															<c:when test="${marriedDaughters[0].vas=='rudavat'}">
																<%=resource.getString("rudavat")%>
															</c:when>
															<c:otherwise>

															</c:otherwise>
														</c:choose>
													</div>
												</div>
											</div>
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("lagan_gam")%>
													</span> <span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[0].laganGam}
												</div>
											</div>
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("presentAddress")%></span>
													<span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[0].presentAddress}
												</div>
											</div>
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("mobile")%></span>
													<span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[0].mobile}
												</div>
											</div>
										</div>

									</div>
									<div class="col-md-6 double-form">
										<div class="flex_form clearfix">
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("bahen_dikari_name")%></span>
													<span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[1].daughterName}</div>
											</div>
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("bahen_dikari_pita_name")%>
													</span> <span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[1].daughterFather}</div>
											</div>
											<div class="flex_div radio_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("vas")%></span> <span
														class="eng"></span>
												</div>
												<div class="flex_text">
													<div class="radio-btns">
														<c:choose>
															<c:when test="${marriedDaughters[1].vas=='bhanavat'}">
																<%=resource.getString("bhanavat")%>
															</c:when>
															<c:when test="${marriedDaughters[1].vas=='setavat'}">
																<%=resource.getString("setavat")%>
															</c:when>
															<c:when test="${marriedDaughters[1].vas=='rudavat'}">
																<%=resource.getString("rudavat")%>
															</c:when>
															<c:otherwise>

															</c:otherwise>
														</c:choose>
													</div>
												</div>
											</div>
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("lagan_gam")%>
													</span> <span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[1].laganGam}
												</div>
											</div>
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("presentAddress")%></span>
													<span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[1].presentAddress}
												</div>
											</div>
											<div class="flex_div">
												<div class="flex_name">
													<span class="guj"><%=resource.getString("mobile")%></span>
													<span class="eng"></span>
												</div>
												<div class="flex_text">
													${marriedDaughters[1].mobile}
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
<!-- 
							<div class="clearfix submit_section">
								<button id="con_submit" class="site-button" type="button"
									onclick="saveMarriegInfo()">Submit</button>
							</div> -->
					</form>

				</div>
			</div>
		</div>
		<!-- Container end -->
	</section>


	<section class="contact padB90 gray-bg container-fluid" id="contact">
        <div class="container">
            <div class="section-title">
                <h2>GET IN TOUCH</h2>
                <p>If you would like to find out more about how We can help you,<br>  Please give us miss call or drop me an email.</p>
            </div>
            <!-- Contact Info -->
            <div class="row">
                <div class="col-md-offset-2 col-md-8 contact-information">
                    <div class="col-md-4 col-sm-4 col-xs-12 contact-info wow fadeInUp" data-wow-delay="0.4s" style="visibility: visible; animation-delay: 0.4s; animation-name: fadeInUp;">
                        <i class="fa fa-phone" aria-hidden="true"></i>
                        <p><span class="small-text">(+91)</span> 989 880 9007 </p>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-12 contact-info wow fadeInUp" data-wow-delay="0.6s" style="visibility: visible; animation-delay: 0.6s; animation-name: fadeInUp;">
                        <i class="fa fa-map-marker" aria-hidden="true"></i>
                        <p><%=resource.getString("address1")%><br/><%=resource.getString("address2")%></p>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-12 contact-info wow fadeInUp" data-wow-delay="0.8s" style="visibility: visible; animation-delay: 0.8s; animation-name: fadeInUp;">
                        <i class="fa fa-envelope" aria-hidden="true"></i>
                        <p>barotyuvaekta@gmail.com</p>
                    </div>
                </div> <!-- information end -->
               
				<div class="col-md-10 col-md-offset-1 wow fadeInUp" data-wow-delay="1s">
                    <form class="col-md-12 contact-form" method="POST" action="##">
						<div class="col-md-3 person_img_div">
							<div class="img-person">
								<img src="<%=request.getContextPath()%>/resources/images/amit-bhai-barot.jpg" class="img-responsive" alt=""/>
								<div class="person_meta">
									<div class="title_name"><%=resource.getString("trusty1")%></div>
									<div class="orange title_bold"><%=resource.getString("trusty2")%></div>
								</div>
							</div>
						</div>
                        <div class="col-md-9">
                            <!--Name-->
                            <div class="col-md-6">
                                <input id="name" name="con_name" class="form-inp requie" type="text" placeholder="Name">
                            </div>
                            <!--Email-->
                            <div class="col-md-6">
                                <input id="email" name="con_email" class="form-inp requie" type="text" placeholder="Email">
                            </div>
                            <div class="col-md-12">
                                <!--Message-->
                                <textarea name="con_message" id="message" class="requie" placeholder="Message" rows="8"></textarea>
                                <input id="con_submit" class="site-button" type="submit" value="SEND A MESSAGE" onclick="saveContact()">
                            </div>
                        </div>
                    </form>
                </div>
            </div>    
        </div>
    </section>
	<footer class="marT0">
		<div class="container">
			<div class="social">
				<a href='javascript:void(0)' target='_blank'><i
					class="fa fa-facebook" aria-hidden="true"></i> </a> <a
					href='javascript:void(0)' target='_blank'><i
					class="fa fa-twitter" aria-hidden="true"></i> </a> <a
					href='javascript:void(0)' target='_blank'><i
					class="fa fa-instagram" aria-hidden="true"></i> </a> <a
					href='javascript:void(0)' target='_blank'><i
					class="fa fa-linkedin" aria-hidden="true"></i> </a>
			</div>
			  <p>Copyright &copy; 2018-2019 <a href='/'>http://devdagam.com/</a>, All rights Reserved. </p>
		</div>
	</footer>

	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
	<!-- jQuery library -->
	<script src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/isotope.pkgd.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/typed.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/main.js?ver=4"></script>
	<script src="<%=request.getContextPath()%>/resources/devada.js"></script>
</body>
</html>
