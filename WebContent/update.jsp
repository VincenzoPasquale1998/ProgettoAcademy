<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Auto</title>
</head>
<body>
<div>
    <form action="update" method="post">
        <input type="text" id="id2" name="id2" value="${auto.id}" hidden="true" required><br>
        <label for="nome">Nome</label>
        <input type="text" id="nome" name="nome" value="${auto.nome}" required><br>
        <label for="marca">Marca</label>
        <input type="text" id="marca" name="marca" value="${auto.marca}"  required><br>
        <label for="modello">Modello</label>
        <input type="text" id="modello" name="modello" value="${auto.modello}"  required><br>
        <label for="descrizione">Descrizione</label>
        <input type="text" id="descrizione" name="descrizione" value="${auto.descrizione}"  required><br>
        <label for="prezzo">Prezzo:</label>
        <input type="text" id="prezzo" name="prezzo" value="${auto.prezzo}"><br><br>
        <label for="foto">Foto:</label>
        <input type="file" id="foto" name="foto" value="${auto.foto}"><br><br>
        <button type="reset">Reset</button>
        <button type="submit">Salva modifica</button>
    </form> 
</div>

</body>
</html>