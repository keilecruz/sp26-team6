# GlowUP - Backend API Documentation

**Base URL:** `http://localhost:8080/api`

---

## Table of Contents

1. [Overview](#1-overview)
2. [User Roles](#2-user-roles)
3. [UML Class Diagram](#3-uml-class-diagram)
4. [API Endpoints](#4-api-endpoints)
   - [Customer Management](#customer-management)
   - [Provider Management](#provider-management)
   - [Portfolio Management](#portfolio-management)
   - [Produce Box Management](#produce-box-management)
   - [Service Management](#service-management)
   - [Review Management](#review-management)
   - [Admin Management](#admin-management)
   - [Audit Logs](#audit-logs)
5. [Use Case Mapping](#5-use-case-mapping)

---
## 1. Overview

The GlowUP API back-end API provides an interface for managing :

- **User Accounts**: Customer, Beauty Professionals, and Admin roles
- **Beauty Professionals Accounts**: Allowing Beauty Professionals to store their portfolio and their information/availability.
- **Portfolio**: Portfolio that is maintained by Professional and contains their description.
- **Availability**: Professionals availability that is inspected by the customer.
- **Reviews**: Customer feedback after session with the Professional
- **Audit-Logs**: Admin maintains the system settings

---
## 2. User Roles

This API supports three main roles

| Role | Description | Primary Responsibilities |
|------|-------------|-------------------------|
| **CUSTOMER** | |
| **BEAUTY-PROFESSIONAL** | |
| **ADMIN** | Platform administrator | Manage access, moderate content, view analytics |

---
## 3. UML Class Diagram

![UML Class Diagram](../docs/UML-class_Design.png)

## 4. API Endpoints

These use-cases are use specifically with the endpoints ('/customer', '/beauty', '/admin')


---
## 5. Use Case Mapping

The API endpoints are meant to follow these SRS use cases : 

### Customer Use Cases
