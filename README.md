# 🏃 Fitness Tracker Application (Spring Boot + JWT)

A **backend REST API** for tracking fitness activities and generating personalized recommendations, built using **Spring Boot**, **Spring Security (JWT)**, **JPA/Hibernate**, and **MySQL**.

This project follows **industry-standard JWT authentication**, where the client sends **only a JWT token**, and the backend derives the authenticated user from the security context.

---

## 🚀 Features

### 🔐 Authentication & Security
- User registration and login
- JWT-based authentication
- Role-based authorization (USER / ADMIN)
- Stateless security (no sessions)

### 🏋️ Activity Management
- Create fitness activities (Running, Walking, Cycling, etc.)
- Retrieve activities of the logged-in user
- Activities are always linked to the authenticated user (no userId sent from client)

### 💡 Recommendations
- Generate recommendations for activities
- Fetch recommendations by activity
- Secure access using JWT

---

## 🧠 Key Design Principles

- **JWT-only authentication** (no userId/email passed in requests)
- User identity extracted from `SecurityContext`
- Clean separation of Controller, Service, Repository layers
- Follows REST best practices

---

## 🛠 Tech Stack

| Layer | Technology                  |
|---|-----------------------------|
| Backend | Spring Boot                 |
| Security | Spring Security + JWT       |
| ORM | Spring Data JPA / Hibernate |
| Database | MySQL                       |
| Build Tool | Maven                       |
| Java Version | Java 21                     |

---
# 🏃 Fitness Tracker Application (Spring Boot + JWT + Docker)

A **backend REST API** for tracking fitness activities and generating personalized recommendations, built using **Spring Boot**, **Spring Security (JWT)**, **JPA/Hibernate**, **MySQL**, and **Docker**.

This project follows **industry-standard JWT authentication**, where the client sends **only a JWT token**, and the backend derives the authenticated user from the Spring Security context.

---

## 🚀 Features

### 🔐 Authentication & Security
- User registration and login
- JWT-based authentication
- Role-based authorization (USER / ADMIN)
- Stateless security (no HTTP sessions)

### 🏋️ Activity Management
- Create fitness activities (Running, Walking, Cycling, etc.)
- Retrieve activities of the logged-in user
- Activities are always linked to the authenticated user  
  *(no userId sent from the client)*

### 💡 Recommendations
- Generate recommendations for activities
- Fetch recommendations by activity
- Secure access using JWT authentication

---

## 🧠 Key Design Principles

- **JWT-only authentication** (no userId/email passed in API requests)
- User identity extracted from `SecurityContext`
- Clean separation of Controller, Service, and Repository layers
- Follows REST API best practices
- Docker-ready configuration for easy deployment

---

## 🛠 Tech Stack

| Layer | Technology |
|------|------------|
| Backend | Spring Boot |
| Security | Spring Security + JWT |
| ORM | Spring Data JPA / Hibernate |
| Database | MySQL |
| Containerization | Docker, Docker Compose |
| Build Tool | Maven |
| Java Version | Java 21 |

---

## 🐳 Docker Support

This project is fully **Dockerized**, allowing the application to run without installing Java or Maven locally.



