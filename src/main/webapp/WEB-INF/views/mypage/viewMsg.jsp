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
                        .dataSet{height:60%; border: 1px solid #c1c1c1; margin: 10px;}
                        .databox{height:50px;}
                        .databox .person{font-family: 'GmarketSansLight'; font-size: small;}
                        .btn{height:40px; line-height:40px; padding: 0 20px; text-align: right;}
                        .btn input[type='button'] {background-color:rgba(153, 216, 225, 0.53); border-style: none;}
                        .titleMsg,.Date{float:left;height:100%;}
                        .titleMsg{width:70%;}.Date{width:30%;text-align:right;}
                        .TopMsg{height:40px; line-height:40px; border-bottom: 1px solid grey; border-top: 1px solid grey; margin: 0 10px; }
                        .sender,.receiver{height:40px;line-height:40px; margin: 0 10px; border-bottom: 1px solid #c1c1c1;}
                        .contentMsg{height:840px; padding:10px;}
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
                                <div class=title><b>쪽지함</b></div>		
                                <div class=dataSet>
                                    <div class=btn><input type=button value='목록' id=list> <input type=button value=삭제 id=delete></div>
                                    <c:forEach var="i" items="${list}">
                                        <div class=databox>
                                            <input type=hidden id=seq value=${i.seq}>
                                            <div class=TopMsg>
                                                <div class=titleMsg>${i.title}</div> <div class=Date>${i.write_date}</div>
                                            </div>
                                            <div class=sender><span class="person">보낸사람</span> ${i.sender}</div>
                                            <div class=receiver><span class="person">받는사람</span> ${i.receiver}</div>				
                                            <div class=contentMsg>${i.contents}</div>		
                                        </div>	
                                    </c:forEach>
                                </div>
                            </article>
                        </section>

                    </div>
                    <footer>
                    <jsp:include page="/WEB-INF/views/footer.jsp"/>
                    </footer>
                </body>
                <script>
                    $("#delete").on("click", function(){
                        $.ajax({
                            url:"/mypage/delMessages.mp",
                            type : "post",
                            data : {
                                seq : $("#seq").val(),
                                id : $(".id").html()
                            },
                            datatype : "json"
                        }).done(function(resp){
                            if(resp){
                                location.href="/mypage/messages.mp?page=1";
                            }
                        })
                    });
                  
                    $("#list").on("click",function(){
                        location.href="/mypage/messages.mp?page=1";
                    })
                </script>
            </html>