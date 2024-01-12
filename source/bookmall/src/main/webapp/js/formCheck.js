function frmCheck() {	
	
	let BOOKNAME = document.querySelector("input[name=bookName]");
	
	if( BOOKNAME.value == "" ) {
		alert("도서명을 입력하세요.");
		BOOKNAME.focus();
		return false;
	}
}