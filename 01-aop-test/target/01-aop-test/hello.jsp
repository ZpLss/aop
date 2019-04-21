<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<script type="text/javascript" src="jQuery/jquery-1.11.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty list1}">
    <p id="button">Hello World</p>
</c:if>

<div id="app">
    <div>
        {{stu.name}}
    </div>
</div>
<div>lang : ${lang}
</div>

<input type="file" accept="image/png,application/pdf" onchange="upLoadFile(this),upLoadImage()">

<script>
    function upLoadFile(obj) {
        alert(obj.value)
        var formData = new FormData();
        console.log(formData)
    }
    function upLoadImage() {
        alert(123)

    }

    $(function () {
        $("#button").click(function () {
            alert(123)
            location.reload();

        })
    })

    var stu = JSON.parse('${stu1}')
    var app = new Vue({
        el : '#app',
        data : {
            message : 'Hello Vue!',
            stu: stu
        }
    })

</script>
</body>
</html>
