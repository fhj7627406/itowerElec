<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>位置</title>
<style>
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#container {
	height: 100%
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=76wfLYdAjvj1IBTws7b8tfLmDhWK9twj">
	
</script>
</head>
<body>

	<div id="container"></div>
	<script type="text/javascript">
		var map = new BMap.Map("container"); // 创建地图实例
		var point = new BMap.Point(<%=request.getParameter("lng")%>, <%=request.getParameter("lat")%>); // 创建点坐标  
		map.centerAndZoom(point, 14); // 初始化地图，设置中心点坐标和地图级别
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.ScaleControl());
		map.addControl(new BMap.OverviewMapControl());
		var marker = new BMap.Marker(point); // 创建标注    
		map.addOverlay(marker);
	</script>
</body>
</html>