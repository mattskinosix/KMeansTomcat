
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
<script type="text/javascript">
	
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

					<li class="active" role="tab" tabindex="-1" aria-controls="store"
						aria-labelledby="ui-id-3" aria-selected="false"
						aria-expanded="false"><a href="#store" role="presentation"
						tabindex="-1" id="ui-id-2">SQL Console</a></li>
				</ul>
			</nav>
			<label>Lo scopo del data mining e' l'estrazione
				(semi)automatica di conoscenza nascosta in voluminose basi di dati
				al fine di renderla disponibile e direttamente utilizzabile. L'area
				di applicazione scelta per questo software e' la segmentazione (o
				clustering) ovvero l'individuazione di gruppi con elementi omogenei
				all'interno del gruppo e diversi da gruppo a gruppo (es.
				individuazione di gruppi di consumatori con comportamenti simili).<br>L'algoritmo
				K-means e' un algoritmo di clustering partizionale che permette di
				suddividere un insieme di oggetti in K gruppi sulla base dei loro
				attributi. E' una variante dell'algoritmo di
				aspettativa-massimizzazione (EM) il cui obiettivo e' determinare i K
				gruppi di dati generati da distribuzioni gaussiane. Si assume che
				gli attributi degli oggetti possano essere rappresentati come
				vettori, e che quindi formino uno spazio vettoriale.
			</label> <img alt="cluster" align="right"
				src="http://pro.arcgis.com/en/pro-app/tool-reference/spatial-statistics/GUID-A06A412D-2F4F-4D35-8FFF-1F4B3B3A8F16-web.png">
			<div id="db">
				<form method="get" action="LearnFromDb">
					<%
						if (session.getAttribute("salva") != "1") {
					%>
					<label for="k">k:</label> <br /> <input type="number" value="1"
						min="0" name="k" id="k" /> <br /> <label for="table">table:</label>
					<br /> <input type="text" name="table" id="table" /> <br /> <br />
					<button type="submit" class="btn btn-success btn-lg ">Cluster</button>
					<br /> <br />
					<%
						}
					%>
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
						if (session.getAttribute("salva") == "1") {
					%>
					<label for="nomeFile">Nome del file:</label> <br /> <input
						type="text" name="nomeFile" id="nomeFile" /> <br /> <br />
					<button type="submit" class="btn btn-success btn-lg ">Salva</button>
					<br /> <br />
					<button type="submit" class="btn btn-success btn-lg ">Indietro</button>
					<%
						}
					%>
					<p>${mining}</p>
				</form>
			</div>
			<div id="file">

				<form method="get" action="LearnFromFile">
					<label for="name">Name:</label><br /> <input type="text" required
						name="name" id="name" /><br> <label for="nameTab">Name
						Table:</label><br /> <input type="text" required name="nameTab"
						id="nameTab" />


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
			<div id="store">
				<form method="get" action="ExecuteQuery">
					<label for="query">Scrivi la query qui: </label><br />
					<textarea name="query" id="query" class="form-control" cols="100"
						rows="10"></textarea>
					<!-- 
					<label for="name">Nome tabella:</label><br /> <input type="text"
						required name="nameTable" id="nameTable" /><br> <br> <label
						for="type">Tipo:</label> <select name="type" id="type">
						<option value="varchar(20)">varchar</option>
						<option value="int">int</option>
						<option value="float">float</option>
						<option value="double">double</option>
					</select><br> <label for="var">Nome variabile:</label><br /> <input
						type="text" required name="var" id="var" /> <label for="query">Scrivi
						la query qui: </label><br /> <input type="text" align="right"
						width="48" height="48" required name="quey" id="query" />
					<button id="add" type="button" onclick="matteo()"
						class="btn btn-success btn-lg">+</button>
					<ul id='list'></ul>

					<script>
						function matteo() {
							//window.alert(5 + 6);
							var text2 = document.getElementById("type").value;
							var text = document.getElementById("var").value;
							clean();
							var list = [];
							var node = document.createElement("li");
							var textnode = document.createTextNode(text + " - "
									+ text2);
							node.appendChild(textnode);
							document.getElementById("list").appendChild(node);
							window.alert(5 + 6);
						}
						function clean() {
							document.getElementById("var").value = "";
						}
					</script>
 -->
					<%
						if (session.getAttribute("selectedTab") == "store") {
					%>
					<script>
						location.hash = "store";
					</script>
					<%
						}
					%>

					<button type="submit" class="btn btn-success btn-lg ">Esegui
						Query</button>
					<p>${error}</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>