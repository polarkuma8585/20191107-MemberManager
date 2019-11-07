package co.micol.command.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;

public class LogOutOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpsession = request.getSession();
		String id = (String) httpsession.getAttribute("id");
		
		httpsession.removeAttribute("id");
		httpsession.removeAttribute("grant");
		
		request.setAttribute("id", id);
		
		String path="view/logoutOk.jsp"; 

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
		
		
		
		
		

	}

}
