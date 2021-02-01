<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignupResult</title>
</head>
<body>
	<c:choose>
		<c:when test="${result>0 }">
			<script>
				alert("가입을 축하합니다!");
				location.href="/";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("가입에 실패했습니다!");
				location.href="/";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>