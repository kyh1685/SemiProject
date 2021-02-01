<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Client Center</title>
</head>
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
/* TOPNAV */
.topNav{
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 4px 10px;
}
/* HEADER */
header {
	background-image: url('/files/header.png');
	background-size: cover;
	padding: 70px;
	text-align: center;
}
header a{
	font-size: 50px;
}
/* NAV */
nav{
	height: 45px;
	background: #ccffff;
}
nav ul{
	display: flex;
	justify-content: space-around;
	align-items: center;
	height: 45px;
}
nav ul li{
	display: flex;
	justify-content: space-around;
	align-items: center;
	width: 250px;
	height: 45px;
}
nav ul li:hover{
	background: #68a6b0;
	border-radius: 4px;
}
/* SECTION */
section{
	padding-bottom: 50px;
}
table, tr, td{
	/* border: 1px solid red; */
}
section .title{
	font-size: 25px;
	text-align: center;
	margin: 30px;
}
table{
	width: 1500px;
	margin: auto;
	border-collapse: collapse;
}
table tr{
	text-align: center;
}
table tr td{
	padding: 10px;
	border-bottom: 1px solid #99d8e2;
}
</style>
<body>
    <div class="topNav">
		<a href="/"><img src="/files/logo.png" class="logo" /></a>
		<div class="link">
			<a href="/">메인페이지</a>
			<a href="/mypage/myPageCheck.mp">마이페이지</a>
		</div>
	</div>
	<!-- HEADER -->
	<header>
		<a href="/client/clientCenter.center?cpage=1">고객센터</a>
    </header>
	<!-- NAV -->
    <nav>
    	<ul>
			<li><a href="/client/clientCenter.center?cpage=1">글목록 조회</a></li>
            <li><a href="/client/write.center">글쓰기</a></li>
            <li><a href="/client/mylist.center?cpage=1">내 작성글 찾기</a></li>
        </ul>
     </nav>
     <!-- SECTION -->
     <section>
     	<div class="title">글목록 조회</div>
     	<table>
     		<tr class="head">
     			<td>번호</td>
     			<td colspan='2'>제목</td>
     			<td>작성자</td>
     			<td>답변</td>
     			<td>작성일자</td>
     		</tr>
     		<c:choose>
     			<c:when test="${list !=null }">
     			<c:forEach var="i" items="${list}" varStatus="status">
     			<tr>
            		<td>${status.count}</td>
            		<td colspan='2'><a href=/client/select.center?seq=${i.seq}>${i.title}</a></td>
            		<td>${i.writer}</td>
            		<c:choose>
            		<c:when test="${i.answer != null}">
            			<td>문의 완료</td>
            		</c:when>
            		<c:otherwise>
            			<td>문의 중</td>
            		</c:otherwise>
            		</c:choose>      				
            		<td>${i.write_date}</td>
            	</tr>
            	</c:forEach>
     			</c:when>
     			<c:otherwise>
     			<tr>
     				<td colspan="6">글이 없습니다.</td>
     			</tr>
     			</c:otherwise>
     		</c:choose>
     		<tr> <td colspan="6">${navi}</td></tr>
     	</table>
     </section>
     <!-- FOOTER -->
     <footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
     </footer>
</body>
</html>