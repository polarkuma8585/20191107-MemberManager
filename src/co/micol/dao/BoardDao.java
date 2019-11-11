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
		dto = new BoardDto();
		String sql = "select * from mvc_board where btitle != '[댓글]' order by bid desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new BoardDto();
				dto.setId(rs.getInt("bid"));
				dto.setWriter(rs.getString("bname"));
				dto.setContents(rs.getString("bcontent"));
				dto.setTitle(rs.getString("btitle"));
				dto.setwDate(rs.getDate("bdate"));
				dto.setHit(rs.getInt("bhit"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}
	
	public ArrayList<BoardDto> select(int id) { // 하나 가져오기 (board 상세뷰)
		list = new ArrayList<BoardDto>();
		dto = new BoardDto();

		String sql = "select * from mvc_board where bgroup = ? order by bid";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new BoardDto();
				dto.setId(rs.getInt("bid"));
				dto.setWriter(rs.getString("bname"));
				dto.setTitle(rs.getNString("btitle"));
				dto.setContents(rs.getString("bcontent"));
				dto.setwDate(rs.getDate("bdate"));
				dto.setHit(rs.getInt("bhit"));
				dto.setIndent(rs.getInt("bindent"));
				dto.setStep(rs.getInt("bstep"));
				dto.setUserId(rs.getString("userid"));
				list.add(dto);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		viewCountUpdate(id);
		close();
		return list;
	}
	public BoardDto selectForUpdate(int id) {
		BoardDto dto = new BoardDto();
		String sql ="select * from mvc_board where bid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDto();
				dto.setTitle(rs.getString("btitle"));
				dto.setContents(rs.getString("bcontent"));
				dto.setWriter(rs.getString("bname"));
				dto.setId(id);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return dto;
	}
	public int insert(BoardDto dto) {
		int n = 0;
		String sql ="insert into mvc_board (bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent,userid)" + 
				" values(b_num.nextval, ?, ?, ?, sysdate, 0, b_num.currval, 0, 0,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContents());
			pstmt.setString(4, dto.getWriter());
			n = pstmt.executeUpdate();
			System.out.println(dto.getWriter()+" 님의 게시글이 자유게시판에 " + n + "건 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	public int insertReply(BoardDto dto) {
		int n = 0;
		String sql = "insert into mvc_board (bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent,userid) "
				+ "values(b_num.nextval,?,'[댓글]',?,sysdate,0,?,1,0,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContents());
			pstmt.setInt(3, dto.getGroup());
			pstmt.setString(4, dto.getUserId());
			n = pstmt.executeUpdate();

			System.out.println(dto.getGroup() + " 번 글에 " + n + "건의 댓글이 추가되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}

	public int update(BoardDto dto) {
		int n = 0;
		String sql ="update mvc_board set btitle=?, bcontent=? where bid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContents());
			pstmt.setInt(3, dto.getId());
			n = pstmt.executeUpdate();
			
			System.out.println(dto.getId() + "번의 게시글이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}
	public int replyUpdate(BoardDto dto) {
		int n = 0;
		String sql="update mvc_board set bcontent =? where bid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContents());
			pstmt.setInt(2, dto.getId());
			
			n = pstmt.executeUpdate();
			
			System.out.println("댓글이 "+ n +"건 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}
	public int delete(int id) {
		int n = 0;
		String sql = "delete from mvc_board where bid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			n = pstmt.executeUpdate();
			
			System.out.println(id + "번의 글이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return n;
	}
	public int deleteReply(int id) {
		int n = 0;
		String sql = "delete from mvc_board where bid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			n = pstmt.executeUpdate();
			
			System.out.println("댓글이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	private void viewCountUpdate(int id) { // 조회수 증가 (타 클래스에서 쓸 수 없게 private 으로.)
		String sql = "update mvc_board set bhit = bhit + 1 where bid = " + id;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println(id + " 번 글의 조회수 1 증가");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 close();
	}

}
