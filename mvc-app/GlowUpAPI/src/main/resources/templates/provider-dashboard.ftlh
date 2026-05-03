<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Dashboard</title>
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

    <main class="provider-main">

        <section class="provider-dashboard-card">

            <h1>Provider Dashboard ✨</h1>
            <p class="provider-subtitle">Manage your profile, services, availability, bookings, and reviews from one place.</p>

            <div class="provider-dashboard-grid">

                <a href="/provider-profile" class="provider-dashboard-link">
                    <h3>View Your Profile</h3>
                    <p>See your public provider profile.</p>
                </a>

                <a href="/provider-profile/edit" class="provider-dashboard-link">
                    <h3>Edit Your Profile</h3>
                    <p>Update your business name, bio, and profile image.</p>
                </a>

                <a href="/services-page" class="provider-dashboard-link">
                    <h3>Manage Services</h3>
                    <p>Add, edit, or delete your services.</p>
                </a>

                <a href="/availability-page" class="provider-dashboard-link">
                    <h3>Manage Availability</h3>
                    <p>Add or remove available times.</p>
                </a>

                <a href="/provider-bookings" class="provider-dashboard-link">
                    <h3>View All Bookings</h3>
                    <p>See customer booking requests.</p>
                </a>

                <a href="/provider-reviews" class="provider-dashboard-link">
                    <h3>View All Reviews</h3>
                    <p>Read customer reviews and feedback.</p>
                </a>

            </div>

        </section>

    </main>

</body>
</html>