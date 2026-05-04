<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Availability - GlowUp</title>
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
            <h1>Create Availability ✨</h1>
            <p>Add a new time slot for bookings.</p>
        </div>

        <form action="/availability/create" method="post" class="provider-form">

            <label>Date</label>
            <input type="text" name="date" placeholder="YYYY-MM-DD" required>

            <label>Time</label>
            <input type="text" name="time" placeholder="10:00 AM - 2:00 PM" required>

            <button type="submit" class="provider-main-btn">Create Availability</button>

        </form>

        <a href="/availability-page" class="provider-back-link">← Back to Availability</a>

    </section>

</main>

</body>
</html>