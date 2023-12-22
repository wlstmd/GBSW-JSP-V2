<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Crawling2.Posts2" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
     <link rel="stylesheet" href="./style2.css">
    <title>당근마켓 웹 크롤링</title>
</head>
<body>
	<header>
		<a href="https://www.daangn.com/"><img class="img" src="./images/danngn.png" alt="img"/></a>
		<nav>
			<ul>
				<li><a href="/JSP_PJT/popular">인기매물 불러오기</a></li>
				<li><a href="/JSP_PJT/worker">알바 불러오기</a></li>
			</ul>
		</nav>
	</header>
	<h1>당근마켓 알바 불러오기</h1>
    <ul>
        <% 
        @SuppressWarnings("unchecked")
        List<Posts2> posts = (List<Posts2>) request.getAttribute("posts");
        if (posts != null) {
            for (Posts2 post : posts) {
        %>
		<div class="border">
			<li>
	            <p>게시물 제목: <%= post.getTitle() %></p>
	            <p>가격: <%= post.getPrice() %></p>
	            <p>위치: <%= post.getRegion() %></p>
	            <img src="<%= post.getImageUrl() %>" alt="Post image"/>
        	</li>
		</div>
        <% 
            } 
        } 
        %>
    </ul>
    <footer>
    	<div class="img">
      		<img src="./images/danngn.png" alt="danngn">
    	</div>
    	<div class="footer-title">
      		<div class="footer-des">
        		<div class="footer-copyright"><i class="fa-regular fa-copyright"></i> 대표 : 김용현, 황도연  | 사업자 번호 375-87-00088</div>
	      	</div>
	      	<ul>
	      		<li><a href="https://www.daangn.com/policy/terms">이용약관</a></li>
		        <li><a href="https://privacy.daangn.com/">개인정보처리방침</a></li>
		        <li><a href="https://www.daangn.com/policy/location">위치기반서비스 이용약관</a></li>
		       	<li><a href="https://www.daangn.com/wv/faqs/3994">당근 이용자보호 비전과 계획</a></li>
		       	<li><a href="https://www.daangn.com/wv/faqs/9010">청소년 보호정책</a></li>
	      	</ul>
	      	<div class="footer-contact">주소 : 서울특별시 구로구 디지털로 30길 28, 609호 (당근서비스)</div>
      		<div class="footer-contact">전화 : 1544-9796 | 고객문의 cs@daangnservice.com</div>
    	</div>
  	</footer>
</body>
</html>
