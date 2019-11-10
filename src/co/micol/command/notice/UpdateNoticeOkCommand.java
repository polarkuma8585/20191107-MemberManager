package co.micol.command.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.noticeDao;
import co.micol.dto.noticeDto;

public class UpdateNoticeOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticeDao dao = new noticeDao();
		noticeDto dto = new noticeDto();

		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));

		int n = dao.update(dto);

		String path;
		if (n != 0) {
			response.sendRedirect("noticeList.do");
		} else {
			path = "updateNoticeOk.do";
			RequestDispatcher dispathcer = request.getRequestDispatcher(path);
			dispathcer.forward(request, response);
		}

	}

}
