<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Provider Reviews</title>
    <link rel="stylesheet" href="/provider.css">
</head>

<body class="provider-page">

    <header class="provider-header">
        <div class="provider-logo">
            <img src="/photos/logo.png" alt="GlowUp Logo">
        </div>

        <nav class="provider-nav">

            <#if roleString=="BEAUTY">
                <a href="/provider-dashboard">Dashboard</a>
                <a href="/provider-profile">Profile</a>
                <#else>
                    <a href="/customer-dashboard">Dashboard</a>
                    <a href="/browse">Browse</a>
            </#if>

            <a href="/logout" class="provider-nav-btn">Log Out</a>

        </nav>
    </header>

    <main class="provider-main provider-main-top">

        <section class="provider-content-card">

            <div class="provider-page-title">
                <h1>${beauty.businessName!"Provider"} Reviews ✨</h1>
                <p>Read customer feedback and ratings.</p>
            </div>

            <div class="reviews-summary-card">
                <h2>
                    <#if reviewCount==0>
                        No ratings yet
                        <#else>
                            ${averageRating?string["0.0"]} <span class="summary-star">★</span>
                    </#if>
                </h2>

                <p>Based on ${reviewCount} review<#if reviewCount !=1>s</#if>
                </p>
            </div>

            <#if roleString != "BEAUTY">
                <div class="add-review-box">
                    <h2>Add a Review</h2>

                    <form action="/review" method="post" class="provider-form">

                        <input type="hidden" name="beautyId" value="${beauty.userId}">

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

                        <button type="submit" class="provider-main-btn">Submit Review</button>

                    </form>
                </div>
            </#if>

            <hr class="profile-divider">

            <div class="profile-section-header">
                <h2>All Reviews</h2>
            </div>

            <div class="all-reviews-grid">
                <#list reviews as review>
                    <div class="review-preview-card">
                        <h3>${review.reviewerName!"Anonymous"}</h3>

                        <p class="stars">
                            <#list 1..review.rating as i>★</#list>
                            <span>${review.rating}.0</span>
                        </p>

                        <p>${review.comment}</p>
                    </div>
                </#list>

                <#if reviews?size==0>
                    <p class="provider-empty-text">No reviews yet.</p>
                </#if>
            </div>

            
            <div class="provider-callout review-callout">

                <#if roleString == "BEAUTY">
                    <div>
                        <h3>Keep track of your customer feedback</h3>
                        <p>View your reviews and use customer feedback to improve your services.</p>
                    </div>

                    <div class="provider-callout-buttons">
                        <a href="/provider-dashboard" class="provider-main-btn">← Back to Dashboard</a>
                        <a href="/provider-profile" class="provider-main-btn">Back to Profile →</a>
                    </div>
                <#else>
                    <div>
                        <h3>Explore this professional’s reviews</h3>
                        <p>Read customer feedback before choosing a service or booking an appointment.</p>
                    </div>

                    <div class="provider-callout-buttons">
                        <a href="/provider/${beauty.userId}" class="provider-main-btn">← Back to Profile</a>
                    </div>
                </#if>

            </div>

        </section>

    </main>

</body>

</html>