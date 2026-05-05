<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Your Reviews</title>

    <link rel="stylesheet" href="/provider.css">
    <link rel="stylesheet" href="/customer.css">
</head>

<body class="provider-page customer-page">

    <!-- HEADER -->
    <header class="provider-header">
        <div class="provider-logo">
            <img src="/photos/logo.png" alt="GlowUp Logo">
        </div>

        <nav class="provider-nav">
            <a href="/customer-dashboard">Dashboard</a>
            <a href="/customer-bookings">Your Bookings</a>
            <a href="/browse">Browse</a>
            <a href="/logout" class="provider-nav-btn">Log Out</a>
        </nav>
    </header>

    <!-- MAIN -->
    <main class="provider-main">

        <div style="width: 100%; max-width: 1200px; margin: 0 auto;">

            <section class="provider-dashboard-card">

                <h1>Your Reviews ⭐</h1>

                <p class="provider-subtitle">
                    Manage your feedback and ratings
                </p>

                <div class="provider-dashboard-grid">

                    <#if reviews?? && reviews?size gt 0>

                        <#list reviews as r>

                            <div class="provider-dashboard-link">

                                <h3>
                                    ${r.beauty.businessName!"Beauty Professional"}
                                </h3>

                                <p>
                                    Rating: ⭐ ${r.rating}
                                </p>

                                <p>
                                    ${r.comment!""}
                                </p>

                                <p style="font-size: 12px; opacity: 0.7;">
                                    By: ${r.reviewerName!"You"}
                                </p>

                                <div class="review-actions">

                                    <a href="/review/edit/${r.reviewId}" class="provider-main-btn">
                                        Edit
                                    </a>

                                    <form action="/review/delete" method="post">
                                        <input type="hidden" name="reviewId" value="${r.reviewId}">
                                        <button type="submit" class="provider-main-btn">
                                            Delete Review
                                        </button>
                                    </form>

                                </div>

                            </div>

                        </#list>

                        <#else>

                            <div class="provider-dashboard-link">
                                <h3>No Reviews Yet</h3>
                                <p>
                                    You haven’t written any reviews yet.
                                </p>
                            </div>

                    </#if>

                </div>

            </section>

        </div>

    </main>

</body>

</html>