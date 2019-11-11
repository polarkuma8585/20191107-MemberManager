package co.micol.command.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;
import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class ReplyInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();
		HttpSession httpsession = request.getSession(); 
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String writer = (String)httpsession.getAttribute("id");
		System.out.println(id);
		System.out.println(writer);
		
		dto.setGroup(id);
		dto.setContents(request.getParameter("reply"));
		dto.setWriter(writer);
		dto.setUserId(writer);
		
		int n  = 0;
		n = dao.insertReply(dto);
		
		
		//request.setAttribute("id", id);
		
		response.sendRedirect("boardView.do?id="+id);
		
	}

}
