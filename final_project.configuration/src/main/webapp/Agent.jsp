<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Agents List</title>
</head>
<body>
    <h1>List of Agents</h1>
    <table border="1">
        <tr>
            <th>AgentID</th>
            <th>AgentName</th>
            <th>Contact Information</th>
            <th>Email</th>
        </tr>
        <c:forEach var="agent" items="${agents}">
            <tr>
                <td><c:out value="${agent.agentId}"/></td>
                <td><c:out value="${agent.agentName}"/></td>
                <td><c:out value="${agent.contactInformation}"/></td>
                <td><c:out value="${agent.email}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>