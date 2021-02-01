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
	min-height: 1000px;
	border-top: 1px solid grey;
}

aside, article {
	float: left;
}

aside {
	width: 30%;
	background-color: rgba(153, 216, 225, 0.53);
}

article {
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


.chargingSpace {
	width: 800px;
	height: 500px;
	text-align: center;
	margin: 20px;
	border-top: 1px solid #c1c1c1;
}

.charging {
	width: 400px;
	height: 100px;
	position: relative;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	line-height: 100px;
	border-radius: 10px;
	background-color: rgba(153, 216, 225, 0.53);
}

#charBtn {
	width: 50px;
	height: 30px;
	margin: 5px;
	background-color: #235258;
	border-style: none;
	color: #ffffff;
}

.articleAlign {
	text-align: center;
	margin-left: 130px;
	margin-top: 20px;
}

.articleAlign div {
	margin: 20px 0;
}

</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/mypageHeader.jsp"></jsp:include>
	</header>
	<div class=container>
		<section>
			<aside>
				<jsp:include page="/WEB-INF/views/aside.jsp"></jsp:include>
			</aside>
			<article>
				<div>
					<fieldset>
						<legend> ${id}님의 마일리지 보유 현황 </legend>
						남은 잔여 마일리지 : ${mileage } (point)
					</fieldset>
				</div>
				<div>결제에 성공하셨습니다.</div>
			</article>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/views/footer.jsp" />
		</footer>
	</div>
</body>

</html>