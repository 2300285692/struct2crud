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
  
    private Connection con;// 与特定数据库的连接（会话）。  
    private PreparedStatement pstmt;// 预编译的 SQL 语句的对象。  
    private ResultSet rs;// 表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。  
    private DBConn db;  
  
    public UserinfoDAOImpl() {  
        // TODO Auto-generated constructor stub  
        db = new DBConn();  
    }  
  
    // 增加方法  
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
  
    // 更新方法  
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
            System.out.println("更新的username:" + username);  
            System.out.println("更新的password:" + password);  
            System.out.println("更新的sex:" + sex);  
            System.out.println("更新的userid:" + userid);  
            if (i > 0) {  
                result = true;  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
  
    // 删除方法  
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
  
    // 查询所有，获取列表  
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
  
    // 根据用户ID来查询所得记录  
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
  
    // 根据用户名来判断是否已经存在该用户  
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