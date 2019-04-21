<%--
  Created by IntelliJ IDEA.
  User: ZP
  Date: 2019/4/21
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
</head>
<script type="text/javascript" src="jQuery/jquery-1.11.0.js"></script>
<style>
    .zjx-form-uploadPath{
        position: absolute;
        left: 0;
        top: 0;
        width: 100%;
        text-align: left;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        text-indent: 10px;
    }
</style>
<body>
上传图片<br><br>
<input type="file" name="" id="img" onchange="img(this);">
<%--<img src="http://172.16.53.105/" id="showImg">--%>
<img src="http://172.16.5.19:8080/docservice/uploadImage/b55e1c1c9d17a10bc70753f58efca8c1/0be5a6c82893ecaa8bb29bd36831e457/orgLegalIdentityImg/20190421/tecdc53app7r.jpg" id="showImg">
<%--<span class="zjx-form-uploadPath" id="chooseImg">点击选择文件</span>--%>
</body>
</html>
<script type="text/javascript">

        function img(file) {

            alert(file);

        }


    
    
</script>
