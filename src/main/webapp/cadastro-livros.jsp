<%--
  Created by IntelliJ IDEA.
  User: Nicolau
  Date: 28-Jul-22
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de livros</title>
</head>
<body>
<fieldset>
  <legend>Dados do livro</legend>
    <form action="livro-servlet/cadastro-livros" method="post">

      <div>
      <label for="nomeLivro">Nome do livro:</label>
      <input type="text" id="nomeLivro" name="nomeLivro">
      </div>

      <div>
      <label for="nomeAutor">Nome do autor:</label>
      <input type="text" id="nomeAutor" name="nomeAutor">
      </div>
      <input type="submit" value="Enviar">
    </form>
</fieldset>
</body>
</html>
