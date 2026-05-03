<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GlowUp Services</title>
    <link rel="stylesheet" href="/style.css">
</head>

<body>

<header class="top-header provider-top-header">
    <nav class="nav-bar">
        <div class="brand">
            <img src="/image/logo.jpg" class="logo-banner" alt="GlowUp Logo">
        </div>

        <div class="nav-links">
            <a href="/services-page" class="active-link">Services</a>
            <a href="/availability-page">Availability</a>
            <a href="#">Profile</a>
            <a href="#">Log out</a>
        </div>
    </nav>
</header>

<section class="provider-shell">
    <div class="provider-panel">

        <div class="provider-hero">
            <div class="provider-hero-left">
                <h2>My Services ✨</h2>
                <p>Manage and showcase the services you offer to your clients.</p>
            </div>
        </div>

        <div class="provider-action">
            <a href="/services/create-form" class="btn">+ Create New Service</a>
        </div>

        <div class="provider-list">
            <#list services as service>
                <#assign name = service.name?lower_case>

                <div class="service-row">
                    <div class="service-left">
                        <div class="service-icon">
                            <#if name?contains("makeup") || name?contains("glam") || name?contains("lashes") || name?contains("bridal")>
                                💄
                            <#elseif name?contains("hair") || name?contains("cut") || name?contains("haircut") || name?contains("bangs")>
                                ✂️
                            <#else>
                                ✨
                            </#if>
                        </div>

                        <div>
                            <div class="service-name">${service.name}</div>
                            <div class="service-desc">${service.description}</div>
                        </div>
                    </div>

                    <div class="service-price">$${service.price}</div>

                    <div class="card-actions">
                        <a href="/services/edit/${service.serviceId}" class="small-btn">Edit</a>
                        <a href="/services/delete/${service.serviceId}" class="small-btn delete">Delete</a>
                    </div>
                </div>
            </#list>
        </div>

        <div class="provider-bottom-callout">
            <div class="provider-bottom-left">
                <div class="callout-icon">✨</div>
                <div>
                    <h3>Keep your services up to date</h3>
                    <p>Update your services and availability to keep clients happy and coming back!</p>
                </div>
            </div>

            <a href="/availability-page" class="btn">Go to Availability →</a>
        </div>

    </div>
</section>

</body>
</html>