<!DOCTYPE html>
<html>
<head>
<title>Login and Registration Page</title>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">

<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery-ui.js"></script>

<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>

</head>

<body>
	<div class="wrapper">
		<div class="container">
			<div id="tabs">
				<ul>
					<li><a href="#login">Cluster DB</a></li>
					<li><a href="#register">Leggi Da File</a></li>
				</ul>
				<div id="login">
					<% 
  	if((String)session.getAttribute("error") != null){ %>
					<h4>Invalid Email or Password. Please try again.</h4>
					<%} %>
					<form method="get" action="LearnFromDb">
						<label for="k">k:</label> <br /> <input type="number"
							name="k" id="k" /> <br /> <label for="table">table:</label>
						<br /> <input type="text" name="table" id="table" /> <br />
						<br /> <input type="submit" value="Cluster!">
						
					</form>
				</div>
				<div id="register">
					<% 
  	if((String)session.getAttribute("errorReg") != null){ %>
					<h4><%=session.getAttribute("errorReg") %></h4>
					<%} %>
					<form method="get" action="LearnFromFile">
						<label for="name">Name:</label><br /> <input type="text"
							name="name" id="name" />
						<p>Output: ${mining}</p>
					</form>
					
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>