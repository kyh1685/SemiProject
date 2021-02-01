<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MypageHeader</title>
<style>
/*font-family*/
@font-face {
	font-family: 'GmarketSansBold';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: 'GmarketSansMedium';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: 'GmarketSansLight';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansLight.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	box-sizing: border-box;
	font-family: 'GmarketSansMedium';
	margin: 0;
	padding: 0;
}

a {
	text-decoration-style: none;
}

li {
	list-style: none;
}

ul {
	display: flex;
	justify-content: space-around;
	padding: 10px 0;
}

header {
	
}

.headTap {
	height: 25px;
}

.hAll{
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 10px;
}

header .logo {
	width: 100px;
	height: 30px;
}

header .headMenu {
	width: 200px;
	height: 25px;
	position: absolute;
	right: 50px;
}

.headMsg {
	width: 45%;
	height: 100%;
	text-align: center;
	float: left;
}

.headMypage {
	width: 45%;
	height: 100%;
	text-align: center;
	float: left;
}

header .menuImgBox {
	width: 10%;
	height: 100%;
	float: left;
}

.menuImgBox .unfold {
	height: 100%;
}

header .btn {
	width: 100px;
	height: 30px;
	border-style: none;
	border-radius: 5px;
	background-color: #ffffff;
	color: #626262;
	margin: 0 4px;
	font-weight: 700;
}

header .hederTitle {
	width: 100%;
	height: 350px;
	top: -30px;
	background-image: url("/files/header.png");
	background-repeat: no-repeat;
	background-size: cover;
	padding: 50px;
	text-align: center;
}

header .hederTitle .titles {
	margin-top: 110px;
	color: grey;
}

header .hederTitle .titles .mainTitle {
	font-size: 50px;
	font-family: 'GmarketSansBold';
}

header .hederTitle .titles .subTitle {
	font-size: 17px;
	font-family: 'GmarketSansMedium';
}

.subMenu {
	position: relative;
	top: 22px;
	right: 90px;
	height: 200px;
	width: 120px;
	background-color: rgba(255, 255, 255, 0.49);
	display: none;
}

.pop {
	position: relative;
	top: 1px;
	right: 150px;
	max-height: 180px;
	width: 360px;
	background-color: #edf8fc;
	display: none;
}

.popHead {
	height: 40px;
}

.customMsg, .tradeAlarm, .systemAlarm {
	float: left;
	width: 118px;
	max-height: 100%;
	line-height: 40px;
} /*border*/
.popBody {
	max-height: 140px;
}

.tabContents {
	max-height: 140px;
}

.tabSection {
	max-height: 110px;
	background-color: #bee9f7;
	overflow: auto;
}

.tabArticle {
	max-height: 30px;
	line-height: 30px;
}

.customMsg {
	background-color: #bee9f7;
}

#tab2, #tab3 {
	display: none;
}

.innerTab {
	height: 70px;
}

.systemMsgD {
	height: 25px;
	line-height: 25px;
	text-align: left;
}

.systemMsgT {
	height: 45px;
	line-height: 45px;
}

.menuImg, .headUnfold {
	float: left;
}

.menuImg {
	width: 60%;
	margin: auto;
}

.subList {
	height: 40px;
	text-align: center;
	line-height: 40px;
	font-size: 12px;
}
</style>
</head>
<body>
	<div class=hAll>
		<div class="logo">
			<a href="/"><img src="/files/logo.png" class="logo" /></a>
		</div>
		<div class=headTap>
			<div class=headMenu>
				<div class=headMsg>
					<a href="/mypage/messages.mp?page=1">메시지</a>
					<div class=pop>
						<div class=popHead>
							<div class=customMsg>
								<a>문의 메시지</a>
							</div>
							<div class=tradeAlarm>
								<a>거래 알림</a>
							</div>
							<div class=systemAlarm>
								<a>시스템 알림</a>
							</div>
						</div>
						<div class=popBody>
							<div id=tab1 class=tabContents>
								<div class=tabSection id=tabSection1></div>
								<div class=tabArticle>
									<a href="/client/clientCenter.center?cpage=1"">모두 보기</a>
								</div>
							</div>
							<div id=tab2 class=tabContents>
								<div class=tabSection id=tabSection2>아직 개발중인 컨텐츠입니다 다음에 이용해주세요</div>
								<div class=tabArticle>...</div>
							</div>
							<div id=tab3 class=tabContents>
								<div class=tabSection id=tabSection3></div>
								<div class=tabArticle>
									<a id=readAll>모두 읽음 처리</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class=headMypage>
					<a href="/mypage/myPageCheck.mp">마이페이지</a>
				</div>
				<div class=menuImgBox>
					<div class=headUnfold>▽</div>
					<div class=subMenu>
						<div class=subList>
							<a href="/mypage/myUpdateCheck.mp">프로필 관리</a>
						</div>
						<div class=subList>
							<a href="/mypage/salesList.mp?page=1">거래 서비스</a>
						</div>
						<div class=subList>
							<a href="/mypage/basket.mp?page=1">찜한 서비스</a>
						</div>
						<div class=subList>
							<a href="/mypage/myPageCheck.mp">계정 설정</a>
						</div>
						<div class=subList>
							<a href="/members/logout.mem">로그아웃</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="hederTitle">
		<div class="titles">
			<div class="subTitle">당신의 재능을 거래해보세요</div>
			<div class="mainTitle">
				<a href="/">재능판매 장터</a>
			</div>
		</div>
	</div>
	<div class=inputArea></div>
