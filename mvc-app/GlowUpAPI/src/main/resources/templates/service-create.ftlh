<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Service - GlowUp</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>

<header class="top-header provider-top-header">
    <nav class="nav-bar">
        <div class="brand">
            <img src="/image/logo.jpg" class="logo-banner" alt="GlowUp Logo">
            
        </div>
    </nav>
</header>

<section class="provider-shell">
    <div class="provider-panel form-box">
        <div class="provider-hero">
            <div class="sparkle">✨</div>
            <h2>Create Service</h2>
            <p>Add a new service for your clients.</p>
        </div>

        <form action="/services/create" method="post">
            <input type="text" name="name" placeholder="Service Name" required>
            <input type="text" name="description" placeholder="Description" required>
            <input type="number" step="0.01" name="price" placeholder="Price" required>
            <button type="submit" class="btn">Create Service</button>
        </form>

        <a href="/services-page" class="back">← Back to Services</a>
    </div>
</section>

</body>
</html>