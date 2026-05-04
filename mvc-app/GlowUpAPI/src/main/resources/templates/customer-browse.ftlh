<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GlowUp Browse Professionals</title>

    <!-- ✅ Use same design system -->
    <link rel="stylesheet" href="/provider.css">
</head>

<body class="provider-page">

    <!-- HEADER -->
    <header class="provider-header">
        <div class="provider-logo">
            <img src="/photos/logo.png" alt="GlowUp logo">
        </div>

        <nav class="provider-nav">
            <a href="/customer-dashboard">Dashboard</a>
            <a href="/browse">Browse</a>
            <a href="/logout" class="provider-nav-btn">Log Out</a>
        </nav>
    </header>

    <!-- MAIN -->
    <main class="provider-main">

        <div style="width: 100%; max-width: 1200px; margin: 0 auto;">

            <section class="provider-dashboard-card">

                <h1>Browse Beauty Professionals 💄</h1>
                <p class="provider-subtitle">
                    Search, filter, and book services from top providers
                </p>

                <!-- SEARCH + FILTER -->
                <form method="get" action="/browse" class="browse-form">

                    <!-- SEARCH -->
                    <div class="search-bar">

                        <input type="text" name="keyword" placeholder="Search by name or service..."
                            value="${keyword!''}" class="search-input">

                        <button type="submit" class="bubble-btn search-btn">
                            Search
                        </button>

                    </div>

                    <!-- FILTER -->
                    <div class="filter-bar">

                        <select name="category" class="filter-select">

                            <option value="">All Services</option>

                            <option value="Hair" <#if category?? && category=="Hair">selected</#if>>
                                Hair Stylist
                            </option>

                            <option value="Makeup" <#if category?? && category=="Makeup">selected</#if>>
                                Makeup Artist
                            </option>

                            <option value="Nails" <#if category?? && category=="Nails">selected</#if>>
                                Nail Technician
                            </option>

                        </select>

                        <button type="submit" class="bubble-btn filter-btn">
                            Apply
                        </button>

                    </div>

                </form>

                <!-- GRID -->
                <div class="provider-dashboard-grid" style="margin-top: 20px;">

                    <#if providers?? && providers?size gt 0>

                        <#list providers as p>

                            <div class="provider-dashboard-link">

                                <!-- IMAGE -->
                                <#if p.profileImage?? && p.profileImage !="">
                                    <img src="${p.profileImage}"
                                        style="width:100%; height:180px; object-fit:cover; border-radius:10px; margin-bottom:10px;">
                                    <#else>
                                        <img src="/photos/profilepic.png"
                                            style="width:100%; height:180px; object-fit:cover; border-radius:10px; margin-bottom:10px;">
                                </#if>

                                <!-- NAME -->
                                <h3>${p.businessName!"Beauty Professional"}</h3>

                                <!-- SPECIALTY -->
                                <p>${p.specialty!"Beauty Services"}</p>

                                <!-- BUTTONS -->
                                <div class="card-buttons">

                                    <a href="/provider/${p.userId}" class="card-btn view-btn">
                                        View Profile
                                    </a>

                                    <a href="/availability/${p.userId}" class="card-btn availability-btn">
                                        Availability
                                    </a>

                                </div>

                            </div>

                        </#list>

                        <#else>

                            <p>No professionals available yet.</p>

                    </#if>

                </div>

    </main>

</body>

</html>