<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Service - GlowUp</title>
    <link rel="stylesheet" href="/provider.css">
</head>

<body class="provider-page">

<header class="provider-header">
    <div class="provider-logo">
        <img src="/photos/logo.png" alt="GlowUp Logo">
    </div>

    <nav class="provider-nav">
        <a href="/provider-dashboard">Dashboard</a>
        <a href="/provider-profile">Profile</a>
        <a href="/logout" class="provider-nav-btn">Log Out</a>
    </nav>
</header>

<main class="provider-main provider-main-top">

    <section class="provider-content-card provider-form-card">

        <div class="provider-page-title">
            <h1>Create Service ✨</h1>
            <p>Add a new service for your clients.</p>
        </div>

        <form action="/services/create" method="post" class="provider-form">

            <label>Service Name</label>
            <input type="text" name="name" placeholder="Example: Bridal Makeup" required>

            <label>Description</label>
            <input type="text" name="description" placeholder="Short description of the service" required>

            <label>Price</label>
            <input type="number" step="0.01" name="price" placeholder="Example: 50.00" required>

            <button type="submit" class="provider-main-btn">Create Service</button>

        </form>

        <a href="/services-page" class="provider-back-link">← Back to Services</a>

    </section>

</main>

</body>
</html>