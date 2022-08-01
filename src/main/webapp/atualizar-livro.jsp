<%--
  Created by IntelliJ IDEA.
  User: Nicolau
  Date: 31-Jul-22
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Atualizar livros</title>
</head>
<body>
<fieldset>
<legend>Id do livro para atualizar</legend>
<form action="atualizar-livro" method="post">
    <div>
        <input type="hidden" name="id" value="${livro.id}">
    </div>
    <div>
        <label for="nomeLivro">Nome do livro:</label>
        <input type="text" id="nomeLivro" name="nomeLivro" value="${livro.nomeLivro}">
    </div>
    <div>
        <label for="nomeAutor">Nome do autor:</label>
        <input type="text" id="nomeAutor" name="nomeAutor" value="${livro.nomeAutor}">
    </div>
    <input type="submit" value="Enviar">
</form>
</fieldset>
</body>
</html>
