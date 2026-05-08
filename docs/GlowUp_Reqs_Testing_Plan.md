**Project Name:**  GlowUp
**Version:** 1.0 
**Date:**  2026-05-04
**Purpose:** GlowUp is a web-based platform that connects customers with beauty professionals. Customers can browse services, book appointments, and leave reviews, while providers can manage their services, availability, and bookings

## Actors
- Provider P: Beauty Professional
- Customer C: Customer
- Service S: Beauty service (hair, nails, makeup, etc.)

## Use Cases
#### 1. Customer: US‑CUST‑001 — Register & manage profile
1. Customer registers an account  
2. Customer logs in  
3. Customer edits profile (name, email, phone)  
4. System saves updates  
5. Customer logs out 

#### 2. US-CUST-002 — Browse & View Providers
1. Customer navigates to “Browse” page  
2. Customer searches or filters providers  
3. System displays matching providers  
4. Customer clicks “View Profile”  
5. Provider profile is displayed  

#### 3. US-CUST-003 — Book Appointment
1. Customer selects a provider  
2. Customer clicks “Book Appointment”  
3. Customer selects time slot and service  
4. Customer submits booking  
5. Booking appears in “Your Bookings”  

#### 4. US-CUST-004 — Manage Bookings
1. Customer views bookings  
2. Customer cancels a booking  

#### 5. US-CUST-005 — Leave & Manage Reviews
1. Customer writes a review  
2. Customer submits rating and comment  
3. Review is saved  
4. Customer edits or deletes review  

#### 6. US-PROV-001 — Provider Manage Profile
1. Provider logs in  
2. Provider edits business information  
3. System saves updates

#### 7. US-PROV-002 — Provider Manage Availability & Services 
1. Provider adds availability slots  
2. Provider adds services  
3. System saves data 

#### 8. US-PROV-003 — Provider view Bookings & Reviews 
1. Provider views bookings  
2. Provider views customer reviews  

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

### Performance Requirements

**Scenario P1: Browse page response time < 1.5 seconds**
- **Setup:** Server under typical load
- **Steps:**
  1. Measure response time for "Browse" page with 5–10 providers and 10+ services
  2. Repeat 10 times
- **Expected Outcome:**
  - 95% of requests ≤ 1.5 seconds
  - Providers and services load correctly without delay

**Scenario P2: Booking submission response time < 1.0 second**
- **Setup:** Active system with multiple users
- **Steps:**
  1. Customer selects provider, service, and time slot
  2. Submits booking request
  3. Measure response time
- **Expected Outcome:**
  - Booking completes ≤ 1.0 second
  - Time slot is marked as taken immediately
  - Booking appears in "Your Bookings"

### Security & Privacy Requirements

**Scenario S1: Role-based access control**
- **Setup:** Customer attempts to access provider dashboard
- **Steps:**
  1. Customer logs in
  2. Navigates to "/provider-dashboard"
  3. Observes system response
- **Expected Outcome:**
  - Access is denied (redirect or 403)
  - Customer is redirected to dashboard or login page
  - No provider data is exposed

**Scenario S2: Customer cannot edit another user's review**
- **Setup:** Two customers (C1 and C2), C1 has written a review
- **Steps:**
  1. C2 logs in
  2. Attempts to access "/review/edit/{id}" for C1’s review
  3. Attempts to submit update request
- **Expected Outcome:**
  - Access is denied or redirected
  - Review is not modified
  - Only the original author can edit/delete their review

### Usability Requirements

**Scenario U1: New user completes first booking in ≤ 3 minutes**
- **Setup:** New customer account (observer records time)
- **Steps:**
  1. User logs in
  2. Navigates to "Browse"
  3. Selects a provider
  4. Clicks "Book Appointment"
  5. Selects time slot and service
  6. Submits booking
- **Expected Outcome:**
  - Booking completed in ≤ 3 minutes
  - User understands flow without assistance

**Scenario U2: Provider creates availability in ≤ 5 minutes**
- **Setup:** New provider account (observed session)
- **Steps:**
  1. Provider logs in
  2. Navigates to availability management
  3. Adds time slots
  4. Saves availability
  5. Record total time
- **Expected Outcome:**
  - Availability created in ≤ 5 minutes
  - Slots appear correctly on provider profile
  - Customers can view and book slots
