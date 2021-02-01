<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<style>
/*font-family*/
@font-face {
	font-family: 'GmarketSansBold';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: 'GmarketSansMedium';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: 'GmarketSansLight';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansLight.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}
/* COMMON */
* {
	box-sizing: border-box;
	font-family: 'GmarketSansMedium';
	margin: 0px;
	padding: 0px;
}
a {
	text-decoration: none;
}

li {
	list-style: none;
}

ul {
	display: flex;
	justify-content: space-around;
	padding: 10px 0;
}
/* HEADER */
header div .logo {
	float: left;
	position: relative;
	top: 2px;
	left: 10px;
}
header .btns {
	display: flex;
	justify-content: flex-end;
	border-style: none;
	border-style: none;
}

header .btns input {
	margin: 0 4px;
}

header .btn {
	width: 100px;
	height: 30px;
	border-style: none;
	border-radius: 5px;
	background-color: #ffffff;
	color: #626262;
	margin: 0 4px;
	font-weight: 700;
}
header .hederTitle {
	width: 100%;
	height: 350px;
	top: -30px;
	background-image: url("/files/header.png");
	background-repeat: no-repeat;
	background-size: cover;
	padding: 50px;
	text-align: center;
}
header .hederTitle .titles {
	margin-top: 110px;
	color: #626262;
}
header .hederTitle .titles .mainTitle {
	font-size: 50px;
	font-family: 'GmarketSansBold';
}
header .hederTitle .titles .subTitle {
	font-size: 17px;
	font-family: 'GmarketSansMedium';
}
/* MAIN */
.container {
	width: 1200px;
	max-height: 2500px;
	margin: 70px auto;
}
.container{
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
}
.inputArea {
	margin: 50px 100px;
}
.inputArea1 {
	width: 1000px;
	height: 100px;
	padding: 15px;
}
.inputArea2 {
	width: 1000px;
	height: 400px;
	display: flex;
}

.inputArea2_1 {
	width: 50%;
	height: 100%;
	float: left;
	padding: 20px;
}
.inputArea2_2 {
	width: 50%;
	height: 100%;
	float: left;
}
.inputArea2_2_1 {
	width: 100%;
	height: 20%;
	padding: 5px;
	border-bottom: 1px solid gray;
}

.inputArea2_2_2 {
	width: 100%;
	height: 20%;
	padding: 5px;
	border-bottom: 1px solid gray;
}
.inputArea2_2_3 {
	width: 100%;
	height: 20%;
	padding: 5px;
	border-bottom: 1px solid gray;
}
.inputArea2_2_4 {
	width: 100%;
	height: 20%;
	padding: 5px;
	border-bottom: 1px solid gray;
}
.inputArea2_2_5 {
	width: 100%;
	height: 20%;
	padding: 5px;
}
.inputArea3 {
	width: 1000px;
	height: 70px;
	text-align: center;
	padding: 10px;
	border-top: 1px solid gray;
}
.btn {
	width: 200px;
	height: 50px;
	border-radius: 10px;
}
#insertBtn{
	width: 200px;
	height: 50px;
	border-style: none;
	border-radius: 10px;
	background-color: #99D8E1;
	color: #626262;
}
/* FOOTER */

</style>
</head>
<body>
	<!--HEADER-->
	<header>
		<div class=hAll>
			<div class="logo">
				<a href="/"><img src="/files/logo.png" class="logo" /></a>
			</div>
			<c:choose>
				<c:when test="${login != null }">
					<div class="btns">
						<c:if test="${checkTrade != 0}">
							<input type="button" class="btn" id="checkTrade" value="거래 요청 확인">
							<script>
							document.getElementById("checkTrade").onclick = function() {
								location.href = "/trade/sellerList.pg";
							}
						</script>
						</c:if>
						<c:if test="${allReq == 'Y' }">
						<input type="button" class="btn" id="checkReq" value="요청한 거래 확인">
							<script>
							document.getElementById("checkReq").onclick = function() {
								location.href = "/trade/buyerlist.pg";
							}
							</script>
						</c:if>			
						<input type="button" class="btn" id="logout" value="로그아웃">
						<input type="button" class="btn" id="mypage" value="마이페이지">
						<input type="button" class="btn" id="write" value="상품등록">
					</div>
					<script>
							document.getElementById("logout").onclick = function() {
								location.href = "/members/logout.mem";
							}
							document.getElementById("mypage").onclick = function() {
								location.href = "/mypage/myPageCheck.mp";
							}
							document.getElementById("write").onclick = function() {
								location.href = "/good/write.good";
							}
					</script>
				</c:when>
				<c:otherwise>
					<div class="btns">
						<input type="button" class="btn" id="login" value="로그인"> <input
							type="button" class="btn" id="signup" value="회원가입"> <input
							type="button" class="btn" id="admin" value="관리자페이지">
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="hederTitle">
			<div class="titles">
				<div class="subTitle">당신의 재능을 거래해보세요</div>
				<div class="mainTitle">
					<a href="/">재능판매 장터</a>
				</div>
			</div>
		</div>
	</header>
	<!-- MAIN -->
	<div class="container">
		<div class="inputArea2">
		<div class="inputArea2_1">
			[상품이미지/상품정보]<br>
			<img src="/files/${img }" width=450 height=320>
			
		</div>
		<div class="inputArea2_2">
			<!--<div class="inputArea2_2_1">
				memberSeq(글작성자)+goodSeq+memberSeq(구매자)+날짜 <br> 식으로 거래번호 형식 이런거
				정해야 할듯;;
			</div> -->
			<div class="inputArea2_2_2">
				[거래요청자 ID]<br>
				${buyer }
			</div>
			<div class="inputArea2_2_3">
				[거래요청자 이메일]<br>
				${email }
			</div>
			<div class="inputArea2_2_4">
				[거래요청자 전화번호]<br>
				${contact }
			</div>
			<div class="inputArea2_2_5">
				[판매 금액]<br>
				${price }원
			</div>
		</div>
	</div>
	<div class="inputArea3">
		<c:choose>
			<c:when test="${seller_cfm == 'N' }">
				<form action="/trade/seller_cfm.pg" method="get">
					<button type="submit" id="insertBtn" class="btn">거래확인</button>
				</form>
			</c:when>

			<c:when test="${seller_cfm == 'Y' }">
				<button type="submit" id="insertBtn" class="btn">거래중</button>
			</c:when>
			<c:otherwise>
					요청된 거래가 존재하지 않습니다.
				</c:otherwise>
		</c:choose>
	</div>
	</div>
	<!-- FOOTER -->
	<footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
	</footer>
</body>
</html>