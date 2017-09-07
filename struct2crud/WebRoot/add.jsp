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
      
    <title>My JSP 'add.jsp' starting page</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">  
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
        <link rel="stylesheet" type="text/css" href="styles.css"> 
        -->  
      
    </head>  
    <s:head />  
    <body>  
    <center>
        <h1>增加用户</h1>  
        <s:form action="userinfoControl!addUserinfo.action">  
            <table>  
      
                <tr>  
                    <td align="center"><s:textfield label="用户ID" name="userid" />  
                    </td>  
                    <td align="center"><s:textfield label="用户名" name="username" />  
                    </td>  
                    <td align="center"><s:textfield label="密码" name="password" />  
                    </td>  
                    <td align="center"><s:select list="{'男','女'}" label="性别" name="sex"></s:select>  
                    </td>  
                    <td colspan="2" align="center"><input type="submit" value="提交" />  
                        <input type="reset" value="重置" /></td>  
      
      
      
                </tr>  
            </table>  
        </s:form>  
        </center>
    </body>  
    </html>  