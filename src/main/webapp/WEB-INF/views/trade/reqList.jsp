<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
   <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style>
* {
	box-sizing: border-box
}

.ModalTrade {
	width: 700px;
	height: 500px;
	border: 1px solid #c1c1c1;
	border-radius: 5px;
	overflow:auto;
}

.partHead {
	float: left;
	width: 100%;
	height: 8%;
	background-color: #99D8E1;
	color: #403e3e;
}

.partRow {
	width: 100%;
	height: 8%;
	border-bottom: 1px solid #c1c1c1;
}

.partNo {
	width: 10%;
	height: 100%;
	float: left;
	text-align: center;
	font-size: small;
	padding: 5px 0;
}

.partBuy {
	width: 15%;
	height: 100%;
	float: left;
	text-align: center;
	font-size: small;
	padding: 5px 0;
}

.partSell {
	width: 15%;
	height: 100%;
	float: left;
	text-align: center;
	font-size: small;
	padding: 5px 0;
}

.partGood {
	width: 25%;
	height: 100%;
	float: left;
	text-align: center;
	font-size: small;
	padding: 5px 0;
}

.partPrice {
	width: 12%;
	height: 100%;
	float: left;
	text-align: center;
	font-size: small;
	padding: 5px 0;
}

.partBtn {
	width: 11%;
	height: 100%;
	float: left;
	text-align: center;
	font-size: small;
	padding: 5px 0;
}

.partRow button {
	width: 70px;
	height: 25px;
	border-style: none;
	border-radius: 5px;
	background-color: #99D8E1;
	margin: -4px 0;
	font-size: small;
	color: #403e3e;
}
#close{
	width: 70px;
	height: 25px;
	border-style: none;
	border-radius: 5px;
	background-color: #99D8E1;
	margin-top: 5px;
	font-size: small;
	color: #403e3e;
}
#tab1,#tab2{
	float:left;
	heigth:100px; 
	width:100px;	
	height: 25px;
	border-style: none;
	background-color: #99D8E1;
	font-size: small;
	color: #403e3e;
	text-align:center;
	}
#tab2{
	background-color: #79D8E1;
}
#tab1:hover{
	cursor:pointer;
	background-color: #90D8E1;
}
#tab2:hover{
	cursor:pointer;
	background-color: #90D8E1;
}
#tabSection2{
	display:none;
}
</style>
</head>
<body>
<div class=ModalTrade>
	<div id=tabs>
	<div id=tab2>팝니다</div>
	<div id=tab1>삽니다</div>	
	</div>
	<div id=tabSections>
		<div id=tabSection1> 
			<div class=partHead>
				<div class=partNo>No</div>
				<div class=partBuy>구매자</div>
				<div class=partSell>판매자</div>
				<div class=partGood>물품</div>
				<div class=partPrice>가격</div>
				<div class=partBtn>바로가기</div>
				<div class=partBtn>취소</div>
			</div>

			<c:forEach var="i" items="${list }">
				<div class="partRow">
					<div class=partNo>${i.seq }</div>
					<div class=partBuy>${i.buyer }</div>
					<div class=partSell>${i.seller }</div>
					<div class=partGood>${i.title}</div>
					<div class=partPrice>${i.price }P</div>
					<div class="partBtn">
						<input type=hidden id=seq name=seq value=${i.goodSeq }>
						<input type=hidden id=title name=title value=${i.title }>
						<input type=hidden id=goodPrice name=goodPrice value=${i.price }>
						<input type=hidden id=goodWriter name=goodWriter value=${i.seller }>
						<input type=hidden id=cf name=cf value=${i.seller_cfm}>
						<button type=button id=link name=link>확인</button>
					</div>
					<div class="partBtn">
						<button type=button id=cancel name=cancel>취소</button>
					</div>	
				</div>
			</c:forEach>
		</div>
		<div id=tabSection2>
			<div class=partHead>
				<div class=partNo>No</div>
				<div class=partBuy>구매자</div>
				<div class=partSell>판매자</div>
				<div class=partGood>물품</div>
				<div class=partPrice>가격</div>
				<div class=partBtn>바로가기</div>
				<div class=partBtn>취소</div>
			</div>

			<c:forEach var="i" items="${list2}">
				<div class="partRow">
					<div class=partNo>${i.seq}</div>
					<div class=partBuy>${i.goodWriter}</div>
					<div class=partSell>${i.buyer}</div>
					<div class=partGood>${i.goodName}</div>
					<div class=partPrice>${i.price}</div>
					<div class="partBtn">
						<input type=hidden id=goodSeq name=goodSeq value=${i.goodSeq}>
						<input type=hidden id=seq name=seq value=${i.seq}>
						<input type=hidden id=cf name=cf value=${i.cf }>
						<input type=hidden id=buyer name=buyer value=${i.buyer}>
						<button type=button id=link2 name=link2>확인</button>
					</div>
					<div class="partBtn">
						<button type=button id=cancel2 name=cancel2>취소</button>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
	<button type=button id=close name=close>닫기</button>
</body>
<script>

$("#tab1").on("click",function(){
	$("#tab1").css("background-color", "#79D8E1");
	$("#tab2").css("background-color", "#99D8E1");
	$("#tabSection1").hide();
	$("#tabSection2").show();
})
$("#tab2").on("click",function(){
	$("#tab1").css("background-color", "#99D8E1");
	$("#tab2").css("background-color", "#79D8E1");
	$("#tabSection1").show();
	$("#tabSection2").hide();
})
$("#link2").on("click",function(){
	let goodSeq = $("#goodSeq").val(); 	//상품번호
	location.href="/trade/buyer.pg?seq="+goodSeq;
})
$("#link").on("click",function(){
	let seq = $("#seq").val(); 	//저는 상품번호인데 title로 하셔서 buyer페이지로 이동하셔야할거같습니다.
	location.href = "/trade/buyer.pg?seq="+seq+"&title="+title.value+"&goodPrice="+goodPrice.value+"&goodWriter="+goodWriter.value;
})
document.getElementById("close").onclick = function() {
	location.href = "/";
}
$("#cancel").on("click",function(){
	let cf =$("#cf").val();
	if(cf == 'Y'){
		alert("거래가 진행중이므로 판매자와 상의 후 취소가 가능합니다.");
	}else{
		let seq = $("#seq").val(); 
		location.href="/trade/buyer_cfmDelete.pg?seq="+seq
	}	
})
$("#cancel2").on("click",function(){
	if(confirm("거래를 취소하시겠습니까?\n임의로 취소한 경우 불이익이 있을 수 도 있습니다.")){
		let seq = $("#goodSeq").val();
		let buyer =$("#buyer").val();
		location.href="cancelReq_trade.pg?seq="+seq+"&buyer="+buyer;
	}else{
		let goodSeq = $("#goodSeq").val(); 	//상품번호
		location.href="/trade/buyer.pg?seq="+goodSeq;
	}
})
</script>
</html>