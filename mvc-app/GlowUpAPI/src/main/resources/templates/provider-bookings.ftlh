<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Bookings</title>
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

    <section class="provider-content-card">

        <div class="provider-page-title">
            <h1>My Bookings ✨</h1>
            <p>View customer booking requests and appointments here.</p>
        </div>

        <div class="booking-empty-card">
            <div class="booking-empty-icon">📅</div>

            <h2>No bookings yet</h2>

            <p>
                When customers book your services, their appointment details will appear here.
            </p>

            <a href="/provider-dashboard" class="provider-main-btn">Back to Dashboard</a>
        </div>

    </section>

</main>

</body>
</html>