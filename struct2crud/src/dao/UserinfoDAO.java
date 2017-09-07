package dao;

import java.util.List;  

import beans.Userinfo;  
  
/** 
 * @author ZTE 
 *  
 */  
public interface UserinfoDAO {  
    // 添加用户信息  
    public boolean addUserinfo(int userid,String username,String password,String sex);  
  
    // 修改用户信息  
    public boolean updateUserinfo(int userid,String username,String password,String sex);  
  
    // 删除用户信息  
    public boolean deleteUserinfo(Userinfo userinfo);  
  
    // 查询所有用户信息  
    public List searcherAllUserinfo();  
  
    // 根据id查询查询指定用户信息  
    public Userinfo searcherUserinfoByID(int userid);  
  
    // 根据用户名称查询是否存在  
    public boolean isExistUserinfo(String username);  
}  