package com.MyClub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyClub.JDBC.JDBC;
import com.MyClub.vo.Activity;

public class ActivityDao {
	private JDBC util = new JDBC(); // 数据库连接类对象
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null; // 操作语句

	// 查询全部记录
	public List<Activity> queryAll() {
		sql = "select * from Activity";
		conn = util.getConnection();
		List<Activity> list = new ArrayList<Activity>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Activity s = new Activity();
				s.setActivityID(rs.getString("ActivityID"));
				s.setClubID(rs.getString("ClubID"));
				s.setActivityName(rs.getString("ActivityName"));
				s.setActivityType(rs.getString("ActivityType"));
				s.setDetails(rs.getString("Details"));
				s.setActivityStatus(rs.getString("ActivityStatus"));
				s.setActivityStartTime(rs.getDate("ActivityStartTime"));
				s.setActivityEndTime(rs.getDate("ActivityEndTime"));
				s.setSignUpStartTime(rs.getDate("SignUpStartTime"));
				s.setSignUpEndTime(rs.getDate("SignUpEndTime"));
				s.setLowerLimit(rs.getInt("LowerLimit"));
				s.setUpperLimit(rs.getInt("UpperLimit"));
				s.setActivityLogo(rs.getString("ActivityLogo"));
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

	// 查单条记录
	public Activity queryActivityById(String Activityid) {
		Activity s = new Activity();
		sql = "select * from Activity where ActivityID=?";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Activityid);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setActivityID(rs.getString("ActivityID"));
				s.setClubID(rs.getString("ClubID"));
				s.setActivityName(rs.getString("ActivityName"));
				s.setActivityType(rs.getString("ActivityType"));
				s.setDetails(rs.getString("Details"));
				s.setActivityStatus(rs.getString("ActivityStatus"));
				s.setActivityStartTime(rs.getDate("ActivityStartTime"));
				s.setActivityEndTime(rs.getDate("ActivityEndTime"));
				s.setSignUpStartTime(rs.getDate("SignUpStartTime"));
				s.setSignUpEndTime(rs.getDate("SignUpEndTime"));
				s.setLowerLimit(rs.getInt("LowerLimit"));
				s.setUpperLimit(rs.getInt("UpperLimit"));
				s.setActivityLogo(rs.getString("ActivityLogo"));
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
	public boolean insertActivity(Activity s) {
		sql = "insert into Activity(ActivityID, ClubID, ActivityName, ActivityType, Details, ActivityStatus, Location, ActivityStartTime, ActivityEndTime, SignUpStartTime, SignUpEndTime, LowerLimit, UpperLimit, ActivityLogo) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getActivityID());
			ps.setString(2, s.getClubID());
			ps.setString(3, s.getActivityName());
			ps.setString(4, s.getActivityType());
			ps.setString(5, s.getDetails());
			ps.setString(6, s.getActivityStatus());
			ps.setString(7, s.getLocation());
			ps.setDate(8, s.getActivityStartTime());
			ps.setDate(9, s.getActivityEndTime());
			ps.setDate(10, s.getSignUpStartTime());
			ps.setDate(11, s.getSignUpEndTime());
			ps.setInt(12, s.getLowerLimit());
			ps.setInt(13, s.getUpperLimit());
			ps.setString(14, s.getActivityLogo());
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
	public boolean updateActivity(Activity s) {
		sql = "update Activity set ClubID =?, ActivityName=?,  Details=?, ActivityStatus=?, Location=?, ActivityStartTime=?, ActivityEndTime=?, SignUpStartTime=?, SignUpEndTime=?, LowerLimit=?, UpperLimit=?, where ActivityID=?";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getClubID());
			ps.setString(2, s.getActivityName());
			ps.setString(3, s.getActivityType());
			ps.setString(4, s.getDetails());
			ps.setString(5, s.getActivityStatus());
			ps.setString(6, s.getLocation());
			ps.setDate(7, s.getActivityStartTime());
			ps.setDate(8, s.getActivityEndTime());
			ps.setDate(9, s.getSignUpStartTime());
			ps.setDate(10, s.getSignUpEndTime());
			ps.setInt(11, s.getLowerLimit());
			ps.setInt(12, s.getUpperLimit());
			ps.setString(13, s.getActivityLogo());
			ps.setString(14, s.getActivityID());
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
	public boolean deleteActivity(String Activityid) {
		sql = "delete from Activity where ActivityID=?";
		boolean flag = false;
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Activityid);
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
