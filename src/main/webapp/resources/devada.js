function savePersonInfo() {
	var data = {}
	var personInfo = {}
	var family = [];
	var isValid = true;
	
	$("#mobileValidation").hide();
	$("#usernameValidation").hide();
	$("#passwordValidation").hide();
	$("#emailValidation").hide();
	
	if(null == $("#mobile").val() || "" == $("#mobile").val().trim() ){
		$("#mobileValidation").show();
		$("#mobileValidation").focus();
		isValid = false;
	}
	if(null == $("#username").val() || "" == $("#username").val().trim() ){
		$("#usernameValidation").show();
		$("#usernameValidation").focus();
		isValid = false;
	}
	if(null == $("#password").val() || "" == $("#password").val().trim() ){
		$("#passwordValidation").show();
		$("#passwordValidation").focus();
		isValid = false;
	}
	if(null == $("#email").val() || "" == $("#email").val().trim()){
		$("#emailValidation").show();
		$("#emailValidation").focus();
		isValid = false;
	}else if(!isEmail($("#email").val().trim())){
		$("#emailValid").show();
		isValid = false;
	}
	
	if(isValid){
		personInfo["name"] = $("#name").val();
		personInfo["birthDate"] = $("#birthDate").val();
		personInfo["fatherName"] = $("#fatherName").val();
		personInfo["motherName"] = $("#motherName").val();
		personInfo["mosan"] = $("#mosan").val();
		personInfo["presentAddress"] = $("#presentAddress").val();
		personInfo["phone"] = $("#phone").val();
		personInfo["mobile"] = $("#mobile").val();
		personInfo["education"] = $("#education").val();
		personInfo["bloodGroup"] = $("#bloodGroup").val();
		personInfo["work"] = $("#work").val();
		personInfo["permanentAddress"] = $("#permanentAddress").val();
		personInfo["vas"] = $("input[name=vas]:checked").val();
		personInfo["username"] = $("#username").val();
		personInfo["password"] = $("#password").val();
		personInfo["email"] = $("#email").val();
		
	
		data["personInformation"] = personInfo;
	
		for (var i = 1; i < 9; i++) {
			var familyInfo = {}
	
			familyInfo["memberName"] = $("#memberName" + i).val();
			familyInfo["age"] = $("#age" + i).val();
			familyInfo["relation"] = $("#relation" + i).val();
			familyInfo["education"] = $("#education" + i).val();
			familyInfo["profession"] = $("#profession" + i).val();
			familyInfo["married"] = $("input[name=married" + i + "]").val();
			familyInfo["bloodGroup"] = $("#bloodGroup" + i).val();
	
			family[i] = familyInfo;
		}
		data["familyInformations"] = family;
	
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "admin/save",
			data : JSON.stringify(data),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#myModal").css("display","block");
				setTimeout(function(){
					window.location.href = "/registration";
			    },5000);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}	
}

function isEmail(email) {
	  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  return regex.test(email);
	}

function saveContact() {
	var data = {}
	data["name"] = $("#name").val();
	data["email"] = $("#email").val();
	data["message"] = $("#message").val();

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "admin/saveContact",
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			window.location.href = "/";
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function login() {
	var data = {};
	data["userName"] = $("#userName").val();
	data["password"] = $("#password").val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/admin/login",
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			if (data == "admin") {
				window.location.href = "/admin/loadList";
			} else if(data == "guser") {
				window.location.href = "/admin/loadApprovedList";
			} else {
				window.location.href = "/admin";
			}
		},
		error : function(e) {
			window.location.href = "/admin";
		},
		done : function(e) {
			
		}
	});
}

function approveInfo(id) {
	var data = {};
	data["id"] = id;
	data["isApproved"] = "Y";
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/admin/approved",
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			window.location.href = "/admin/loadList";
		},
		error : function(e) {
			window.location.href = "/admin/loadList";
		},
		done : function(e) {
		}
	});
}

