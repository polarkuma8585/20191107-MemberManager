package co.micol.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.command.IndexCommand;
import co.micol.command.member.LogOutOkCommand;
import co.micol.command.member.LoginCommand;
import co.micol.command.member.LoginOkCommand;
import co.micol.common.Command;

@WebServlet(description = "컨트롤러", urlPatterns = { "/NewFrontController" })
public class NewFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> cont = new HashMap<String, Command>();

	public NewFrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// cont에 url과 실행 class를 정의 하는 부분
		cont.put("/index.do", new IndexCommand()); // 홈페이지 호출
		cont.put("/login.do", new LoginCommand()); //로그인 페이지 호출
		cont.put("/loginOk.do", new LoginOkCommand()); // 로그인 확인
		cont.put("/logOutOk.do", new LogOutOkCommand()); //로그아웃
//		cont.put("/index.do", new IndexCommand());
//		cont.put("/index.do", new IndexCommand());

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// 요청하는 url을 분석하여 실행하는 부분
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());

		Command commandImpl = cont.get(path); // 실행 클래스 선택
		commandImpl.execute(request, response);
		
	}
}
