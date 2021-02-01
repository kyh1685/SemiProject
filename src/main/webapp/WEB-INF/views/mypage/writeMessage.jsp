<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>WriteMessage</title>

                    <script src = "${path}/ckeditor/ckeditor.js"></script>
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
                        
                        .boxHeader {text-align: right; padding: 5px 20px;}
                        .writeBox {margin: 20px;}
                        .writeBox input[type='button']{background-color:rgba(153, 216, 225, 0.53); border-style: none;}
                        .writeBox input[type='submit']{background-color:rgba(153, 216, 225, 0.53); border-style: none;}
                        .receiver {padding:0 20px;}
                        .titleMsg {padding:0 20px;}
                        #smartEditor {width:750px; height: 700px; margin: 20px;}
                        
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
                                <form action="/mypage/insertMessage.mp" method="post" id=frm>
                                    <div class=writeBox>
                                        <div class=boxHeader><input type=submit value=보내기 id=savebutton> <input type=button value=취소 id=cancel></div>
                                        <div class="receiver"><p>받는 사람 :		
                                            <input type=text name=receiver required size=70px value=${list}>
                                            </p></div>
                                        <div class="titleMsg"><p>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목 : <input type=text name=title required size=70px id=title></div>
                                        <div class="contentMsg" ><textarea id=smartEditor name=contents required=required></textarea></div>
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
                    CKEDITOR.replace("smartEditor",{
                        height : 700
                    }); 
                       
                    $("#cancel").on("click",function(){
                        location.href="/mypage/messages.mp?page=1";
                    })
                </script>


            </html>