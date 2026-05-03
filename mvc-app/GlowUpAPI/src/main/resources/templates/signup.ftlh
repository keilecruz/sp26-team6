<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>GlowUp SignUp</title>
    <link rel="stylesheet" href="/style.css">
</head>

<body>

    <header class="top-header">
        <nav>
            <img src="/photos/logo.jpg" class="logo">

            <div class="nav-links">
                <a href="/login">Log in</a>
                <a href="/index" class="btn">Home</a>
            </div>
        </nav>
    </header>

    <section class="signup-section">

        <div class="container">

            <h2>Create your Account</h2>

            <form action="/signup" method="post">

                <label>First Name</label>
                <input type="text" name="firstName">

                <label>Last Name</label>
                <input type="text" name="lastName">

                <label>Email</label>
                <input type="email" name="email">

                <label>Password</label>
                <input type="password" name="password">

                <label>Phone</label>
                <input type="text" name="phone">

                <select name="role">
                    <option value="CUSTOMER">Customer</option>
                    <option value="PROFESSIONAL">Professional</option>
                    <option value="ADMIN">Admin</option>
                </select>

                <button type="submit" class="btn">Sign Up</button>

            </form>

            <p>Already have an account? <a href="/login">Log in</a></p>

        </div>

    </section>

</body>

</html>