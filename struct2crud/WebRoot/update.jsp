    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <%@ taglib prefix="s" uri="/struts-tags"%>  
    <%  
        String path = request.getContextPath();  
        String basePath = request.getScheme() + "://"  
                + request.getServerName() + ":" + request.getServerPort()  
                + path + "/";  
    %>  
      
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
    <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'update.jsp' starting page</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">  
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
      
    </head>  
    <s:head />  
    <body>  
    <center>
        <h1>更改信息</h1>  
        <s:form action="userinfoControl!updateUserinfo.action">  
            <table>  
                <tr>  
                    <td><s:textfield label="用户ID"  
                            value="%{#session.userinfo.userid}" name="userid" readonly="true"  
                            tooltip="禁止修改" /></td>  
                    <td><s:textfield label="用户名"  
                            value="%{#session.userinfo.username}" name="username" /></td>  
                    <td><s:textfield label="密码"  
                            value="%{#session.userinfo.password}" name="password" /></td>  
      
                    <td><s:select list="{'男','女'}" label="性别"  
                            value="%{#session.userinfo.sex}" name="sex" />  
                    </td>  
                    <td colspan="2" align="center"><input type="submit" value="提交" />  
                        <input type="reset" value="重置" /></td>  
                </tr>  
            </table>  
        </s:form>  
        </center>
    </body>  
    </html>  