<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Pets:</h1> <br/>
<a href="/create/pet/form">Cadastrar novo pet</a><br/><br/><br/>
<div class="panel-body">
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Foto</th>
            <th>Id</th>
            <th>Nome</th>
            <th>Porte</th>
            <th>Tipo</th>
            <th>Idade</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${pets}" var="pet">
            <tr>
                <td class="text-center">${pet.photoUrl} </td>
                <td class="text-center">${pet.id}</td>
                <td class="text-center">${pet.name}</td>
                <td class="text-center">${pet.size.description}</td>
                <td class="text-center">${pet.type.description}</td>
                <td class="text-center">${pet.ageInYears}</td>
            </tr>
        </c:forEach>
        <c:if test="${empty pets}">
            <td class = "text-center">Ops! Não há nenhum registro nessa lista!</td>
        </c:if>
        </tbody>
    </table>
</div>
