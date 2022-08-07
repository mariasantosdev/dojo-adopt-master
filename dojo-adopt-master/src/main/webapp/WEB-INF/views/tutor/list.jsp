<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Tutores:</h1> <br/>
<a href="/create/tutor/form">Cadastrar novo tutor</a><br/><br/><br/>
<div class="panel-body">
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Foto</th>
            <th>Nome</th>
            <th>CPF</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${tutors}" var="tutor">
            <tr>
                <td class="text-center">${tutor.id}</td>
                <td class="text-center">${tutor.photoUrl}</td>
                <td class="text-center">${tutor.name}</td>
                <td class="text-center">${tutor.cpf}</td>
            </tr>
        </c:forEach>
        <c:if test="${empty tutors}">
            <td class = "text-center">Ops! Não há nenhum registro nessa lista!</td>
        </c:if>
        </tbody>
    </table>
</div>
