package co.micol.command.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;
import co.micol.dao.noticeDao;
import co.micol.dto.noticeDto;

public class NoticeListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<noticeDto> list = new ArrayList<>();
		noticeDto dto = new noticeDto();
		noticeDao dao = new noticeDao();
		
		list = dao.select();
		int size = list.size();
		request.setAttribute("list", list);
		request.setAttribute("size", size);
		
		String path="view/noticeList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
		
		
	}

}
