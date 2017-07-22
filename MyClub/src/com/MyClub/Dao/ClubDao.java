package com.MyClub.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MyClub.JDBC.JDBC;
import com.MyClub.enums.CType;
import com.MyClub.enums.StatusE;
import com.MyClub.vo.Club;

public class ClubDao {
	private JDBC util = new JDBC(); // ���ݿ����������
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null; // �������
	
	private final int MAX_SIZE = 20; // ÿҳ��ʾ������¼��
	
	public int getCountPage(){
        sql = "SELECT COUNT(*) AS num FROM club WHERE status = 'Pending'";   //��ѯ��¼����
		conn = util.getConnection();
        int countPage = 0;
        int total = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("num");   //totalΪ��¼��������  
            }  
              
             //    ��ҳ��=������/ÿҳ��ʾ������������ܳ���ʱֱ��ȡ��������ܳ���ʱ�������1�����һҳ����ʾ  
            countPage = (total % MAX_SIZE == 0 ? total / MAX_SIZE : total / MAX_SIZE + 1);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
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
        if (countPage != 0)
            return countPage;
        return countPage + 1;   //û�е�0ҳ�����Լ�1
    }

	// ��ѯȫ����¼
	public List<Club> queryAll(int currentPage) {
		sql = "select * from Club where status = 'Pending' LIMIT ?,?";
		conn = util.getConnection();
		List<Club> list = new ArrayList<Club>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage - 1) * MAX_SIZE);
            ps.setInt(2, MAX_SIZE);
			rs = ps.executeQuery();
			while (rs.next()) {
				Club s = new Club();
				s.setClubID(rs.getString("ClubID"));
				s.setClubName(rs.getString("ClubName"));
				s.setClubType(rs.getString("ClubType"));
				s.setSchool(rs.getString("School"));
				s.setStatus(rs.getString("Status"));
				s.setFeesStatus(rs.getBoolean("FeesStatus"));
				s.setPerFees(rs.getFloat("PerFees"));
				s.setCreateDate(rs.getDate("CreateDate"));
				s.setAbout(rs.getString("About"));
				s.setClubLogo(rs.getString("ClubLogo"));
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
	
	public int countAll() {
		int num=0;
		sql = "select count(clubid) AS num from Club";
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
		sql = "select count(clubid) AS num from Club where clubtype=?";
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

	// �鵥����¼
	public Club queryClubById(String Clubid) {
		Club s = new Club();
		sql = "select * from Club where ClubID=?";
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Clubid);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setClubID(rs.getString("ClubID"));
				s.setClubName(rs.getString("ClubName"));
				s.setClubType(rs.getString("ClubType"));
				s.setSchool(rs.getString("School"));
				s.setStatus(rs.getString("Status"));
				s.setFeesStatus(rs.getBoolean("FeesStatus"));
				s.setPerFees(rs.getFloat("PerFees"));
				s.setCreateDate(rs.getDate("CreateDate"));
				s.setAbout(rs.getString("About"));
				s.setClubLogo(rs.getString("ClubLogo"));
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
	public boolean insertClub(Club s) {
		sql = "insert into Club(ClubID, ClubName, ClubType, School, Status, FeesStatus, PerFees, CreateDate, About, ClubLogo) values(?,?,?,?,?,?,?,?,?,?)";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.getClubID());
			ps.setString(2, s.getClubName());
			ps.setString(3, s.getClubType());
			ps.setString(4, s.getSchool());
			ps.setString(5, s.getStatus());
			ps.setBoolean(6, s.getFeesStatus());
			ps.setFloat(7, s.getPerFees());
			ps.setDate(8, s.getCreateDate());
			ps.setString(9, s.getAbout());
			ps.setString(10, s.getClubLogo());
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
	public boolean updateClub(StatusE s ,String clubid) {
		sql = "update Club set Status=? where ClubID=?";
		conn = util.getConnection();
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, s.toString());
			ps.setString(2, clubid);
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
	public boolean deleteClub(String Clubid) {
		sql = "delete from Club where ClubID=?";
		boolean flag = false;
		conn = util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Clubid);
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
