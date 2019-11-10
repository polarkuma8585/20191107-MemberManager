package co.micol.command.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class InsertBoardOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			BoardDao dao = new BoardDao();
			BoardDto dto = new BoardDto();
			
			dto.setWriter(request.getParameter("writer"));
			dto.setTitle(request.getParameter("title"));
			dto.setContents(request.getParameter("contents"));
			dao.insert(dto);
			
			response.sendRedirect("boardList.do");	
	}

}
