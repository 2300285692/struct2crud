    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
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
      
    <title>My JSP 'error.jsp' starting page</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">  
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
        <link rel="stylesheet" type="text/css" href="styles.css"> 
        -->  
      
    <script type="text/javascript">  
    //  function getTime() {  
            var now = new Date();  
            var year = now.getYear();  
            var month = now.getMonth() + 1;  
            var date = now.getDate();  
            var hours = now.getHours();  
            var mins = now.getMinutes();  
            var secs = now.getSeconds();  
            if (month < 10)  
                month = "0" + month;  
            if (date < 10)  
                date = "0" + date;  
            if (hours < 10)  
                hours = "0" + hours;  
            if (mins < 10)  
                mins = "0" + mins;  
            if (secs < 10)  
                secs = "0" + secs;  
            var timeVal = "";  
            timeVal = year + "-" + month + "-" + date + " " + hours + ":" + mins  
                    + ":" + secs;  
    //      return timeVal;  
    //  }  
        //测试  
    //  alert(getTime() + ":操作失败!!!");  
    </script>  
    </head>  
      
    <body>  
        <h1 style="color: red">  
            <script type="text/javascript">  
                document.write(timeVal);  
            </script>  
            :    操作失败!!!  
        </h1>  
        <input type="button" value="后退" onClick="history.go(-1)">  
    </body>  
    </html>  