<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data</title>
</head>
<body>
	<div align="center">
		<form action="pessoa" method="post">
			<table>
				<tr><td><input type="number" min="1" step="1" id="id" name="id"
					placeholder="#ID"></td></tr>
				<tr><td><input type="text" id="nome" name="nome" 
					placeholder="Nome"></td></tr>
				<tr><td><input type="date" id="data_nascimento" name="data_nascimento">
					</td></tr>
				<tr><td align="center"><input type="submit" id="botao" name="botao" 
					value="Inserir"></td></tr>
				<tr><td align="center"><input type="submit" id="botao" name="botao" 
					value="Listar"></td></tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div align="center">
		<c:if test="${not empty pessoas }">
			<table border = 1>
				<thead>
					<tr>
						<th><b>#ID</b></th>
						<th><b>NOME</b></th>	
						<th><b>DATA NASCIMENTO</b></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pessoas }" var="p">
					<tr>
						<td><c:out value="${p.id }"></c:out></td>
						<td><c:out value="${p.nome }"></c:out></td>
						<td><c:out value="${p.dataNascimento }"></c:out></td>
					</tr>
				</c:forEach>
				</tbody>				
			</table>
		</c:if>
	</div>
</body>
</html>