package co.micol.command.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.MemberDao;
import co.micol.dto.MemberDto;

public class MemberListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberDto> list = new ArrayList<>();
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();
	
		list = dao.select();
		request.setAttribute("list", list);
		
		String path = "view/memberList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		

	}

}
