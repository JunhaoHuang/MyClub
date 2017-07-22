package com.MyClub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyClub.JDBC.JDBC;
import com.MyClub.enums.CType;
import com.MyClub.enums.SexE;
import com.MyClub.vo.User;

public class UserDao {
	private JDBC util = new JDBC(); // 数据库连接类对象
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null; // 操作语句

	// 查询全部记录
	public List<User> queryAll() {
		sql = "select * from User";
		conn = util.getConnection();
		List<User> list = new ArrayList<User>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User s = new User();
				s.setUserID(rs.getString("UserID"));
				s.setUserName(rs.getString("UserName"));
				s.setSex(rs.getString("Sex"));
				s.setPhoneNumber(rs.getString("PhoneNumber"));
				s.setSchool(rs.getString("School"));
				s.setStudentID(rs.getString("StudentID"));
				s.setName(rs.getString("Name"));
				s.setHeadPicture(rs.getString("HeadPicture"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 关闭连接
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
	
	public int countAll() {
		int num=0;
		sql = "select count(userid) AS num from user";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				num=rs.getInt("num");
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
		return num;
	}
	
	public int countBySex(SexE s) {
		int num=0;
		sql = "select count(userid) AS num from user where sex=?";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				num=rs.getInt("num");
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
		return num;
	}

	// 查单条记录
	public User queryUserById(String userid) {
		User s = new User();
		sql = "select * from User where UserID=?";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setUserID(rs.getString("UserID"));
				s.setUserName(rs.getString("UserName"));
				s.setSex(rs.getString("Sex"));
				s.setPhoneNumber(rs.getString("PhoneNumber"));
				s.setSchool(rs.getString("School"));
				s.setStudentID(rs.getString("StudentID"));
				s.setName(rs.getString("Name"));
				s.setHeadPicture(rs.getString("HeadPicture"));
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

	// 增加记录
	public boolean insertUser(User s) {
		sql = "insert into User(UserID, UserName, Sex, PhoneNumber, School, StudentID, Name, HeadPicture) values(?,?,?,?,?,?,?,?)";
		boolean flag = false;
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUserID());
			ps.setString(2, s.getUserName());
			ps.setString(3, s.getSex());
			ps.setString(4, s.getPhoneNumber());
			ps.setString(5, s.getSchool());
			ps.setString(6, s.getStudentID());
			ps.setString(7, s.getName());
			ps.setString(8, s.getHeadPicture());
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

	// 修改记录
	public boolean updateUser(User s) {
		sql = "update User set UserName=?, Sex=?, PhoneNumber=?, School=?, StudentID=?, Name=?, HeadPicture=? where UserID=?";
		boolean flag = false;
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUserName());
			ps.setString(2, s.getSex());
			ps.setString(3, s.getPhoneNumber());
			ps.setString(4, s.getSchool());
			ps.setString(5, s.getStudentID());
			ps.setString(6, s.getName());
			ps.setString(7, s.getHeadPicture());
			ps.setString(8, s.getUserID());
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

	// 删除记录
	public boolean deleteUser(String userid) {
		sql = "delete from User where UserID=?";
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
