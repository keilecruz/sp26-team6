<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GlowUp Browse Professionals</title>
    <link rel="stylesheet" href="/style.css">

    <!--- Users can filter and sort to find other professionals -->

</head>

<body>


    <!--- Top Header-->
    <header class="top-header">
        <nav>
            <img src="../../photos/logo.jpg" alt="GlowUp logo" class="logo">

            <div class="nav-links">
                <a href="/profile"> Profile</a>
                <a href="/login" class="btn"> Log Out </a>

            </div>

        </nav>

    </header>

    <section class="browse-section">


        <h2 class="page-title">Browse Beauty Professionals</h2>

        <form method="get" action="/browse">

            <!-- Search -->
            <div class="search-bar">
                <input type="text" name="keyword" placeholder="Search by name or service...">
                <button type="submit" class="search-btn">Search</button>
            </div>

            <!-- Filter -->
            <div class="filter-bar">
                <select name="category">
                    <option value="">All Services</option>
                    <option value="Hair">Hair Stylist</option>
                    <option value="Makeup">Makeup Artist</option>
                    <option value="Nails">Nail Technician</option>
                </select>

                <button type="submit" class="bubble-btn">Apply</button>
                
            </div>

        </form>

        <!-- Professionals Grid -->
        <div class="professionals-grid">

            <#if services?? && services?size gt 0>

                <#list services as service>

                    <div class="professional-card">

                        <img src="${service.imageUrl!'/photos/default.jpg'}" alt="${service.beauty.businessName!''}">

                        <h3>${service.name}</h3>

                        <p>${service.description!''}</p>

                        <p><strong>$${service.price}</strong></p>

                        <p>
                            By: ${service.beauty.businessName!''}
                        </p>

                        <p>${service.beauty.specialty!''}</p>

                        <div class="card-buttons">
                            <a href="/portfolio/${service.beauty.userId!''}" class="bubble-btn">View Portfolio</a>
                            <a href="/booking/${service.serviceId!''}" class="bubble-btn">Book Appointment</a>
                        </div>

                </#list>

                <#else>

                    <p>No services available at the moment.</p>

            </#if>

        </div>

    </section>


</body>

</html>