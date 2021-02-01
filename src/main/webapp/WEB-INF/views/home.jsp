<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
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
	color: #303441;
}
		
a {
	text-decoration: none;
}

li {
	list-style: none;
}

/* HEADER */
header {
	background-image: url('/files/header.png');
	background-size: cover;
	padding: 50px;
}

.logoAndBtn{
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px;
}

.btns{
	display: flex;
	font-size: 17px;
}

.logoAndBtn .btns input {
	margin: 0 6px;
	border-style: none;
	background-color: white;
	cursor: pointer;
}

.logoAndBtn .logo{
	width: 100px;
	height: 30px;
}

header .title {
	text-align: center;
	margin-top: 70px;
}

header .title .mainTitle a{
	font-size: 50px;
	font-family: 'GmarketSansBold';
}

header .title .subTitle {
	font-size: 17px;
	font-family: 'GmarketSansMedium';
}

header .search {
	text-align: center;
	margin: 20px;
}

header .search select {
	height: 60px;
	padding-left: 20px;
	border-radius: 4px;
	border-style: none;
	font-size: 17px;
	color: gray;
}

header .search input {
	width: 500px;
	height: 60px;
	border-style: none;
	border-radius: 4px;
	padding-left: 30px;
	font-size: 17px;
}

/* NAV */
nav {
	background: #99d8e2;
	display: flex;
	justify-content: center;
	height: 50px;
}

nav ul {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 30px 0;
	background: #ffffff;
	width: 1200px;
	height: 100px;
	border-radius: 20px;
}
nav ul li{
	margin: 10px;
	font-size: 25px;
	margin-right: 100px;
}

nav ul li a,
nav ul li i{
	color: gray;
}

/* MAIN */
section {
	width: 100%;
	display: flex;
	justify-content: center;
}
table{
	border-collapse: separate;
	border-spacing: 40px;
	margin: 70px;
}

.image{
	width: 300px;
	height: 200px;
	overflow: hidden;  
	border-radius: 10px;
}
.image img{
	width: 100%;
	height: 100%;
	margin-bottom: 4px;
	object-fit:cover;     
	transform:scale(1.0);        
    transition: transform .5s; 
}
.image img:hover{
	transform:scale(1.5);
	transition: transform .5s;
}
.align div{
	margin: 7px 0;
}

table tr:last-child{
	width: 100%;
	text-align: center;
}

.cate_buy{
	background: #68a6b0;
	padding: 5px;
	border-style: none;
	border-radius: 4px;
	color: #ffffff;
}
.cate_sell{
	background: #99d8e2;
	padding: 5px;
	border-style: none;
	border-radius: 4px;
	color: #ffffff;
} 
#checkTrade,#checkReq{display:none;}
</style>
</head>
<body>
	<div class="logoAndBtn">
		<a href="/"><img src="/files/logo.png" class="logo" /></a>
		<c:choose>
			<c:when test="${login != null }">
					<div class="btns">
					
							<input type="button" id="checkTrade" value="거래 요청 확인">
						<script>
							document.getElementById("checkTrade").onclick = function() {
								location.href = "/trade/sellerList.pg";
							}
						</script>
				
						<input type="button" class="btn" id="checkReq" value="요청한 거래 확인">
							<script>
							document.getElementById("checkReq").onclick = function() {
								location.href = "/trade/buyerlist.pg";
							}
							</script>
						
							<input type="button" id="logout" value="로그아웃"> 
							<input type="button" id="mypage" value="마이페이지"> 
							<input type="button" id="write" value="상품등록">
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
					<input type="button" id="login" value="로그인"> <input
						type="button" id="signup" value="회원가입"> <input
						type="button" id="admin" value="관리자페이지">
				</div>
			</c:otherwise>
		</c:choose>

	</div>
	<!--HEADER-->
	<header>
		<div class="title">
			<div class="subTitle">당신의 재능을 거래해보세요</div>
			<div class="mainTitle">
				<a href="/">재능판매 장터</a>
			</div>
		</div>
		<div class="search">
			<select name="cateCode" id="cateCode">
				<option value="3">전체</option>
				<option value="1">삽니다</option>
				<option value="2">팝니다</option>
			</select> <input type="text" id="search" placeholder="검색어를 입력하세요">
		</div>
	</header>
	<script type="text/javascript">
	document.getElementById("search").onkeydown = function(){
		if (event.keyCode == 13){
			let goodName = document.getElementById("search").value;
			let cateCode = document.getElementById("cateCode").value;
			location.href = "/good/search.pro?goodName="+goodName+"&cateCode="+cateCode;
		}
	}
	</script>

	<!--SIDE-->
	<nav>
		<ul>
			<li><i class="fas fa-shopping-basket"></i> <a
				href="/good/category.pro?cateCode=1">삽니다</a></li>
			<li><i class="fas fa-comment-dollar"></i> <a
				href="/good/category.pro?cateCode=2">팝니다</a></li>
		</ul>
	</nav>


	<!--MAIN-->
	<section>
		<table>
			<tr>
				<c:choose>
					<c:when test="${list != null }">
						<c:forEach var="dto" items="${list }" varStatus="status">
							<c:if test="${status.index%4==0}">
								<tr></tr>
							</c:if>
							<td class="align"><a
								href="/good/view.good?goodSeq=${dto.goodSeq}&page=1 " class="image">
									<div class="image">
										<img src="/files/${dto.getGoodImg()}" />
									</div> 
									<c:choose>
										<c:when test="${dto.getCateCode() == 1}">
											<span class="cate_buy">삽니다</span>
										</c:when>
										<c:otherwise>
											<span class="cate_sell">팝니다</span>
										</c:otherwise>
									</c:choose>
									<div>${dto.getGoodName() }</div>
									<div>${dto.getGoodPrice() }원</div>
			
							</a></td>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<td class="nolist">글이 없습니다</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
                <td colspan="4">
                	${navi }
                </td>
            </tr>
		</table>
	</section>
	<!--FOOTER-->
	<footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
	</footer>

	<script>
		$(document).ready(function(){
			$.ajax({
				 url:"/members/checkTrade.mem",
                 type : "post",
                 data : {},
                 datatype : "json"
			}).done(function(resp){
				console.log(resp);
				if(resp == 0){
					$("#checkTrade").hide();
				}else{
					$("#checkTrade").show();
				}
			})
			$.ajax({
				url : "/members/checkReq.mem",
				type : "post",
				data :{},
			}).done(function(resp){
				if(resp == 'N'){
					$("#checkReq").hide();
				}else{
					$("#checkReq").show();
				}
			})
			$.ajax({
				url:"/members/blackListCheck.mem",
                type : "post",
                data : {},
                datatype : "json"
			}).done(function(resp){
				if(resp != 0){
					$("#write").hide();
				}else{
					$("#write").show();
				}
			})
		})
		document.getElementById("login").onclick = function() {
			location.href = "/members/loginPage.mem";
		}
		document.getElementById("signup").onclick = function() {
			location.href = "/members/signupViewNomal.mem";
		}
		document.getElementById("admin").onclick = function() {
			location.href = "/nex/index.html";
		}
	</script>
</body>
</html>