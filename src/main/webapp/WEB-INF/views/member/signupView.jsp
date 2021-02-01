<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style>
/* FONT */
@font-face {
	font-family: 'GmarketSansBold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
@font-face {
    font-family: 'GmarketSansLight';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansLight.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
/* COMMON */
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	font-family: 'GmarketSansMedium';
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 600px;
	min-height: 100vh;
	margin: 0 auto;
	padding: 10px;
}

.logo{
	 width: 250px;
     margin-bottom: 20px;
     text-align: center;
}

form input[type="text"], form input[type="password"] {
	width: 400px;
	height: 50px;
	margin: 4px 0px;
	padding: 10px;
	font-family: 'GmarketSansLight';
}

select, td{
	font-family: 'GmarketSansLight';
}

form input[type="button"] {
	width: 100px;
	height: 50px;
	padding: 4px;
	border-style: none;
	border-radius: 4px;
	background: #99d8e2;
    color: #ffffff;
    font-size: 16px;
}

form input[type="button"]:hover{
	background: #68a6b0;
}

table tr:nth-child(1) {
	font-size: 30px;
}

table tr:nth-child(1) th {
	font-weight: 100;
	padding: 15px 0;
}

tr:last-child {
	text-align: center;
}

tr:last-child input[type="submit"] {
	text-align: center;
	width: 505px;
	height: 50px;
	margin: 40px 0px;
	padding: 4px;
	background: #99d8e2;
    color: #ffffff;
    border-style: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 18px;
}

tr:last-child input[type="submit"]:hover{
	background: #68a6b0;
}

#email1, #email2 {
	width: 186px;
	height: 50px;
	margin: 4px 0;
	padding: 4px;
}
#authNum{
	display: none;
}
</style>
</head>
<body>
	<div class="container">
		<form action="/members/signup.mem" id="form">
			<table>
				<tr>
				<a href="/"><img src="/files/logo.png" class="logo" /></a>
				</tr>
				<tr>
					<td><input type="text" name="id" id="id"
						placeholder="아이디를 입력해주세요." Required> <input type="button"
						id="duplCk" value="중복확인">
						<div id="txt"></div></td>
				</tr>
				<c:if test="${sessionName==null }">
				<tr>
					<td>
						<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력해주세요." Required>
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" id="pwck" placeholder="비밀번호를 재입력해주세요." Required>
						<div id="pwTxt"></div>
					</td>
				</tr>
				<script>
				// 비밀번호 확인
				document.getElementById("pwck").oninput = function(){
			    let pw = document.getElementById("pw").value;
			    let pwck = document.getElementById("pwck").value;
			    let txt = document.getElementById("pwTxt");
			    
			    if(pw==pwck){
			        txt.innerHTML = "비밀번호가 일치합니다."
			        txt.style.color = 'blue';
			       }else{
			        txt.innerHTML = "비밀번호가 일치하지 않습니다."
			        txt.style.color = 'red';
			   		}
				}
				</script>
				</c:if>
				<tr>
					<td><input type="text" name="name" id="name" value="${sessionName }"
						placeholder="이름을 입력해주세요." Required></td>
				</tr>
				<tr>
					<td><input type="text" name="contact" id="contact"
						placeholder="전화번호를 입력해주세요." Required></td>
				</tr>
				<tr>
					<td>
						<input type="text" name="email1" id="email1" value="${sessionEmail }" placeholder="이메일" Required>
						 @ <select name="email2" id="email2">
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
							</select>
						<input type="button" id="btnReq" value="인증요청">
						<div id="emailTxt"></div>
						<span id="authNum"></span> 	
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" id="emailCk" placeholder="인증번호를 입력해주세요." Required>
						<input type="button" id="btnEmailCk" value="인증하기">
						<div id="emailResultTxt"></div>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>

	<script>
	// 아이디 중복 확인
	$("#duplCk").click(function(){
    	$.ajax({
        	url: "/members/idCheck.mem",
            type: "get",
            data: {id: document.getElementById("id").value},
            dataType: "json"
            }).done(function(resp){
            	if(document.getElementById("id").value.length == 0){
            		document.getElementById("txt").innerHTML = "아이디를 입력해주세요."
            	}else{
            		document.getElementById("txt").innerHTML = resp.msg
                	document.getElementById("id").value = resp.value
            	}
           })
    })
    
    // 이메일 인증번호 보내기
    $("#btnReq").click(function(){
    	$.ajax({
    		url: "/members/emailCheck.mem",
            type: "get",
            data: {email1: document.getElementById("email1").value,email2: document.getElementById("email2").value},
            dataType: "json"
            }).done(function(resp){
            	if(document.getElementById("email1").value.length == 0){
            		document.getElementById("emailTxt").innerHTML = "이메일을 입력해주세요."
            	}else{
            		document.getElementById("emailTxt").innerHTML = resp.msg
                	document.getElementById("authNum").innerHTML = resp.value
            	}
    	})
    })
    
    // 이메일 인증번호 확인
    document.getElementById("btnEmailCk").onclick = function(){
		let emailNum = document.getElementById("emailCk").value; // 사용자가 입력한 인증번호
		let authNum = document.getElementById("authNum").innerHTML // 서버가 보낸 인증번호
		if(authNum!=""){
			if(emailNum == authNum){
    			document.getElementById("emailResultTxt").innerHTML = "인증되었습니다."
    		}else{
    			document.getElementById("emailResultTxt").innerHTML = "인증번호가 일치하지 않습니다."
    		}
		}else{
			document.getElementById("emailResultTxt").innerHTML = "인증번호를 입력해주세요."
		}
		
	}
	
	// form 제출전 아이디 중복확인과 패스워드 일치 확인
    document.getElementById("form").onsubmit = function(){
    	let idMsg = document.getElementById("txt").innerHTML;
    	let pwMsg = document.getElementById("pwTxt").innerHTML;
    	let emailMsg = document.getElementById("emailTxt").innerHTML;
    	let emailCkMsg = document.getElementById("emailResultTxt").innerHTML;
    	
    	if(idMsg!="사용 가능한 아이디 입니다."){
    		alert("중복확인을 눌러주세요.");
    		return false;
    	}else if(pwMsg!="비밀번호가 일치합니다."){
    		alert("비밀번호가 일치하지 않습니다.");
    		return false;
    	}else if(emailMsg!="인증번호를 보냈습니다."){
    		alert("인증요청을 눌러주세요.");
    		return false;
    	}else if(emailCkMsg!="인증되었습니다."){
    		alert("인증번호가 일치하지 않습니다.");
    		return false;
    	}else{
    		return true;
    	}
    }
    </script>
</body>
</html>