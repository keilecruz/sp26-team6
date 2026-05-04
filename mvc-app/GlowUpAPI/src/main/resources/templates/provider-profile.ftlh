<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Provider Profile</title>
    <link rel="stylesheet" href="/provider.css">
</head>

<body class="provider-page">

    <#assign roleString=roleString!"">
        <#assign isOwner=isOwner!false>

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

                <section class="profile-card">

                    <div class="profile-top">

                        <div class="profile-image-box">
                            <#if beauty.profileImage?? && beauty.profileImage !="">
                                <img src="${beauty.profileImage}" class="profile-main-img">
                                <#else>
                                    <img src="/photos/profilepic.png" class="profile-main-img">
                            </#if>

                            <div class="profile-badge">✓</div>
                        </div>

                        <div class="profile-info">

                            <h1>${beauty.businessName!"Beauty Professional"} ✨</h1>

                            <div class="profile-tag">Beauty Professional</div>

                            <#if !reviewCount?? || reviewCount==0>
                                <p class="profile-rating-text">No ratings yet</p>
                                <#else>
                                    <p class="profile-rating-text">
                                        ${averageRating?string["0.0"]} ★
                                        based on ${reviewCount} review<#if reviewCount !=1>s</#if>
                                    </p>
                            </#if>

                            <p class="profile-bio">
                                ${beauty.bio!"No bio added yet."}
                            </p>

                            <#if isOwner>
                                <a href="/provider-profile/edit" class="provider-main-btn">
                                    Edit Profile
                                </a>

                                <#elseif roleString=="CUSTOMER">
                                    <a href="/booking/${beauty.userId}" class="provider-main-btn">
                                        Book Appointment
                                    </a>
                            </#if>

                        </div>

                    </div>

                    <hr class="profile-divider">

                    <div class="profile-section-header">
                        <div>
                            <h2>Reviews</h2>

                            <#if !reviewCount?? || reviewCount==0>
                                <p class="profile-rating-text">No reviews yet</p>
                                <#else>
                                    <p class="profile-rating-text">
                                        ${averageRating?string["0.0"]} ★
                                        based on ${reviewCount} review<#if reviewCount !=1>s</#if>
                                    </p>
                            </#if>
                        </div>

                        <a href="/provider-reviews">View more reviews →</a>
                    </div>

                    <div class="reviews-preview-grid">

                        <#if reviews?? && reviews?size gt 0>

                            <#list reviews as review>
                                <#if review_index < 3>
                                    <div class="review-preview-card">

                                        <h3>${review.reviewerName!"Anonymous"}</h3>

                                        <p class="stars">
                                            <#list 1..review.rating as i>★</#list>
                                            <span>${review.rating}.0</span>
                                        </p>

                                        <p>${review.comment!""}</p>

                                    </div>
                                </#if>
                            </#list>

                            <#else>

                                <p class="provider-empty-text">No reviews yet.</p>

                        </#if>

                    </div>

                    <hr class="profile-divider">

                    <!-- PORTFOLIO -->
                    <div class="profile-section-header">
                        <h2>Work Gallery</h2>
                    </div>

                    <div class="portfolio-preview-grid">

                        <#if portfolios?? && portfolios?size gt 0>

                            <#list portfolios as portfolio>
                                <img src="${portfolio.imageUrl!'/photos/default.jpg'}">
                            </#list>

                            <#else>

                                <p class="provider-empty-text">No sample work photos added yet.</p>

                        </#if>

                    </div>

                    <div class="profile-bottom-actions">

                        <#if roleString=="BEAUTY">
                            <a href="/provider-dashboard" class="provider-back-button">
                                ← Back to Dashboard
                            </a>
                            <#else>
                                <a href="/browse" class="provider-back-button">
                                    ← Back to Browse
                                </a>
                        </#if>

                    </div>

                </section>

            </main>

</body>

</html>