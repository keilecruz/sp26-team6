<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Service - GlowUp</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>

<header class="top-header provider-top-header">
    <nav class="nav-bar">
        <div class="brand">
            <img src="/image/logo.jpg" class="logo-banner" alt="GlowUp Logo">
        </div>

        <div class="nav-links">
            <a href="/services-page" class="active-link">Services</a>
            <a href="/availability-page">Availability</a>
            <a href="#">Profile</a>
            <a href="#">Log out</a>
        </div>
    </nav>
</header>

<section class="provider-shell">
    <div class="provider-panel form-box">

        <div class="provider-hero">
            <div class="provider-hero-left">
                <h2>Edit Service ✨</h2>
                <p>Update your service details below.</p>
            </div>
        </div>

        <form action="/services/update/${service.serviceId}" method="post">
            <input type="text" name="name" value="${service.name}" required>
            <input type="text" name="description" value="${service.description}" required>
            <input type="number" step="0.01" name="price" value="${service.price}" required>

            <button type="submit" class="btn">Update Service</button>
        </form>

        <a href="/services-page" class="back">← Back to Services</a>

    </div>
</section>

</body>
</html>