**Project Name:** GlowUp  
**Team:** Keile Cruz-Maldonado; Maisha Fyruz  
**Course:** CSC 340  
**Version:** 1.0  
**Date:** 2026-02-12

---

## 1. Overview

**Vision.** GlowUp is a web-based platform that allows customers to connect with beauty and grooming professionals. Customers can view portfolios, services, book appointments, and leave reviews. Beauty and grooming professionals can manage their professional profile, services, availability, client appointments, sample work gallery, and view customer reviews and ratings.

**Glossary** 
- **Sample Work Gallery:** Collection of provider-uploaded image paths that display examples of the provider’s past beauty or grooming work.
- **Service Listing:** Published beauty and grooming service that includes description, price, and time.
- **Availability Slot:** Date and time window that a provider creates so customers can book appointments.
- **Appointment:** Scheduled service session between customer and provider.
- **Review:** Customer rating and written feedback about the completed service.
- **Booking Status:** Appointment status that begins as pending and can be confirmed by the provider.

**Primary Users / Roles**
- **Customer (client seeking beauty/grooming service)** — Discover providers; book and manage appointments; leave reviews.
- **Provider (beauty/grooming professional)** — Manage professional profile, sample work gallery, services, availability, bookings, and customer reviews/ratings.

**Scope (this semester)**
- Browse through provider profiles, sample work galleries, and services with filtering/sorting.
- Book appointments and manage bookings, including canceling customer bookings and confirming provider-side bookings.
- Provider onboarding; create/edit provider profile; manage sample work gallery; create, edit, and delete service listings; update availability slots.
- Reviews and ratings where customers can submit reviews and providers can view customer reviews and average rating.

**Out of scope (deferred)**
- Online payments and refund processing.
- SMS/email notification.
- Mobile app version.
- Real-time messaging/chat system.

---

## 2. Functional Requirements (User Stories)

### 2.1 Customer Stories

- **US-CUST-001 — Register and Manage Profile**  
  _Story:_ As a customer, I want to create and manage my profile, including name, contact information, and preferred services, so that I can book appointments and write reviews of my experience.  
  _Acceptance:_
  ```gherkin
  Scenario: Register with valid details
    Given I am not registered
    When  I sign up with required information
    Then  my customer profile is created and visible on my profile
  ```

- **US-CUST-002 — Browse Provider Profile and Portfolio**  
  _Story:_ As a customer, I want to browse provider profiles, portfolios, and service listings so that I can evaluate the provider’s experience before booking.  
  _Acceptance:_
  ```gherkin
  Scenario: View provider profile
    Given multiple providers exist on the platform
    When  I select a provider profile
    Then  I can view the provider’s portfolio and see services, pricing, and ratings
  ```

- **US-CUST-003 — Filter and Search Services**  
  _Story:_ As a customer, I want to filter and search services by category, price, rating, and availability, so that I can find services that fit my needs and budget.  
  _Acceptance:_
  ```gherkin
  Scenario: Filter by category and sort by rating
    Given multiple services exist in different categories
    When  I filter by category "Women Haircuts" and sort by rating "High/Low"
    Then  I can only see women hair styling options ordered by highest rating first
  ```

- **US-CUST-004 — Book Appointment**  
  _Story:_ As a customer, I want to book an available time slot, so that I can secure an appointment with a provider.  
  _Acceptance:_
  ```gherkin
  Scenario: Book an available time slot
    Given I am logged in and a provider has available time slots
    When  I select a date and time and confirm booking
    Then  the appointment is saved in the system and appears on my dashboard
  ```

- **US-CUST-005 — Write a Review**  
  _Story:_ As a customer, I want to leave a rating and a written review after my appointment, so that I can share my experience with other customers.  
  _Acceptance:_
  ```gherkin
  Scenario: Submit review for completed appointment
    Given I have completed an appointment
    When  I submit a rating and written review
    Then  the review is published on the provider's profile and the provider can view it
  ```

### 2.2 Provider Stories

- **US-PROV-001 — Register and Manage Professional Profile**  
  _Story:_ As a provider, I want to create and manage my professional business profile, including business name, bio, profile image, and sample work gallery, so that customers can evaluate my work before booking.  
  _Acceptance:_
  ```gherkin
  Scenario: Create and update provider profile
    Given I am logged in as a provider
    When  I update my business name, bio, profile image, or sample work gallery
    Then  my updated provider profile is saved and visible on my provider profile page
  ```

- **US-PROV-002 — Manage Services**  
  _Story:_ As a provider, I want to create, edit, and delete my services, so that customers can see what services I offer and the prices before booking.  
  _Acceptance:_
  ```gherkin
  Scenario: Manage provider services
    Given I am logged in as a provider
    When  I create, edit, or delete a service
    Then  the updated service information is saved and connected to my provider account
  ```
- **US-PROV-003 — Manage Availability**  
  _Story:_ As a provider, I want to create and delete availability slots, so that customers can book appointments only during the times I am available.
  _Acceptance:_
  ```gherkin
  Scenario: Manage provider availability
    Given I am logged in as a provider
    When  I create or delete an availability slot
    Then  the updated availability information is saved and connected to my provider account
  ```
- **US-PROV-004 — View Customer Reviews and Average Rating**  
  _Story:_ As a provider, I want to view customer reviews and my average rating, so that I can understand customer feedback about my services.  
  _Acceptance:_
  ```gherkin
  Scenario: View customer reviews
    Given customers have submitted reviews for my provider profile
    When  I open the reviews page
    Then  I can see all customer reviews and the average rating for my provider account
  ```

- **US-PROV-005 — View and Confirm Customer Bookings**  
  _Story:_ As a provider, I want to view customer bookings and confirm pending appointments, so that customers know their appointment has been accepted.  
  _Acceptance:_
  ```gherkin
  Scenario: Confirm pending booking
    Given a customer has booked one of my services
    When  I open my bookings page and click confirm booking
    Then  the booking status changes from PENDING to CONFIRMED
  ```

---

## 3. Non-Functional Requirements

- **Performance:** The system should load main pages within 3 seconds under normal internet conditions.
- **Availability/Reliability:** The application should be available during the semester demonstration period and run consistently for the final demo.
- **Security/Privacy:** User accounts require login authentication, role-based access, and no real payment information will be stored in this prototype.
- **Usability:** The interface should be easy to navigate, readable on desktop devices, and provide clear buttons and labels for profile management, services, availability, reviews, and booking actions.

---

## 4. Assumptions, Constraints, and Policies

- The system is a semester project prototype and will not include full production-level features.
- Real payment processing will not be implemented in this prototype.
- Users must create an account before booking or reviewing services.
- Service providers are responsible for managing their own profile, services, availability, and booking confirmations.
- The project must follow UNCG academic integrity policies and appropriate content guidelines.
- Development is limited to the technologies required in CSC 340, including Java, Spring Boot, PostgreSQL, and a web interface.

---

## 5. Milestones (course-aligned)

- **M2 Requirements** — this file + stories opened as issues.
- **M3 High-fidelity prototype** — core customer/provider flows fully interactive.
- **M4 Design** — architecture, schema, API outline.
- **M5 Backend API** — key endpoints + tests.
- **M6 Increment** — at least 2 use cases end-to-end.
- **M7 Final** — complete system and documentation.

---

## 6. Change Management

- User stories are living artifacts, and changes are tracked through GitHub issues and linked pull requests.
- Major requirement changes should be updated in this SRS document.