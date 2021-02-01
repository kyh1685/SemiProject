<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>failedCheck</title>
</head>
<body>
		<c:choose>
			<c:when test="${Type == 'check'}">
				<script>
					alert("비밀번호가 일치하지 않습니다.");
					location.href="/mypage/myPageCheck.mp";
				</script>
			</c:when>
			<c:when test="${Type == 'update' }">
				<script>
					alert("비밀번호가 일치하지 않습니다.");
					location.href="/mypage/myUpdateCheck.mp";
				</script>
			</c:when>
			<c:otherwise>
				<script>
					alert("비밀번호가 일치하지 않습니다.");
					location.href="/mypage/myDelCheck.mp";
				</script>
			</c:otherwise>
		</c:choose>
		
		
</body>
</html>