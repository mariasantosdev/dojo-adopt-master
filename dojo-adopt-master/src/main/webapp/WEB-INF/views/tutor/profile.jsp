<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty tutorProfile.photoUrl}">
    Esse tutor não tem foto cadastrada
</c:if>
<br/>
<br/>
<img src="${tutorProfile.photoUrl}"/>
<br/>
${tutorProfile.name}
<br/>
CPF: ${tutorProfile.cpf}
<br/>
<hr>
<br/>
Deseja adotar qual animal?
<br>
<table class="table table-bordered table-striped">
    <thead>
    <tr>
        <th class="text-center col-md-4">Foto url</th>
        <th class="text-center col-md-4">Id</th>
        <th class="text-center col-md-4">Nome</th>
        <th class="text-center col-md-4">Porte</th>
        <th class="text-center col-md-4">Tipo</th>
        <th class="text-center col-md-4">Idade</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pets}" var="pet">
        <tr>
            <td class="text-center col-md-4"></td><img src="${pet.getPhotoUrl()}"/></td>
            <td class="text-center col-md-4">${pet.id}</td>
            <td class="text-center col-md-4">${pet.name}</td>
            <td class="text-center col-md-4">${pet.size.description}</td>
            <td class="text-center col-md-4">${pet.type.description}</td>
            <td class="text-center col-md-4">${pet.ageInYears}</td>
            <td class="text-center">
                <form action="/create/adoption" method="post">
                    <input type="hidden" value="${tutorProfile.id}" name="tutorId">
                    <input type="hidden" value="${pet.id}" name="petId">
                    <input type="submit" value="Adotar"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>