<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Profile</title>
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

    <section class="profile-card">

        <div class="profile-top">

            <div class="profile-image-box">
                <#if beauty.profileImage?? && beauty.profileImage != "">
                    <img src="${beauty.profileImage}" alt="Profile Image" class="profile-main-img">
                <#else>
                    <img src="/photos/profilepic.png" alt="Default Profile Image" class="profile-main-img">
                </#if>

                <div class="profile-badge">✓</div>
            </div>

            <div class="profile-info">
                <h1>${beauty.businessName!"Beauty Professional"} ✨</h1>

                <div class="profile-tag">Beauty Professional</div>

                <#if reviewCount == 0>
                    <p class="profile-rating-text">No ratings yet</p>
                <#else>
                    <p class="profile-rating-text">
                        ${averageRating?string["0.0"]} <span class="summary-star">★</span>
                        based on ${reviewCount} review<#if reviewCount != 1>s</#if>
                    </p>
                </#if>

                <p class="profile-bio">
                    ${beauty.bio!"No bio added yet. Click edit profile to add your business description."}
                </p>

                <a href="/provider-profile/edit" class="provider-main-btn profile-edit-btn">Edit Profile</a>
            </div>

        </div>

        <hr class="profile-divider">

        <div class="profile-section-header">
            <div>
                <h2>Reviews</h2>

                <#if reviewCount == 0>
                    <p class="profile-rating-text">No reviews yet</p>
                <#else>
                    <p class="profile-rating-text">
                        ${averageRating?string["0.0"]} <span class="summary-star">★</span>
                        based on ${reviewCount} review<#if reviewCount != 1>s</#if>
                    </p>
                </#if>
            </div>

            <a href="/provider-reviews">View more reviews →</a>
        </div>

        <div class="reviews-preview-grid">

            <#list reviews as review>
                <#if review_index < 3>
                    <div class="review-preview-card">
                        <h3>${review.reviewerName!"Anonymous"}</h3>

                        <p class="stars">
                            <#list 1..review.rating as i>★</#list>
                            <span>${review.rating}.0</span>
                        </p>

                        <p>${review.comment}</p>
                    </div>
                </#if>   
            </#list>

            <#if reviews?size == 0>
                <p class="provider-empty-text">No reviews yet.</p>
            </#if>

        </div>

        <hr class="profile-divider">

        <div class="profile-section-header">
            <h2>Work Gallery</h2>
        </div>

        <div class="portfolio-preview-grid">
            <#list portfolios as portfolio>
                <img src="${portfolio.imageUrl}" alt="Sample work photo">
            </#list>

            <#if portfolios?size == 0>
                <p class="provider-empty-text">No sample work photos added yet.</p>
            </#if>
        </div>

        <div class="profile-bottom-actions">
            <a href="/provider-dashboard" class="provider-back-button">← Back to Dashboard</a>
        </div>

    </section>

</main>

</body>
</html>