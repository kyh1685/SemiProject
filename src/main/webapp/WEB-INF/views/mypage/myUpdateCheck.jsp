<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>UpDate</title>
                    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
                    <style>
                        .container{padding: 50px 0; width: 1200px; height: 1000px; margin: auto; }
                        section{min-height: 1000px;border-top: 1px solid grey;}

                        aside,article{float:left;}
                        aside{width:30%; background-color:rgba(153, 216, 225, 0.53);}
                        article{width:70%;}
                        a{text-decoration:none; color:black;} 
                        a:hover{cursor:pointer;} 
                       	.endHide,.myHide{display: none;margin: 10px;background-color: rgba(255, 255, 255, 0.49);border-radius: 5px;}
                       	.userHide{margin: 10px;background-color: rgba(255, 255, 255, 0.49);border-radius: 5px;}

                        .title{height:10%;font-size:40px;padding:10px;}
                        .sucSpace {height:50%; text-align: center; margin: 20px; border-top: 1px solid #c1c1c1; }
                        .mileSpace {width:400px; height: 150px; line-height: 30px; position:relative; top:50%; left: 50%; transform: translate(-50%, -100%); border-radius: 10px;background-color:rgba(153, 216, 225, 0.53);}
                        .suc {font-size:x-large;  color: grey; padding: 20px; margin: 50px 0 0 0;}
                        .mileage {font-size:x-large;  margin: 2px 0 ;}
                        .mileTxt {font-size: medium; color: #235258; line-height: 70px;}
                        
                        .title{height:10%;font-size:40px;padding:10px;}
                        .empty {width: 100%;height: 50px; }
                        .mySpace {width: 60%;margin: auto; font-size: small; color: gray;background-color:rgba(153, 216, 225, 0.53);border-radius: 10px;}
                        .mySpace .txt {font-size: large; color: #000000; text-align: right; margin: 3px 0 ;}
                        .rmenu {padding:15px 30px;}
                        article .btn {width: 60%;margin: auto; text-align: right;}
                        article .btns { width: 50px; height: 30px; margin: 10px 5px; background-color: #235258; border-style: none; color: #ffffff;}
                        article .resultpw {width:440px; height: 20px; text-align: right;}
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
                                <div class=title><b>회원 정보 수정</b></div>
                             <form action="/mypage/myUpdateCheckPro.mp" onsubmit="return Check()" method=post>
                                <div class="empty"></div>
                                <div class="mySpace">
                                    <div class="rmenu">아이디<p class="txt">${id}</p></div>
                                    <div class="rmenu">비밀번호
                                    <p class="txt"><input type='password' id='pw' name='pw' ></p>     
                                    </div>
                                </div>
                                <div class="btn" >
                                    <input type="submit" class="btns" value="확인">
                                    <input type="button" class="btns" id=cancel value="취소">
                                </div>
							</form>
                            </article>
                        </section>
                    </div>

                    <footer>
                    <jsp:include page="/WEB-INF/views/footer.jsp"/>
                    </footer>
                </body>
                <script>
          		 function Check(){
           			 if($("#pw").val() == ""){
           				alert("비밀번호를 입력해주세요");
						return false;
           			 }
           		 }         
      
                    $("#cancel").on("click",function(){
                    	location.href="/mypage/update.my"
                    })

                </script>
            </html>