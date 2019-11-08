package co.micol.command.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.noticeDao;
import co.micol.dto.noticeDto;

public class InsertNoticeOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticeDto dto = new noticeDto();
		noticeDao dao = new noticeDao();

		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));

		int n = dao.insert(dto);

		response.sendRedirect("noticeList.do");

	}

}
