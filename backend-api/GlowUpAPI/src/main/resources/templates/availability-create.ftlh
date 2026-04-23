<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Availability - GlowUp</title>
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
            <h2>Create Availability</h2>
            <p>Add a new time slot for bookings.</p>
        </div>

        <form action="/availability/create" method="post">
            <input type="text" name="date" placeholder="YYYY-MM-DD" required>
            <input type="text" name="time" placeholder="10:00 AM - 2:00 PM" required>
            <button type="submit" class="btn">Create Availability</button>
        </form>

        <a href="/availability-page" class="back">← Back to Availability</a>
    </div>
</section>

</body>
</html>