//个人资料修改 获取值
function perFiles() {
	var userName = $("#userName").val();
	var name = $("#name").val();
	var entryDate = $("#entryDate").val();
	var leaveDate = $("#leaveDate").val();
	var id = $("#id").val();
	var age = $("#age").val();
	var phone = $("#phones").val();
	var email = $("#emails").val();
	var sex = $('input[name="sex"]:checked').val();
	$.ajax({
		url : "updateUserPost",
		type : "post",
		data : {
			"id" : id,
			"age" : age,
			"phone" : phone,
			"email" : email,
			"sex" : sex,
			"userName" : userName,
			"name" : name,
			"entryDate" : entryDate,
			"leaveDate" : leaveDate,

		},
		success : function(result) {
			$.messager.alert({
				title : '提示',
				msg : '修改成功！',
			});
		}
	});

}

// 修改密码（弹出框）
function perPassword() {
	$("#updatePass").window('open');
}

//修改密码
function updatePwd(){
	var id = $("#id").val();
	var password = $("#pwd").val();
	var repassword = $("#repwd").val();
	
	$.ajax({
		url:"updatePassword",
		typw:"post",
		data:{
			"id":id,
			"passWord":password,
			"repassword":repassword
		},
		success : function(result) {
			$.messager.alert({
				title : '提示',
				msg : '修改成功！',
			});			
		}
		
	});
	location.href="login"
}

// 年龄的验证
function isAge() {
	var str = document.getElementById("age").value;
	var ag = /^[1-9]*$/;
	if (str != "") {
		if (str.search(ag) < 0) {
			document.getElementById('agess').innerHTML = '年龄格式错误！';
		} else {
			if (str > 110 || str < 0) {
				document.getElementById('agess').innerHTML = '年龄不能大于110小于0！';
			} else {
				document.getElementById('agess').innerHTML = '年龄正确';
			}
		}
	} else {
		document.getElementById('agess').innerHTML = '不能为空！';
	}

}

// 电话号码的验证
function isPhone() {
	var str = document.getElementById("phones").value;
	var patt = /^((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+(\d{8})$/;
	if (str != '') {
		if (str.search(patt) < 0) {
			document.getElementById('Phonenumber').innerHTML = '电话号码格式错误！';
		} else {
			document.getElementById('Phonenumber').innerHTML = '电话号码格式正确！';
		}
	} else {
		document.getElementById('Phonenumber').innerHTML = '不能为空！';
	}
}

// 邮箱的验证
function isEmail() {
	var str = document.getElementById("emails").value;
	var reg = /^[0-9a-zA-Z_]{5,12}@(163|126|qq|yahoo|gmail|sina)\.(com|com\.cn|cn|la)$/;
	if (str != '') {
		if (str.search(reg) < 0) {
			document.getElementById("emails").focus();
			document.getElementById('emailmsg').innerHTML = '邮箱错误！';
		} else {			
			document.getElementById('emailmsg').innerHTML = '邮箱正确！';			
		}
	} else {
		document.getElementById('emailmsg').innerHTML = '不能为空';
	}
}

// 判断输入旧密码
function isPas() {
	var str = $("#pwd").val();
	var pas = $("#pwdsa").val();
	if (str != pas) {
		$.messager.alert({
			title : '提示',
			msg : '密码输入有误！请重新输入！',
		});
		return false
	}
}

// 判断输入新密码
function isReps() {
	var str = document.getElementById("pwd").value;
	var ts = document.getElementById("repwd").value;
	var x=document.getElementById("repwd").value.length;	
	if(x>=6&&x<=12){
		if (str == ts) {
			$.messager.alert({
				title : '提示',
				msg : '新密码不可以与原密码一致！',
			});
			return false
		}
	}else{
		$.messager.alert({
			title : '提示',
			msg : '密码位数有误，位数为6-12位！',
		});
	}	
}
// 判断新密码与旧密码是否一致
function isRepsT() {
	var ts = $("#repwd").val();
	var re = $("#repwds").val();
	if (ts != re) {
		$.messager.alert({
			title : '提示',
			msg : '两次密码不一致！',
		});
		return false
	}
}
