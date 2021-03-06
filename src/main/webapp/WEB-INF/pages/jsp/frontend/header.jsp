<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="nav-bg-b main-header navfix fixed-top">
			<div class="container-fluid m-pad">
				<div class="menu-header">
					<div class="dsk-logo"><a class="nav-brand" href="">
						<img src="<%=request.getContextPath()%>/resources/frontend/images/white-logo.png" alt="Logo" class="mega-white-logo"/>
						<img src="<%=request.getContextPath()%>/resources/frontend/images/logo.png" alt="Logo" class="mega-darks-logo"/>
					</a></div>
					<div class="custom-nav" role="navigation">
						<ul class="nav-list">
							<li><a href="/" class="menu-links">Home</a></li>
							<li class="sbmenu"><a href="#" class="menu-links">Company</a>
							<div class="nx-dropdown">
								<div class="sub-menu-section">
									<div class="container">
										<div class="col-md-12">
											<div class="sub-menu-center-block" style="justify-content: center;">
												<div class="sub-menu-column">
													<a href="contact.html"><img src="<%=request.getContextPath()%>/resources/frontend/images/banner/header-img-1.png" alt="service" class="img-fluid"></a>
												</div>
												<div class="sub-menu-column">
													<div class="menuheading">Why Niwax</div>
													<ul>
														<li><a href="about-us.html">About Us</a></li>
														<li><a href="why-us.html">Why Us</a></li>
														<li><a href="development-process.html">Our Development Process</a></li>
														<li><a href="mission-vision.html">Mission & Vision</a></li>
													</ul>
												</div>
												<div class="sub-menu-column">
													<div class="menuheading">&nbsp;</div>
													<ul>
														<li><a href="team.html">Our Team</a></li>
														<li><a href="client-reviews.html">Client Reviews</a> </li>
														<li><a href="portfolio.html">Portfolio</a> </li>
														<li><a href="contact.html">Contact Us</a> </li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li class="sbmenu"><a href="#" class="menu-links">Services</a>
						<div class="nx-dropdown">
							<div class="sub-menu-section">
								<div class="container">
									<div class="col-md-12">
										<div class="sub-menu-center-block">
											
											<c:forEach items="${mainCategoryList}" var="maincategory">
												<div class="sub-menu-column">
											 		<div class="menuheading">${maincategory.mainCategoryName}</div>
											 			<ul>
											     			<c:forEach items="${subCategoryList}" var="subcategory">
											     				<c:if test="${subcategory.mainCategoryId == maincategory.id}">
											     	   				 <li><a href="service-inner.html"> <c:out value="${subcategory.subCategoryName}"></c:out> </a> </li>
											     				</c:if>
											    			 </c:forEach>
											     		</ul>
											     </div>
											</c:forEach>
											
											
