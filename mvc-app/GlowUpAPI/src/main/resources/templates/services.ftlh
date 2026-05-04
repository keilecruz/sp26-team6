<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GlowUp Services</title>
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
            <h1>My Services ✨</h1>
            <p>Manage and showcase the services you offer to your clients.</p>
        </div>

        <div class="provider-action-row">
            <a href="/services/create-form" class="provider-main-btn">+ Create New Service</a>
        </div>

        <div class="provider-list">
            <#list services as service>
                <#assign name = service.name?lower_case>

                <div class="provider-service-row">

                    <div class="provider-service-left">
                        <div class="provider-service-icon">
                            <#if name?contains("makeup") || name?contains("glam") || name?contains("lashes") || name?contains("bridal")>
                                💄
                            <#elseif name?contains("hair") || name?contains("cut") || name?contains("haircut") || name?contains("bangs")>
                                ✂️
                            <#else>
                                ✨
                            </#if>
                        </div>

                        <div>
                            <h3>${service.name}</h3>
                            <p>${service.description}</p>
                        </div>
                    </div>

                    <div class="provider-service-price">
                        $${service.price}
                    </div>

                    <div class="provider-row-actions">
                        <a href="/services/edit/${service.serviceId}" class="provider-small-btn">Edit</a>
                        <a href="/services/delete/${service.serviceId}" class="provider-small-btn delete">Delete</a>
                    </div>

                </div>
            </#list>

            <#if services?size == 0>
                <p class="provider-empty-text">No services added yet.</p>
            </#if>
        </div>

        <div class="provider-callout">
            <div>
                <h3>Keep your services up to date</h3>
                <p>Update your services and availability so customers can book the right service at the right time.</p>
            </div>

            <div class="provider-callout-buttons">
                <a href="/provider-dashboard" class="provider-main-btn">← Back to Dashboard</a>
                <a href="/availability-page" class="provider-main-btn">Go to Availability →</a>
            </div>
        </div>

    </section>

</main>

</body>
</html>