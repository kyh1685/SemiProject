<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>


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
	margin: 0px;
	padding: 0px;
}

a {
	text-decoration: none;
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

header input[type=button] {
	cursor: pointer;
}

header div .logo {
	float: left;
	position: relative;
	top: 2px;
	left: 10px;
}

header .btns {
	display: flex;
	justify-content: flex-end;
	border-style: none;
	border-style: none;
}

header .btns input {
	margin: 0 4px;
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
	color: #626262;
}

header .hederTitle .titles .mainTitle {
	font-size: 50px;
	font-family: 'GmarketSansBold';
}

header .hederTitle .titles .subTitle {
	font-size: 17px;
	font-family: 'GmarketSansMedium';
}

.container {
	width: 1200px;
	max-height: 2500px;
	margin: auto;
}

.inputArea {
	margin: 50px 100px;
}

.inputArea0 {
	border-top: 1px solid #c1c1c1;
}

.inputArea0_1 {
	font-weight: 700;
	color: #626262;
	font-size: large;
	padding: 5px;
	margin: 20px 10px;
	float: left;
}

.inputArea0_2 {
	float: right;
	margin: 10px;
}

#likeBtn {
	width: 50px;
	height: 50px;
	font-size: 40px;
	border-style: none;
	background-color: rgba(255, 255, 255, 0.33);
	color: #99D8E1;
}

.sub {
	font-weight: 500;
	color: #595480;
	font-size: small;
}

.inputArea1 {
	width: 100%;
	display: flex;
}

.inputArea1_1 {
	width: 55%;
	text-align: center;
}

.inputArea1_2 {
	width: 5%;
}

.inputArea1_3 {
	width: 40%;
	border: 1px solid #c1c1c1;
	padding: 10px;
}

.inputArea1_3 .Txt {
	text-align: right;
	margin: 0 0 0px;
	font-weight: 700;
	color: #626262;
	font-size: large;
}

.inputArea1_3_1 {
	height: 20%;
	padding: 5px 30px;
}

.inputArea1_3_2 {
	height: 20%;
	padding: 5px 30px;
}

.inputArea1_3_3 {
	height: 30%;
	padding: 5px 30px;
}

.inputArea1_3_4 {
	height: 30%;
	padding: 5px 30px;
}

.inputArea3 {
	width: 100%;
	margin: 10px 0;
	border-top: 1px solid #c1c1c1;
	text-align: center;
	padding: 10px 0 0 0;
}

.inputArea4 {
	width: 100%;
	padding: 10px;
	border-top: 1px solid #c1c1c1;
}

.inputArea4 .Txt {
	margin: 0 0 10px;
	font-weight: 700;
	color: #626262;
	font-size: x-large;
}

.inputArea4 .goodDes {
	margin: 0 0 10px;
	font-weight: 500;
	color: #626262;
	font-size: large;
}

.inputArea6 {
	width: 100%;
	display: flex;
	justify-content: flex-end;
}

.inputArea6 .btn {
	width: 100px;
	height: 30px;
	border-style: none;
	border-radius: 5px;
	background-color: #99D8E1;
	color: #626262;
	margin: 0 4px;
	font-weight: 700;
}

.inputArea7 {
	width: 100%;
	padding: 10px;
	border-top: 1px solid #c1c1c1;
}

.inputArea7 .Txt {
	margin: 0 0 10px;
	font-weight: 700;
	color: #626262;
	font-size: x-large;
}

.inputArea7_1 {
	display: flex;
	justify-content: center;
}

.inputArea7_1 #rContents {
	width: 1000px;
	height: 100px;
}

.inputArea7_1 #reviewBtn {
	width: 80px;
	height: 100px;
	border-style: none;
	border-radius: 5px;
	background-color: #99D8E1;
	color: #626262;
	margin: 0 4px;
	font-weight: 700;
}

.inputArea8_1 {
	max-height: 1080px;
}

#buy {
	width: 350px;
	height: 50px;
	border-style: none;
	border-radius: 10px;
	background-color: #99D8E1;
	position: relative;
	left: -15px;
	top: 10px;
	font-weight: 700;
	color: #626262;
	font-size: large;
	margin: 0 0 2px;
}