</body>
<script>
	$.ajax({
		url : "/mypage/customCount.mp",
		type : "post",
		data : {},
		datatype : "json"
		}).done(function(resp) {
			if (resp == '0') {
				$("#tabSection1").html("도착한 답변이 없습니다.");}
			else {$("#tabSection1").html(resp+ "개의 답변이 도착했습니다.");
			}
		})
		
	$.ajax({
            url:"/mypage/ajaxMessages.mp",
            type : "post",
            data : {},
            datatype : "json"
        }).done(function(resp){
            let obj = JSON.parse(resp);
            if(obj.length > 0){
                for(let i=0; i<obj.length; i++){
                    let div = $("<div class=innerTab>");
                    let date = $("<div class=systemMsgD>"+ obj[i].write_date+"</div>");
                    let title =$("<div class=systemMsgT><a href='/mypage/viewMsg.mp?receiver=${id}&seq="+obj[i].seq+"'>"+obj[i].title+"</a></div>");
                    div.append(date);
                    div.append(title);
                    if(obj[i].read=="N"){
                        let hidden = $("<input type=hidden class=readN value=N>");
                        div.append(hidden);
                    }else{
                        let hidden = $("<input type=hidden class=readY value=Y>");
                        div.append(hidden);
                    }
                    $("#tabSection3").append(div);
                }			
            }else{
                $("#tabSection3").html("글이 없습니다.");
            }
        })	
	
	$(".headMsg").on("mouseover", function() {
		$(".pop").show();
	})
	$(".headMsg").on("mouseleave", function() {
		if ($(".pop").is(":focus")) {
			$(".pop").show();
		} else {
			$(".pop").hide();
		}
	})
	$(".customMsg").on("click", function() {
		$("#tab1").show();
		$("#tab2").hide();
		$("#tab3").hide();
		$(".systemAlarm").css("background-color", "#edf8fc");
		$(".tradeAlarm").css("background-color", "#edf8fc");
		$(this).css("background-color", "#bee9f7");
		$(".tabSection").css("background-color", "#bee9f7");
		$.ajax({
			url : "/mypage/customCount.mp",
			type : "post",
			data : {},
			datatype : "json"
			}).done(function(resp) {
				if (resp == '0') {
					$("#tabSection1").html("도착한 답변이 없습니다.");}
				else {$("#tabSection1").html(resp+ "개의 답변이 도착했습니다.");
				}
			})
	})
	$(".tradeAlarm").on("click", function() {
		$("#tab1").hide();
		$("#tab2").show();
		$("#tab3").hide();
		$(".systemAlarm").css("background-color", "#edf8fc");
		$(".customMsg").css("background-color", "#edf8fc");
		$(this).css("background-color", "#bee9f7");
		$(".tabSection").css("background-color", "#bee9f7");	
	})
	$(".systemAlarm").on("click", function() {
		$("#tab1").hide();
		$("#tab2").hide();
		$("#tab3").show();
		$(".tradeAlarm").css("background-color", "#edf8fc");
		$(".customMsg").css("background-color", "#edf8fc");
		$(this).css("background-color", "#bee9f7");
		if ($(".readN").val() == "N") {
			$(".readN").parent().css("background-color", "skyblue");
		}
		if ($(".readY").val() == "Y") {
			$(".readY").parent().css("background-color", "#bee9f7");
		}
		
	})
	$(".menuImgBox").on("mouseover", function() {
		$(".headUnfold").html("△");
		$(".subMenu").show();
	})
	$(".menuImgBox").on("mouseleave", function() {
		if ($(".subMenu").is(":focus")) {
			$(".subMenu").show();
		} else {
			$(".headUnfold").html("▽");
			$(".subMenu").hide();
		}
	})
	$("#readAll").on("click", function() {
		$.ajax({
			url : "/mypage/readAll.mp",
			type : "post",
			data : {
				receiver : $(".id").html()
			},
			datatype : "json"
		}).done(function(resp) {
			if (resp) {
				$(".innerTab").css("background-color", "#bee9f7");
			}
		})
	})
	</script>
</html>