/**
 * 
 */
package co.micol.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.dto.MemberDto;

/**
 * @author 정재흠 작성일자: 2019-11-07 상위 DAO 클래스를 상속받아 memberDao를 생성
 *
 */
public class MemberDao extends DAO {
	private MemberDto dto;
	private ArrayList<MemberDto> list;

	public MemberDao() {
		super();
	}

	public ArrayList<MemberDto> select() { // 전체 회원 목록 가져오기
		list = new ArrayList<MemberDto>();
		dto = new MemberDto();
		String sql = "select * from member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("member_id"));
				dto.setName(rs.getString("member_name"));
				dto.seteDate(rs.getDate("member_enterdate"));
				dto.setAddr(rs.getString("member_address"));
				dto.setTel(rs.getString("member_tell"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return list;
	}

	public MemberDto select(String id) { // 1명의 회원정보 가져오기
		dto = new MemberDto();

		close();
		return dto;
	}

	public int insert(MemberDto dto) { //회원 가입
		int n = 0;
		String sql = "insert into member(member_id,member_name,member_pw,member_address,member_tell)"
				+ " values(?,?,?,?,?)";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getTel());
			n = pstmt.executeUpdate();
	
			System.out.println(dto.getId() + "님의 회원가입" + n + "건이 성공했습니다.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		return n;
	}

	public int delete(String id) {
		int n = 0;

		close();
		return n;
	}

	public int update(MemberDto dto) {
		int n = 0;

		close();
		return n;
	}

	public boolean isIdCheck(String id) { // id 중복체크 존재하면 false, 없으면 true
		boolean boo = true;
		String sql ="select member_id from member where member_id =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) 
				boo = false;
			else 
				boo = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return boo;
	}

	public String loginCheck(String id, String pw) { // 로그인 메소드
		String grant = null;
		String sql = "select member_grant from member where member_id =? and member_pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next())
				grant = rs.getString("member_grant");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return grant; // 로그인 성공시 권한을 넘겨줌.
	}

}
