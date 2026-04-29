<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Availability - GlowUp</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>

<header class="top-header provider-top-header">
    <nav class="nav-bar">
        <div class="brand">
            <img src="/image/logo.jpg" class="logo-banner" alt="GlowUp Logo">
        </div>

        <div class="nav-links">
            <a href="/services-page">Services</a>
            <a href="/availability-page" class="active-link">Availability</a>
            <a href="#">Profile</a>
            <a href="#">Log out</a>
        </div>
    </nav>
</header>

<section class="provider-shell">
    <div class="provider-panel">

        <div class="provider-hero">
            <div class="provider-hero-left">
                <h2>My Availability ✨</h2>
                <p>Manage your schedule so clients can book easily.</p>
            </div>
        </div>

        <div class="provider-action">
            <a href="/availability/create-form" class="btn">+ Create Availability</a>
        </div>

        <div class="provider-list">
            <#list availabilities as availability>
                <div class="service-row">

                    <div class="service-left">
                        <div class="service-icon">📅</div>

                        <div>
                            <div class="service-name">${availability.date}</div>
                            <div class="service-desc">Available Slot</div>
                        </div>
                    </div>

                    <div class="service-price">${availability.time}</div>

                    <div class="card-actions">
                        <a href="/availability/delete/${availability.id}" class="small-btn delete">Delete</a>
                    </div>

                </div>
            </#list>
        </div>

        <div class="provider-bottom-callout">
            <div class="provider-bottom-left">
                <div class="callout-icon">✨</div>
                <div>
                    <h3>Keep your booking flow smooth</h3>
                    <p>Update your services so clients know exactly when you are available.</p>
                </div>
            </div>

            <a href="/services-page" class="btn">Go to Services →</a>
        </div>

    </div>
</section>

</body>
</html>