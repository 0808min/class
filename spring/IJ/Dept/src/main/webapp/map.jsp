<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-30
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <title>Kakao 지도 시작하기</title>
</head>
<body>
<div id="map" style="width:500px;height:400px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=883e94ddc431c0e0f63b2884a87e7634"></script>
<script>
  var container = document.getElementById('map');
  var options = {
    center: new kakao.maps.LatLng(33.450701, 126.570667),
    level: 3
  };

  var map = new kakao.maps.Map(container, options);
</script>
</body>
</html>
