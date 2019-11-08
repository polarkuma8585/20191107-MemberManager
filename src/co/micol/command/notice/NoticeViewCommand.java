package co.micol.command.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.noticeDao;
import co.micol.dto.noticeDto;

public class NoticeViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		noticeDao dao = new noticeDao();
		noticeDto dto = new noticeDto();
		
		dto = dao.select(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("dto", dto);
		
		String path ="view/noticeView.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

}