#pBuy {
	font-weight: 700;
	color: #626262;
	font-size: large;
	margin: 0 0 2px;
}

#reportModal {
	position: relative;
	z-index: 1;
	display: none;
}

.repModalArea {
	width: 400px;
	height: 400px;
	position: fixed;
	top: 20%;
	left: calc(50%);
	background: #ffffff;
	z-index: -1;
	border: 1px solid #c1c1c1;
}

.inputModalArea1 {
	width: 100%;
	height: 10%;
	text-align: center;
	padding: 10px;
}

.inputModalArea2 {
	width: 100%;
	height: 15%;
	text-align: center;
	padding: 15px;
}

.inputModalArea3 {
	width: 100%;
	height: 60%;
	text-align: center;
}

#reportTxt {
	width: 380px;
	height: 230px;
}

.inputModalArea4 {
	width: 100%;
	height: 15%;
	text-align: center;
	padding: 15px;
}

.repModBtn {
	width: 100px;
	height: 30px;
	border-style: none;
	border-radius: 5px;
	background-color: #99D8E1;
	color: #626262;
	margin: 0 4px;
	font-weight: 700;
}

.rUpdModal {
	position: relative;
	z-index: 1;
	display: none;
}

.rUpdContent {
	position: fixed;
	top: 30%;
	left: calc(15%);
	width: 700px;
	height: 200px;
	background: #ffffff;
	z-index: -1;
	padding: 20px 10px;
	border: 1px solid #c1c1c1;
}

.rUpdContent textarea {
	width: 670px;
	height: 140px;
}

.modalRevBtns {
	width: 100px;
	height: 30px;
	border-style: none;
	border-radius: 5px;
	background-color: #99D8E1;
	color: #626262;
	margin: 2px 4px;
	font-weight: 700;
}

.BtnsArea {
	text-align: center;
}

.inputArea8_1_0 {
	background-color: #e1e8eb;
	border-radius: 5px;
	padding: 10px;
	margin: 5px;
}

.inputArea8_1_0 .revWriter {
	font-weight: 600;
	color: #626262;
	font-size: small;
}

.inputArea8_1_0 .revDate {
	font-weight: 300;
	color: #626262;
	font-size: x-small;
}

.inputArea8_1_0 .revContents {
	font-weight: 400;
	color: #626262;
	font-size: medium;
	margin: 10px 0;
}

.inputArea8_1_0 .rBtn {
	border-style: none;
	border-radius: 2px;
	background-color: #ffffff;
	color: #626262;
	margin: 0 2px;
}

#revPage {
	text-align: center;
}

