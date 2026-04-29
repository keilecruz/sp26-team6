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
                <a href="dashboard.html"> Dashboard</a>
                <a href="login.html" class="btn"> Log Out </a>

            </div>

        </nav>

    </header>

    <section class="browse-section">


        <h2 class="page-title">Browse Beauty Professionals</h2>

        <!-- Search Bar -->
        <div class="search-bar">
            <input type="text" placeholder="Search by name or service...">
            <button class="search-btn">Search</button>
        </div>

        <!-- Filter Bar -->
        <div class="filter-bar">
            <select>
                <option>All Services</option>
                <option>Hair Stylist</option>
                <option>Makeup Artist</option>
                <option>Nail Technician</option>
            </select>

            <select>
                <option>Sort By</option>
                <option>Highest Rated</option>
                <option>Most Experience</option>
            </select>
        </div>

        <!-- Professionals Grid -->
        <div class="professionals-grid">

            <#if professionals?? && professionals?size gt 0>

                <#list professionals as prof>

                    <div class="professional-card">

                        <img src="${prof.imageUrl!'/photos/default.jpg'}" alt="${prof.name}">

                        <h3>${prof.name}</h3>

                        <p>${prof.specialty} | ${prof.experience} Years Experience</p>

                        <p>
                            Rating:
                            <#if prof.rating??>
                                ${prof.rating}
                                <#else>
                                    Not rated
                            </#if>
                        </p>

                        <div class="card-buttons">
                            <a href="/portfolio/${prof.id}" class="bubble-btn">View Portfolio</a>
                            <a href="/booking/${prof.id}" class="bubble-btn">Book Appointment</a>
                        </div>

                    </div>

                </#list>

                <#else>

                    <p>No professionals available at the moment.</p>

            </#if>

        </div>

    </section>


</body>

</html>