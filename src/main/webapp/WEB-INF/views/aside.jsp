<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Basket</title>

<style>
.mypage {
	height: 50px;
	font-size: 20px;
	text-align: center;
	line-height: 50px;
}

.menuArea .menu {
	padding: 0 50px;
}

.id {
	height: 50px;
	text-align: center;
}

.hide {
	display: none;
	margin: 10px;
	background-color: rgba(255, 255, 255, 0.49);
	border-radius: 5px;
}

.sub {
	height: 30px;
	line-height: 30px;
	padding-left: 20px;
}

.menu {
	margin: 10px;
}

.listbox {
	height: 25px;
}

.list {
	width: 80%;
	float: left;
}

.unfold {
	width: 20%;
	float: right;
}
</style>
</head>
<body>
		<div class=id>${id}</div>
		<!--세션 ID?NickName?-->
		<div class=mypage>
			<b>마이페이지</b>
		</div>
		<div class="menuArea">
			<div class=menu>
				<a href="/mypage/messages.mp?page=1">쪽지함</a>
			</div>
			<div class=menu>
				<a href="/mypage/basket.mp?page=1">찜 목록</a>
			</div>
			<div class=menu>
				<div class=listbox>
					<div class=list>
						<a href="/mypage/myBuy.mp?page=1">내 작성글 보기</a>
					</div>
					<div class=unfold>▽</div>
				</div>
				<div class=myHide>
					<div class=sub>
						<a href="/mypage/myBuy.mp?page=1">삽니다</a>
					</div>
					<div class=sub>
						<a href="/mypage/mySell.mp?page=1">팝니다</a>
					</div>
				</div>
			</div>
			<div class=menu>
				<a href="/mypage/salesList.mp?page=1">판매 내역</a>
			</div>
			<div class=menu>
				<a href="/mypage/purchaseList.mp?page=1">구매 내역</a>
			</div>
			<div class=menu>
				<div class=listbox>
					<div class=list>
						<a href="/mypage/endList_Clear.mp?page=1">종료 내역</a>
					</div>
					<div class=unfold>▽</div>
				</div>
				<div class=endHide>
					<div class=sub>
						<a href="/mypage/endList_Clear.mp?page=1">거래 완료</a>
					</div>
					<div class=sub>
						<a href="/mypage/endList_Pay.mp?page=1">결제 내역</a>
					</div>
				</div>
			</div>
			<div class=menu>
				<a href="/mypage/cancelList.mp?page=1">취소 내역</a>
			</div>
			<div class=menu>
				<div class=listbox>
					<div class=list>
						<a href="/members/insert.pg">마일리지</a>
					</div>
					<div class=unfold>▽</div>
				</div>
				<div class=hide>
					<div class=sub>
						<a href="/members/insert.pg">충전</a>
					</div>
					<div class=sub>
						<a href="/mypage/notYet.mp">출금</a>
					</div>
				</div>
			</div>
			<div class=menu>
				<div class=listbox>
					<div class=list>
						<a href="/mypage/myPageCheck.mp">내 정보</a>
					</div>
					<div class=unfold>▽</div>
				</div>
				<div class=userHide>
					<div class=sub>
						<a href="/mypage/myPageCheck.mp">내 정보 보기</a>
					</div>
					<div class=sub>
						<a href="/mypage/myUpdateCheck.mp">회원 정보 수정</a>
					</div>
					<div class=sub>
						<a href="/mypage/myDelCheck.mp">회원 탈퇴</a>
					</div>
				</div>
			</div>
		</div>
</body>

<script>
if($(".userHide").is(":visible")){
	$(".userHide").prev().children().next().html("△")
}
if($(".myHide").is(":visible")){
	$(".myHide").prev().children().next().html("△")
}
if($(".endHide").is(":visible")){
	$(".endHide").prev().children().next().html("△")
}

	$(".unfold").on("click", function() {
		/* $(this).next("ul").toggleClass("hide"); */
		var submenu = $(this).parent("div").next("div");
		if (submenu.is(":visible")) {
			$(this).html("▽");
			submenu.slideUp();
		} else {
			$(this).html("△");
			submenu.slideDown();
		}
	})

</script>
</html>