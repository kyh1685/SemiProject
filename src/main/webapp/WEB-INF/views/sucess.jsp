<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layer</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style>
.container {
	padding: 50px 0;
	width: 1200px;
	height: 1000px;
	margin: auto;
}

section {
	height: 1000px;
	border-top: 1px solid grey;
}



aside {
	float: left;
	width: 30%;
	background-color: rgba(153, 216, 225, 0.53);
}

article {
	float: left;
	width: 70%;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	cursor: pointer;
}
.endHide,.myHide,.userHide{display: none;margin: 10px;background-color: rgba(255, 255, 255, 0.49);border-radius: 5px;}

.articleAlign{
	margin:200px;
	text-align:center;
}



</style>
</head>
<body>
<!--HEADER-->
	<header>
		<jsp:include page="/WEB-INF/views/mypageHeader.jsp"></jsp:include>
	</header>
	<div class=container>
		<section>
			<aside>
				<jsp:include page="/WEB-INF/views/aside.jsp"></jsp:include>
			</aside>
			<article>
				<div class="articleAlign">
				<button id=return>마일리지 보유현황 확인하기</button>
				</div>
			</article>
		</section>
		<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
		</footer>
	</div>
</body>
<script>
		document.getElementById("return").onclick  = function(){
	   		location.href="/members/sucess1.pg";
		}
	
	</script>
</html>