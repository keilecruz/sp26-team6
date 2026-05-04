<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Availability - GlowUp</title>
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

    <section class="provider-content-card">

        <div class="provider-page-title">
            <h1>My Availability ✨</h1>
            <p>Manage your schedule so clients can book easily.</p>
        </div>

        <div class="provider-action-row">
            <a href="/availability/create-form" class="provider-main-btn">+ Create Availability</a>
        </div>

        <div class="provider-list">
            <#list availabilities as availability>

                <div class="provider-service-row">

                    <div class="provider-service-left">
                        <div class="provider-service-icon">📅</div>

                        <div>
                            <h3>${availability.date}</h3>
                            <p>Available Slot</p>
                        </div>
                    </div>

                    <div class="provider-service-price">
                        ${availability.time}
                    </div>

                    <div class="provider-row-actions">
                        <a href="/availability/delete/${availability.id}" class="provider-small-btn delete">Delete</a>
                    </div>

                </div>

            </#list>

            <#if availabilities?size == 0>
                <p class="provider-empty-text">No availability added yet.</p>
            </#if>
        </div>

        <div class="provider-callout">
            <div>
                <h3>Keep your booking flow smooth</h3>
                <p>Update your availability so clients know exactly when they can book you.</p>
            </div>

            <div class="provider-callout-buttons">
                <a href="/provider-dashboard" class="provider-main-btn">← Back to Dashboard</a>
                <a href="/services-page" class="provider-main-btn">Go to Services →</a>
            </div>
        </div>

    </section>

</main>

</body>
</html>