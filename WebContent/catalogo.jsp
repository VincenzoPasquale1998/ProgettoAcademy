<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Catalogo Automobili</title>
</head>
<body>
	<h1>Catalogo Automobili</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Marca</th>
				<th>Modello</th>
				<th>Prezzo</th>
				<th>Descrizione</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="auto" items="${listaAuto}">
				<tr>
					<td>${auto.nome}</td>
					<td>${auto.marca}</td>
					<td>${auto.modello}</td>
					<td>${auto.prezzo}</td>
					<td>${auto.descrizione}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>