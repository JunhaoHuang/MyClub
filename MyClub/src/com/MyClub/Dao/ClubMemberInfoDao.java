package com.MyClub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyClub.JDBC.JDBC;
import com.MyClub.enums.CType;
import com.MyClub.vo.ClubMemberInfo;

public class ClubMemberInfoDao {
	private JDBC util = new JDBC(); // 数据库连接类对象
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null; // 操作语句

	// 查询全部记录
	public List<ClubMemberInfo> queryAll() {
		sql = "select * from ClubMemberInfo";
		conn = util.getConnection();
		List<ClubMemberInfo> list = new ArrayList<ClubMemberInfo>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClubMemberInfo s = new ClubMemberInfo();
				s.setId(rs.getInt("id"));
				s.setClubID(rs.getString("ClubID"));
				s.setUserID(rs.getString("UserID"));
				s.setStatus(rs.getString("Status"));
				s.setPayStatus(rs.getString("PayStatus"));
				s.setPosition(rs.getString("Position"));
				s.setJoinDate(rs.getDate("JoinDate"));
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
	public List<ClubMemberInfo> queryClubMemberInfoByClubID(String Clubid) {
		sql = "select * from ClubMemberInfo where ClubID=?";
		conn = util.getConnection();
		List<ClubMemberInfo> list = new ArrayList<ClubMemberInfo>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Clubid);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClubMemberInfo s = new ClubMemberInfo();
				s.setId(rs.getInt("id"));
				s.setClubID(rs.getString("clubid"));
				s.setUserID(rs.getString("userid"));
				s.setStatus(rs.getString("status"));
				s.setPayStatus(rs.getString("paystatus"));
				s.setPosition(rs.getString("position"));
				s.setJoinDate(rs.getDate("joindate"));
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
	public List<ClubMemberInfo> queryClubMemberInfoByUserID(String Userid) {
		sql = "select * from ClubMemberInfo where UserID=?";
		conn = util.getConnection();
		List<ClubMemberInfo> list = new ArrayList<ClubMemberInfo>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClubMemberInfo s = new ClubMemberInfo();
				s.setId(rs.getInt("id"));
				s.setClubID(rs.getString("clubid"));
				s.setUserID(rs.getString("userid"));
				s.setStatus(rs.getString("status"));
				s.setPayStatus(rs.getString("paystatus"));
				s.setPosition(rs.getString("position"));
				s.setJoinDate(rs.getDate("JoinDate"));
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
	
	public int countAll() {
		int num=0;
		sql = "select count(id) AS num from Clubmemberinfo";
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
	
	public int countByType(CType t) {
		int num=0;
		sql = "select count(id) AS num from Clubmemberinfo where clubid in (select clubid from club where clubtype=?)";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.toString());
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

	// 根据社团号和用户号查单条记录
	public ClubMemberInfo queryClubMemberInfoByClubIDandUserID(String Clubid, String Userid) {
		ClubMemberInfo s = new ClubMemberInfo();
		sql = "select * from ClubMemberInfo where ClubID=? and UserID=?";
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
				s.setStatus(rs.getString("Status"));
				s.setPayStatus(rs.getString("PayStatus"));
				s.setPosition(rs.getString("Position"));
				s.setJoinDate(rs.getDate("JoinDate"));
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
	public boolean insertClubMemberInfo(ClubMemberInfo s) {
		sql = "insert into ClubMemberInfo(ClubID, UserID, Status, PayStatus, Position, joinDate) values(?,?,?,?,?,?)";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getClubID());
			ps.setString(2, s.getUserID());
			ps.setString(3, s.getStatus());
			ps.setString(4, s.getPayStatus());
			ps.setString(5, s.getPosition());
			ps.setDate(6, s.getJoinDate());
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
	public boolean updateClubMemberInfo(int id) {
		sql = "update ClubMemberInfo set Position='President' where id=?";
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

	// 删除记录
	public boolean deleteClubMemberInfo(int id) {
		sql = "delete from ClubMemberInfo where id=?";
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
