package com.MyClub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyClub.JDBC.JDBC;
import com.MyClub.vo.ClubFeesInfo;

public class ClubFeesInfoDao {
	private JDBC util = new JDBC(); // 数据库连接类对象
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null; // 操作语句

	// 查询全部记录
	public List<ClubFeesInfo> queryAll() {
		sql = "select * from ClubFeesInfo";
		conn = util.getConnection();
		List<ClubFeesInfo> list = new ArrayList<ClubFeesInfo>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClubFeesInfo s = new ClubFeesInfo();
				s.setId(rs.getInt("id"));
				s.setClubID(rs.getString("ClubID"));
				s.setUserID(rs.getString("UserID"));
				s.setFees(rs.getFloat("Fees"));
				s.setTime(rs.getDate("Time"));
				s.setFeesType(rs.getString("FeesType"));
				s.setRemarks(rs.getString("Remarks"));
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

	// 根据社团号查单条记录
	public List<ClubFeesInfo> queryClubFeesInfoByClubID(String Clubid) {
		sql = "select * from ClubFeesInfo where ClubID=?";
		conn = util.getConnection();
		List<ClubFeesInfo> list = new ArrayList<ClubFeesInfo>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Clubid);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClubFeesInfo s = new ClubFeesInfo();
				s.setId(rs.getInt("id"));
				s.setClubID(rs.getString("ClubID"));
				s.setUserID(rs.getString("UserID"));
				s.setFees(rs.getFloat("Fees"));
				s.setTime(rs.getDate("Time"));
				s.setFeesType(rs.getString("FeesType"));
				s.setRemarks(rs.getString("Remarks"));
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
	public List<ClubFeesInfo> queryClubFeesInfoByUserID(String Userid) {
		sql = "select * from ClubFeesInfo where UserID=?";
		conn = util.getConnection();
		List<ClubFeesInfo> list = new ArrayList<ClubFeesInfo>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClubFeesInfo s = new ClubFeesInfo();
				s.setId(rs.getInt("id"));
				s.setClubID(rs.getString("ClubID"));
				s.setUserID(rs.getString("UserID"));
				s.setFees(rs.getFloat("Fees"));
				s.setTime(rs.getDate("Time"));
				s.setFeesType(rs.getString("FeesType"));
				s.setRemarks(rs.getString("Remarks"));
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

	// 根据社团号和用户号查单条记录
	public ClubFeesInfo queryClubFeesInfoByClubIDandUserID(String Clubid, String Userid) {
		ClubFeesInfo s = new ClubFeesInfo();
		sql = "select * from ClubFeesInfo where ClubID=? and UserID=?";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Clubid);
			ps.setString(2, Userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt("id"));
				s.setClubID(rs.getString("ClubID"));
				s.setUserID(rs.getString("UserID"));
				s.setFees(rs.getFloat("Fees"));
				s.setTime(rs.getDate("Time"));
				s.setFeesType(rs.getString("FeesType"));
				s.setRemarks(rs.getString("Remarks"));
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
	public boolean insertClubFeesInfo(ClubFeesInfo s) {
		sql = "insert into ClubFeesInfo(ClubID, UserID, Fees, Time, FeesType, Remarks) values(?,?,?,?,?,?)";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getClubID());
			ps.setString(2, s.getUserID());
			ps.setFloat(3, s.getFees());
			ps.setDate(4, s.getTime());
			ps.setString(5, s.getFeesType());
			ps.setString(6, s.getRemarks());
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
	public boolean updateClubFeesInfo(ClubFeesInfo s) {
		sql = "update ClubFeesInfo set ClubID=?, UserID=?, Fees=?, Time=?, FeesType=?, Remarks=? where id=?";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getClubID());
			ps.setString(2, s.getUserID());
			ps.setFloat(3, s.getFees());
			ps.setDate(4, s.getTime());
			ps.setString(5, s.getFeesType());
			ps.setString(6, s.getRemarks());
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
	public boolean deleteClubFeesInfo(int id) {
		sql = "delete from ClubFeesInfo where id=?";
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
