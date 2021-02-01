<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>PurchaseList</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
                    <style>
                        .container{padding: 50px 0; width: 1200px; height: 1000px; margin: auto; }
                        section{min-height: 1000px;border-top: 1px solid grey;}

                       aside,article{float:left;}
                        aside{width:30%; background-color:rgba(153, 216, 225, 0.53);}
                        article{width:70%;}
                        a{text-decoration:none; color:black;} 
                        a:hover{cursor:pointer;} 
                       .endHide,.userHide,.myHide{display: none;margin: 10px;background-color: rgba(255, 255, 255, 0.49);border-radius: 5px;}

                        .title{height:10%;font-size:40px;padding:10px;}
                        .search{height:5%;}
                        #search {background-color:rgba(153, 216, 225, 0.53); border-style: none;}
                        .calander{margin:10px;}
                        .dataSet{height:85%;}
                        .data{height:90%;}
                        .titlebox{height:50px; border-bottom: 1px solid grey; border-top: 1px solid grey; margin: 0 10px;}
                        .none{height:600px; text-align:center; line-height:600px;}
                        .databox{height:50px;}
                        .seq,.category,.product,.price,.Date{height:50px;float:left;text-align:center;line-height:50px;}
                        .seq{width:8%}.category{width:13%}.price{width:10%}.product{width:55%;}.Date{width:14%}
                        .naviBox{height:10%;background-color:gray;}
                        .navi{text-align:center; height:50%;}
                        .deleteBox{height:50%; text-align:right;}
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
                                <div class=title><b>구매 내역</b></div>
                                <div class=search><div class=calander><input type=text id=startDate value=${startDate}>~<input type=text id=endDate value=${endDate}> <input type=button value=조회 id=search></div></div> <!-- DatePicker 사용  -->
                                <div class=dataSet>
                                   <div class="data">
                                        <div class=titlebox>
                                            <div class=seq>번호</div>
                                            <div class=category>분류</div>
                                            <div class=product>상품명</div>
                                            <div class=price>가격</div>
                                            <div class=Date>완료 일자</div>
                                        </div>
                                        <c:choose>
                                            <c:when test="${empty list}">
                                                <div class=none>내역이 없습니다.</div>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach var="i" items="${list}">
                                                    <div class=databox>	
                                                        <div class=seq>${i.rn}</div>
                                                        <c:choose>
                                                        	<c:when test="${i.cateCode == 1}">
                                                       			<div class=category>삽니다</div>
                                                        	</c:when>
                                                        	<c:otherwise>
                                                        		<div class=category>팝니다</div>
                                                       		</c:otherwise>
                                                        </c:choose>
                                                        <div class=product><a href="/good/view.good?page=1&goodSeq=${i.goodSeq}">${i.title}</a></div>
                                                        <div class=price>${i.price}</div>
                                                        <div class=Date>
                                                            <fmt:parseDate var="Date" value="${i.write_date}" pattern="yyyy-MM-dd"/>
                                                            <fmt:formatDate value="${Date}" type="date" pattern="yyyy-MM-dd"/>

                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:otherwise>
                                        </c:choose>	
                                    </div>
                                    <div class=naviBox>
                                        <div class=navi>${navi}</div>
                                        <div class=deleteBox></div>
                                    </div>
                                </div>
                            </article>
                        </section>
                        <footer>
                        </footer>
                    </div>
                    <footer>
					<jsp:include page="/WEB-INF/views/footer.jsp"/>
                    </footer>
                </body>
                <script>
                    $(document).ready(function(){
                    	$.datepicker.setDefaults($.datepicker.regional['ko']); 
                        $( "#startDate" ).datepicker({
                             changeMonth: true, 
                             changeYear: true,
                             nextText: '다음 달',
                             prevText: '이전 달', 
                             dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                             dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                             monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                             monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                             dateFormat: "yy-mm-dd",
                             maxDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
                             onClose: function( selectedDate ) {    
                                  //시작일(startDate) datepicker가 닫힐때
                                  //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
                                 $("#endDate").datepicker( "option", "minDate", selectedDate );
                             }    
             
                        });
                        $( "#endDate" ).datepicker({
                             changeMonth: true, 
                             changeYear: true,
                             nextText: '다음 달',
                             prevText: '이전 달', 
                             dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                             dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                             monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                             monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                             dateFormat: "yy-mm-dd",
                             maxDate: 0,                       // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
                             onClose: function( selectedDate ) {    
                                 // 종료일(endDate) datepicker가 닫힐때
                                 // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
                                 $("#startDate").datepicker( "option", "maxDate", selectedDate );
                             }    
                        });    

                    });

                    $("#search").on("click", function(){
                        var start = $("#startDate").val();
                        var end = $("#endDate").val();
                        if(start <= end){
                            location.href="/mypage/searchPurchaseList.mp?page=1&startDate="+start+"&endDate="+end;
                        }else{
                            alert("날짜를 다시 선택해주세요");
                        }
                    })
                 
                </script>
            </html>