</style>
</head>
<body>
	<!--HEADER-->
	<header>
		<div class=hAll>
			<div class="logo">
				<a href="/"><img src="/files/logo.png" class="logo" /></a>
			</div>
			<c:choose>
				<c:when test="${login != null }">
					<div class="btns">
						<c:if test="${checkTrade != 0}">
							<input type="button" class="btn" id="checkTrade" value="거래 요청 확인">
							<script>
							document.getElementById("checkTrade").onclick = function() {
								location.href = "/trade/sellerList.pg";
							}
						</script>
						</c:if>
						<c:if test="${req == 'Y' }">
						<input type="button" class="btn" id="checkReq" value="요청한 거래 확인">
							<script>
							document.getElementById("checkReq").onclick = function() {
								location.href = "/trade/buyerlist.pg";
							}
							</script>
						</c:if>
						<input type="button" class="btn" id="logout" value="로그아웃">
						<input type="button" class="btn" id="mypage" value="마이페이지">
						<input type="button" class="btn" id="write" value="상품등록">
					</div>
					<script>
							document.getElementById("logout").onclick = function() {
								location.href = "/members/logout.mem";
							}
							document.getElementById("mypage").onclick = function() {
								location.href = "/mypage/myPageCheck.mp";
							}
							document.getElementById("write").onclick = function() {
								location.href = "/good/write.good";
							}
					</script>
				</c:when>
				<c:otherwise>
					<div class="btns">
						<input type="button" class="btn" id="login" value="로그인"> <input
							type="button" class="btn" id="signup" value="회원가입"> <input
							type="button" class="btn" id="admin" value="관리자페이지">
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="hederTitle">
			<div class="titles">
				<div class="subTitle">당신의 재능을 거래해보세요</div>
				<div class="mainTitle">
					<a href="/">재능판매 장터</a>
				</div>
			</div>
		</div>
	</header>

	<section class="container">
		<div class="inputArea">
			<form  role="form" method="post" autocomplete="off">
				<input type="hidden" id=seq name="n" value="${dto.goodSeq}">
				<input type="hidden" id=cateCode name=cateCode value=${dto.cateCode }>
				<input type="hidden" id=goodWriter name=goodWriter value=${dto.goodWriter }> 
				<input type="hidden" id=goodPrice name=goodPrice value=${dto.goodPrice }> 
				<input type="hidden" id=goodName name=goodName value='${dto.goodName }'>
				<input type="hidden" id=img name=img value=${dto.goodImg }>
				<input type="hidden" id=id value=${id}>
				<div class="inputArea0">
					<div class="inputArea0_1">
						<span>${dto.goodName}</span>
					</div>
					<div class="inputArea0_2">
						<c:choose>
							<c:when test="${count > 0}">
								<button id="likeBtn" value=${dto.goodLike } type=button>★</button>
							</c:when>
							<c:otherwise>
								<button id="likeBtn" value=${dto.goodLike } type=button>☆</button>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="inputArea1">
					<div class="inputArea1_1">
						<img src="/files/${dto.goodImg}" class="thumImg" id="thumImg"
							width="420px" height="294px" />
					</div>
					<div class="inputArea1_2"></div>
					<div class="inputArea1_3">
						<div class="inputArea1_3_1">
							<label class="sub">Category</label>
							<c:if test="${dto.cateCode==1}">
								<p class="Txt">삽니다</p>
							</c:if>
							<c:if test="${dto.cateCode==2}">
								<p class="Txt">팝니다</p>
							</c:if>
						</div>
						<div class="inputArea1_3_2">
							<label class="sub">View</label>
							<p class="Txt">${dto.goodViewCount}</p>
						</div>


						<div class="inputArea1_3_3">
							<label for="goodPrice" class="sub">Price </label>
							<p></p>
							<p class="Txt">￦ ${dto.goodPrice}</p>
							
						</div>

						<div class="inputArea1_3_4">
							<input type=button id="buy" name="buy" class="btn" value=거래신청>
						</div>
					</div>

				</div>

				<script>		
					$("#buy").click(function(){
						if($("#goodWriter").val()!=$("#id").val()){
	                      location.href="/trade/buyer.pg?seq="+seq.value+"&title="+goodName.value+"&goodWriter="+goodWriter.value+"&goodPrice="+goodPrice.value;
						}else{
							alert("본인의 상품을 구매 할 수 없습니다.")
						}   
	                   });
				 	 
                </script>
				<div class="inputArea2"></div>

				<div class="inputArea3">
					<img src="/files/${dto.goodImg}" class="oriImg" id="oImg"
						width="600px" height="420px" />
				</div>

				<div class="inputArea4">
					<p class="Txt">서비스소개</p>
					<p class="goodDes">${dto.goodDes}</p>
				</div>
				<div class="inputArea5">
					<p></p>

				</div>

				<div class="inputArea6">
					<c:if test="${id == dto.goodWriter}">
						<input type="button" id="upd" name="upd" class="btn" value="수정하기">
						<input type="button" id="del" name="del" class="btn" value="삭제하기">
						<input type="hidden" id="error" value="${error}">
					</c:if>
					<!--if문으로 로그인 했으면 버튼 보이게 만들기-->
					<input type="button" id="reportBtn" name="report" class="btn"
						value="신고하기">
				</div>
			</form>

			<!--신고 모달 창 -->

			<div class="reportModal" id="reportModal">
				<form action="/report/insert.report" method="post">
					<div class="repModalArea" id="reportCon">
						<div class="modalCon">
							<div class="inputModalArea1">판매자신고</div>
							<div class="inputModalArea2">
								신고사유 <select name="selectReport" id="selectReport">
									<option value="1">부적절한 상품 등록</option>
									<option value="2">잦은 응답 부재/ 잠수</option>
									<option value="3">부적절한 언어 표현</option>
								</select>
							</div>
							<div class="inputModalArea3">
								<input type="hidden" id="reportPage" name="reportPage"
									value="${dto.goodSeq}"> <input type=hidden
									name=reportedUser value="${dto.goodWriter}"> <input
									type="text" id="reportTxt" name="reportTxt"
									placeholder="신고 내용을 입력해주세요">
							</div>
							<div class="inputModalArea4">
								<input type="submit" id="reportOkay" class="repModBtn"
									value="신고하기"> <input type="button" id="reportClose"
									class="repModBtn" value="취소">
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="inputArea7">
				<!--  댓글 입력창 -->
				<input type="hidden" name="goodSeq" id="gSeq" value="${dto.goodSeq}">
				<p class="Txt">서비스평가</p>
				<div class="inputArea7_1">
					<textarea name="revContents" id="rContents"></textarea>
					<button type="button" id="reviewBtn">등록</button>
				</div>

			</div>
			<div class="inputArea8" id=revList>
				<c:forEach var="i" items="${list}">
					<div class='inputArea8_1_0'>					
						<span class='revWriter'>${i.revWriter}</span> 
						<span class='revDate'>${i.revDate}</span>
						<p class='revContents'>${i.revContents}</p>	
						<c:if test="${i.revWriter == id}">
						<button type='button' class='rUpdBtn' data-revSeq=${i.revSeq}>수정</button>
						<button type='button' class='rDelBtn' data-revSeq=${i.revSeq}>삭제</button>
						</c:if>
					</div>
				</c:forEach>
				<!--댓글 페이징 처리 -->
			</div>
			<div id='revPage'>${navi}</div>
			<!-- 리뷰수정창 -->
			<div class="rUpdModal">
				<div class="rUpdContent">
					<div>
						<textarea class="modalRevCon" name="modalRevCon"></textarea>
					</div>
					<div class="BtnsArea">
						<button type="button" class="modalRevBtns" id="modUpdBtn">수정</button>
						<button type="button" class="modalRevBtns" id="modCanBtn">취소</button>
					</div>
				</div>
			</div>
		</div>
	</section>

	<footer>
			<jsp:include page="/WEB-INF/views/footer.jsp"/>
	</footer>

