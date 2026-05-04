<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Your Bookings</title>

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
            <a href="/browse">Browse Professionals</a>
            <a href="/logout" class="provider-nav-btn">Log Out</a>
        </nav>
    </header>

    <!-- MAIN -->
    <main class="provider-main">

        <div style="width: 100%; max-width: 1200px; margin: 0 auto;">

            <section class="provider-dashboard-card">

                <h1>Your Appointments 📅</h1>

                <p class="provider-subtitle">
                    View and manage your bookings
                </p>

                <div class="provider-dashboard-grid">

                    <#if bookings?? && bookings?size gt 0>

                        <#list bookings as b>

                            <div class="provider-dashboard-link">

                                <!-- SERVICE -->
                                <h3>${b.service.name}</h3>

                                <!-- DATE & TIME -->
                                <p>
                                    ${b.availability.date} - ${b.availability.time}
                                </p>

                                <!-- PROVIDER -->
                                <p>
                                    ${b.beauty.businessName}
                                </p>

                                <!-- STATUS -->
                                <p>Status: ${b.status}</p>

                                <!-- ACTIONS -->
                                <div style="margin-top: 10px;">

                                    <!-- CANCEL -->
                                    <form action="/book/cancel" method="post" style="margin-bottom: 8px;">
                                        <input type="hidden" name="bookingId" value="${b.id}">
                                        <button type="submit" class="provider-main-btn">
                                            Cancel Booking
                                        </button>
                                    </form>

                                    <!-- REVIEW (placeholder for later) -->
                                    <a href="/review/${b.beauty.userId}" class="provider-main-btn">
                                        Write Review
                                    </a>

                                </div>

                            </div>

                        </#list>

                        <#else>

                            <div class="provider-dashboard-link">
                                <h3>No Bookings Yet</h3>
                                <p>Start by booking a service!</p>
                            </div>

                    </#if>

                </div>

            </section>

        </div>

    </main>

</body>

</html>