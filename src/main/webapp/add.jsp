<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-01-15
  Time: 上午 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {
             $("[type=submit]").click(function () {
               if($("#xinzheng").val()==""||$("#zuoze").val()==""||
                   $("#riqi").val()==""){
                   alert("不能为空")
                   return false;

                   var reg=/^\d{4}-(0?[1-9]|1[0-2])-\d{2}$/;
                   var riqi= $("#riqi").val();
                   if(!reg.test(riqi)){
                       alert("日期格式不正确");
                       return false;
                   }
                   if ($("#ss").val()==0){
                       alert("请选择图书分类");
                       return false;
                   }
               }
               return true;
             })
        })
    </script>
</head>
<body>
<form action="pp?type=add" method="post">
    <table border="1">
        <tr>
            <td>新增图书的信息</td>
        </tr>
        <tr>
            <td>图书名称:<input type="text" name="xinzheng" id="xinzheng"></td>
        </tr>
        <tr>
            <td>图书作者：<input type="text" name="zuoze" id="zuoze"></td>
        </tr>
        <tr>
            <td>购买日期： <input type="text" name="riqi" id="riqi">yyyy-xx-ss格式</td>
        </tr>
        <tr>
            <td>图书类别：
            <select name="ss" id="ss">
                <option value="0">--请选择--</option>
                <option value="1">计算机</option>
                <option value="2">小说</option>
                <option value="3">杂</option>
            </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="增加"></td>
        </tr>
    </table>
</form>
</body>
</html>
