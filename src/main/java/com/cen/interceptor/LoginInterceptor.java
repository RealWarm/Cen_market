package com.cen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cen.controller.CategoryController;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


//@Log4j
@Slf4j
public class LoginInterceptor 
	implements HandlerInterceptor {
	
	private final String loginKey = "login";
	private final String origRequestURIKey = "originalRequestURI";


	@Override
	public boolean preHandle(// preHandle - 지정된 컨트롤러의 동작 이전에 가로채는 역할
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws Exception {		
		log.info("LoginInterceptor::preHandle(req, res, handler) invoked.");		
		log.info("request : "  + request);
		log.info("response : "  + response);
		log.info("handler : "  + handler);
		log.info("\t SessionID:" + request.getSession().getId());
		log.info("RequestURI : " + request.getRequestURI() );
        log.info("----------------------------------------------------------------------------");
		
		// 이미 세션 영역에 지정된 키의 속성객체가 존재한다면,
		// 이 속성객체를 세션영역에서 제거.
		HttpSession session = request.getSession();
		if(session.getAttribute(loginKey) != null) {			
			session.removeAttribute(loginKey);
		}// if
		
		return true; // true : Next 로 이동
	}// preHandle

	// postHandel - 지정된 컨트롤러의 동작 이후에 처리 >> 화면 처리하기 전에 동작
    // (전제 : 컨트롤러가 정상적으로 끝났을 때)
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView) throws Exception {		
		log.info("LoginInterceptor::postHandle(req, res, handler, modelAndView) invoked.");
		log.info("request : "  + request);
		log.info("response : "  + response);
		log.info("handler : "  + handler);
		log.info("\t SessionID:" + request.getSession().getId());
		log.info("\t SessionID:" + request.getSession());
		log.info("modelAndView :" + modelAndView );
		
		
		// 로그인 성공후, 사후처리 진행
		// 1. 기존에 생성된 세션객체가 있으면 반환하고, 없으면 새로이 세션객체를 
		//    만들어서 반환함
		HttpSession session = request.getSession();
		// HttpSession session = request.getSession(true);
		
		// 기존에 생성된 세션객체가 있으면 반환하고, 없으면 null 값을 반환
		// session = request.getSession(false);
		
		// 2. ModelAndView 객체를 활용하여, 
		// 이미 session scope에 사용자 정보객체가 있으면 엎어치고
		// 없다면, 새로운 속성으로 등록해줍니다.
		ModelMap modelMap = modelAndView.getModelMap();
		Object memberVO = modelMap.get("MemberVO");
		if(memberVO != null) { // if login success
			log.info("\t+ Login Success.");
			
			// 2-1. 세션 영역에 사용자 정보 객체를 속성으로 설정
			session.setAttribute(loginKey, memberVO);
			
			// 2-2. 원래의 URI를 복구하여, 복구된 URI로
			//      이동시킴
			Object orignalRequestURI = 
					session.getAttribute(origRequestURIKey);
			
			System.out.println("orignalRequestURI :: " + orignalRequestURI);
			
			response.sendRedirect(
					orignalRequestURI != null?
					// (String)orignalRequestURI : "/main"
					(String)orignalRequestURI : "/" );
		} // if
	} // postHandle

	
	
	@Override
	public void afterCompletion(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			Exception ex) throws Exception {		
		log.info("LoginInterceptor::afterCompletion(req, res, handler, ex) invoked.");
		
	}// afterCompletion
	
	

}// end class