<!-- 											<div class="sub-menu-column"> -->
<!-- 												<div class="menuheading">Web Developments</div> -->
<!-- 												<ul> -->
<!-- 													<li><a  href="service-inner.html">Kishan</a></li> -->
<!-- 													<li><a href="service-inner.html">Harsh</a></li> -->
<!-- 													<li><a href="service-inner.html">Deep</a></li> -->
<!-- 													<li><a href="service-inner.html">Laravel Development</a></li> -->
<!-- 													<li><a href="service-inner.html">Node Development</a></li> -->
<!-- 													<li><a href="service-inner.html">Codeigniter Development</a></li> -->
<!-- 													<li><a href="service-inner.html">ASP.Net Development</a></li> -->
<!-- 												</ul> -->
<!-- 											</div> -->
<!-- 											<div class="sub-menu-column"> -->
<!-- 												<div class="menuheading">Mobile App Development </div> -->
<!-- 												<ul> -->
<!-- 													<li><a href="service-inner.html">Mobile App Development</a> </li> -->
<!-- 													<li><a href="service-inner.html">Android App Development</a> </li> -->
<!-- 													<li><a href="service-inner.html">iPhone App Development</a> </li> -->
<!-- 													<li><a href="service-inner.html">Windows App Development</a> </li> -->
<!-- 													<li><a href="service-inner.html">Custom Application Development</a> </li> -->
<!-- 													<li><a href="service-inner.html">Wearable App Development</a> </li> -->
<!-- 												</ul> -->
<!-- 											</div> -->
<!-- 											<div class="sub-menu-column"> -->
<!-- 												<div class="menuheading">Digital Marketing</div> -->
<!-- 												<ul> -->
<!-- 													<li><a href="service-inner.html">Search Engine Optimization</a> </li> -->
<!-- 													<li><a href="service-inner.html">Social Media Marketing</a> </li> -->
<!-- 													<li><a href="service-inner.html">Pay per Click</a> </li> -->
<!-- 													<li><a href="service-inner.html">Content Writing</a> </li> -->
<!-- 													<li><a href="service-inner.html">Email Marketing</a> </li> -->
<!-- 												</ul> -->
<!-- 											</div> -->
<!-- 											<div class="sub-menu-column"> -->
<!-- 												<div class="menuheading">Graphic Design</div> -->
<!-- 												<ul> -->
<!-- 													<li><a href="service-inner.html">Graphic Design Service </a> </li> -->
<!-- 													<li><a href="service-inner.html">Brochure Design</a> </li> -->
<!-- 													<li><a href="service-inner.html">Print & Packaging Design</a> </li> -->
<!-- 													<li><a href="service-inner.html">Logo Design</a> </li> -->
<!-- 													<li><a href="service-inner.html">Branding</a> </li> -->
<!-- 												</ul> -->
<!-- 											</div> -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</li>
					
				<li><a href="portfolio.html" class="menu-links">Portfolio</a> </li>
				<!--menu right border-->
				<li><a href="contact.html" class="menu-links right-bddr">Contact</a> </li>
				<li class="contact-show"><a href="#" class="btn-round- btn-br bg-btn3"><i class="fas fa-phone-alt"></i></a>
				<div class="contact-inquiry">
					<div class="contact-info-">
						<div class="contct-heading">Niwax Contacts</div>
						<div class="inquiry-card-nn hrbg">
							<div class="title-inq-c">FOR HR DEPARTMENT</div>
							<ul><li class="mb0"><img src="<%=request.getContextPath()%>/resources/frontend/images/flags/us.svg" alt="us office" class="flags-size"> <a href="tel:1111111111" >+1-123-456-7890</a></li></ul>
						</div>
						<div class="inquiry-card-nn">
							<div class="title-inq-c">FOR SALES DEPARTMENT</div>
							<ul><li><a href="tel:1111111111"><img src="<%=request.getContextPath()%>/resources/frontend/images/flags/us.svg" alt="us office" class="flags-size"> +1-123-456-7890</a></li>
							<li><a href="tel:1111111111"><img src="<%=request.getContextPath()%>/resources/frontend/images/flags/au.svg" alt="australia office" class="flags-size"> +1-123-456-7890</a></li>
							<li><a href="tel:1111111111"><img src="<%=request.getContextPath()%>/resources/frontend/images/flags/it.svg" alt="italy office" class="flags-size"> +91-123-456-7890</a></li>
							<li><i class="fab fa-skype"></i><a href="skype:niwax.company?call" >niwax.company</a></li>
							<li><i class="fas fa-envelope"></i><a href="mailto:info@businessname.com" >info@businessname.com</a></li></ul>
						</div>
					</div>
				</div>
			</li>
			<li><a href="##" class="btn-br bg-btn3 btshad-b2 lnk">Request A Quote <span class="circle"></span></a> </li>
		</ul>
					</div>
					<div class="mobile-menu2">
						<ul class="mob-nav2">
							<li><a href="#" class="btn-round- btn-br bg-btn3 btshad-b1"  data-toggle="modal" data-target="#menu-contact"><i class="fas fa-phone-alt"></i></a></li>
							<li class="navm-"> <a class="toggle" href="#"><span></span></a></li>
						</ul>
					</div>
				</div>
				<!--Mobile Menu-->
				<nav id="main-nav">
					<ul class="first-nav">
					<li><a href="/">Home</a></li>
					<li><a href="#">Company</a>
						<ul>
							<li><a href="about-us.html">About Us</a></li>
							<li><a href="why-us.html">Why Us</a></li>
							<li><a href="development-process.html">Our Development Process</a></li>
							<li><a href="mission-vision.html">Mission & Vision</a></li>
							<li><a href="team.html">Our Team</a></li>
							<li><a href="client-reviews.html">Client Reviews</a> </li>
							<li><a href="portfolio.html">Portfolio</a> </li>
							<li><a href="contact.html">Contact Us</a> </li>
						</ul>
					</li>
				<li><a href="#">Services</a>
					<ul>
							<c:forEach items="${mainCategoryList}" var="maincategory">
							<li>
								<a href="#">${maincategory.mainCategoryName}</a>
									<ul>
										<c:forEach items="${subCategoryList}" var="subcategory">
											<c:if test="${subcategory.mainCategoryId == maincategory.id}">
												<li><a href="service-inner.html"> <c:out value="${subcategory.subCategoryName}"></c:out> </a> </li>
											</c:if>
										</c:forEach>
									</ul>
							</li>	     
							</c:forEach>
					</ul>
				
