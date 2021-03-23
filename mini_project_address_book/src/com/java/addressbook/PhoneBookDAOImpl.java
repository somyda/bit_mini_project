package com.java.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookDAOImpl implements PhoneBookDAO {
	
	private String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "hr";
	private String password = "1234";
	
	
	public PhoneBookDAOImpl() {
		
	}
	
	public List<PhoneBookVO> getList() {
		List<PhoneBookVO> phoneBookList = new ArrayList<PhoneBookVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(dburl, userName, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, name, hp, tel FROM PHONE_BOOK");
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String tel = rs.getString("tel");
				
				PhoneBookVO phoneBookVO = new PhoneBookVO(id, name, hp, tel); 
				phoneBookList.add(phoneBookVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) { 
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) { 
				try {
					stmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) { 
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		
		return phoneBookList;
	}
	
	public int addPhone(PhoneBookVO phoneBookVO) {
		int updateCount = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(dburl, userName, password);
			stmt = conn.createStatement();
			updateCount = stmt.executeUpdate("INSERT INTO PHONE_BOOK(id, name, hp, tel) VALUES(SEQ_PHONE_BOOK.NEXTVAL, '"
			                                + phoneBookVO.getName() + "', '"
					                        + phoneBookVO.getHp() + "', '"
			                                + phoneBookVO.getTel() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		
		return updateCount;
	}
	
	public int deletePhone(int deleteId) {
		int deleteCount = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(dburl, userName, password);
			stmt = conn.createStatement();
			deleteCount = stmt.executeUpdate("DELETE FROM PHONE_BOOK WHERE id = " + deleteId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return deleteCount;
	}
	
	
	public List<PhoneBookVO> getSearch(String keyword) {
		List<PhoneBookVO> phoneBookList = new ArrayList<PhoneBookVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(dburl, userName, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, name, hp, tel FROM PHONE_BOOK WHERE name like '" + keyword + "%'");
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String tel = rs.getString("tel");
				
				PhoneBookVO phonebook = new PhoneBookVO(id, name, hp, tel);
				phoneBookList.add(phonebook);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return phoneBookList;
		
	}
	
}
