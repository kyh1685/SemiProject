<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Home</title>
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
section .title{
	font-size: 25px;
	text-align: center;
	margin-top: 30px;
}
table{
	width: 1100px;
	margin: auto;
	border-collapse: collapse;
}
table tr td:nth-child(1){
	text-align: center;
}
table tr td{
	padding: 10px;
	border-bottom: 1px solid #99d8e2;
}
table input[type=text]{
	width: 1000px;
	height: 50px;
}
table textarea{
	width: 1000px;
	height: 500px;
}
table input[type=button],
table input[type=submit]{
	width: 100px;
	height: 50px;
	background: #99d8e2;
	color: #ffffff;
	border-style: none;
	border-radius: 4px;
	font-size: 16px;
	margin-right: 4px;
	cursor: pointer;
}
table input[type=button]:hover,
table input[type=submit]:hover{
	background: #68a6b0;
}
/* FOOTER */

</style>
<body>
    <div class="topNav">
		<a href="/"><img src="/files/logo.png" class="logo" /></a>
		<a href="/">메인페이지</a>
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
     <section>
     	<div class="title">글쓰기</div>
     	<form action="/client/writefocus.center?cpage=1" method=post>
			<table>
            	<tr>
            		<td>작성자</td>
            		<td>
            			${id}
            			<input type="hidden" name=writer value="${id}">
       				</td>
            	</tr>
            	<tr>
            		<td>제목</td>
            		<td><input type="text" name="title"></td>
            	</tr>
            	<tr>
            		<td>내용</td>
            		<td><textarea class="tarea" name="contents"></textarea></td>
            	</tr>
            	<tr>
            		<td colspan="2">
            			<input type="submit" value="글쓰기" id="btnWrite">
                		<input type="button" value="취소" id="btnCancel">
                		<input type="hidden" name="answer" >
                	</td>
                </tr>
			</table>
     	</form>
	 </section>
         <!-- FOOTER -->
     <footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
     </footer>
	<script>
    document.getElementById("cancel").onclick=function(){
        location.href="/client/clientCenter.center";
    }
    </script>
</body>
</html>