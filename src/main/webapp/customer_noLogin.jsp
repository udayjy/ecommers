<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Sign in</title>
<style type="text/css">
body {
	background-color: #ba0000;
	font-family: 'Ubuntu', sans-serif;
}

.main {
	background-color: #FFFFFF;
	width: 400px;
	height: 430px;
	margin: 7em auto;
	border-radius: 1.5em;
	box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}


.sign {
	padding-top: 40px;
	color: red;
	font-family: 'Ubuntu', sans-serif;
	font-weight: bold;
	font-size: 23px;
}

.un {
	width: 76%;
	color: rgb(38, 50, 56);
	font-weight: 700;
	font-size: 14px;
	letter-spacing: 1px;
	background: rgba(136, 126, 126, 0.04);
	padding: 10px 20px;
	border: none;
	border-radius: 20px;
	outline: none;
	box-sizing: border-box;
	border: 2px solid rgba(0, 0, 0, 0.02);
	margin-bottom: 50px;
	margin-left: 46px;
	text-align: center;
	margin-bottom: 27px;
	font-family: 'Ubuntu', sans-serif;
}

form.form1 {
	padding-top: 40px;
}

.pass {
	width: 76%;
	color: rgb(38, 50, 56);
	font-weight: 700;
	font-size: 14px;
	letter-spacing: 1px;
	background: rgba(136, 126, 126, 0.04);
	padding: 10px 20px;
	border: none;
	border-radius: 20px;
	outline: none;
	box-sizing: border-box;
	border: 2px solid rgba(0, 0, 0, 0.02);
	margin-bottom: 50px;
	margin-left: 46px;
	text-align: center;
	margin-bottom: 27px;
	font-family: 'Ubuntu', sans-serif;
}

.error-box{
	width: 100%;
	color: red;
	font-weight: 700;
	font-size: 11px;
	letter-spacing: 1px;
	background: rgba(0, 0, 0, 0);
	margin-top: 30px;
	margin-left: 10px;
	text-align: center;
	font-family: 'Ubuntu', sans-serif;
}

.un:focus, .pass:focus {
	border: 2px solid rgba(0, 0, 0, 0.18) !important;
}

.submit {
	cursor: pointer;
	border-radius: 5em;
	color: #fff;
	background: linear-gradient(to right, red, red);
	border: 0;
	padding-left: 40px;
	padding-right: 40px;
	padding-bottom: 10px;
	padding-top: 10px;
	font-family: 'Ubuntu', sans-serif;
	margin-left: 35%;
	font-size: 13px;
	box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
}

.forgot {
	text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
	color: #E1BEE7;
	padding-top: 15px;
}

a {
	text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
	color: #E1BEE7;
	text-decoration: none
}

@media ( max-width : 600px) {
	.main {
		border-radius: 0px;
	}
}
</style>
<script>
	function signIn(){
		document.Form1.action = "Controller_customerLogin";
	}
</script>
</head>
<body>
	<div class="main">
		<p class="sign" align="center">Sign in</p>
		<form name="Form1" method="post" class="form1">
			<input class="un" type="text" align="center" placeholder="Username" name=customerName">
			<input class="pass" type="password" align="center" placeholder="Password" name="customerPassword">
			<input onclick="signIn()" type="submit" class="submit" align="center" value="Sign in">
			<p class="error-box">Username or Password is not correct, Please try again</p>
			<p class="forgot" align="center"> <a href="./customerRegister.jsp">Register</a></p>
		</form>
	</div>
</body>
</html>