<!-- 				<ul> -->
<!-- 					<li> -->
<!-- 						<a href="#">Web Development</a> -->
<!-- 						<ul> -->
<!-- 							<li><a href="service-inner.html">Web Development</a></li> -->
<!-- 							<li><a href="service-inner.html">PHP Development</a></li> -->
<!-- 							<li><a href="service-inner.html">Angular JS</a></li> -->
<!-- 							<li><a href="service-inner.html">Laravel</a></li> -->
<!-- 							<li><a href="service-inner.html">Node Js</a></li> -->
<!-- 							<li><a href="service-inner.html">Codeigniter</a></li> -->
<!-- 							<li><a href="service-inner.html">ASP.Net</a></li> -->
<!-- 						</ul> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<a href="#">Mobile App Development</a> -->
<!-- 						<ul> -->
<!-- 							<li><a href="service-inner.html">Mobile App Development</a> </li> -->
<!-- 							<li><a href="service-inner.html">Android App</a> </li> -->
<!-- 							<li><a href="service-inner.html">Cross App</a> </li> -->
<!-- 							<li><a href="service-inner.html">Windows App</a> </li> -->
<!-- 							<li><a href="service-inner.html">Custom Application</a> </li> -->
<!-- 							<li><a href="service-inner.html">Wearable App</a> </li> -->
<!-- 						</ul> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<a href="#">Digital Marketing</a> -->
<!-- 						<ul> -->
<!-- 							<li><a href="service-inner.html">Digital Marketing Service</a> </li> -->
<!-- 							<li><a href="service-inner.html">Social Media Marketing</a> </li> -->
<!-- 							<li><a href="service-inner.html">Pay per Click</a> </li> -->
<!-- 							<li><a href="service-inner.html">Content Writing</a> </li> -->
<!-- 							<li><a href="service-inner.html">Email Marketing</a> </li> -->
<!-- 						</ul> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<a href="#">Graphic Design</a> -->
<!-- 						<ul> -->
<!-- 							<li><a href="service-inner.html">Graphic Design Service </a> </li> -->
<!-- 							<li><a href="service-inner.html">Brochure</a> </li> -->
<!-- 							<li><a href="service-inner.html">Print & Packaging</a> </li> -->
<!-- 							<li><a href="service-inner.html">Logo Design</a> </li> -->
<!-- 							<li><a href="service-inner.html">Branding</a> </li> -->
<!-- 						</ul> -->
<!-- 					</li> -->
<!-- 				</ul> -->
				</li>
				 
				<li><a href="portfolio.html">Portfolio</a> </li>
				<li><a href="contact.html">Contact</a> </li>
				</ul>
				<ul class="bottom-nav">
				<li class="prb">
				<a href="tel:+11111111111">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 384">
					<path d="M353.188,252.052c-23.51,0-46.594-3.677-68.469-10.906c-10.719-3.656-23.896-0.302-30.438,6.417l-43.177,32.594
						c-50.073-26.729-80.917-57.563-107.281-107.26l31.635-42.052c8.219-8.208,11.167-20.198,7.635-31.448
						c-7.26-21.99-10.948-45.063-10.948-68.583C132.146,13.823,118.323,0,101.333,0H30.813C13.823,0,0,13.823,0,30.813
						C0,225.563,158.438,384,353.188,384c16.99,0,30.813-13.823,30.813-30.813v-70.323C384,265.875,370.177,252.052,353.188,252.052z"
						/>
					</svg>
				</a>
				</li>
				<li class="prb">
				<a href="mailto:somewebmedia@gmail.com">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M20 4H4c-1.1 0-1.99.9-1.99 2L2 18c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2zm0 4l-8 5-8-5V6l8 5 8-5v2z"/><path d="M0 0h24v24H0z" fill="none"/></svg>
				</a>
				</li>
				<li class="prb">
				<a href="skype:niwax.company?call">
					<svg enable-background="new 0 0 24 24" height="18" viewBox="0 0 24 24" width="18" xmlns="http://www.w3.org/2000/svg"><path d="m23.309 14.547c1.738-7.81-5.104-14.905-13.139-13.543-4.362-2.707-10.17.352-10.17 5.542 0 1.207.333 2.337.912 3.311-1.615 7.828 5.283 14.821 13.311 13.366 5.675 3.001 11.946-2.984 9.086-8.676zm-7.638 4.71c-2.108.867-5.577.872-7.676-.227-2.993-1.596-3.525-5.189-.943-5.189 1.946 0 1.33 2.269 3.295 3.194.902.417 2.841.46 3.968-.3 1.113-.745 1.011-1.917.406-2.477-1.603-1.48-6.19-.892-8.287-3.483-.911-1.124-1.083-3.107.037-4.545 1.952-2.512 7.68-2.665 10.143-.768 2.274 1.76 1.66 4.096-.175 4.096-2.207 0-1.047-2.888-4.61-2.888-2.583 0-3.599 1.837-1.78 2.731 2.466 1.225 8.75.816 8.75 5.603-.005 1.992-1.226 3.477-3.128 4.253z"/></svg>
				</a>
				</li>
				</ul>
				</nav>
				<!--Mobile contact-->
				<div id="menu-contact" class="res-menu p-0 modal fade" role="dialog">
				<div class="modal-dialog" role="document">
				<div class="modal-content full">
				<div class="menu modal-body">
					<div class="contact-info-">
						<div class="contct-heading">Niwax Contacts <button type="button" class="close" data-dismiss="modal">&times;</button></div>
						<div class="inquiry-card-nn hrbg">
							<div class="title-inq-c">FOR HR DEPARTMENT</div>
							<ul><li class="mb0"><img src="<%=request.getContextPath()%>/resources/frontend/images/flags/us.svg" alt="us office" class="flags-size"> <a href="tel:1111111111" >+1-123-456-7890</a></li></ul>
						</div>
						<div class="inquiry-card-nn">
							<div class="title-inq-c">FOR SALES DEPARTMENT</div>
							<ul><li><a href="tel:1111111111"><img src="<%=request.getContextPath()%>/resources/frontend/images/flags/us.svg" alt="us office" class="flags-size"> +1-123-456-7890</a></li>
							<li><a href="tel:1111111111"><img src="<%=request.getContextPath()%>/resources/frontend/images/flags/au.svg" alt="australia office" class="flags-size"> +1-123-456-7890</a></li>
							<li><a href="tel:1111111111"><img src="<%=request.getContextPath()%>/resources/frontend/images/flags/it.svg" alt="italy office" class="flags-size"> +91-123-456-7890</a></li>
							<li><i class="fab fa-skype"></i><a href="skype:niwax.company?call" >niwax.company</a></li>
							<li><i class="fas fa-envelope"></i><a href="mailto:info@businessname.com" >info@businessname.com</a></li></ul>
						</div>
					</div>
				</div>
				</div>
				</div>
				</div>
			</div>
		</header>