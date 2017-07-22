package com.MyClub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyClub.JDBC.JDBC;
import com.MyClub.vo.Information;

public class InformationDao {
	private JDBC util = new JDBC(); // ���ݿ����������
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null; // �������

	// ��ѯȫ����¼
	public List<Information> queryAll() {
		sql = "select * from Information";
		conn = util.getConnection();
		List<Information> list = new ArrayList<Information>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Information s = new Information();
				s.setInforID(rs.getInt("InforID"));
				s.setUserID(rs.getString("UserID"));
				s.setSourceID(rs.getString("SourceID"));
				s.setInfoContent(rs.getString("InfoContent"));
				s.setTime(rs.getDate("Time"));
				s.setInfoType(rs.getString("InfoType"));
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

	// ������Դ�Ų鵥����¼
	public List<Information> queryInformationBySourceID(String SourceID) {
		sql = "select * from Information where SourceID=?";
		conn = util.getConnection();
		List<Information> list = new ArrayList<Information>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, SourceID);
			rs = ps.executeQuery();
			while (rs.next()) {
				Information s = new Information();
				s.setInforID(rs.getInt("InforID"));
				s.setUserID(rs.getString("UserID"));
				s.setSourceID(rs.getString("SourceID"));
				s.setInfoContent(rs.getString("InfoContent"));
				s.setTime(rs.getDate("Time"));
				s.setInfoType(rs.getString("InfoType"));
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

	// �����û��Ų鵥����¼
	public List<Information> queryInformationByUserID(String Userid) {
		sql = "select * from Information where UserID=?";
		conn = util.getConnection();
		List<Information> list = new ArrayList<Information>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Information s = new Information();
				s.setInforID(rs.getInt("InforID"));
				s.setUserID(rs.getString("UserID"));
				s.setSourceID(rs.getString("SourceID"));
				s.setInfoContent(rs.getString("InfoContent"));
				s.setTime(rs.getDate("Time"));
				s.setInfoType(rs.getString("InfoType"));
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

	// ������Դ�ź��û��Ų鵥����¼
	public Information queryInformationBySourceIDandUserID(String SourceID, String Userid) {
		Information s = new Information();
		sql = "select * from Information where SourceID=? and UserID=?";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, SourceID);
			ps.setString(2, Userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setInforID(rs.getInt("InforID"));
				s.setUserID(rs.getString("UserID"));
				s.setSourceID(rs.getString("SourceID"));
				s.setInfoContent(rs.getString("InfoContent"));
				s.setTime(rs.getDate("Time"));
				s.setInfoType(rs.getString("InfoType"));
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

	// ���Ӽ�¼
	public boolean insertInformation(Information s) {
		sql = "insert into Information(UserID, SourceID, InfoContent, Time, InfoType) values(?,?,?,?,?)";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUserID());
			ps.setString(2, s.getSourceID());
			ps.setString(3, s.getInfoContent());
			ps.setDate(4, s.getTime());
			ps.setString(5, s.getInfoType());
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
	public boolean updateInformation(Information s) {
		sql = "update Information set UserID=?, SourceID=?, InfoContent=?, Time=?, InfoType=? where InfoID=?";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getUserID());
			ps.setString(2, s.getSourceID());
			ps.setString(3, s.getInfoContent());
			ps.setDate(4, s.getTime());
			ps.setString(5, s.getInfoType());
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
	public boolean deleteInformation(int Infoid) {
		sql = "delete from Information where InfoID=?";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Infoid);
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
