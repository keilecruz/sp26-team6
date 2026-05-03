<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GlowUp Dashboard</title>
    <link rel="stylesheet" href="style.css">

    <!--- Users can look at dashboard-->

</head>

<body>

    <!--- Top Header-->
    <header class="top-header">
        <nav>
            <img src="../../photos/logo.jpg" alt="GlowUp logo" class="logo">

            <div class="nav-links">
                <a href="/browse"> Browse Professional</a>
                <a href="/login" class="btn"> Log Out </a>

            </div>
        </nav>
    </header>

    <!--- Dashboard Section -->
    <section class="dashboard">

        <div class="container welcome-header">
            <img src="../../photos/profilepic.png" alt="Profile Icon" class="profile-icon">
            <h2>Welcome, ${userName!"User"}!</h2>
            <p>Find your beauty and embrace your glow.</p>

            <a href="/edit-profile" class="edit-profile-btn">Edit Profile</a>
        </div>

        <div class="cards-box">
            <h3>Recommended Professionals</h3>

            <div class="empty-state">
                <p>No recommendations yet.</p>
                <p>Browse services to discover professionals!</p>

                <a href="/browse" class="bubble-btn">Browse Services</a>
            </div>
        </div>

    </section>

</body>

</html>