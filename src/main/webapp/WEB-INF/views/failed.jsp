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
                        .container{padding: 50px 0; width: 1200px; height: 1000px; margin: auto; }
                        section{min-height: 1000px;border-top: 1px solid grey;}
	
                        aside,article{float:left;}
                        aside{width:30%; background-color:rgba(153, 216, 225, 0.53);}
                        article{width:70%;}
                        a{text-decoration:none; color:black;} 
                        a:hover{cursor:pointer;}
						.endHide,.myHide,.userHide{display: none;margin: 10px;background-color: rgba(255, 255, 255, 0.49);border-radius: 5px;}
						
                        .title{height:10%;font-size:40px;padding:10px;}
                        .failSpace {height:50%; text-align: center; margin: 20px; border-top: 1px solid #c1c1c1; }
                        .backSpace {font-size:x-large;  color: grey; padding: 20px; margin: 50px 0 0 0; text-align: center;}
                        .fail {font-size:x-large;  color: grey; padding: 20px; margin: 50px 0 0 0; text-align: center;}
                        #return {background-color:#99D8E1; color: #626262; border-style: none;width: 100px;height: 40px; }
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
                                <div class=title><b>충전하기</b></div>
                                <div class="failSpace">
                                    <div class="fail">충전을 실패했습니다.</div>
                                    <div class="backSpace">
                                        <button id=return>되돌아가기</button>
                                    </div>

                                </div>
                            </article>
                        </section>
                    </div>

                    <footer>
			<jsp:include page="/WEB-INF/views/footer.jsp"/>
                    </footer>
                </body>
                <script>
                    document.getElementById("return").onclick  = function(){
                        location.href="/members/insert.pg";
                    }
                </script>
            </html>