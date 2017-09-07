package action;

import java.util.List;  
import java.util.Map;  
  
import beans.Userinfo;  
  
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;  
  
import dao.UserinfoDAO;  
import daoimpl.UserinfoDAOImpl;  
  
/** 
 * @author ZTE 
 *  
 */  
public class UserinfoAction extends ActionSupport {  
    private int userid;  
  
    public int getUserid() {  
        return userid;  
    }  
  
    public void setUserid(int userid) {  
        this.userid = userid;  
    }  
  
    private Userinfo userinfo;  
  
    public Userinfo getUserinfo() {  
        return userinfo;  
    }  
  
    public void setUserinfo(Userinfo userinfo) {  
        this.userinfo = userinfo;  
    }  
  
    private String username;  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    private String password;  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public String getSex() {  
        return sex;  
    }  
  
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
  
    private String sex;  
  
    /** 
     *  
     */  
    public UserinfoAction() {  
        // TODO Auto-generated constructor stub  
    }  
  
    @Override  
    public String execute() throws Exception {  
        // TODO Auto-generated method stub  
        listAllUserinfo();  
        return SUCCESS;  
    }  
  
    // 显示所有用户信息  
    public String listAllUserinfo() throws Exception {  
        String result = "";  
        UserinfoDAO userinfoDAO = new UserinfoDAOImpl();  
        List userinfoList = userinfoDAO.searcherAllUserinfo();  
        if (userinfoList != null) {  
            ActionContext ctx = ActionContext.getContext();  
            Map map = ctx.getSession();  
            map.put("userinfoList", userinfoList);  
            System.out.println("userinfoList.size():" + userinfoList.size());  
            result = "show";  
        } else {  
            result = "error";  
        }  
        return result;  
  
    }  
  
    // 增加一个用户信息  
    public String addUserinfo() throws Exception {  
        String result = "";  
        UserinfoDAO userinfoDAO = new UserinfoDAOImpl();  
        // 首先查询该用户名称是否存在  
        boolean isExists = userinfoDAO.isExistUserinfo(this.username);  
        if (isExists) {// 如果已经存在  
            result = "input";  
        } else {// 名称不存在  
            boolean adduserinfoResult = userinfoDAO.addUserinfo(this.userid,  
                    this.username, this.password, this.sex);  
            if (adduserinfoResult) {  
                result = this.listAllUserinfo();  
            } else {  
                result = "error";  
            }  
        }  
        return result;  
  
    }  
  
    // 预处理更新一个用户信息  
    public String preupdateUserinfo() throws Exception {  
        String result = "";  
        // 1.根据用户id来获取用户信息  
        UserinfoDAO userinfoDAO = new UserinfoDAOImpl();  
        userinfo = userinfoDAO.searcherUserinfoByID(userid);  
  
        if (userinfo != null) {  
            // 2.将用户信息列表保存到内存中  
            ActionContext ctx = ActionContext.getContext();  
            Map map = ctx.getSession();  
            map.put("userinfo", userinfo);  
            result = "update";  
        } else {  
            result = "error";  
        }  
        return result;  
    }  
  
    // 更新一个用户信息  
    public String updateUserinfo() throws Exception {  
        String result = "";  
        UserinfoDAO userinfoDAO = new UserinfoDAOImpl();  
        System.out.println("this.userid:" + this.userid);  
        boolean updateuserinfoResult = userinfoDAO.updateUserinfo(this.userid,  
                this.username, this.password, this.sex);  
        if (updateuserinfoResult) {  
            result = this.listAllUserinfo();  
        } else {  
            result = "error";  
        }  
        return result;  
    }  
  
    // 删除一个用户信息  
    public String deleteUserinfo() throws Exception {  
        System.out.println("进入到删除功能……");  
        String result = "";  
        UserinfoDAO userinfoDAO = new UserinfoDAOImpl();  
        Userinfo userinfo = userinfoDAO.searcherUserinfoByID(this.userid);  
        System.out.println("userid=" + userid);  
        System.out.println("userinfo=" + userinfo);  
        boolean deleteuserinfoResult = userinfoDAO.deleteUserinfo(userinfo);  
  
        if (deleteuserinfoResult) {  
            result = this.listAllUserinfo();  
        } else {  
            result = "error";  
        }  
        System.out.println("退出删除功能……");  
        return result;  
    }  
  
    // 根据userid来查询用户信息  
    public String searcherUserinfoByID() throws Exception {  
        String result = "";  
        UserinfoDAO userinfoDAO = new UserinfoDAOImpl();  
        Userinfo u = userinfoDAO.searcherUserinfoByID(userid);  
        u.setUserid(userinfo.getUserid());  
        if (u != null) {  
            result = this.listAllUserinfo();  
        } else {  
            result = "error";  
        }  
        return result;  
    }  
}  
