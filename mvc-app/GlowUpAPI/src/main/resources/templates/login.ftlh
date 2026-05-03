<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>GlowUp Login</title>
    <link rel="stylesheet" href="/login.css">
</head>

<body class="login-page">

    <header class="login-header">
        <div class="login-logo">
            <img src="/photos/logo.png" alt="GlowUp Logo">
        </div>

        <nav class="login-nav">
            <a href="/index">Home</a>
            <a href="#">About</a>
            <a href="/signup" class="login-signup-btn">Sign Up</a>
        </nav>
    </header>

    <main class="login-main">

        <section class="login-card">

            <h1>Welcome Back ✨</h1>

            <form action="/login" method="post" class="login-form">

                <label>Email</label>
                <input type="email" name="email" placeholder="you@example.com" required>

                <label>Password</label>
                <input type="password" name="password" placeholder="Enter your password" required>

                <button type="submit" class="login-submit-btn">Log In</button>

            </form>

            <div class="login-divider">
                <span></span>
                <p>or</p>
                <span></span>
            </div>

            <p class="login-bottom-text">
                New here? <a href="/signup">Create an account</a>
            </p>

        </section>

    </main>

</body>

</html>