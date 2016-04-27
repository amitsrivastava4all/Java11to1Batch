<%@page import="com.brainmentors.ims.cache.dto.CacheDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.brainmentors.ims.common.utils.CacheConstants"%>
<%@page import="com.brainmentors.ims.common.listener.CacheListener"%>
<%@page import="com.brainmentors.ims.common.dao.CacheDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Add New User :::
<input type="text" placeholder="Type UserName"/>
Choose Your Role :
<select>
<%
List<CacheDTO> cacheList =CacheListener.getCacheMap(CacheConstants.ROLE_KEY);
for(CacheDTO cacheDTO : cacheList){
%>
<option <%=cacheDTO.getDesc() %>><%=cacheDTO.getValue() %></option>
<%
}
%>
</select>
</body>
</html>