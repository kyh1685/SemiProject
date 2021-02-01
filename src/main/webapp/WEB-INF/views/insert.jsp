<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Messages</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style>
.container {
	padding: 50px 0;
	width: 1000px;
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

.title {
	height: 10%;
	font-size: 40px;
	padding: 10px;
}

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
				<div>
					<div class=title>
						<b>충전하기</b>
					</div>
					<div class="chargingSpace">
						<div class="charging">
							<form action="/members/payment.pg" method="post">
								충전할 금액 : <input type="text" name=totalPrice required> <input
									type="submit" id="charBtn" value="충전">
							</form>
						</div>
					</div>
				</div>
			</article>
		</section>
	</div>

	<footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"/>
	</footer>
</body>

</html>