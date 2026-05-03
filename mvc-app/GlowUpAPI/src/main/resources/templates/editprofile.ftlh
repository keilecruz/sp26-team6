<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="/style.css">
</head>

<body>

    <header class="top-header">
        <nav>
            <img src="/photos/logo.jpg" class="logo">

            <div class="nav-links">
                <a href="/browse">Browse Professional</a>
                <a href="/dashboard">Profile</a>
                <a href="/login" class="btn">Log Out</a>
            </div>
        </nav>
    </header>

    <section class="edit-profile-section">

        <div class="edit-profile-container">

            <h2>Edit Your Profile</h2>

            <!-- PROFILE FORM -->
            <form class="edit-profile-form" action="/profile/update" method="post">

                <!-- hidden ID (IMPORTANT) -->
                <input type="hidden" name="id" value="${customer.id!''}">

                <label>Full Name</label>
                <input type="text" name="firstName" value="${customer.firstName!''}">

                <label>Last Name</label>
                <input type="text" name="lastName" value="${customer.lastName!''}">

                <label>Email Address</label>
                <input type="email" name="email" value="${customer.email!''}">

                <label>Password</label>
                <input type="password" name="password" value="${customer.password!''}">

                <label>Phone Number</label>
                <input type="tel" name="phone" value="${customer.phone!''}">

                <label>Beauty Preferences</label>
                <select name="role">

                    <option value="CUSTOMER" <#if customer.role=="CUSTOMER">selected</#if>>
                        Customer
                    </option>

                </select>

                <div class="form-buttons">
                    <a href="/dashboard" class="bubble-btn">Cancel</a>
                    <button type="submit" class="bubble-btn">Save Changes</button>
                </div>

            </form>

        </div>

    </section>

</body>

</html>