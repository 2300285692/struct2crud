    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <!-- jstl/el标签库 -->  
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
      
    <title>My JSP 'index.jsp' starting page</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">  
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
        <link rel="stylesheet" type="text/css" href="styles.css"> 
        -->  
    <script type="text/javascript">  
          
    function p_del() {  
      var msg = "您真的确定要删除吗？\n\n请确认！";  
      if (confirm(msg) == true) {  
       return true;  
      } else {  
       return false;  
      }  
     }  
        </script>  
    </head>  
      
    <body>  
    <center>
        <a href="<%=basePath%>userinfoControl!listAllUserinfo.action">点击获取全部数据</a>  
        <a href="<%=basePath%>add.jsp">添加</a>  
        <table class="" border="1">  
            <tr>  
                <th align="center">用户ID</th>  
                <th align="center">用户名</th>  
                <th align="center">密码</th>  
                <th align="center">性别</th>  
                <th></th>  
            </tr>  
<!--             <tr>   -->
<!--                 <th colspan="5">   -->
<!--                     <h3>这个是用Jstl/EL表达式循环遍历出来</h3>   -->
<!--                 </th>   -->
<!--             </tr>   -->
<!--             <tr>   -->
<!--                 <c:forEach items="${userinfoList}" var="u">   -->
<!--                     <tr>   -->
<!--                         <th>${u.userid}</th>   -->
<!--                         <th>${u.username}</th>   -->
<!--                         <th>${u.password}</th>   -->
<!--                         <th>${u.sex}</th>   -->
<!--                         <th align="center"><a   -->
<!--                             href="userinfoControl!preupdateUserinfo.action?userid=${u.userid}">修改</a>   -->
<!--                             <a href="userinfoControl!deleteUserinfo.action?userid=${u.userid}"   -->
<!--                             onclick="javascript:return p_del()">删除</a></th>   -->
<!--                     </tr>   -->
<!--                 </c:forEach>   -->
<!--             <tr>   -->
<!--                 <th colspan="5">   -->
<!--                     <h3>这个是用struts2标签循环遍历出来</h3>   -->
<!--                 </th>   -->
<!--             </tr>   -->
            <s:iterator value="#session.userinfoList" status="userinfoList">  
                <tr>  
                    <th align="center"><s:property value="userid" />  
                    </th>  
                    <th align="center"><s:property value="username" />  
                    </th>  
                    <th align="center"><s:property value="password" />  
                    </th>  
                    <th align="center"><s:property value="sex" /></th>  
                    <th align="center"><a  
                        href="userinfoControl!preupdateUserinfo.action?userid=<s:property value='userid'/>">修改</a>  
                        <a  
                        href="userinfoControl!deleteUserinfo.action?userid=<s:property value='userid'/>"  
                        onclick="javascript:return p_del()">删除</a></th>  
                </tr>  
            </s:iterator>  
        </table>  
        </center>
    </body>  
    </html>  