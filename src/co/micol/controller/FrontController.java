package co.micol.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.command.IndexCommand;
import co.micol.common.Command;

@WebServlet(description = "메인컨트롤러", urlPatterns = { "/FrontController" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HashMap<String, Command> cont = new HashMap<String, Command>();
    
    
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// cont에 url과 실행 class를 정의 하는 부분
		cont.put("/index.do", new IndexCommand()); // 홈페이지 호출
//		cont.put("/index.do", new IndexCommand());
//		cont.put("/index.do", new IndexCommand());
//		cont.put("/index.do", new IndexCommand());
//		cont.put("/index.do", new IndexCommand());
//		cont.put("/index.do", new IndexCommand());
		
		
		// 요청하는 url을 분석하여 실행하는 부분
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Command commandImpl = cont.get(path); // 실행 클래스 선택
	
			commandImpl.execute(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
