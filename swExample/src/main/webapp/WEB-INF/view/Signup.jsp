<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>
회원가입 페이지
하나라도 입력 안하면 submit 못하게 jsp파일에서 설정하는것이 나을듯

<!-- 스프링 폼 사용 -->
<form:form modelAttribute="signupTest" action="/swExample/signUpCheck" method="post">

    
    
	<label>학번 : <input type="text" name="userId" value="${User.userId }"/></label>
	<br>
	
	<label>비밀번호 : <input type="password" name="userPw"/></label>
	<br>
	
	<label>이름 : <input type="text" name="userName"/></label>
	<br>
	
	<label>이메일 : <input type="email" name="userEmail" pattern="[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.]+[a-zA-Z]+[.]*[a-zA-Z]*" size="40" /></label>
	<br>
	
	<label>전화번호 : <input type="text" name="userPhoneNumber" placeholder="하이픈(-)을 제외하고 입력하세요"/></label>
	<br>
	<input type="submit" value="가입"/><br>
</form:form>
</body>
</html>