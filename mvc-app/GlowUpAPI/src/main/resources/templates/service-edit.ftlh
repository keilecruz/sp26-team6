<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Service - GlowUp</title>
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
            <h1>Edit Service ✨</h1>
            <p>Update your service details below.</p>
        </div>

        <form action="/services/update/${service.serviceId}" method="post" class="provider-form">

            <label>Service Name</label>
            <input type="text" name="name" value="${service.name}" required>

            <label>Description</label>
            <input type="text" name="description" value="${service.description}" required>

            <label>Price</label>
            <input type="number" step="0.01" name="price" value="${service.price}" required>

            <button type="submit" class="provider-main-btn">Update Service</button>

        </form>

        <a href="/services-page" class="provider-back-link">← Back to Services</a>

    </section>

</main>

</body>
</html>