<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Write Review</title>
    <link rel="stylesheet" href="/provider.css">
</head>

<body class="provider-page">

<header class="provider-header">
    <div class="provider-logo">
        <img src="/photos/logo.png" alt="GlowUp Logo">
    </div>

    <nav class="provider-nav">
        <a href="/customer-dashboard">Dashboard</a>
        <a href="/customer-bookings">Your Bookings</a>
        <a href="/logout" class="provider-nav-btn">Log Out</a>
    </nav>
</header>

<main class="provider-main provider-main-top">

    <section class="provider-content-card">

        <h1>Write a Review ✨</h1>

        <form action="/review" method="post" class="provider-form">

            <input type="hidden" name="beautyId" value="${beautyId}">

            <label>Your Name</label>
            <input type="text" name="reviewerName" placeholder="Enter your name" required>

            <label>Rating</label>
            <select name="rating" required>
                <option value="5">5 - Excellent</option>
                <option value="4">4 - Good</option>
                <option value="3">3 - Okay</option>
                <option value="2">2 - Poor</option>
                <option value="1">1 - Bad</option>
            </select>

            <label>Comment</label>
            <textarea name="comment" rows="4" placeholder="Write your review..." required></textarea>

            <button type="submit" class="provider-main-btn">
                Submit Review
            </button>

        </form>

        <div class="profile-bottom-actions">
            <a href="/customer-bookings" class="provider-back-button">
                ← Back to Bookings
            </a>
        </div>

    </section>

</main>

</body>
</html>