package co.micol.command.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.noticeDao;
import co.micol.dto.noticeDto;


public class UpdateNoticeCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticeDao dao = new noticeDao();
		noticeDto dto = new noticeDto();
		
		dto = dao.select(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("dto", dto);
		
		String path="view/updateNotice.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

}
