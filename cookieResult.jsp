<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>쿠키 값 확인</h2>
<%
   Cookie[] cookies = request.getCookies();
  // request에서 받아온 쿠키 정보를 cookies라는 쿠키 배열에 저장.
  if(cookies != null) {
	  for(Cookie cookie : cookies) {
		  
		  String name = cookie.getName();
		  String value = cookie.getValue();
		  
		  out.print("쿠키명 : " + name + "/쿠키값 : " + value + "<br>");
	  }
  }


%>

</body>
</html>