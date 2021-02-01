<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
	<input type="hidden" id= id name= id value=${id }>
	<input type="hidden" id = totalPrice name=totalPrice value=${totalPrice }>
</body>
	<script>
		IMP.init('imp14435351');

		IMP.request_pay({
			pg : 'inicis', // version 1.1.0부터 지원.
			pay_method : 'card',
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '마일리지 결제',
			amount : ${totalPrice}, //판매 가격
			buyer_email : ${email},
			buyer_name : ${name},
			buyer_tel : ${phone},
			buyer_addr : ${address},
			buyer_postcode : '123-456'
		}, function(rsp) {
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				
				location.href="/members/sucess.pg?id="+id.value+"&totalPrice="+totalPrice.value;
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
				
				location.href="failed.pg";
			}
			alert(msg);
		});
	</script>

</html>
