<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page import="servlet.CatalogoServlet" %>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Catalogo Automobili</title>
</head>
<body>
	<h1>Catalogo Automobili</h1>
	<%=request.getAttribute("msg") %>
	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Marca</th>
				<th>Modello</th>
				<th>Prezzo</th>
				<th>Descrizione</th>
				<th>Modifica</th>
				<th>Elimina</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listaAuto" items="${listaAuto}">
				<tr>
					<td>${listaAuto.nome}</td>
					<td>${listaAuto.marca}</td>
					<td>${listaAuto.modello}</td>
					<td>${listaAuto.prezzo}</td>
					<td>${listaAuto.descrizione}</td>
					<td><a href="update?id=${listaAuto.id}"><b>Modifica</b></a></td>
					<td><a href="elimina?id=${listaAuto.id}"><b>Elimina</b></a></td>
					<!--<td><a href="update.jsp">Modifica</a></td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>