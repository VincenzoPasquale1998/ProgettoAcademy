<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Automobile</title>
</head>
<body>
    <form action="admin" method="post" enctype="multipart/form-data">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome"><br><br>
        <label for="marca">Marca:</label>
        <input type="text" id="marca" name="marca"><br><br>
        <label for="modello">Modello:</label>
        <input type="text" id="modello" name="modello"><br><br>
        <label for="prezzo">Prezzo:</label>
        <input type="text" id="prezzo" name="prezzo"><br><br>
        <label for="descrizione">Descrizione:</label>
        <input type="text" id="descrizione" name="descrizione"><br><br>
        <label for="foto">Foto:</label>
        <input type="file" id="foto" name="foto"><br><br>
        <input type="submit" value="Upload">
    </form>
</body>
</html>