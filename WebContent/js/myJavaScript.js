function LoginFormCheck() {
	if (frm.id.value == "") {
		alert("아이디를 입력해주세요.")
		frm.id.focus();
		return false;
	}

	if (frm.pw.value == "") {
		alert("패스워드를 입력해주세요.")
		frm.pw.focus();
		return false;
	}

	return true;

}
function memberFormCheck() {
	if (frm.id.value == "") {
		alert("사용할 아이디를 입력해주세요.");
		frm.id.focus();
		return false;
	}
	if (frm.idch.value == "unCheck") {
		alert("아이디 중복체크를 해주세요.");
		return false;
	}
	if (frm.pw.value == "") {
		alert("사용할 패스워드를 입력해주세요.");
		frm.pw.focus();
		return false;
	}
	if (frm.pwChk.value == "") {
		alert("패스워드 확인창을 입력해주세요.");
		frm.pwChk.focus();
		return false;
	}
	if (frm.pw.value != frm.pwChk.value) {
		alert("패스워드가 일치하지 않습니다. 다시 확인해 주세요.");
		frm.pwChk.focus();
		return false;
	}
	if (frm.tel.value == "") {
		alert("연락처를 입력해주세요.")
		frm.tel.focus();
		return false;
	}
	return true;
}

function idCheck(id) {
	var id = frm.id.value;
	if (id == "") {
		alert("아이디를 입력해주세요.");
		frm.id.focus();
	} else {
		window.open("idCheck.do?id=" + id, "", "width=500, height=400, left=50");
	}
}
function noticeFormCheck(){
	if (frm.title.value == "") {
		alert("제목을 입력해주세요.");
		frm.title.focus();
		return false;
	}
	if (frm.contents.value == "") {
		alert("내용을 입력해주세요.");
		frm.contents.focus();
		return false;
	}
	return true;
}

function transId(n){
	frm.action="noticeView.do";
	frm.id.value=n;
	frm.submit();
}
