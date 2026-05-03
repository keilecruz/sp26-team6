<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GlowUp Login </title>
    <link rel="stylesheet" href="style.css">

    <!--- This is for user/professional to log in-->

</head>

<body>

    <!--- Top Header-->
    <header class="top-header">
        <nav>
            <img src="../../photos/logo.jpg" alt="GlowUp logo" class="logo">

            <div class="nav-links">
                <a href="/login">Log in</a>
                <a href="/index" class="btn">Home</a>

            </div>

        </nav>

    </header>

    <!--- Login Information (if user has an account for this website)-->
    <section class="login-section">
        <div class="container">

            <!-- CONNECTS TO SPRING -->
            <form action="/login" method="post">

                <h2>Welcome Back!</h2>

                <label>Email</label>

                <input type="email" name="email" placeholder="Enter your email" required>

                <label>Password</label>

                <input type="password" name="password" placeholder="Enter your password" required>

                <button type="submit" class="btn">Log In</button>

            </form>

            <p> Don't have an Account? <a href="/signup">Sign Up</a></p>

        </div>
    </section>

</body>

</html>