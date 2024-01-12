function frmDeleteCheck() {	
	
	let BOOKNAME = document.querySelector("input[name=bookName]");
	
	if( BOOKNAME.value == "" ) {
		alert("도서를 삭제 하면 복구가 불가 합니다.");
		BOOKNAME.focus();
		return false;
	}
}