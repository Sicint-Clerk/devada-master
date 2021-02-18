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
					<li class="breadcrumb-item active">Approved Data</li>
				</ol> 
				
				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i><%=resource.getString("information")%>
						<c:if test="${sessionScope.loginUserRole eq 'admin'}">
							| <i class="fas fa-fw fa-table"></i>
							<span> <a href="exportData">Export Data</a></span>
						</c:if>
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
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th><%=resource.getString("mainPersonName")%></th>
										<th width="100"><%=resource.getString("mobileNo")%></th>
										<th><%=resource.getString("vas")%></th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="personInfo" items="${personInformations}"
										varStatus="count">
										<c:if test="${personInfo.role ne 'admin'}">
											<tr>
												<td><a href="/admin/viewProfile/${personInfo.id}"
													target="_blank">${personInfo.name}</a></td>
												<td>${personInfo.mobile}</td>
												<td>${personInfo.vas}</td>
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
