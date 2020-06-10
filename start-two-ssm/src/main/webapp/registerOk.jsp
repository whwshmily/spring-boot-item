<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/logout_style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery.1.4.js"></script>
</head>
<body>
<div class="succeed">
	<div class="s_cornor_t">
		<div class="s_cornor_tl">
		</div>
		<div class="s_cornor_tr">
		</div>
	</div>
	<div class="s_cornor_c">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr>
					<td align="right" width="200">
						<img src="img/suc_05.gif" height="66" width="85"/></td>
					<td>
						<h1>
							注册成功！</h1>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<font color="#999999"><strong id="strong">3</strong>&nbsp;秒后自动返回&nbsp;<a href="/category/showAllOneLevelCategory">书城主页</a>，请稍候...</font></td>
				</tr>
				<script>
					var time = setInterval(function () {
							var value = $("#strong").text();
							value = value -1;
							$("#strong").text(value);
							if (value == 0){
								clearInterval(time);
								window.location.href = "/category/showAllOneLevelCategory";
							}
						},1000)
				</script>
				<tr>
					<td colspan="2" align="right">
						<img src="img/logo2.jpg" height="46" width="167"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="s_cornor_b">
		<div class="s_cornor_bl">
		</div>
		<div class="s_cornor_br">
		</div>
	</div>
</div>
</body>
</html>
