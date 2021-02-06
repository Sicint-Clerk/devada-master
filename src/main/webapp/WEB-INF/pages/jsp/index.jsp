<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Barot Yuva Ekta</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Favicon -->   
<link href="<%=request.getContextPath()%>/resources/images/favicon.png" rel="shortcut icon" type="image/x-icon" />

<!-- Stylesheets -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/reset.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css?ver=10"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/animate.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/magnific-popup.css"/> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/masterslider.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/owl.carousel.min.css"/>
    
<!-- Google Web fonts -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600" rel="stylesheet">

<!-- Font icons -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/icon-fonts/font-awesome-4.5.0/css/font-awesome.min.css"/>

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<style>
ul.about_ul {padding: 0;list-style: none;font-size: 16px;color: #777;line-height: 25px;}
ul.about_ul li:last-child {margin: 0;}
ul.about_ul li {margin: 0 0 10px 0;}
</style>
</head>
<body>
<% ResourceBundle resource = ResourceBundle.getBundle("messages",Locale.getDefault());
%>
     <!-- Preloading --> 
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
                    <li><a href="#about" class="smoothScroll">About</a><span></span></li>
                    <li><a href="#gallery" class="smoothScroll">Gallery</a><span></span></li>
                    <li><a href="#contact" class="smoothScroll">Contact</a></li>
                    <li><a href="/registration" class="smoothScroll">Registration</a></li>
                    <li><a href="/marrigereg" class="smoothScroll">Marriage Registration</a></li>
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
	<section class="home slider" id="home"> 
		<%-- <div class="home-content">
			<h1><span class="element"></span></h1>
			<div class="social">
                <a href='javascript:void(0)' target='_blank'><i class="fa fa-facebook" aria-hidden="true"></i>  </a>
                <a href='javascript:void(0)' target='_blank'><i class="fa fa-twitter" aria-hidden="true"></i>  </a>
                <a href='javascript:void(0)' target='_blank'><i class="fa fa-instagram" aria-hidden="true"></i>  </a>
                <a href='javascript:void(0)' target='_blank'><i class="fa fa-linkedin" aria-hidden="true"></i>  </a>
			</div>
			<a class="home-down bounce smoothScroll" href="#about"><i class="fa fa-angle-down"></i></a>
		</div>
		<div class="home-video">
			<div class="player" style="display:block;height:100%; background: rgba(0,0,0,0.5);overflow:hidden">
				<div class="bg-image" style="background-image:url('<%=request.getContextPath()%>/resources/images/bg-image.jpg')"></div>
			</div>
		</div> --%>
		<!-- Changes 7-1-19 start -->
		<div class="ms-fullscreen-template" id="slider1-wrapper">
			<div class="master-slider ms-skin-default" id="masterslider">
				<div class="ms-slide slide-4 text-bottom-left home-content">
					<div class="slide-pattern"></div>
					<img src="img/blank.gif" data-src="<%=request.getContextPath()%>/resources/images/gallery/gallery-aa.jpg" alt=""/>  
				</div>
				<div class="ms-slide slide-4 text-bottom-left home-content">
					<div class="slide-pattern"></div>
					<img src="img/blank.gif" data-src="<%=request.getContextPath()%>/resources/images/gallery/gallery-bb.jpg" alt=""/>  
				</div>
				<div class="ms-slide slide-4 text-bottom-left home-content">
					<div class="slide-pattern"></div>
					<img src="img/blank.gif" data-src="<%=request.getContextPath()%>/resources/images/gallery/gallery-cc.jpg" alt=""/>  
				</div>
				<div class="ms-slide slide-4 text-bottom-left home-content">
					<div class="slide-pattern"></div>
					<img src="img/blank.gif" data-src="<%=request.getContextPath()%>/resources/images/gallery/e.jpg" alt=""/>  
				</div>
				<div class="ms-slide slide-4 text-bottom-left home-content">
					<div class="slide-pattern"></div>
					<img src="img/blank.gif" data-src="<%=request.getContextPath()%>/resources/images/gallery/j.jpg" alt=""/>  
				</div>
			
			</div>
			<div class="slider_texts_animated home-content">
				<div class="p ms-layer small-text">
					<h1><span class="element"></span></h1>
					<div class="social">
						<a href='javascript:void(0)' target='_blank'><i class="fa fa-facebook" aria-hidden="true"></i>  </a>
						<a href='javascript:void(0)' target='_blank'><i class="fa fa-twitter" aria-hidden="true"></i>  </a>
						<a href='javascript:void(0)' target='_blank'><i class="fa fa-instagram" aria-hidden="true"></i>  </a>
						<a href='javascript:void(0)' target='_blank'><i class="fa fa-linkedin" aria-hidden="true"></i>  </a>
					</div>
				</div>
				<div class="home-content bottom">
					<a class="home-down bounce smoothScroll" href="#about"><i class="fa fa-angle-down"></i></a>
				</div>
			</div>
		</div>
		<!--
		<div class="home-video">
			<div class="player" style="display:block;height:100%; background: rgba(0,0,0,0.5);overflow:hidden">
				<div class="bg-image" style="background-image:url('images/bg-image.jpg')"></div>
			</div>
		</div>
		-->
	<!-- Changes 7-1-19 end -->
		
	</section>
    
    <!--ABOUT-->
    <section class="about" id="about">
            <div class="container"> 
                <div class="row">
                    <div class="col-md-6 about-image wow fadeInUp" data-wow-delay="0.4s">
						<div class="embed-responsive embed-responsive-16by9 right-video shadow" style="background-image:url(<%=request.getContextPath()%>/resources/images/video-thumb.jpg)">
							<!-- <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/_pAricXiIys"></iframe> -->
						</div>
                    </div>
                  <!-- Changes 7-1-19 start -->
                    <div class="col-md-6 about-txt wow fadeInUp" data-wow-delay="0.8s">
                        <div class="right-about">
							<h2>About Devda</h2>
							<br/><p>
							According to Census 2011 information the location code or village code of Devda village is 509419. Devda village is located in Vijapur Tehsil of Mahesana district in Gujarat, India. It is situated 16km away from sub-district headquarter Vijapur and 29km away from district headquarter Mahesana. As per 2009 stats, Devda village is also a gram panchayat.</p>
							<p>The total geographical area of village is 516.8 hectares. Devda has a total population of 2,639 peoples. There are about 587 houses in Devda village. Vijapur is nearest town to Devda which is approximately 16km away.</p>
							<p>Source: <a href="https://villageinfo.in/gujarat/mahesana/vijapur/devda.html" target="_blank">https://villageinfo.in/gujarat/mahesana/vijapur/devda.html</a> </p>

                        </div>
                        <div class="hide">
							<!-- <h2>બ્રહ્મભટ્ટ એટલે કોણ ?? "शिवाधीन " </h2> -->
							<br/>
							<ul class="about_ul">
								<li><%=resource.getString("aboutUsLine1")%></li>
								<li><%=resource.getString("aboutUsLine2")%></li>
								<li><%=resource.getString("aboutUsLine3")%></li>
								<li><%=resource.getString("aboutUsLine4")%></li>
								<li><%=resource.getString("aboutUsLine5")%></li>
								<li><%=resource.getString("aboutUsLine6")%></li>
                            </ul>
                        </div>
                    </div>
					<!-- Changes 7-1-19 end -->
                </div>
            </div> <!-- Container end -->
   </section>
    
    <!--PORTFOLIO-->
    <section class="portfolio" id="gallery">
        <div class="container">
            <div class="section-title">
                <h2>Gallery</h2>
                <div class="portfolio_filter">
                    <ul>
                        <li class="select-cat" data-filter="*">All</li>
                        <li data-filter=".photos">Photos</li>
                        <li data-filter=".video">Videos</li>
                    </ul>
                </div>
            </div>
            <!--Portfolio Items-->  
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="isotope_items row">
                        <!-- Item video-->
						<a href="https://youtu.be/t8zIR1XxMjI" target="_blank" class="single_item video col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-video-1.jpg" alt=""> 
							<span class="yt-ico"></span>
                        </a>
						<!-- Item video-->
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-1.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-1.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-2.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-2.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-3.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-3.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-4.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-4.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-5.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-5.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-6.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-6.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-7.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-7.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-8.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-8.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-9.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-9.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-10.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-10.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-11.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-11.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-12.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-12.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-13.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-13.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/gallery-14.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/gallery-14.jpg" alt=""> 
                        </a>
                        
                         <a href="<%=request.getContextPath()%>/resources/images/gallery/a.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/a.jpg" alt=""> 
                        </a>
                         <a href="<%=request.getContextPath()%>/resources/images/gallery/b.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/b.jpg" alt=""> 
                        </a>
                         <a href="<%=request.getContextPath()%>/resources/images/gallery/c" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/c.jpg" alt=""> 
                        </a>
                         
                         <a href="<%=request.getContextPath()%>/resources/images/gallery/g.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/g.jpg" alt=""> 
                        </a>
                        
                         <a href="<%=request.getContextPath()%>/resources/images/gallery/h.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/h.jpg" alt=""> 
                        </a>
                         <a href="<%=request.getContextPath()%>/resources/images/gallery/i.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/i.jpg" alt=""> 
                        </a>
                         <a href="<%=request.getContextPath()%>/resources/images/gallery/j.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/j.jpg" alt=""> 
                        </a>
                         <a href="<%=request.getContextPath()%>/resources/images/gallery/k.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/k.jpg" alt=""> 
                        </a>
                        
                         <a href="<%=request.getContextPath()%>/resources/images/gallery/m.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/m.jpg" alt=""> 
                        </a>
                        
                          <a href="<%=request.getContextPath()%>/resources/images/gallery/n.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/n.jpg" alt=""> 
                        </a>
                         
                          <a href="<%=request.getContextPath()%>/resources/images/gallery/p.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/p.jpg" alt=""> 
                        </a>
                         
                          <a href="<%=request.getContextPath()%>/resources/images/gallery/s.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/s.jpg" alt=""> 
                        </a>
                          <a href="<%=request.getContextPath()%>/resources/images/gallery/t.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/t.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/u.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/u.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/v.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/v.jpg" alt=""> 
                        </a>
                        <a href="<%=request.getContextPath()%>/resources/images/gallery/w.jpg" class="single_item link photos col-md-4 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img src="<%=request.getContextPath()%>/resources/images/gallery/thumb/w.jpg" alt=""> 
                        </a>
                        
                    </div>
                </div>
                </div>
        </div>
    </section>
    <section class="contact gray-bg container-fluid advrtize">
        <div class="container">
            <div class="section-title">
                <h2>Advertisement</h2>
                <p>Advertise with us, and get listed here.</p>
            </div>
            <div class="row blog">
				<div class="owl-carousel owl-theme adz-slider">
					
					<c:forEach items="${dbFileList}" var="row" varStatus="rowCounter">
		      			<a href="javascript:void(0)" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 blog-content wow fadeInUp">	
	      					<div class="blog-image" style='background-image:url("data:image/jpeg;base64,${row.imageInStr}")'></div>
							<h1>${row.adDesc}</h1>
	   					</a>	
	  				</c:forEach >
					
				</div>
            </div>
        </div>
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
<script src="<%=request.getContextPath()%>/resources/js/masterslider.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/owl.carousel.min.js"></script>

<!-- Changes 7-1-19 start -->
<script type="text/javascript">		
$(document).ready(function(){	
	
	var contextPath = "<%=request.getContextPath()%>";
	/* var adImage = contextPath+"/resources/images/adz-default.png";
	
	$('.blog-image').css('backgroundImage','url('+adImage+')'); */

	var slider = new MasterSlider();
	slider.setup('masterslider' , {
		width:1024,
		height:768,
		space:5,
		view:'fade',
		autofill:true,
		speed:20,
		loop:true,
		layout:'fullwidth',
		instantStartLayers:true,
		overPause: false,
		startOnAppear: false,
		autoplay:true,
		grabCursor:false,
		swipe:false,
	});
		
//		slider.control('bullets');

	var wrapper = $('#slider1-wrapper');
	wrapper.height(window.innerHeight);
	$(window).resize(function(event) {
		wrapper.height(window.innerHeight);
	});
});
</script>
<script>
$('.adz-slider').owlCarousel({
    loop:true,
    margin:10,
	items:3,
    autoplay:true,
    autoplayTimeout:1900,
    autoplayHoverPause:false,	
	navText: [ "<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>" ],
    responsiveClass:true,
    responsive:{
        0:{
            items:1,
            nav:true
        },
        600:{
            items:2,
            nav:false
        },
        1000:{
            items:3,
            nav:true
        }
    }
})

</script>

<!-- Changes 7-1-19 end -->

</body>
</html>