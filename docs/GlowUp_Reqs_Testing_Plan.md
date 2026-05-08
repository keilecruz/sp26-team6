**Project Name:** GlowUp  
**Version:** 1.0  
**Date:** 2026-05-04  
**Purpose:** GlowUp is a web-based platform that connects customers with beauty professionals. Customers can browse providers, view services and availability, book appointments, and leave reviews. Providers can manage their professional profile, sample work gallery, services, availability, bookings, and customer reviews.

## Actors
- Provider P: Beauty Professional
- Customer C: Customer
- Service S: Beauty service (hair, nails, makeup, etc.)

## Use Cases

#### 1. Customer: US-CUST-001 — Register & Manage Profile
1. Customer registers an account  
2. Customer logs in  
3. Customer edits profile information  
4. System saves updates  
5. Customer logs out  

#### 2. Customer: US-CUST-002 — Browse & View Providers
1. Customer navigates to the “Browse” page  
2. Customer searches or filters providers  
3. System displays matching providers  
4. Customer clicks “View Profile”  
5. Provider profile is displayed  

#### 3. Customer: US-CUST-003 — Book Appointment
1. Customer selects a provider  
2. Customer clicks “Book Appointment”  
3. Customer enters name and phone number  
4. Customer selects a time slot and service  
5. Customer submits booking  
6. Booking appears in “Your Appointments” with PENDING status  

#### 4. Customer: US-CUST-004 — Manage Bookings
1. Customer views appointments  
2. Customer sees booking status  
3. Customer cancels a booking if needed  

#### 5. Customer: US-CUST-005 — Leave & Manage Reviews
1. Customer writes a review  
2. Customer submits rating and comment  
3. Review is saved  
4. Review appears on the provider profile and reviews page  

#### 6. Provider: US-PROV-001 — Manage Professional Profile
1. Provider logs in  
2. Provider opens the provider dashboard  
3. Provider views their professional profile  
4. Provider edits business name, bio, profile image, or sample work gallery  
5. System saves updates  
6. Updated profile information appears on the provider profile page  

#### 7. Provider: US-PROV-002 — Manage Services
1. Provider logs in  
2. Provider navigates to “Manage Services”  
3. Provider creates a new service with name, description, and price  
4. Provider edits or deletes an existing service  
5. System saves service data connected to the logged-in provider  

#### 8. Provider: US-PROV-003 — Manage Availability
1. Provider logs in  
2. Provider navigates to “Manage Availability”  
3. Provider creates available time slots  
4. Provider deletes unavailable or incorrect slots  
5. System saves availability data connected to the logged-in provider  

#### 9. Provider: US-PROV-004 — View Reviews and Average Rating
1. Provider logs in  
2. Provider opens the reviews page  
3. Provider views all customer reviews connected to their profile  
4. Provider sees the average rating based on submitted customer reviews  
5. Provider cannot submit, edit, or delete customer reviews  

#### 10. Provider: US-PROV-005 — View and Confirm Bookings
1. Provider logs in  
2. Provider opens the bookings page  
3. Provider views customer booking details, including customer name, phone number, selected service, selected availability, and status  
4. New bookings appear with PENDING status  
5. Provider clicks “Confirm Booking”  
6. Booking status updates from PENDING to CONFIRMED  

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

### Performance Requirements

**Scenario P1: Browse page response time < 1.5 seconds**
- **Setup:** Server under typical load
- **Steps:**
  1. Measure response time for the “Browse” page with 5–10 providers and 10+ services
  2. Repeat 10 times
- **Expected Outcome:**
  - 95% of requests load within 1.5 seconds
  - Providers and services load correctly without major delay

**Scenario P2: Booking submission response time < 1.0 second**
- **Setup:** Active system with multiple users
- **Steps:**
  1. Customer selects provider, service, and time slot
  2. Customer submits booking request
  3. Measure response time
- **Expected Outcome:**
  - Booking completes within 1.0 second
  - Booking appears in “Your Appointments”
  - Booking appears on the provider bookings page with PENDING status

### Security & Privacy Requirements

**Scenario S1: Role-based access control**
- **Setup:** Customer attempts to access provider dashboard
- **Steps:**
  1. Customer logs in
  2. Navigates to `/provider-dashboard`
  3. Observes system response
- **Expected Outcome:**
  - Access is denied or redirected
  - Customer is redirected to dashboard or login page
  - No provider-only data is exposed

**Scenario S2: Provider cannot edit or delete customer reviews**
- **Setup:** Customer has written a review for a provider
- **Steps:**
  1. Provider logs in
  2. Provider opens the reviews page
  3. Provider checks available review actions
- **Expected Outcome:**
  - Provider can view reviews and average rating
  - Provider cannot submit, edit, or delete customer reviews
  - Customer review content remains unchanged by the provider

### Usability Requirements

**Scenario U1: New user completes first booking in ≤ 3 minutes**
- **Setup:** New customer account, observer records time
- **Steps:**
  1. User logs in
  2. Navigates to “Browse”
  3. Selects a provider
  4. Clicks “Book Appointment”
  5. Enters name and phone number
  6. Selects time slot and service
  7. Submits booking
- **Expected Outcome:**
  - Booking is completed in ≤ 3 minutes
  - User understands the flow without assistance

**Scenario U2: Provider creates availability in ≤ 5 minutes**
- **Setup:** New provider account, observed session
- **Steps:**
  1. Provider logs in
  2. Navigates to availability management
  3. Adds time slots
  4. Saves availability
  5. Record total time
- **Expected Outcome:**
  - Availability is created in ≤ 5 minutes
  - Slots appear correctly on the provider availability page
  - Customers can view and book available slots