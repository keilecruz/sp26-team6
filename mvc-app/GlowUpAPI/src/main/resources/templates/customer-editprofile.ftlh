<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>

    <!-- ✅ Use same design system -->
    <link rel="stylesheet" href="/provider.css">
    <link rel="stylesheet" href="/customer.css">
</head>

<body class="provider-page customer-page">

    <!-- Header -->
    <header class="provider-header">
        <div class="provider-logo">
            <img src="/photos/logo.png" alt="GlowUp Logo">
        </div>

        <nav class="provider-nav">
            <a href="/customer-dashboard">Dashboard</a>
            <a href="/browse">Browse</a>
            <a href="/logout" class="provider-nav-btn">Log Out</a>
        </nav>
    </header>

    <!-- Main -->
    <main class="provider-main">

        <div style="width: 100%; max-width: 600px; margin: 0 auto;">

            <section class="provider-dashboard-card">

                <h1>Edit Profile ✨</h1>
                <p class="provider-subtitle">Update your personal details</p>

                <!-- FORM -->
                <form action="/edit-profile" method="post" class="edit-form">

                    <input type="hidden" name="id" value="${customer.id!''}">

                    <div class="form-group">
                        <label>First Name</label>
                        <input type="text" name="firstName" value="${customer.firstName!''}" required>
                    </div>

                    <div class="form-group">
                        <label>Last Name</label>
                        <input type="text" name="lastName" value="${customer.lastName!''}" required>
                    </div>

                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" name="email" value="${customer.email!''}" required>
                    </div>

                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" name="password" value="${customer.password!''}" required>
                    </div>

                    <div class="form-group">
                        <label>Phone</label>
                        <input type="tel" name="phone" value="${customer.phone!''}">
                    </div>

                    <div class="form-actions">

                        <a href="/customer-dashboard" class="provider-nav-btn cancel-btn">
                            Cancel</a>

                        <button type="submit" class="provider-nav-btn save-btn">
                            Save Changes</button>

                    </div>

                </form>
            </section>

        </div>

    </main>

</body>

</html>