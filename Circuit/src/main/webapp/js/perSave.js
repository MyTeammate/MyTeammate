var hasSaved = false;// 是否有输进的内容未保存标志，初始值为false
function CheckUnsave() {
	//alert(sss)
	if (hasSaved == false) {
		var age = document.getElementById("age").value;
		var phones = document.getElementById("phones").value;
		var email = document.getElementById("emails").value;
		if (age != "" || phones != "" || email != "") {
			alert("您上传的东西尚未保存，请保存后再离开页面,否则会造成服务器上很多垃圾文件...");
			return false;
		}
	}
	ChangeState();
}
// 保存了则改变状态
function ChangeState() {
	hasSaved = true;
}