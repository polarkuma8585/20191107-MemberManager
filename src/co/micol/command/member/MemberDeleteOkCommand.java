package co.micol.command.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;
import co.micol.dao.MemberDao;

public class MemberDeleteOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao dao = new MemberDao();
		HttpSession httpsession = request.getSession();
		String id = (String) httpsession.getAttribute("id");
		request.setAttribute("id", id);
		
		dao.delete(id);
		
		httpsession.removeAttribute("id");
		httpsession.removeAttribute("grant");
		
		
		
		String path="view/memberDeleteOk.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
