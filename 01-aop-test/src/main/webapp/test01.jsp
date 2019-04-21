<%--
  Created by IntelliJ IDEA.
  User: ZP
  Date: 2018/9/28
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="jQuery/jquery-1.11.0.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<p>上传图片</p>

<form method="post" action="<%=request.getContextPath()%>/test.do" id="form">
    姓名：<input type="text" name="name" id="name" value="lisi"></br></br>
    年龄：<input type="text" name="age" id="age" value="18"></br></br>
    照片：<input type="file" name="image" id="image" onchange="upLoadImage(this)"></br></br>
    <input type="submit" value="提交" style="text-align: center">
</form>

<div  id="btn">点击</div>
</body>
</html>
<script type="text/javascript">
    $(function () {
        $("#btn").click(function () {
            var form = document.getElementById("form")
            var formData = new FormData(form);

            $.ajax({
                url:"<%=request.getContextPath()%>/test.do",
                type : "post",
                data : formData,
                processData : false,  // tell jQuery not to process the data,default true
                contentType : false,  // tell jQuery not to set contentType,default application/x-www-form-urlencoded(传参的格式，默认是简单的键值对jaon格式)
                dataType : "json",    //接收数据的格式
                success : function (data) {
                    alert(data.name)
                }
            })
        })
    })
    function upLoadImage(obj) {
        alert(obj.value)

    }

</script>
