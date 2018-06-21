<!DOCTYPE html>
<html>
<head>
<title>KMeans</title>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">

<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery-ui.js"></script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
<script>
function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}​
</script>
<link rel="icon"
	href="https://icon-icons.com/icons2/828/PNG/512/K_icon-icons.com_66548.png">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div class="container">
		<div id="tabs">
			<ul>
				<li><a href="#db">Cluster DB</a></li>
				<li><a href="#register">Leggi Da File</a></li>
			</ul>
			<div id="db">
				<%
					if ((String) session.getAttribute("error") != null) {
				%>
				<h4>Invalid Email or Password. Please try again.</h4>
				<%
					}
				%>
				<form method="get" action="LearnFromDb">
					<label for="k">k:</label> <br /> <input type="number" name="k"
						id="k" /> <br /> <label for="table">table:</label> <br /> <input
						type="text" name="table" id="table" /> <br /> <br />
					<button type="submit" class="btn btn-success btn-lg ">Cluster</button>

					<p>Output: ${mining}</p>
				</form>
			</div>
			<div id="register">
				<%
					if ((String) session.getAttribute("errorReg") != null) {
				%>
				<h4><%=session.getAttribute("errorReg")%></h4>
				<%
					}
				%>
				<form method="get" action="LearnFromFile">
					<label for="name">Name:</label><br /> <input type="text"
						name="name" id="name" />
					
					<p>file: ${selectedTab}</p>
					<script>
						location.hash = document.getElementById("selectedTab").value;
					</script>

					<button type="submit" class="btn btn-success btn-lg ">Leggi
						file</button>
					<p>Output: ${miningFile}</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>