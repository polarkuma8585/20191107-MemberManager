package co.micol.command.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.BoardDao;

public class DeleteBoardCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		int n = 0;
		int id = Integer.parseInt(request.getParameter("id"));
		
		n = dao.delete(id);
		
		response.sendRedirect("boardList.do");

	}

}
