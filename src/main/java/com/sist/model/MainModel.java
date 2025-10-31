package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 *     4) 주석 : <%-- --%> 사라진다 <!-- -->는 남아 있다
 * 			   | 자바 포함		  | HTML만 주석
 *  2. JSP의 지시자
 *  	<%@ page %> : JSP파일에 대한 정보
 *  				  속성
 *   					= contnetType
 *   					= import
 *   					= errorPage : 에러발생시 이동하는 파일을 설정
 *   						errorPage = "error.jsp"
 *   					=> 기본 : forward를 사용하고 있다
 *   					*** URL주소(request를 가지고 있다)
 *   					= a.jsp ==> b.jsp
 *   						     | request가 초기화
 * 	   <%@ taglib %> : JSP에서 자바를 제거하기 위해 사용
 * 							  --------
 * 							   자바기능을 가지고 있어야 한다
 * 							   ------
 *	   <%@ taglib prefix="c" uri="jakarta.tags.core" %>
 *				   | 사용자 지정 => 시작태그
 *					<c:set> : 변수 선언
 *					<c:forEach> : 반복문
 *				    <c:if> : 조건문 (<c:else>존재하지 않는다)
 *					<c:redirect> : sendRedirect
 *					<c:choose> : 다중 조건문
 * 	   <%@ include %> : 특정 JSP부분에 다른 JSP를 첨부
 * 						 => 정적페이지
 * 						 => 소스+소스 = 컴파일
 * 						 => 동적
 * 							<jsp:include page="">
 * 							---------------------
 * 							 소스  소스
 * 							  |    |
 * 							컴파일  컴파일
 * 							  |	   |
 * 							  ------
 * 							   HTML
 * 
 * 		3. JSP 동작 
 * 			1) 클라이언트(사용자)가 .jsp요청
 * 				.jsp 파일 제작
 * 			2) 톰캣 => 서블릿으로 변경
 * 				a.jsp => a+jsp.java
 * 			3) 컴파일 => a_jsp.class
 * 			4) 실행 => 메모리에 HTML만 출력
 * 			5) 브라우저에서 한줄씩 읽어서 출력
 * 			------------------ 자동 처리
 * 		4. 내장 객체
 * 			request => HttpWervletRequest
 * 			  = 사용자 요청정보를 가지고 있다
 * 					| 사용자 보내주는 모든 데이터를 가지고 있다
 * 			  = session / cookie
 * 			=> 주요 메소드
 * 				사용자 요청값 받기
 * 				getParameter() => getParameterValues()
 * 				getSession()
 * 				getCookies()
 * 				데이터 추가
 * 				setAttribute() / getAttribute
 * 			response => HttpServletResponse
 * 			  = 응답 정보 => 브라우저 전송
 * 				| HTML / Cookie
 * 						  | addCookie()
 * 				   | setContentType("text/html")
 * 			  = 화면 서버에서 이동
 * 				sendRedirect()
 * 			session => HttpSession
 * 			pageContext => PageContext
 * 			application => ServletContext
 * 			out
 * 	5. Cookie
 * 		=> 브라우저에 저장
 * 		=> 문자열만 저장이 가능
 * 		=> 보안이 취약하다 => 최신방문 / 장바구니
 * 		=> 생성
 * 			Cookie cookie=new Cookie(키,값) 
 * 		=> 저장 기간
 * 		   cookie.setMaxAge(초) => 60*60*24 (하루)
 * 			** setMaxAge(0) => 삭제
 * 		=> 브라우저 전송
 * 			response.addCookie(cookie)
 * 		=> 쿠키 읽기
 * 			Cookie[] cookies=request.getCookies()
 * 			** 키 읽기 : getName()
 * 			** 값 읽기 : getValue()
 * 
 * 	6. EL (화면 데이터 출력) 
 * 		${} : 형식
 * 		${param.키}
 * 		${requestScope.키} => request.getAttribute("no")
 * 			=> ${requestScope.no}
 * 			=> ${no} => requestScope.는 생략이 가능
 * 		${sessionScope.키} => session.getAttribute("id")
 * 		 => 연산자 
 * 
 * 		=> 확장성 / 재사용 / 전문성 => MVC
 * 		MVC => 스트럿츠 / 스프링
 * 						| 모든 언어가 가능
 * 				| 자바 전용
 * 				---------------- 통합 (표준화)
 * 		| 역할 분리 => 유지보수와 확장성을 높이는 설계 패턴
 * 			MV => MVC => MVP => MVVM
 * 			MV : Model + View 
 * 			MVC : Model + View + Controller
 * 								 ---------- 자바/HTML매칭
 * 								 | Servlet으로 제작 : 요청 = Model = 응답 = View
 * 				  비지니스 로직 => VO, DAO, Manager, Service
 * 				  요청 => 처리 => 응답
 * 					Model에서 보낸 값을 출력 : JSP/HTML
 * 										  --------
 * 										  ThymeLeaf
 * 		실행 순서
 * 		사용자 요청 (브라우저)
 * 			| list.do
 * 		Controller
 * 			| 1. Model찾기(class, method)		
 */
@Controller
public class MainModel {
  @RequestMapping("main/main.do")
  public String main_main(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  // main_jsp => 화면 
	  request.setAttribute("main_jsp", "../main/home.jsp");
	  return "../main/main.jsp";
  }
}