<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  ResourceBundle resource = ResourceBundle.getBundle("messages");%>
	
<jsp:include page="../header.jsp"></jsp:include>

	
				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<form method="POST" action="/admin/uploadExcelFile"
							enctype="multipart/form-data">
							<i class="fas fa-table"></i><%=resource.getString("information")%>
							| <i class="fas fa-fw fa-table"></i> <span> <a
								href="downloadSample">Download Sample Template</a></span> | <i
								class="fas fa-table"></i> Upload Data <input type="file"
								name="file" /> <input type="submit" value="Submit" />
						</form>
					</div>
					<div class="card-body">
						<div class="table-responsive" style="padding: 10px;">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th><%=resource.getString("mainPersonName")%></th>
										<th width="100"><%=resource.getString("mobileNo")%></th>
										<th width="80"><%=resource.getString("vas")%></th>
										<th width="130">Action</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th><%=resource.getString("mainPersonName")%></th>
										<th width="100"><%=resource.getString("mobileNo")%></th>
										<th><%=resource.getString("vas")%></th>
										<th>Action</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="personInfo" items="${personInformations}" varStatus="count">
										<c:if test="${personInfo.role ne 'admin'}">
										<tr>
											<td>${personInfo.name}</td>
											<td>${personInfo.mobile}</td>
											<td>${personInfo.vas}</td>
											<td>
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
											</td>
										</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

<jsp:include page="../footer.jsp"></jsp:include>
			