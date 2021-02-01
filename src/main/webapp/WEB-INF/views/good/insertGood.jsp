<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
            <title>Insert Market</title>
            <script src = "${path}/ckeditor/ckeditor.js"></script>
            <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
            <style>
                /*font-family*/
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

                *{box-sizing: border-box; font-family: 'GmarketSansMedium';}
                a {text-decoration-style: none;}
                li {list-style: none;}
                ul {display:flex; justify-content:space-around;padding: 10px 0;}


                header {}
                header input[type=button] {cursor: pointer;}
                header div .logo {float: left; position: relative; top:2px;left: 50px;}
                header .btns {display: flex; justify-content: flex-end; border-style: none; border-style: none;}
                header .btns input {margin: 0 4px;}
                header .btn {width: 100px; height: 30px; border-style: none; border-radius: 5px; background-color: #ffffff; color: #626262;margin: 0 4px; font-weight: 700;}
                header .hederTitle {width: 100%; height: 350px; top:-30px; background-image:url("/files/header.png"
                ); background-repeat :no-repeat; background-size : cover; padding: 50px;text-align: center; }
                header .hederTitle .titles {margin-top: 110px; color:#626262;}
                header .hederTitle .titles .mainTitle {font-size: 50px;font-family: 'GmarketSansBold';}
                header .hederTitle .titles .subTitle {font-size: 17px;font-family:'GmarketSansMedium';}


                .container {width: 1000px; height: 1200px; margin:auto;}
                .inputArea1 {padding: 10px; margin: 50px 0 0 0; font-size: xx-large; border-bottom: 1px solid #c1c1c1; color: gray;}
                .inputArea2 {width: 100%; height: 3%;overflow: hidden; }
                .inputArea2_1 {width: 10%; height: 100%; float: left;text-align: center; line-height: 40px; color: #6bb2bc;}
                .inputArea2_2 {width: 90%; height: 100%;}
                .category {width:100px;height: 30px; margin: 5px 10px;}
                .inputArea3 {width: 100%; height: 3%;overflow: hidden; }
                .inputArea3_1 {width:10%; height: 100%;padding:5px; float: left; text-align: center; line-height: 30px; color: #6bb2bc;}
                .inputArea3_2 {width:90%; height: 100%;padding:5px;}
                #goodName {width:500px; margin: 0 10px;}
                .inputArea4 {width: 100%; height: 3%; border-bottom: 1px solid #c1c1c1;overflow: hidden;}
                .inputArea4_1 {width:10%;  height: 100%;padding:2px; float: left;text-align: center; line-height: 35px;color: #6bb2bc;}
                .inputArea4_2 {width:90%; height: 100%;padding:2px;}
                #goodPrice {width:500px; margin: 3px 10px}
                .inputArea5{width: 100%; height: 43%; border-bottom: 1px solid #c1c1c1;}
                .inputArea5_1 {text-align: right; padding: 5px 200px;}
                .inputArea5_1 label { display: inline-block; padding: 2px; font-size: inherit;line-height: normal; vertical-align: middle; background-color: #99D8E1;cursor: pointer; border: 1px solid #99D8E1;border-radius: 3px; margin: 2px 5px;}
                #goodImg {display: none;}
                .imgUp {color: gray; font-size: small;}
                .selectImg{text-align: center;margin: 20px 0; font-size: small;}
                .selectImg img {width:600px; height:420px;}
                .inputArea6{width:100%; height: 30%; padding: 5px; }
                                .inputArea6 span {color: #6bb2bc; font-size: x-large;}
                #goodDes  {width:985px; height: 300px;}
                .inputArea7 {width:100%; height:5%; text-align: center; }
                .insertBtn {width:200px; height: 30px; border-style: none; border-radius: 10px; background-color: #99D8E1;}
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
								location.href = "/trade/seller.pg";
							}
						</script>
					</c:if>
						<c:if test="${allReq == 'Y' }">
						<input type="button" class="btn" id="checkReq" value="요청한 거래 확인">
							<script>
							document.getElementById("checkReq").onclick = function() {
								location.href = "/trade/buyerlist.pg";
							}
							
							</script>
						</c:if>
							<input type="button" class="btn" id="logout" value="로그아웃"> <input
								type="button" class="btn" id="mypage" value="마이페이지"> <input
								type="button" class="btn"  id="write" value="상품등록">
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
						<script>
						document.getElementById("login").onclick = function() {
			    			location.href = "/members/loginPage.mem";
			    		}
			    		document.getElementById("signup").onclick = function() {
			    			location.href = "/members/signupViewNomal.mem";
			    		}
			    		document.getElementById("admin").onclick = function() {
			    			location.href = "/nex/index.html";
			    		}
						</script>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</header>

            <div class="container">
                <form action="/good/insert.good" method="post"  enctype="multipart/form-data">
                    <div class="inputArea1">
                        <b>재능 등록하기</b>
                    </div>
                    <div class="inputArea2">
                        <div class="inputArea2_1">
                            <label>항&nbsp;&nbsp;목</label>
                        </div>
                        <div class="inputArea2_2">
                            <select class="category" name="cateCode">
                                <option value="1">삽니다</option>
                                <option value="2">팝니다</option>
                            </select>
                        </div>


                    </div>

                    <div class="inputArea3">
                        <div class="inputArea3_1">
                            <label for="goodName">상품명</label>
                        </div>
                        <div class="inputArea3_2">
                    		<input type="hidden" name="goodWriter" value="${id}">
                            <input type="text" id="goodName" name="goodName" required />
                        </div>
                    </div>

                    <div class="inputArea4">
                        <div class="inputArea4_1">
                            <label for="goodPrice">상품가격</label>
                        </div >
                        <div class="inputArea4_2">
                            <input type="text" id="goodPrice" name="goodPrice" required/>
                        </div>
                    </div>

                    <div class="inputArea5">
                        <div class="inputArea5_1">

                            <span class="imgUp">이미지 업로드 권장 사이즈 600px * 420px</span>
                            <label for="goodImg">파일 업로드</label>
                            <input type="file" class="imgUpBtn" id="goodImg" name="file"/>
                        </div>
                        <div class="selectImg">
                            <img src="" width="750px" height="525px"/>
                        </div>


                    </div>

                    <div class="inputArea6">
                        <div class="inputArea6_1"><span>서비스 소개</span></div>
                        <div class="inputArea6_2"><textarea id="goodDes" name="goodDes" required></textarea></div>

                    </div>


                    <div class="inputArea7">
                    	<input type=hidden id= error value=${error }>
                        <button type="submit" id="insertBtn" class="insertBtn">등록하기</button>
                        <button type="button" id="backBtn" class="insertBtn">취소</button>

                    </div>
                </form>
            </div>
            <footer>
            		<jsp:include page="/WEB-INF/views/footer.jsp"/>
            </footer>
        </body>
        <script>
        CKEDITOR.replace("goodDes",{
            height : 300
        }); 
            $("#goodImg").change(
                function() {
                    if (this.files && this.files[0]) {
                        let reader = new FileReader;
                        reader.onload = function(data) {
                            $(".selectImg img").attr("src", data.target.result).width(500);
                        }
                        reader.readAsDataURL(this.files[0]);
                    }
                });
            document.getElementById("backBtn").onclick = function() {
                location.href = "/";
            }

    		 if(document.getElementById("error").value =='x'){
    	           alert("중복된 제목입니다. 다른 제목을 입력해 주세요")
    	        }else if(document.getElementById("error").value =='number'){
    	        	if(confirm("보유한 금액이 적습니다\n충전페이지로 이동하시겠습니까?")){
    	        		location.href="/members/insert.pg"
    	        	}
    	        }

        </script>
    </html>