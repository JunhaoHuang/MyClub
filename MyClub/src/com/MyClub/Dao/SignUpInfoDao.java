package com.MyClub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyClub.JDBC.JDBC;
import com.MyClub.vo.SignUpInfo;

public class SignUpInfoDao {
	private JDBC util = new JDBC(); // 数据库连接类对象
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null; // 操作语句

	// 查询全部记录
	public List<SignUpInfo> queryAll() {
		sql = "select * from SignUpInfo";
		conn = util.getConnection();
		List<SignUpInfo> list = new ArrayList<SignUpInfo>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				SignUpInfo s = new SignUpInfo();
				s.setId(rs.getInt("id"));
				s.setActivityID(rs.getString("ActivityID"));
				s.setUserID(rs.getString("UserID"));
				s.setStatus(rs.getString("Status"));
				s.setExperience(rs.getString("Experience"));
				s.setComment(rs.getString("Comment"));
				s.setTime(rs.getDate("Time"));
				s.setSelfEvaluation(rs.getString("SelfEvaluation"));
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

	// 根据活动号查单条记录
	public List<SignUpInfo> querySignUpInfoByActivityID(String Activityid) {
		sql = "select * from SignUpInfo where ActivityID=?";
		conn = util.getConnection();
		List<SignUpInfo> list = new ArrayList<SignUpInfo>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Activityid);
			rs = ps.executeQuery();
			while (rs.next()) {
				SignUpInfo s = new SignUpInfo();
				s.setId(rs.getInt("id"));
				s.setActivityID(rs.getString("ActivityID"));
				s.setUserID(rs.getString("UserID"));
				s.setStatus(rs.getString("Status"));
				s.setExperience(rs.getString("Experience"));
				s.setComment(rs.getString("Comment"));
				s.setTime(rs.getDate("Time"));
				s.setSelfEvaluation(rs.getString("SelfEvaluation"));
				list.add(s);
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
		return list;
	}

	// 根据用户号查单条记录
	public List<SignUpInfo> querySignUpInfoByUserID(String Userid) {
		sql = "select * from SignUpInfo where UserID=?";
		conn = util.getConnection();
		List<SignUpInfo> list = new ArrayList<SignUpInfo>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				SignUpInfo s = new SignUpInfo();
				s.setId(rs.getInt("id"));
				s.setActivityID(rs.getString("ActivityID"));
				s.setUserID(rs.getString("UserID"));
				s.setStatus(rs.getString("Status"));
				s.setExperience(rs.getString("Experience"));
				s.setComment(rs.getString("Comment"));
				s.setTime(rs.getDate("Time"));
				s.setSelfEvaluation(rs.getString("SelfEvaluation"));
				list.add(s);
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
		return list;
	}

	// 根据活动号和用户号查单条记录
	public SignUpInfo querySignUpInfoByActivityIDandUserID(String Activityid, String Userid) {
		SignUpInfo s = new SignUpInfo();
		sql = "select * from SignUpInfo where ActivityID=? and UserID=?";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Activityid);
			ps.setString(2, Userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt("id"));
				s.setActivityID(rs.getString("ActivityID"));
				s.setUserID(rs.getString("UserID"));
				s.setStatus(rs.getString("Status"));
				s.setExperience(rs.getString("Experience"));
				s.setComment(rs.getString("Comment"));
				s.setTime(rs.getDate("Time"));
				s.setSelfEvaluation(rs.getString("SelfEvaluation"));
			} else {
				s = null;
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
		return s;
	}

	// 增加记录
	public boolean insertSignUpInfo(SignUpInfo s) {
		sql = "insert into SignUpInfo(ActivityID, UserID, Status, Experience, Comment, Time, SelfEvaluation) values(?,?,?,?,?,?,?)";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getActivityID());
			ps.setString(2, s.getUserID());
			ps.setString(3, s.getStatus());
			ps.setString(4, s.getExperience());
			ps.setString(5, s.getComment());
			ps.setDate(6, s.getTime());
			ps.setString(7, s.getSelfEvaluation());
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
	public boolean updateSignUpInfo(SignUpInfo s) {
		sql = "update SignUpInfo set ActivityID=?, UserID=?, Status=?, Experience=?, Comment=?, Time=?, SelfEvaluation=? where id=?";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUserID());
			ps.setString(2, s.getStatus());
			ps.setString(3, s.getExperience());
			ps.setString(4, s.getComment());
			ps.setDate(5, s.getTime());
			ps.setString(6, s.getSelfEvaluation());
			ps.setString(7, s.getActivityID());
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
	public boolean deleteSignUpInfo(int id) {
		sql = "delete from SignUpInfo where id=?";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
