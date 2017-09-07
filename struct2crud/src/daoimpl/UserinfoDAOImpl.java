package daoimpl;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
  
import conn.DBConn;  
import beans.Userinfo;  
import dao.UserinfoDAO;  
  
/** 
 * @author ZTE 
 *  
 */  
public class UserinfoDAOImpl implements UserinfoDAO {  
  
    private Connection con;// ���ض����ݿ�����ӣ��Ự����  
    private PreparedStatement pstmt;// Ԥ����� SQL ���Ķ���  
    private ResultSet rs;// ��ʾ���ݿ����������ݱ�ͨ��ͨ��ִ�в�ѯ���ݿ��������ɡ�  
    private DBConn db;  
  
    public UserinfoDAOImpl() {  
        // TODO Auto-generated constructor stub  
        db = new DBConn();  
    }  
  
    // ���ӷ���  
    public boolean addUserinfo(int userid, String username, String password,  
            String sex) {  
        // TODO Auto-generated method stub  
        boolean result = false;  
        try {  
            con = db.getConn();  
            String sql = "insert into userinfo(userid,username,password,sex) values(?,?,?,?)";  
            pstmt = con.prepareStatement(sql);  
            pstmt.setInt(1, userid);  
            pstmt.setString(2, username);  
            pstmt.setString(3, password);  
            pstmt.setString(4, sex);  
            int i = pstmt.executeUpdate();  
            if (i > 0) {  
                result = true;  
            }  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
  
        return result;  
    }  
  
    // ���·���  
    public boolean updateUserinfo(int userid, String username, String password,  
            String sex) {  
        // TODO Auto-generated method stub  
        boolean result = false;  
        try {  
            con = db.getConn();  
            String sql = "update userinfo set username=?,password=?,sex=? where userid=?";  
            pstmt = con.prepareStatement(sql);  
  
            pstmt.setString(1, username);  
            pstmt.setString(2, password);  
            pstmt.setString(3, sex);  
            pstmt.setInt(4, userid);  
  
            int i = pstmt.executeUpdate();  
            System.out.println("���µ�username:" + username);  
            System.out.println("���µ�password:" + password);  
            System.out.println("���µ�sex:" + sex);  
            System.out.println("���µ�userid:" + userid);  
            if (i > 0) {  
                result = true;  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
  
    // ɾ������  
    public boolean deleteUserinfo(Userinfo userinfo) {  
        // TODO Auto-generated method stub  
        boolean result = false;  
        try {  
            con = db.getConn();  
            String sql = "delete userinfo where userid=?";  
            pstmt = con.prepareStatement(sql);  
            System.out.println("userinfo.getUserid():" + userinfo.getUserid());  
            pstmt.setInt(1, userinfo.getUserid());  
            System.out.println(userinfo.getUserid());  
            int i = pstmt.executeUpdate();  
            if (i > 0) {  
                result = true;  
            }  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
  
        return result;  
    }  
  
    // ��ѯ���У���ȡ�б�  
    public List searcherAllUserinfo() {  
        // TODO Auto-generated method stub  
        List list = new ArrayList();  
        String sql = "select * from userinfo";  
        try {  
            con = db.getConn();  
            pstmt = con.prepareStatement(sql);  
  
            rs = pstmt.executeQuery();  
            while (rs.next()) {  
                int id = rs.getInt(1);  
                String name = rs.getString(2);  
                String pass = rs.getString(3);  
                String sex = rs.getString(4);  
  
                Userinfo u = new Userinfo();  
                u.setUserid(id);  
                u.setUsername(name);  
                u.setPassword(pass);  
                u.setSex(sex);  
                list.add(u);  
            }  
  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return list;  
    }  
  
    // �����û�ID����ѯ���ü�¼  
    public Userinfo searcherUserinfoByID(int userid) {  
        // TODO Auto-generated method stub  
        Userinfo userinfo = null;  
        String sql = "select * from userinfo where userid=?";  
        try {  
            con = db.getConn();  
            pstmt = con.prepareStatement(sql);  
            pstmt.setInt(1, userid);  
            rs = pstmt.executeQuery();  
            System.out.println("userid:" + userid);  
            System.out.println("sql:" + sql);  
            if (rs.next()) {  
                int id = rs.getInt("userid");  
                String username = rs.getString("username");  
                String password = rs.getString("password");  
                String sex = rs.getString("sex");  
  
                userinfo = new Userinfo();  
                userinfo.setUserid(userid);  
                userinfo.setUsername(username);  
                userinfo.setPassword(password);  
                userinfo.setSex(sex);  
            }  
  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return userinfo;  
    }  
  
    // �����û������ж��Ƿ��Ѿ����ڸ��û�  
    public boolean isExistUserinfo(String username) {  
        // TODO Auto-generated method stub  
        boolean result = false;  
        try {  
            con = db.getConn();  
            String sql = "select * from userinfo where username=?";  
            pstmt = con.prepareStatement(sql);  
            pstmt.setString(1, username);  
            rs = pstmt.executeQuery();  
            while (rs.next()) {  
                result = true;  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
  
}  