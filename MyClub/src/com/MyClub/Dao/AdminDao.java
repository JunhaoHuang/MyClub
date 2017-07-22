package com.MyClub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyClub.JDBC.JDBC;
import com.MyClub.vo.Admin;

public class AdminDao {
	private JDBC util = new JDBC(); // ���ݿ����������
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null; // �������

	// ��ѯȫ����¼
	public List<Admin> queryAll() {
		sql = "select * from Admin";
		conn = util.getConnection();
		List<Admin> list = new ArrayList<Admin>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Admin s = new Admin();
				s.setUserID(rs.getString("UserID"));
				s.setAccountNum(rs.getString("AccountNum"));
				s.setPassword(rs.getString("Password"));
				s.setUserType(rs.getString("UserType"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // �ر�����
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	// �鵥����¼
	public Admin queryAdminById(String userid) {
		Admin s = new Admin();
		sql = "select * from Admin where UserID=?";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setUserID(rs.getString("UserID"));
				s.setAccountNum(rs.getString("AccountNum"));
				s.setPassword(rs.getString("Password"));
				s.setUserType(rs.getString("UserType"));
			} else
				s = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s;
	}

	// �鵥����¼
		public Admin queryAdminByAccount(String account) {
			Admin s = new Admin();
			sql = "select * from Admin where AccountNum=?";
			conn = util.getConnection();
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, account);
				rs = ps.executeQuery();
				if (rs.next()) {
					s.setUserID(rs.getString("UserID"));
					s.setAccountNum(rs.getString("AccountNum"));
					s.setPassword(rs.getString("Password"));
					s.setUserType(rs.getString("UserType"));
				} else
					s = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return s;
		}
	
	// ���Ӽ�¼
	public boolean insertAdmin(Admin s) {
		sql = "insert into Admin(UserID, AdminNum, Password,UserType) values(?,?,?,?)";
		boolean flag = false;
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUserID());
			ps.setString(2, s.getAccountNum());
			ps.setString(3, s.getPassword());
			ps.setString(4, s.getUserType());
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	// �޸ļ�¼
	public boolean updateAdmin(Admin s) {
		sql = "update Admin set AdminNum=?, Password=?, UserType=? where UserID=?";
		boolean flag = false;
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getAccountNum());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getUserType());
			ps.setString(4, s.getUserID());
			if (ps.execute())
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	// ɾ����¼
	public boolean deleteAdmin(String userid) {
		sql = "delete from Admin where UserID=?";
		boolean flag = false;
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			if (ps.execute())
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
}