function rejectInfo(id) {
	var data = {};
	data["id"] = id;
	data["isApproved"] = "N";
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/admin/approved",
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			window.location.href = "/admin/loadList";
		},
		error : function(e) {
			console.log("ERROR: ", e);
			window.location.href = "/admin/loadList";
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function getPassword(){
	var data = {};
	data["emailid"] = $("#inputEmail").val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/resetpassword",
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log(data);
			/*if (data == "admin") {
				window.location.href = "/admin/loadList";
			} else if(data == "guser") {
				window.location.href = "/admin/loadApprovedList";
			} else {
				window.location.href = "/admin";
			}*/
		},
		error : function(e) {
			window.location.href = "/admin";
		},
		done : function(e) {
		}
	});
}

function saveMarriegInfo() {
	var data = {}
	var personInfo = {}
	var marriedDaughter = [];
	var isValid = true;
	
	if(null == $("#mobile").val() || "" == $("#mobile").val().trim() ){
		$("#mobileValidation").show();
		$("#mobileValidation").focus();
		isValid = false;
	}else{
		$("#mobileValidation").hide();
		isValid = true;
	}
	
	if(isValid){
		personInfo["name"] = $("#childName").val();
		personInfo["birthDate"] = $("#birthDate").val();
		personInfo["fatherName"] = $("#fatherName").val();
		personInfo["motherName"] = $("#motherName").val();
		personInfo["mosan"] = $("#mosan").val();
		personInfo["presentAddress"] = $("#presentAddress").val();
		personInfo["phone"] = $("#phone").val();
		personInfo["mobile"] = $("#mobile").val();
		personInfo["education"] = $("#education").val();
		personInfo["bloodGroup"] = $("#bloodGroup").val();
		personInfo["work"] = $("#work").val();
		personInfo["permanentAddress"] = $("#permanentAddress").val();
		personInfo["vas"] = $("input[name=vas]:checked").val();
	
		data["marriageInformation"] = personInfo;
	
		for (var i = 0; i < 2; i++) {
			var marriedDaughterInfo = {}
			var row = i+1;
			marriedDaughterInfo["daughterName"] = $("#bahenDikariName"+row).val();
			marriedDaughterInfo["daughterFather"] = $("#bahenDikariPitaName" + row).val();
			marriedDaughterInfo["vas"] = $("input[name=vaas"+row+"]:checked").val();
			marriedDaughterInfo["laganGam"] = $("#laganGam"+row).val();
			marriedDaughterInfo["presentAddress"] = $("#presentAddress"+row).val();
			marriedDaughterInfo["mobile"] = $("#mobile"+row).val();
	
			marriedDaughter[i] = marriedDaughterInfo;
		}
		data["marriedDaughter"] = marriedDaughter;
	
		//console.log("dasdsa");
		//console.log(data);
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "admin/saveMarriege",
			data : JSON.stringify(data),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				$("#myModal").css("display","block");
				setTimeout(function(){
					window.location.href = "/marrigereg";
			    },5000);
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}	
}

function changePassword(){
	var data = {};
	var isValid = true;
	data["password"] = $("#password").val();
	data["newPassword"] = $("#newPassword").val();
	data["cnfPassword"] = $("#cnfPassword").val();
	
	if(null == $("#password").val() || "" == $("#password").val().trim() ){
		$("#passwordValidation").show();
		$("#passwordValidation").focus();
		isValid = false;
	}
	
	if(null == $("#newPassword").val() || "" == $("#newPassword").val().trim() ){
		$("#newAndCnf").show();
		$("#newAndCnf").focus();
		isValid = false;
	}else if(null == $("#cnfPassword").val() || "" == $("#cnfPassword").val().trim() ){
		$("#newAndCnf").show();
		$("#newAndCnf").focus();
		isValid = false;
	}else if($("#cnfPassword").val().trim() != $("#newPassword").val().trim() ){
		$("#newAndCnf").show();
		$("#newAndCnf").focus();
		isValid = false;
	}
	
	
	if(isValid){
	
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/changPwd",
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(data) {
				if (data == "admin") {
					window.location.href = "/admin/loadList";
				} else if(data == "guser") {
					window.location.href = "/admin/loadApprovedList";
				} else {
					window.location.href = "/admin";
				}
			},
			error : function(e) {
				window.location.href = "/admin";
			},
			done : function(e) {
				
			}
		});
	
	}
}
