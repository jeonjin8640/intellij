function frmCheck() {
	
	let custname = document.querySelector("input[name=custname]");
	
	if(custname.value == "") {
		alert("회원성명을 입력하세요.");
		custname.focus();
		return false;
	}
	
}