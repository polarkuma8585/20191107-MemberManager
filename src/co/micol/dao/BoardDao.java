package co.micol.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.dto.BoardDto;

public class BoardDao extends DAO {
	private BoardDto dto;
	private ArrayList<BoardDto> list;

	public BoardDao() {
		super();
	}

	public ArrayList<BoardDto> select() { // 전체 리스트
		list = new ArrayList<BoardDto>();

		return list;
	}

	public ArrayList<BoardDto> select(int id) { // 하나 가져오기
		list = new ArrayList<BoardDto>(); // id = 0 전체 else 그룹전체
		dto = new BoardDto();

		String sql = "select * from mvc_board ";
		if (id != 0)
			sql = sql + "where bgroup = ?";

		try {
			pstmt = conn.prepareStatement(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public int insert(BoardDto dto) {
		int n = 0;

		return n;
	}

	public int update(BoardDto dto) {
		int n = 0;

		return n;
	}

	public int delete(int id) {
		int n = 0;

		return n;
	}

}