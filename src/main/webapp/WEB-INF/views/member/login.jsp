<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
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
    *{
      	box-sizing: border-box;
      	font-family: 'GmarketSansMedium';
        margin: 0;
        padding: 0;
     }
     a{
        text-decoration: none;
     }
     /* LOGIN PAGE*/
     .container{
     	/* border: 1px solid lightgray; */
     	display: flex;
        justify-content: center;
        align-items: center;
        width: 400px;
        min-height: 100vh;
        margin: 0 auto;
		text-align: center;
        color: #303441;
      }
     .checkBox {
        display: flex;
        justify-content: left;
        align-items: center;
        margin-bottom: 25px;
      }
     .checkBox input{
        margin: 4px; 
      }
     .logo{
        width: 280px;
        margin-bottom: 30px;
      }
     .idBox input,
     .pwBox input{
        width: 400px;
        height: 45px;
        margin: 4px;
        padding: 10px;
        font-family: 'GmarketSansLight';
      }   
      .btnBox input{
        width: 400px;
        height: 45px;
        margin: 4px;
        background: #99d8e2;
        color: #ffffff;
        border-style: none;
        border-radius: 4px;
        cursor: pointer;
      }
      .btnBox input:hover{
      	background: #68a6b0;
      }
      .line{
      	border-bottom: 1px solid lightgray;
      	margin-bottom: 15px;
      	padding: 10px 0;
      	font-size: 14px;
      }
</style>
</head>
<body>
	<div class="container">
		<form action="/members/login.mem" id="loginForm" name="loginForm" method="post">
			<a href="/"><img src="/files/logo.png" class="logo" /></a>
			<div class="idBox">
				<input type="text" name="id" id="id" placeholder="아이디">
			</div>
			<div class="pwBox">
				<input type="password" name="Spw" id="pw" placeholder="비밀번호">
			</div>
			<div class="btnBox">
				<input type="submit" value="로그인">
				<input type="button" id="btnSignup" value="회원가입">
			</div>
			<div class="checkBox">
				<input type="checkbox" name="saveId" id="saveId">
				<div class="saveIdCheck">아이디 저장</div>
			</div>
			<!-- SNS 로그인 -->
			<div class="line">SNS로 더 간편하게 회원가입 해보세요!</div>
			<div id="naver_id_login" style="text-align:center">
				<a href="${url}">
					<img width="400" height="70" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/>
				</a>
			</div>
		</form>
	</div>
	<script>
	 document.getElementById("loginForm").onsubmit = function(){
	    	let frm = document.getElementById("loginForm");
	    	let id = document.getElementById("id");
	    	let pw = document.getElementById("pw");
	    	
	        if (!id.value) { //아이디를 입력하지 않으면.
	            alert("아이디를 입력 해주세요!");
	            id.focus();
	            return false;
	        }
	        if (!pw.value) { //패스워드를 입력하지 않으면.
	            alert("패스워드를 입력 해주세요!");
	            pw.focus();
	            return false;
	        }
	 
	        if (document.getElementById("saveId").checked == true) { // 아이디 저장을 체크 하였을때
	            setCookie("id",id.value, 7); //쿠키이름을 id로 아이디입력필드값을 7일동안 저장
	        } else { // 아이디 저장을 체크 하지 않았을때
	            setCookie("id",id.value, 0); //날짜를 0으로 저장하여 쿠키삭제
	        }
	        
	        return true;
	    }
	
	// 회원가입 페이지로 이동
    document.getElementById("btnSignup").onclick = function(){
    	location.href = "/members/signupViewNomal.mem"
     }
	
    window.onload = function() {
        if (getCookie("id")) { // getCookie함수로 id라는 이름의 쿠키를 불러와서 있을경우
            document.loginForm.id.value = getCookie("id"); //input 이름이 id인곳에 getCookie("id")값을 넣어줌
            document.loginForm.saveId.checked = true; // 체크는 체크됨으로
        }
    }
 
    function setCookie(name, value, expiredays) //쿠키 저장함수
    {
        var todayDate = new Date();
        todayDate.setDate(todayDate.getDate() + expiredays);
        document.cookie = name + "=" + escape(value) + "; path=/; expires="
                + todayDate.toGMTString() + ";"
    }
 
    function getCookie(Name) { // 쿠키 불러오는 함수
        var search = Name + "=";
        if (document.cookie.length > 0) { // if there are any cookies
            offset = document.cookie.indexOf(search);
            if (offset != -1) { // if cookie exists
                offset += search.length; // set index of beginning of value
                end = document.cookie.indexOf(";", offset); // set index of end of cookie value
                if (end == -1)
                    end = document.cookie.length;
                return unescape(document.cookie.substring(offset, end));
            }
        }
    }
    </script>
</body>
</html>