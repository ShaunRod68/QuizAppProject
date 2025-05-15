<%@ page session="true" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form method="post" action="/login">
    <input name="username" placeholder="Username"/><br>
    <input name="password" type="password" placeholder="Password"/><br>
    <button type="submit">Login</button>
</form>
<p>${msg}</p>
</body>
</html>
