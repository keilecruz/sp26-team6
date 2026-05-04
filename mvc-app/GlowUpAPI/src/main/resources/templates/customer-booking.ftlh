<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Book Appointment</title>

    <link rel="stylesheet" href="/provider.css">
</head>

<body class="provider-page">

    <!-- HEADER -->
    <header class="provider-header">
        <div class="provider-logo">
            <img src="/photos/logo.png" alt="GlowUp Logo">
        </div>

        <nav class="provider-nav">
            <a href="/customer-dashboard">Dashboard</a>
            <a href="/browse">Browse</a>
            <a href="/logout" class="provider-nav-btn">Log Out</a>
        </nav>
    </header>

    <!-- MAIN -->
    <main class="provider-main">

        <section class="profile-card">

            <h1>Book Appointment ✨</h1>

            <form action="/book" method="post">

                <!-- Hidden Beauty ID -->
                <input type="hidden" name="beautyId" value="${beautyId}">

                <hr class="profile-divider">

                <!-- TIME SLOT -->
                <h2>Select Time</h2>

                <#if slots?? && slots?size gt 0>
                    <select name="availabilityId" required>
                        <#list slots as s>
                            <option value="${s.id}">
                                ${s.date} - ${s.time}
                            </option>
                        </#list>
                    </select>
                    <#else>
                        <p class="provider-empty-text">No available time slots.</p>
                </#if>

                <hr class="profile-divider">

                <!-- SERVICES -->
                <h2>Select Service</h2>

                <#if services?? && services?size gt 0>
                    <select name="serviceId" required>
                        <#list services as s>
                            <option value="${s.serviceId}">
                                ${s.name} - $${s.price}
                            </option>
                        </#list>
                    </select>
                    <#else>
                        <p class="provider-empty-text">No services available.</p>
                </#if>

                <hr class="profile-divider">

                <!-- SUBMIT BUTTON -->
                <#if (slots?? && slots?size gt 0) && (services?? && services?size gt 0)>
                    <button type="submit" class="provider-main-btn">
                        Book Appointment
                    </button>
                    <#else>
                        <button type="button" class="provider-main-btn" disabled>
                            Booking Unavailable
                        </button>
                </#if>

            </form>

            <!-- BACK BUTTON -->
            <div class="profile-bottom-actions">
                <a href="/provider/${beautyId}" class="provider-back-button">
                    ← Back to Profile
                </a>
            </div>

        </section>

    </main>

</body>

</html>