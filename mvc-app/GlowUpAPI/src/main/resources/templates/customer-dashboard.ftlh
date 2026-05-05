<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>

    <link rel="stylesheet" href="/provider.css">
    <link rel="stylesheet" href="/customer.css">
</head>

<body class="provider-page customer-page">

    <!-- ================= HEADER ================= -->
    <header class="provider-header">
        <div class="provider-logo">
            <img src="/photos/logo.png" alt="GlowUp Logo">
        </div>

        <!-- CLEAN NAV (NO PROFILE HERE) -->
        <nav class="provider-nav">
            <a href="/customer-dashboard">Dashboard</a>
            <a href="/browse">Browse Professionals</a>
            <a href="/logout" class="provider-nav-btn">Log Out</a>
        </nav>
    </header>

    <!-- ================= MAIN ================= -->
    <main class="provider-main">

        <div style="width: 100%; max-width: 1200px; margin: 0 auto;">

            <!-- ========== WELCOME CARD ========== -->
            <section class="provider-dashboard-card">

                <h1>
                    Welcome, ${userName!"User"} ✨
                </h1>

                <p class="provider-subtitle">
                    Find your beauty and embrace your glow.
                </p>

                <!-- DASHBOARD ACTIONS -->
                <div class="provider-dashboard-grid">

                    <!-- Browse -->
                    <a href="/browse" class="provider-dashboard-link">
                        <h3>Browse Professionals</h3>
                        <p>Discover services and beauty experts near you.</p>
                    </a>

                    <!-- Bookings -->
                    <a href="/customer-bookings" class="provider-dashboard-link">
                        <h3>Your Bookings</h3>
                        <p>View and manage your appointments.</p>
                    </a>

                    <!-- Reviews -->
                    <a href="/customer-reviews" class="provider-dashboard-link">
                        <h3>Your Reviews</h3>
                        <p>Manage your feedback and ratings.</p>
                    </a>

                    <!-- Edit Profile (ONLY place it exists) -->
                    <a href="/edit-profile" class="provider-dashboard-link">
                        <h3>Edit Profile</h3>
                        <p>Update your personal information.</p>
                    </a>

                </div>

            </section>

            <!-- ========== RECOMMENDED PROVIDERS ========== -->
            <section class="provider-dashboard-card" style="margin-top: 30px;">

                <h1>Recommended Professionals 💄</h1>

                <p class="provider-subtitle">
                    Discover top beauty experts
                </p>

                <div class="provider-dashboard-grid">

                    <#if providers?? && providers?size gt 0>

                        <#list providers as p>

                            <a href="/provider/${p.userId}" class="provider-dashboard-link">

                                <!-- IMAGE -->
                                <#if p.profileImage?? && p.profileImage !="">
                                    <img src="${p.profileImage}" class="provider-card-img">
                                    <#else>
                                        <img src="/photos/profilepic.png" class="provider-card-img">
                                </#if>

                                <!-- NAME -->
                                <h3>
                                    ${p.businessName!"Beauty Professional"}
                                </h3>

                                <!-- SPECIALTY -->
                                <p>
                                    ${p.specialty!"Beauty Services"}
                                </p>

                            </a>

                        </#list>

                        <#else>

                            <div class="provider-dashboard-link">

                                <h3>No Professionals Yet</h3>

                                <p>
                                    Check back later as providers join!
                                </p>

                            </div>

                    </#if>

                </div>

            </section>

        </div>

    </main>

</body>

</html>