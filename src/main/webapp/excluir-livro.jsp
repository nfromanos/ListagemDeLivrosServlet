<%--
  Created by IntelliJ IDEA.
  User: Nicolau
  Date: 31-Jul-22
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excluir livro</title>
</head>
<body>
<fieldset>
    <legend>Id do livro para excluir</legend>
    <form action="livro-servlet/excluir-livro" method="post">

        <div>
            <label for="idLivro">ID do Livro:</label><br>
            <input type="text" id="idLivro" name="idLivro"><br>
        </div>
        <input type="submit" value="Enviar">
    </form>
</fieldset>
</body>
</html>
