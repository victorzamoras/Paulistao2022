<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<link rel='stylesheet' href='./css/style.css' />
<title>Times</title>
</head>
<body>
	<div class="header">
		<ul>
			<li><a href="index.jsp" class="link-grupos">Grupos</a></li>
			<li><a href="rodadas.jsp" class="link-rodadas">Rodadas</a></li>
			<li><a href="times.jsp" class="link-times">Times</a></li>
		</ul>
	</div>
	<br>
	<br>

	<div align="center">
		<c:if test="${not empty erro}">
			<h4>
				<c:out value="${erro}"></c:out>
			</h4>
		</c:if>
	</div>

	<div class="Times">
		<img alt="Logo" src="./assets/logo.png">
		<form action="ServletTimes" method="post">
			<input type="submit" id=gerar_times name=gerar_times
				value="Visualizar Times">
		</form>

		<div>
			<table>
				<c:forEach items="${times}" var="t">
					<table>
						<tr>
							<th><c:out value="${t.getNome()}">
								</c:out>
							</th>
						</tr>
						<tr>
							<th class='Time'>CodigoTime</th>
							<th class='Time'>Nome</th>
							<th class='Time'>Estadio</th>
							<th class='Time'>Cidade</th>
							<th class='Time'>Material</th>
						</tr>
						<c:forEach items="${t.getTimes()}" var="t1">
							<tr>
								<td align="center"><c:out value="${t1.getCodigoTime()}"></c:out></td>
								<td align="center"><c:out value="${t1.getNome()}"></c:out></td>
								<td align="center"><c:out value="${t1.getEstadio()}"></c:out></td>
								<td align="center"><c:out value="${t1.getCidade()}"></c:out></td>
								<td align="center"><c:out value="${t1.getMaterial()}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
				</c:forEach>

			</table>
		</div>
		<div align="center">
			<c:if test="${not empty saida}">
				<h4>
					<c:out value="${saida}"></c:out>
				</h4>
			</c:if>
		</div>
	</div>
</body>
</html>
