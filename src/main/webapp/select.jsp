<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-01-15
  Time: 上午 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-1.12.4.js"></script>
    <script type="text/javascript">
        function aa(id) {
            if(confirm("确定要删除吗")){
            $.ajax({
                "url":"pp",
                "type":"GET",
                "data":"type=del&id="+id,
                "dataType":"text",
                "success":a
            })
                function a(data) {
                    if(data=="true"){
                   $("#a"+id).parent().remove()
                    }else{
                        alert("删除失败");
                    }
                }
            }
        }
    </script>
</head>
<body>
<form action="" method="post">
    <table border="1">
        <tr>
            <td colspan="5">图书信息</td>
        </tr>
        <tr>
            <td>图书名称</td>
            <td>作者</td>
            <td>购买时间</td>
            <td>图书分类</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="f">
        <tr>
            <td>${f.id}</td>
            <td>${f.name}</td>
            <td>${f.author}</td>
            <td>${f.time}</td>
            <td id="a${f.id}"><a id="d" href="javascript:aa(${f.id})">删除</a></td>
        </tr>
        </c:forEach>
    </table>
    <a href="add.jsp">新增图书信息</a>
</form>
</body>
</html>
