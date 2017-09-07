package dao;

import java.util.List;  

import beans.Userinfo;  
  
/** 
 * @author ZTE 
 *  
 */  
public interface UserinfoDAO {  
    // ����û���Ϣ  
    public boolean addUserinfo(int userid,String username,String password,String sex);  
  
    // �޸��û���Ϣ  
    public boolean updateUserinfo(int userid,String username,String password,String sex);  
  
    // ɾ���û���Ϣ  
    public boolean deleteUserinfo(Userinfo userinfo);  
  
    // ��ѯ�����û���Ϣ  
    public List searcherAllUserinfo();  
  
    // ����id��ѯ��ѯָ���û���Ϣ  
    public Userinfo searcherUserinfoByID(int userid);  
  
    // �����û����Ʋ�ѯ�Ƿ����  
    public boolean isExistUserinfo(String username);  
}  