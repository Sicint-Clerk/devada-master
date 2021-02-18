<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  ResourceBundle resource = ResourceBundle.getBundle("messages");%>
	
<jsp:include page="../header.jsp"></jsp:include>

<div id="content-wrapper">
			<div class="container-fluid">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Marriage Data</li>
				</ol> 
				

				<!-- DataTables Example -->
				<div class="card mb-3">

					<div class="card-body">
						<div class="table-responsive" style="padding: 10px;">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th><%=resource.getString("mainPersonName")%></th>
										<th width="100"><%=resource.getString("mobileNo")%></th>
										<th width="80"><%=resource.getString("vas")%></th>
										<!-- <th width="130">Action</th> -->
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th><%=resource.getString("mainPersonName")%></th>
										<th width="100"><%=resource.getString("mobileNo")%></th>
										<th><%=resource.getString("vas")%></th>
										<!-- <th>Action</th> -->
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="personInfo" items="${personInformations}"
										varStatus="count">
										<tr>
											<td><a href="/admin/viewMarriageProfile/${personInfo.id}"
												target="_blank">${personInfo.name}</a></td>
											<td>${personInfo.mobile}</td>
											<td>${personInfo.vas}</td>
											<%-- <td>
												<div class="slds-radio_button-group">
													<c:choose>
														<c:when test="${personInfo.isApproved == 'Y'}">
															<span class="slds-button slds-radio_button"> <input
																name="appr_rej${count.index}" type="radio"
																id="Approve${count.index}" value="Y" checked /> <label
																class="slds-radio_button__label"
																for="Approve${count.index}"> <span
																	class="slds-radio_faux">Approve</span>
															</label>
															</span>
															<span class="slds-button slds-radio_button reject_span">
																<input name="appr_rej${count.index}" type="radio"
																id="reject${count.index}" value="N"
																onclick="rejectInfo(${personInfo.id})" /> <label
																class="slds-radio_button__label"
																for="reject${count.index}"> <span
																	class="slds-radio_faux">Reject</span>
															</label>
															</span>
														</c:when>
														<c:when test="${personInfo.isApproved == 'N'}">
															<span class="slds-button slds-radio_button"> <input
																name="appr_rej${count.index}" type="radio"
																id="Approve${count.index}" value="Y"
																onclick="approveInfo(${personInfo.id})" /> <label
																class="slds-radio_button__label"
																for="Approve${count.index}"> <span
																	class="slds-radio_faux">Approve</span>
															</label>
															</span>
															<span class="slds-button slds-radio_button reject_span">
																<input name="appr_rej${count.index}" type="radio"
																id="reject${count.index}" value="N" checked /> <label
																class="slds-radio_button__label"
																for="reject${count.index}"> <span
																	class="slds-radio_faux">Reject</span>
															</label>
															</span>
														</c:when>
														<c:otherwise>
															<span class="slds-button slds-radio_button"> <input
																name="appr_rej${count.index}" type="radio"
																id="Approve${count.index}" value="Y"
																onclick="approveInfo(${personInfo.id})" /> <label
																class="slds-radio_button__label"
																for="Approve${count.index}"> <span
																	class="slds-radio_faux">Approve</span>
															</label>
															</span>
															<span class="slds-button slds-radio_button reject_span">
																<input name="appr_rej${count.index}" type="radio"
																id="reject${count.index}" value="N"
																onclick="rejectInfo(${personInfo.id})" /> <label
																class="slds-radio_button__label"
																for="reject${count.index}"> <span
																	class="slds-radio_faux">Reject</span>
															</label>
															</span>
														</c:otherwise>
													</c:choose>
												</div>
											</td> --%>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

				</div>

			</div>
			<!-- /.container-fluid -->
			<jsp:include page="../footer.jsp"></jsp:include>
			<%-- <!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright Â© Your Website 2018</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Ã</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="/logout">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendor/datatables/jquery.dataTables.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/admin/vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="<%=request.getContextPath()%>/resources/admin/js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script
		src="<%=request.getContextPath()%>/resources/admin/js/demo/datatables-demo.js"></script>
	<script src="<%=request.getContextPath()%>/resources/devada.js"></script>
</body>

</html> --%>
