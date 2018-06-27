<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
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
<link rel="icon"
	href="https://icon-icons.com/icons2/828/PNG/512/K_icon-icons.com_66548.png">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div class="container">
		<div id="tabs">
			<nav class="navbar navbar-inverse">

				<div class="navbar-header">
					<a class="navbar-brand" href="#db">KMeans</a>
				</div>
				<ul class="nav navbar-nav">
					<li role="tab" tabindex="0" aria-controls="db"
						aria-labelledby="ui-id-1" aria-selected="true"
						aria-expanded="true" class="active"><a href="#db"
						role="presentation" tabindex="-1" id="ui-id-1">Cluster DB</a></li>
					<li class="active" role="tab" tabindex="-1" aria-controls="file"
						aria-labelledby="ui-id-2" aria-selected="false"
						aria-expanded="false"><a href="#file" role="presentation"
						tabindex="-1" id="ui-id-2">Leggi Da File</a></li>
				</ul>
			</nav>
			<div id="db">
				<form method="get" action="LearnFromDb">
					<label for="k">k:</label> <br /> <input type="number"  value="1" min="0"
						 name="k" id="k" /> <br /> <label for="table">table:</label>
					<br /> <input type="text" name="table" id="table" /> <br />
					<br />
					<button type="submit" class="btn btn-success btn-lg ">Cluster</button>
					<br /> <br />
					<%
						if (session.getAttribute("selectedTab") == "db") {
					%>
					<script>
						location.hash = "db";
					</script>
					<%
						}
					%>
					<%
						if (session.getAttribute("selectedTab") == "db") {
					%>
					<label for="nomeFile">Nome del file:</label> <br /> <input type="text"
						required name="nomeFile" id="nomeFile" /> <br /> <br />
					<button type="submit" class="btn btn-success btn-lg ">Salva</button>
					<%
						}
					%>
					<p>${mining}</p>
				</form>
			</div>
			<div id="file">

				<form method="get" action="LearnFromFile">
					<label for="name">Name:</label><br /> <input type="text" required
						name="name" id="name" />

					<%
						if (session.getAttribute("selectedTab") == "file") {
					%>
					<script>
						location.hash = "file";
					</script>
					<%
						}
					%>

					<button type="submit" class="btn btn-success btn-lg ">Leggi
						file</button>
					<p>${miningFile}</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>