</body>
<script>
                /*찜 버튼 스크립트*/
                $("#likeBtn").on("click",function(){     
                   $.ajax({
                       url:"/good/updateBasket.good",
                         type:"post",
                         data : { gSeq:$("#gSeq").val(),
                        	 title:$("#goodName").val(),
                        	 price:$("#goodPrice").val(),
                        	 goodLike:$(this).val()}, //writer =id 매칭 넣어야됨
                   }).done(function(resp){
                      if(resp == 'Y'){
                         $("#likeBtn").val('Y');
                         $("#likeBtn").html("★");                   
                      }else{
                         $("#likeBtn").val('N');
                         $("#likeBtn").html("☆");
                      }
                   })
                   
                })

            </script>
<script>
				
				$(document).ready(function(){
					$.ajax({
						 url:"/members/blackListCheck.mem",
					    type : "post",
					    data : {},
					    datatype : "json"
					}).done(function(resp){
						console.log(resp)
						if(resp == 0){
							$("#write").show();
							$("#buy").show();
						}else{
							$("#write").hide();
							$("#buy").hide();
						}
					})
				})
                function insertRev(){    
                    $(".inputArea8_1_0").remove(); 
                    $.ajax({
                        url:"/review/insert.review",
                        type:"post",
                        data : {gSeq:$("#gSeq").val(),rContents:$("#rContents").val()}, //writer =id 매칭 넣어야됨
                        dataType:"json"
                    }).done(function(obj){
                        console.log(obj);
                        let id =$("#id").val()
                        for (let i=0; i<obj.length;i++){
                            let div = $("<div class='inputArea8_1_0'>");  
                            
                            if(obj[i].revWriter == id){
                            	 str= "<span class='revWriter'>"+obj[i].revWriter+"</span>"+
                                 "<span class='revDate'>"+obj[i].revDate+"</span>"+
                                 "<p class='revContents'>"+obj[i].revContents+"</p>"+
                                 "<button type='button' class='rUpdBtn' data-revSeq='"+obj[i].revSeq+"'>수정</button>"+
                                 "<button type='button' class='rDelBtn' data-revSeq='"+obj[i].revSeq+"'>삭제</button>"+
                                 "</div>"
                            }else{
                            	 str= "<span class='revWriter'>"+obj[i].revWriter+"</span>"+
                                 "<span class='revDate'>"+obj[i].revDate+"</span>"+
                                 "<p class='revContents'>"+obj[i].revContents+"</p>"+
                                 "</div>"
                            }
                            div.html(str);
                            $("#revList").append(div);
                            $("#rContents").val("");
                        }               
                    })
                    $.ajax({
                        url:"/review/getNavi.review",
                        type:"post",
                        data : {gSeq:$("#gSeq").val()}, //writer =id 매칭 넣어야됨                     
                }).done(function(resp){
                	$("#revPage").html(resp);
                	})
                };

                let formObj = $("form[role='form']");

                $("#upd").click(function() {
                    formObj.attr("action", "updateGood.good");
                    formObj.attr("method", "get")
                    formObj.submit();
                });

                $("#del").click(function() {
                    let con = confirm("정말로 삭제하시겠습니까?");
                    if (con) {
                        formObj.attr("action", "deleteGood.good");
                        formObj.submit();
                    }
                });
                
                //신고모달창 
                $("#reportBtn").on("click",function(){
                    $("#reportModal").attr("style","display:block");
                })
                $("#reportClose").on("click",function(){
                    $("#reportModal").attr("style","display:none");
                })
                $("#reportOkay").on("click",function(){
                    $("#reportOkay").attr("style","display:none");
                })

                $("#reviewBtn").click(function(){
                    insertRev();
                });


                $("#revList").on("click",".rUpdBtn",function(){
                    $(".rUpdModal").attr("style", "display:block;");
                    let rCon = $(this).parent().children(".revContents").text();
                    $(".modalRevCon").val(rCon);
                    let revSeq = $(this).attr("data-revSeq");
                    console.log(revSeq);
                    $("#modUpdBtn").attr("data-revSeq",revSeq);
                });

                $("#revList").on("click",".rDelBtn",function(){
                    let delConfirm = confirm("삭제하시겠습니까?");
                    if(delConfirm){
                   	$(this).parent().remove();
                        $.ajax({
                            url:"/review/delete.review",
                            type:"post",
                            data:{revSeq: $(this).attr("data-revSeq")},
                            dataType:"json"
                        })
                    $.ajax({
                        url:"/review/getNavi.review",
                        type:"post",
                        data : {gSeq:$("#gSeq").val()}, //writer =id 매칭 넣어야됨                     
                }).done(function(resp){
                	$("#revPage").html(resp);
                		})
                    }
                });
  
                $("#modCanBtn").on("click",function(){
                    $(".rUpdModal").attr("style", "display:none;");
                });

                $("#modUpdBtn").on("click",function(){
                    let updConfirm = confirm("수정하시겠습니까?");
                    if(updConfirm) {
                        $.ajax({
                            url:"/review/update.review",
                            type:"post",
                            data:{revSeq:$(this).attr("data-revSeq"),revContents:$(".modalRevCon").val(),gSeq:$("#gSeq").val()},
                            dataType:"json"
                        }).done(function(obj){
                       		console.log(obj);
                            if(obj.length > 0 ){
                                alert("업데이트 성공");
                                $(".inputArea8_1_0").remove();
                                for (let i=0; i<obj.length;i++){
                                    let div = $("<div class='inputArea8_1_0'>");
                                    str= "<span class='revWriter'>"+obj[i].revWriter+"</span>"+
                                        "<span class='revDate'>"+obj[i].revDate+"</span>"+
                                        "<p class='revContents'>"+obj[i].revContents+"</p>"+
                                        "<button type ='button' class='rUpdBtn' data-revSeq='"+obj[i].revSeq+"'>수정</button>"+
                                        "<button type='button' class='rDelBtn' data-revSeq='"+obj[i].revSeq+"'>삭제</button>"+
                                        "</div>"
                                    div.html(str);
                                    $("#revList").append(div);
                                }
                            }
                            $(".rUpdModal").attr("style", "display:none;");
                        })
                    }
                });
                console.log($("#error").val());
                if($("#error").val()=='error'){
                	alert("거래요청사항이 있습니다.");
                }
                
            </script>

</html>