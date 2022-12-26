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

  <input type="text" id="sample5_address" placeholder="주소">
    <input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
      <div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>

      <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=883e94ddc431c0e0f63b2884a87e7634"></script>
<script>
  var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
          };

  //지도를 미리 생성
  var map = new daum.maps.Map(mapContainer, mapOption);
  //주소-좌표 변환 객체를 생성
  var geocoder = new daum.maps.services.Geocoder();
  //마커를 미리 생성
  var marker = new daum.maps.Marker({
    position: new daum.maps.LatLng(37.537187, 127.005476),
    map: map
  });


  function sample5_execDaumPostcode() {
    new daum.Postcode({
      oncomplete: function(data) {
        var addr = data.address; // 최종 주소 변수

        // 주소 정보를 해당 필드에 넣는다.
        document.getElementById("sample5_address").value = addr;
        // 주소로 상세 정보를 검색
        geocoder.addressSearch(data.address, function(results, status) {
          // 정상적으로 검색이 완료됐으면
          if (status === daum.maps.services.Status.OK) {

            var result = results[0]; //첫번째 결과의 값을 활용

            // 해당 주소에 대한 좌표를 받아서
            var coords = new daum.maps.LatLng(result.y, result.x);
            // 지도를 보여준다.
            mapContainer.style.display = "block";
            map.relayout();
            // 지도 중심을 변경한다.
            map.setCenter(coords);
            // 마커를 결과값으로 받은 위치로 옮긴다.
            marker.setPosition(coords)
          }
        });
      }
    }).open();
  }

</script>


</body>
</html>
