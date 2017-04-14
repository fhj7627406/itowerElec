<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.fuhj.util.*,com.fuhj.itower.service.*,java.util.*,com.fuhj.itower.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/fonts.css" rel="stylesheet" type="text/css">
<title>FSU网络运行情况</title>
<style type="text/css">
/* CSS Document */
body {
	font: normal 13px auto Open Sans,SimSun, Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
	margin: 1px 0 0 0;
}

a {
	color: #c75f3e;
}

#mytable {
	width: 455px;
	padding: 0;
	margin: 0px;
	border-bottom: 2px solid #C1DAD7;
}

caption {
	padding: 0 0 5px 0;
	width: 455px;
	font: italic 12px Open Sans,SimSun, Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}

th {
	font: bold 12px Open Sans,SimSun, Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 5px 2px 5px 8px;
	background: #CAE8EA;
	height: 16px;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
	height: 16px;
}

td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	background: #fff;
	font-size: 13px;
	padding: 5px 2px 5px 8px;
	color: #4f6b72;
	height: 16px;
	text-align: center;
}

td.alt {
	background: #F5FAFA;
	color: #797268;
	height: 16px;
	text-align: center;
}

th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	background: #fff;
	font: bold 12px Open Sans,SimSun, Verdana, Arial, Helvetica, sans-serif;
	height: 16px;
}

th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	background: #f5fafa;
	font: bold 12px Open Sans,SimSun, Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
	height: 16px;
}
/*---------for IE 5.x bug*/
html>body td {
	font: 13px Open Sans,SimSun, Verdana, Arial, Helvetica, sans-serif;
}
</style>
</head>
<%
	StationService stationService = SpringUtil.getBean(StationService.class);
	LocationService locationService = SpringUtil.getBean(LocationService.class);
	String qid = request.getParameter("qid");
	Date queryTime = null;
	String cityName = "";
	if (qid != null && qid.length() > 0) {
		List<FSUCondItem> fsuCondList = stationService.getFSUCondByQueryId(qid);
		pageContext.setAttribute("fsuCondList", fsuCondList);
		queryTime = fsuCondList.get(0).getQuerytime();
		cityName = locationService.getCityById(fsuCondList.get(0).getItcityid()).getCname();
	}
%>
<body>
	<table id="mytable" cellspacing="0">
		<tr>
			<th colspan="5"
				style="text-align: center; border-bottom: none; border-left: 1px solid #C1DAD7;"><%=cityName%>FSU网络运行情况(
				<%=FormatUtil.getFDate(queryTime)%>)</th>
		</tr>
		<tr>
			<th style="border-left: 1px solid #C1DAD7;">区域</th>
			<th style="text-align: center;">当前停电数</th>
			<th style="text-align: center;">当前欠压数</th>
			<th style="text-align: center;" width="90px">当前一級低压脱离数</th>
			<th style="text-align: center;">当前离线/异常数</th>
		</tr>
		<c:set var="sumtd" value="0" />
		<c:set var="sumvlow" value="0" />
		<c:set var="sumdz" value="0" />
		<c:set var="sumoffline" value="0" />
		<c:forEach var="item" items="${fsuCondList}" varStatus="status">
			<c:choose>
				<c:when test="${(status.index + 1)%2!=0}">
					<tr>
						<th class="spec">${item.areaname}</th>
						<td>${item.tdcount}</td>
						<td>${item.vlowcount}</td>
						<td>${item.dzcount}</td>
						<td>${item.offlinecount}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<th class="specalt">${item.areaname}</th>
						<td class="alt">${item.tdcount}</td>
						<td class="alt">${item.vlowcount}</td>
						<td class="alt">${item.dzcount}</td>
						<td class="alt">${item.offlinecount}</td>
					</tr>
				</c:otherwise>
			</c:choose>
			<c:set var="sumtd" value="${sumtd+item.tdcount}" />
			<c:set var="sumvlow" value="${sumvlow+item.vlowcount}" />
			<c:set var="sumdz" value="${sumdz+item.dzcount}" />
			<c:set var="sumoffline" value="${sumoffline+item.offlinecount}" />
		</c:forEach>
		<tr>
			<th style="border-left: 1px solid #C1DAD7;">合计</th>
			<th style="text-align: center;">${sumtd}</th>
			<th style="text-align: center;">${sumvlow}</th>
			<th style="text-align: center;">${sumdz}</th>
			<th style="text-align: center;">${sumoffline}</th>
		</tr>
	</table>
</body>
</html>