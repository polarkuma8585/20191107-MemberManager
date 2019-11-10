package co.micol.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.dto.noticeDto;


public class noticeDao extends DAO {
	private ArrayList<noticeDto> list;
	private noticeDto dto;
	
	public noticeDao() {
	}
	
	public noticeDto select(int id) { // 하나만 가져오는 리스트
		dto = new noticeDto();
		
		String sql = "select * from notice where nid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new noticeDto();
				dto.setId(rs.getInt("nid"));
				dto.setTitle(rs.getString("ntitle"));
				dto.setContents(rs.getString("ncontents"));
				dto.setnDate(rs.getDate("ndate"));
				dto.setHit(rs.getInt("nhit"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		viewCountUpdate(id);	
		close();
		return dto;
	}
	
	private void viewCountUpdate(int id) { // 조회수 증가 (타 클래스에서 쓸 수 없게 private 으로.)
		String sql = "update notice set nhit = nhit + 1 where nid = " + id;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println(id + " 번 글의 조회수 1 증가");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 close();
	}
		
	public ArrayList<noticeDto> select() { // 전체 리스트
		list = new ArrayList<noticeDto>();  
		dto = new noticeDto();

		String sql = "select * from notice ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new noticeDto();
				dto.setId(rs.getInt("nid"));
				dto.setTitle(rs.getString("ntitle"));
				dto.setContents(rs.getString("ncontents"));
				dto.setnDate(rs.getDate("ndate"));
				dto.setHit(rs.getInt("nhit"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 close();
		return list;

	}

	public int insert(noticeDto dto) {
		int n = 0;
		String sql ="insert into notice (nid,ntitle,ncontents,ndate,nhit) "
				+ "values(n_num.nextval, ?,?,sysdate,0)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContents());
			n = pstmt.executeUpdate();
			System.out.println(n + "건의 공지사항이 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 close();
		return n;
	}

	public int update(noticeDto dto) {
		int n = 0;
		String sql = "update notice set ntitle=?, ncontents=?, ndate=sysdate where nid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContents());
			pstmt.setInt(3, dto.getId());
			n = pstmt.executeUpdate();
			
			System.out.println(dto.getId()+" 번의 공지사항이 수정되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 close();
		return n;
	}

	public int delete(int id) {
		int n = 0;
		String sql = "delete from notice where nid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			n = pstmt.executeUpdate();
			
			System.out.println(id + " 번의 공지사항이 삭제 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 close();
		return n;
	}
 
	
	
}
