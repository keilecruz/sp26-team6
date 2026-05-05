<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Edit Review</title>

    <link rel="stylesheet" href="/provider.css">
</head>

<body class="provider-page customer-page">

    <header class="provider-header">
        <div class="provider-logo">
            <img src="/photos/logo.png" alt="GlowUp Logo">
        </div>

        <nav class="provider-nav">
            <a href="/customer-dashboard">Dashboard</a>
            <a href="/customer-bookings">Your Bookings</a>
            <a href="/customer-reviews">Your Reviews</a>
            <a href="/browse">Browse</a>
            <a href="/logout" class="provider-nav-btn">Log Out</a>
        </nav>
    </header>

    <main class="provider-main">

        <div style="max-width: 600px; margin: auto;">

            <section class="profile-card">

                <h1>Edit Your Review ✏️</h1>
                <p class="provider-subtitle">
                    Update your feedback and rating
                </p>

                <form action="/review/update" method="post" class="edit-review-form">

                    <input type="hidden" name="reviewId" value="${review.reviewId}">

                    <label>Rating</label>
                    <select name="rating" required>
                        <option value="5" <#if review.rating==5>selected</#if>>⭐⭐⭐⭐⭐ (5)</option>
                        <option value="4" <#if review.rating==4>selected</#if>>⭐⭐⭐⭐ (4)</option>
                        <option value="3" <#if review.rating==3>selected</#if>>⭐⭐⭐ (3)</option>
                        <option value="2" <#if review.rating==2>selected</#if>>⭐⭐ (2)</option>
                        <option value="1" <#if review.rating==1>selected</#if>>⭐ (1)</option>
                    </select>

                    <label>Comment</label>
                    <textarea name="comment" rows="4" required>${review.comment!""}</textarea>

                    <div class="edit-actions">

                        <a href="/customer-reviews" class="provider-main-btn cancel-btn">
                            Cancel
                        </a>

                        <button type="submit" class="provider-main-btn">
                            Save Changes
                        </button>

                    </div>

                </form>

            </section>

        </div>

    </main>

</body>

</html>