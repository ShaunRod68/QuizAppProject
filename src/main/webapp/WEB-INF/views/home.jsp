<%@ page session="true" %>
<html>
<head><title>Home</title></head>
<body>
<h2>Welcome, ${sessionScope.username}!</h2>
<a href="/logout">Logout</a>
</body>
</html>
