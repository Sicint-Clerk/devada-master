<jsp:include page="header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
				<div class="container h-100">
					<div class="row h-100 justify-content-center align-items-center">
						<div class="col-sm-5">
							<h3>Upload Adv.</h3>
							<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
								<div class="form-group">
									<label class="control-label" for="uploadfile">Upload File:</label>
									<input type="file" class="form-control" id="uploadfile" placeholder="Upload File"  name="files"></input>
								</div>
								
								<div class="flex_div">
										<div class="flex_name">
											<span class="guj">Ads Description</span>
											<span class="eng"></span>
										</div>
										<div class="flex_text">
											<textarea class="input" rows="3" name="description" cols="58" id="adDesc"></textarea>
										</div>
									</div>
								
																
						        <button type="submit" class="btn btn-default" id="btnSubmit">Upload</button>
						        
							</form>
							<hr/>
							<div id="listFiles">
							
								<img id="img1" />
								
									
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="container-fluid">
				<div class="container h-100">
					<div class="row h-100 justify-content-center align-items-center">
						<div class="col-sm-5">
							<table>
					  			<c:forEach items="${dbFileList}" var="row" varStatus="rowCounter">
				      				<tr>
					    				<td><img src="data:image/jpeg;base64,${row.imageInStr}" height="383" width="383"/> <br> <b>Ad. Desc.:</b> ${row.adDesc}</td>
					    				<%-- <td>${row.adDesc}</td> --%>
			   						</tr>
			   						<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
				  				</c:forEach >
							</table>
						</div>
					</div>
				</div>
			</div>			
			
			<!-- /.container-fluid -->

<jsp:include page="footer.jsp"></jsp:include>