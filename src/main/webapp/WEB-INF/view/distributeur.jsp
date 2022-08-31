<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Student form</title>
    </head>
    <body>
        
        
        <h1>Crédit : </h1>
        ${balance}
        
        <table>
            <caption>Liste des produit</caption>
            <tr>
                <th>Numéro de produit</th>
                <th>Nom</th>
                <th>Quantité</th>
                <th>Prix</th>
            </tr>

            <c:forEach var="product" items="${products}">
                <tr>
                    <td><c:out value="${product.getId()}"/></td>
                    <td><c:out value="${product.getNom()}"/></td>
                    <td><c:out value="${product.getQuantite()}"/></td>
                    <td><c:out value="${product.getPrix()}"/></td>
                </tr>
            </c:forEach>

        </table>
        
        <br />
        <form:form method="POST" action="/addBalance" modelAttribute="balanceForm">
            <fieldset>
                <legend>Ajouter du crédit</legend>
                <p>
                    <form:label path="balance">Crédit</form:label>
                    <form:input type="number" path="balance" />
                    <form:errors path="balance" />
                </p>
                <input type="submit" value="Ajouter" />
            </fieldset>
            
        </form:form>

        <br />

       
    </body>
</html>