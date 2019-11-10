package co.micol.command.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;
import co.micol.dao.BoardDao;
import co.micol.dto.BoardDto;

public class BoardViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BoardDto> list = new ArrayList<>();
		BoardDao dao = new BoardDao();
		//BoardDto dto = new BoardDto();
		HttpSession session = request.getSession();
		String writer = (String)session.getAttribute("id");
		
		list = dao.select(Integer.parseInt(request.getParameter("id")));
		int length = list.size();
		request.setAttribute("list", list);
		request.setAttribute("length", length);
		
		request.setAttribute("writer", writer); // 세션 아이디(글 작성자) 설정 
		
		String path="view/boardView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

}
