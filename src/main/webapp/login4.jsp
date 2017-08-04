<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="baseUrl" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>测试测试</title>
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<script type="text/javascript" src="/sys/js/jquery-1.9.1.min.js.js"></script>
		<script type="text/javascript">
            //登录提示方法
            function login() {
                $("#loginform").submit();

            }
		</script>
	</head>

	<body  >
	<form id="loginform" action="${baseUrl}/user/login.do" method="post">
		<TABLE class="tab" border="0" cellSpacing="6" cellPadding="8">
			<TBODY>
			<TR>
				<TD>用户名：</TD>
				<TD colSpan="2"><input type="text" id="usercode"
									   name="username" style="WIDTH: 130px" /></TD>
			</TR>
			<TR>
				<TD>密 码：</TD>
				<TD><input type="password" id="pwd" name="password" style="WIDTH: 130px" />
				</TD>
			</TR>
			<%--<TR>
				<TD>验证码：</TD>
				<TD><input id="randomcode" name="randomcode" size="8" /> <img
						id="randomcode_img" src="${baseurl}validatecode.jsp" alt=""
						width="56" height="20" align='absMiddle' /> <a
						href=javascript:randomcode_refresh()>刷新</a></TD>
			</TR>--%>
			<tr>
				<TD></TD>
				<td><input type="checkbox" name="rememberMe" />自动登陆</td>
			</tr>

			<TR>
				<TD colSpan="2" align="center"><input type="button"
													  class="btnalink" onclick="login()" value="登&nbsp;&nbsp;录" />
					<input type="reset" class="btnalink" value="重&nbsp;&nbsp;置" /></TD>
			</TR>
			</TBODY>
		</TABLE>

	</form>
	</body>
</html>

