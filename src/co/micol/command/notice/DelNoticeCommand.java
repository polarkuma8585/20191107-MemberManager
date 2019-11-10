package co.micol.command.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.noticeDao;

public class DelNoticeCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticeDao dao = new noticeDao();
		
		dao.delete(Integer.parseInt(request.getParameter("id")));
		
		response.sendRedirect("noticeList.do");

		
	}

}
