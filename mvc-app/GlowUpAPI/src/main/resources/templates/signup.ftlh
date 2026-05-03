<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>GlowUp Sign Up</title>
    <link rel="stylesheet" href="/signup.css">
</head>

<body class="signup-page">

    <header class="signup-header">
        <div class="signup-logo">
            <img src="/photos/logo.png" alt="GlowUp Logo">
        </div>

        <nav class="signup-nav">
            <a href="/index">Home</a>
            <a href="#">About</a>
            <a href="/login" class="signup-login-btn">Log In</a>
        </nav>
    </header>

    <main class="signup-main">

        <section class="signup-card">

            <h1>Create Account ✨</h1>

            <form action="/signup" method="post" class="signup-form">

                <label>Account Type</label>
                <select name="role" required>
                    <option value="CUSTOMER">Customer</option>
                    <option value="BEAUTY">Beauty Professional</option>
                </select>

                <label>First Name</label>
                <input type="text" name="firstName" placeholder="Enter your first name">

                <label>Last Name</label>
                <input type="text" name="lastName" placeholder="Enter your last name">

                <label>Email</label>
                <input type="email" name="email" placeholder="you@example.com" required>

                <label>Password</label>
                <input type="password" name="password" placeholder="Create a password" required>

                <label>Phone</label>
                <input type="text" name="phone" placeholder="Enter your phone number">

                <label>Business Name</label>
                <input type="text" name="businessName" placeholder="For providers only">

                <button type="submit" class="signup-submit-btn">Sign Up</button>

            </form>

            <div class="signup-divider">
                <span></span>
                <p>or</p>
                <span></span>
            </div>

            <p class="signup-bottom-text">
                Already have an account? <a href="/login">Log in</a>
            </p>

        </section>

    </main>

</body>

</html>