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

                <p class="profile-bio">
                    ${beauty.bio!"No bio added yet. Click edit profile to add your business description."}
                </p>

                <a href="/provider-profile/edit" class="provider-main-btn profile-edit-btn">Edit Profile</a>
            </div>

        </div>

        <hr class="profile-divider">

        <div class="profile-section-header">
            <h2>Reviews</h2>
            <a href="/provider-reviews">View more reviews →</a>
        </div>

        <div class="reviews-preview-grid">

            <div class="review-preview-card">
                <h3>Samantha R.</h3>
                <p class="stars">★★★★★ <span>5.0</span></p>
                <p>Absolutely loved the service! So clean, pretty, and professional.</p>
            </div>

            <div class="review-preview-card">
                <h3>Jasmine L.</h3>
                <p class="stars">★★★★★ <span>5.0</span></p>
                <p>My makeup came out stunning. I felt so confident for my event.</p>
            </div>

            <div class="review-preview-card">
                <h3>Aaliyah M.</h3>
                <p class="stars">★★★★★ <span>5.0</span></p>
                <p>Very talented and sweet. I would definitely book again.</p>
            </div>

        </div>

        <hr class="profile-divider">

        <div class="profile-section-header">
            <h2>Work Gallary</h2>
        </div>

        <div class="portfolio-preview-grid">
            <img src="/photos/makeup1.jpg" alt="Portfolio work">
            <img src="/photos/hair1.jpg" alt="Portfolio work">
            <img src="/photos/hair2.jpg" alt="Portfolio work">
            <img src="/photos/hair3.jpg" alt="Portfolio work">
            <img src="/photos/profilepic.png" alt="Portfolio work">
        </div>

        <div class="profile-bottom-actions">
            <a href="/provider-dashboard" class="provider-back-button">← Back to Dashboard</a>
        </div>

    </section>

</main>

</body>
</html>