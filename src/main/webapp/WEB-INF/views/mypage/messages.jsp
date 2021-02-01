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
                        .dataSet{height:85%;}
                        .data{height:90%;}
                        .titlebox{height:50px; border-bottom: 1px solid #c1c1c1;border-top: 1px solid #c1c1c1;}
                        .titlebox input[type=button]{border-style: none; border-radius: 3px; background-color: #99D8E1;}
                        .titlebox input[type=submit]{border-style: none; border-radius: 3px; background-color: #99D8E1;}
                        .none{height:600px; text-align:center; line-height:600px;}
                        .databox{height:50px;}
                        .databox .check {padding: 5px 0;}
                        .check,.titleMsg,.sender,.Date{height:50px;float:left;line-height:50px;}
                        .check,.Date{text-align:center;}
                        .checkT,.delete,.read,.write,.response,.searchBox{height:50px;float:left;text-align:center;padding: 10px 0;}
                        .check,.checkT{width:7%;}
                        .sender{width:20%;}
                        .titleMsg{width:53%;}
                        .Date{width:20%}
                        .delete,.read,.response{width:8%;}.write{width:12%}.searchBox{width:57%;}
                        .naviBox{height:5%;border-bottom: 1px solid #c1c1c1; border-top: 1px dotted #c1c1c1; }
                        .navi{text-align:center; height:50%; padding: 20px 0;}

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
                                    <div class="data">
                                        <div class=titlebox>
                                            <div class=checkT><input type=checkbox id=chkAll></div>
                                            <div class=delete><input type=button value=삭제 id=delete></div>
                                            <div class=read><input type=button value=읽음 id=read></div>
                                            <div class=write><input type=button value=쪽지쓰기 id=write></div>
                                            <div class=response><input type=button value=답장 id=response></div>
                                            <form action="/mypage/searchMessages.mp" method="post" class=searchBox>
                                                <select name=category>
                                                    <option value=s>보낸 사람</option>
                                                    <option value=t>제목</option>
                                                    <option value=c>내용</option>
                                                </select>
                                                <input type=text name=searchText> <input type=submit value=찾기>
                                            </form>   
                                        </div>
                                        <c:choose>
                                            <c:when test="${empty list}">
                                                <div class=none>내역이 없습니다.</div>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach var="i" items="${list}">
                                                    <c:if test="${i.read == 'N'}">      
                                                        <div class=databox >   
                                                            <div class=check><input type=checkbox name=chk[] value=${i.seq} ></div>
                                                            <div class=sender>${i.sender}<input type=hidden value=${i.sender}></div>
                                                            <div class=titleMsg>
                                                                <a href="/mypage/viewMsg.mp?receiver=${id}&seq=${i.seq}" >${i.title}</a>
                                                                <input type=hidden value=${i.read} class=readCheck>
                                                            </div>
                                                            <div class=Date>
                                                                <fmt:parseDate var="Date" value="${i.write_date}" pattern="yyyy-MM-dd"/>
                                                                <fmt:formatDate value="${Date}" type="date" pattern="yyyy-MM-dd"/>
                                                            </div>
                                                        </div>   
                                                    </c:if>
                                                    <c:if test="${i.read == 'Y'}">      
                                                        <div class="databox" style="color:#c1c1c1">   
                                                            <div class=check><input type=checkbox name=chk[] value=${i.seq} ></div>
                                                            <div class=sender>${i.sender}<input type=hidden value=${i.sender}></div>
                                                            <div class=titleMsg>
                                                                <a href="/mypage/viewMsg.mp?receiver=${id}&seq=${i.seq}"style=color:#c1c1c1>${i.title}</a>
                                                                <input type=hidden value=${i.read} class=readCheck>
                                                            </div>
                                                            <div class=Date>
                                                                <fmt:parseDate var="Date" value="${i.write_date}" pattern="yyyy-MM-dd"/>
                                                                <fmt:formatDate value="${Date}" type="date" pattern="yyyy-MM-dd"/>
                                                            </div>
                                                        </div>   
                                                    </c:if>
                                                </c:forEach>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class=naviBox>
                                        <div class=navi>${navi}</div>
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
                    var chk = $("input:checkbox[name='chk[]']");
                    $("#chkAll").on("click", function() {
                        if ($(this).is(":checked")) {
                            chk.prop("checked", true)
                        } else {
                            chk.prop("checked", false)
                        }
                    })
                    $("#delete").on("click", function() {
                        var chkCount = $("input:checkbox[name='chk[]']:checked").length;
                        if (chk.length > 0) {
                            if (chkCount > 0) {
                                var result = confirm("선택된" + chkCount + "개의 메시지를 삭제하시겠습니까?")
                                if (result) {
                                    $(chk).each(function() {
                                        if (this.checked) {
                                            $(this).parent().parent().remove();
                                            $.ajax({
                                                url : "/mypage/delMessages.mp",
                                                type : "post",
                                                data : {
                                                    seq : this.value,
                                                },
                                                datatype : "json"
                                            })
                                        }
                                    })
                                }
                            } else {
                                alert("선택된 목록이 없습니다.")
                            }
                        } else {
                            alert("메시지가  없습니다.");
                        }
                    })
                    $("#read").on("click",function() {
                            var chkCount = $("input:checkbox[name='chk[]']:checked").length;
                            if (chk.length > 0) {
                                if (chkCount > 0) {
                                    $(chk)
                                        .each(
                                        function() {
                                            if (this.checked) {
                                                $(this).parent().parent().css("color","black");
                                                $(this).parent().parent().children("div").children("a").css("color","black");
                                                $ .ajax({
                                                    url : "/mypage/readUpdate.mp",
                                                    type : "post",
                                                    data : {
                                                        seq : this.value,
                                                    },
                                                    datatype : "json"
                                                })
                                            }
                                        })
                                } else {
                                    alert("선택된 목록이 없습니다.")
                                }
                            } else {
                                alert("메시지가  없습니다.");
                            }
                        })
                    $("#write").on("click", function() {
                        location.href = "/mypage/writePage.mp";
                    })
                  
                    $("#response").on("click", function() {
                            var chkArray = "";
                            var chkCount = $("input:checkbox[name='chk[]']:checked").length;
                            if (chk.length > 0) {
                                if (chkCount > 0) {
                                    $(chk).each(
                                        function() {
                                            if (this.checked) {
                                                chkArray += $(this).parent().next().children().val() + "/";
                                            }
                                        })
                                    console.log($(this));
                                    location.href = "/mypage/responsePage.mp?seq="
                                        + chkArray;
                                } else {
                                    alert("선택된 목록이 없습니다.")
                                }
                            } else {
                                alert("메시지가  없습니다.");
                            }

                        })
                </script>
            </html>