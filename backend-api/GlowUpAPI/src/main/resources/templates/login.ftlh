<!DOCTYPE html>
<html>
<head>
    <title>GlowUp Login</title>
</head>
<body>
    <h1>GlowUp Login</h1>

    <#if error??>
        <p style="color:red;">${error}</p>
    </#if>

    <form action="/login" method="post">
        <label>Email:</label>
        <input type="email" name="email" required>

        <br><br>

        <label>Password:</label>
        <input type="password" name="password" required>

        <br><br>

        <button type="submit">Login</button>
    </form>

    <p>New? <a href="/signup">Create an account</a></p>
</body>
</html>