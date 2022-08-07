<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Cadastro de animais</h1>

<br/>
<br/>

<form:form modelAttribute="petNewForm" method="post" action="/create/pet">
    <form:errors path="" cssStyle="color:red"/>

    <label>Nome:</label>
    <form:input path="name"/>
    <form:errors path="name" cssStyle="color: red"/>

    <label>Custo mensal:</label>
    <form:input path="monthlyCost"/>
    <form:errors path="monthlyCost" cssStyle="color: red"/>

    <label>Data de nascimento:</label>
    <form:input type="date" path="birthDate"/>
    <form:errors path="birthDate" cssStyle="color: red"/>

    <form:select path="type" class="form-control">
        <form:options items="${types}" itemLabel="description"/>
    </form:select>
    <form:errors path="type" cssStyle="color: red"/>

    <form:select path="size" class="form-control">
        <form:options items="${sizes}" itemLabel="description"/>
    </form:select>
    <form:errors path="size" cssStyle="color: red"/>

    <label>Porte Url:</label>
    <form:input type="url" path="photoUrl"/>
    <form:errors path="photoUrl" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button>Cadastrar</form:button>

</form:form>
