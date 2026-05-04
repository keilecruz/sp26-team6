<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GlowUp Portfolio</title>
    <link rel="stylesheet" href="/style.css">
</head>

<body>

<!-- HEADER -->
<header class="top-header">
    <nav>
        <img src="/photos/logo.jpg" class="logo">

        <div class="nav-links">
            <a href="/browse">Browse Professionals</a>
            <a href="/dashboard">Dashboard</a>
            <a href="/login" class="btn">Log Out</a>
        </div>
    </nav>
</header>

<section class="portfolio-section">

    <!-- PROFESSIONAL INFO -->
    <div class="portfolio-header">
        <h2>${beauty.businessName!''}</h2>
        <p>${beauty.specialty!''}</p>
    </div>

    <!-- SERVICES OFFERED -->
    <div class="portfolio-services">
        <h3>Services Offered</h3>

        <#if beauty.services?? && beauty.services?size gt 0>

            <#list beauty.services as service>

                <div class="service-card">
                    <h4>${service.name}</h4>
                    <p>${service.description!''}</p>
                    <p><strong>$${service.price}</strong></p>
                </div>

            </#list>

        <#else>
            <p>No services available.</p>
        </#if>
    </div>

    <!-- PORTFOLIO GALLERY -->
    <div class="portfolio-gallery">
        <h3>Portfolio</h3>

        <#if portfolios?? && portfolios?size gt 0>

            <#list portfolios as item>
                <img src="${item.imageUrl!'/photos/default.jpg'}" alt="Work Example">
            </#list>

        <#else>

            <!-- fallback images if none in DB -->
            <img src="/photos/hair1.jpg">
            <img src="/photos/hair2.jpg">
            <img src="/photos/hair3.jpg">

        </#if>
    </div>

    <!-- REVIEWS (leave static for now) -->
    <div class="portfolio-reviews">
        <h3>Customer Reviews</h3>

        <div class="review-card">
            <p>★★★★★</p>
            <p>"Great service and very professional!"</p>
        </div>

        <div class="review-card">
            <p>★★★★☆</p>
            <p>"Loved the results, would book again."</p>
        </div>
    </div>

    <!-- ACTION BUTTONS -->
    <div class="portfolio-action">

        <a href="/browse" class="bubble-btn">← Back to Browse</a>

        <a href="/booking/${beauty.userId!''}" class="bubble-btn">
            Book Appointment
        </a>

    </div>

</section>

</body>
</html>