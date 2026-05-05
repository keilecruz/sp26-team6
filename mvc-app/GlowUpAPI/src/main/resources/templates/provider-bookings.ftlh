<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Bookings</title>
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
            <h1>My Bookings ✨</h1>
            <p>View customer booking requests and appointments here.</p>
        </div>

        <#if bookings?size == 0>

            <div class="booking-empty-card">
                <div class="booking-empty-icon">📅</div>

                <h2>No bookings yet</h2>

                <p>
                    When customers book your services, their appointment details will appear here.
                </p>
            </div>

        <#else>

            <div class="provider-list">

                <#list bookings as booking>

                    <div class="provider-service-row booking-row">

                        <div class="provider-service-left">
                            <div class="provider-service-icon">📅</div>

                            <div>
                                <h3>${booking.service.name!"Booked Service"}</h3>

                                <p>
                                    Availability:
                                    ${booking.availability.date!"No date"}
                                    at
                                    ${booking.availability.time!"No time"}
                                </p>

                                <p>Status: ${booking.status!"PENDING"}</p>
                            </div>
                        </div>

                        <div class="booking-action-area">
                            <#if booking.status?? && booking.status == "CONFIRMED">
                                <p class="booking-confirmed-text">Confirmed</p>
                            <#else>
                                <a href="/provider-bookings/confirm/${booking.id}" class="provider-main-btn booking-confirm-btn">
                                    Confirm Booking
                                </a>
                            </#if>
                        </div>

                    </div>

                </#list>

            </div>

        </#if>

        <div class="provider-callout booking-callout">
            <div>
                <h3>Stay ready for your appointments</h3>
                <p>Review your customer bookings and prepare for upcoming services.</p>
            </div>

            <div class="provider-callout-buttons">
                <a href="/provider-dashboard" class="provider-main-btn">← Back to Dashboard</a>
                <a href="/provider-profile" class="provider-main-btn">Back to Profile →</a>
            </div>
        </div>

    </section>

</main>

</body>
</html>