<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Cadastro de tutores</h1>

<br/>
<br/>

<form:form modelAttribute="tutorNewForm" method="post" action="/create/tutor">
    <form:errors path="" cssStyle="color:red"/>

    <label>Nome:</label>
    <form:input path="name"/>
    <form:errors path="name" cssStyle="color: red"/>

    <label>CPF:</label>
    <form:input path="cpf"/>
    <form:errors path="cpf" cssStyle="color: red"/>

    <label>Data de nascimento:</label>
    <form:input type="date" path="birthDate"/>
    <form:errors path="birthDate" cssStyle="color: red"/>

    <label>Remuneração:</label>
    <form:input path="remuneration"/>
    <form:errors path="remuneration" cssStyle="color: red"/>

    <label>Foto:</label>
    <form:input type="url" path="photoUrl"/>
    <form:errors path="photoUrl" cssStyle="color: red"/>

    <label>Tipo de moradia:</label>
    <form:select path="typeofHousing" class="form-control">
        <form:options items="${typesOfHousing}" itemLabel="description"/>
    </form:select>
    <form:errors path="typeofHousing" cssStyle="color: red"/>
    <br/>
    <br/>

    <form:button>Cadastrar</form:button>

</form:form>
