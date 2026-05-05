<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Provider Profile</title>
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

    <section class="provider-content-card provider-form-card">

        <div class="provider-page-title">
            <h1>Edit Profile ✨</h1>
            <p>Update your business profile information customers will see.</p>
        </div>

        <#if beauty.profileImage?? && beauty.profileImage != "">
            <div class="edit-profile-preview">
                <img src="${beauty.profileImage}" alt="Current Profile Image">
                <p>Current profile image</p>
            </div>
        <#else>
            <div class="edit-profile-preview">
                <img src="/photos/profilepic.png" alt="Default Profile Image">
                <p>Default profile image</p>
            </div>
        </#if>
        
        <form action="/provider-profile/update" method="post" class="provider-form">

            <label>Business Name</label>
            <input type="text" name="businessName" value="${beauty.businessName!''}" required>

            <input type="hidden" name="specialty" value="${beauty.specialty!'Beauty Services'}">

            <label>Bio</label>
            <textarea name="bio" rows="5" placeholder="Write a short bio about your salon or beauty services.">${beauty.bio!''}</textarea>

            <label>Profile Image Path</label>
            <input type="text" name="profileImage" value="${beauty.profileImage!''}" placeholder="/photos/profilepic.png">

            <button type="submit" class="provider-main-btn">Update Profile</button>

        </form>

        <hr class="profile-divider">

        <div class="provider-page-title sample-work-title">
            <h1>Sample Work</h1>
            <p>Add image paths for your makeup, hair, nails, or beauty work.</p>
        </div>

        <form action="/provider-sample-work/add" method="post" class="provider-form">

            <label>Sample Work Image Path</label>
            <input type="text" name="imageUrl" placeholder="/photos/makeup1.jpg" required>

            <button type="submit" class="provider-main-btn">Add Sample Work</button>

        </form>

        <div class="edit-sample-work-grid">
            <#list portfolios as portfolio>
                <div class="edit-sample-work-card">
                    <img src="${portfolio.imageUrl}" alt="Sample work photo">
                    <a href="/provider-sample-work/delete/${portfolio.portfolioId}" class="provider-small-btn delete">Delete</a>
                </div>
            </#list>

            <#if portfolios?size == 0>
                <p class="provider-empty-text">No sample work photos added yet.</p>
            </#if>
        </div>

        <div class="provider-form-actions">
            <a href="/provider-profile" class="provider-main-btn">Back to Profile</a>
        </div>

    </section>

</main>

</body>
</html>