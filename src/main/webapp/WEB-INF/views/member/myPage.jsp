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
                        .empty {width: 100%;height: 50px; }
                        .mySpace {width: 60%;margin: auto; font-size: small; color: gray;background-color:rgba(153, 216, 225, 0.53);border-radius: 10px;}
                        .mySpace .txt {font-size: large; color: #000000; text-align: right; margin: 10px 0 ;}
                        .rmenu {padding:15px 30px;}
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

                                <div class=title><b>내 정보 보기</b></div>
                                <div class="empty"></div>
                                <div class="mySpace">
                                    <div class="rmenu">아이디<p class="txt">${dto.id}</p></div>
                                    
                                    <div class="rmenu">이름<p class="txt">${dto.name}</p></div>
                                    <div class="rmenu">이메일<p class="txt">${dto.email}</p></div>
                                    <div class="rmenu">전화번호<p class="txt">${dto.contact}</p></div>
                                    <div class="rmenu">마일리지<p class="txt">${dto.mileage}</p></div>
                                </div>

                            </article>
                        </section>
                    </div>

                    <footer>
                    		<jsp:include page="/WEB-INF/views/footer.jsp"/>
                    </footer>
                </body>    
            </html>