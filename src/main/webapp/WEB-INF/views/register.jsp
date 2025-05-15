<%@ page session="true" %>
<html>
<head><title>Register</title></head>
<body>
<h2>Register</h2>
<form method="post" action="/register">
    <input name="username" placeholder="Username"/><br>
    <input name="password" type="password" placeholder="Password"/><br>
    <button type="submit">Register</button>
</form>
<p>${msg}</p>
</body>
</html>
