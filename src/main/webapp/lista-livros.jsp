<%--
  Created by IntelliJ IDEA.
  User: Nicolau
  Date: 28-Jul-22
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="solid">
    <tr>
        <th>ID</th>
        <th>Nome do livro</th>
        <th>Nome do autor</th>
    </tr>
    <c:forEach var="livro" items="${livros}" varStatus="id">
        <tr>
            <td>${livro.id}</td>
            <td>${livro.nomeLivro}</td>
            <td>${livro.nomeAutor}</td>
        </tr>
</table>
<div>
    <a href="${pageContext.request.contextPath}/livro-servlet/atualizar-livro?id=<c:out value='${livro.id}' />">Edit</a>
    <a href="${pageContext.request.contextPath}/livro-servlet/excluir-livro?id=<c:out value='${livro.id}' />">Excluir</a>
</div>
</c:forEach>
<a href="${pageContext.request.contextPath}/livro-servlet/excluir-livro.jsp>">Cadastrar novo livro</a>
</body>
</html>
