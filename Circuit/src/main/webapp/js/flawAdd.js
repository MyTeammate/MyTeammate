function flawAdd(){
	if(!$('#name').validatebox('isValid')){
		$('#name').focus();
	}else if(!$('#state').validatebox('isValid')){
		$('#state').focus();
	}else{
		return true;
	}
	return false;
}