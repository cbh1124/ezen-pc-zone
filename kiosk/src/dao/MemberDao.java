package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Member;

public class MemberDao {

	private Connection connection ; 
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet; 
	
	private static MemberDao memberDao = new MemberDao();
	
	public static MemberDao getMemberDao() { return memberDao; }
	
	
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ezenpczone?serverTimezone=UTC" , 
					"root" , "1234");
		}
		catch (Exception e) {
			System.out.println(" * DB ���� ���� : " + e);
		}
	}
	//1. ȸ������ �޼ҵ�
	public boolean signup (Member member) {
		String sql =  "insert into member(m_id, m_pw, m_name, m_email, m_phone, m_sex) value(?, ?, ?, ?, ?,?)";
		try {
		
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, member.getM_id());
		preparedStatement.setString(2, member.getM_pw());
		preparedStatement.setString(3, member.getM_name());
		preparedStatement.setString(4, member.getM_email());
		preparedStatement.setString(5, member.getM_phone());
		preparedStatement.setInt(6, member.getM_sex());
		preparedStatement.executeUpdate();
		
		return true;
		}catch (Exception e) {
			System.out.println("db ���� ����");
			return false;
		}
	}
	//2. ���̵� �ߺ�üũ
	public boolean idcheck (String id) {
		String sql = "select m_id from member where m_id =?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	//�α��� �޼ҵ�
	public boolean login (String id , String pw) {
		String sql = "select * from member where m_id=? and m_pw=?";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	
	
	
}

























