<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HttpMessageConverter Demo</title>
</head>
<body>
	<div id="resp"></div>
	<input type="button" onclick="req();" value="request">
	<script type="text/javascript" src="assets/js/jquery.js"></script>
	<script type="text/javascript">
		function req() {
			$.ajax({
				url: "convert",
				data: "1000-varhzj",
				type: "POST",
				contentType: "application/x-varhzjlab",
				success: function(data) {
					$("#resp").html(data);
				}
			});
		}
	</script>
</body>
</html>