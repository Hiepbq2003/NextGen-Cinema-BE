# ⚙️ NextGen Cinema - Backend (be-sba)

The Spring Boot backend for the Cinema Ticket Booking System. Handles authentication, movie catalog, bookings, and payments.

## 🚀 Getting Started

### Prerequisites
- Java JDK 17+
- Maven
- MySQL Database

### Environment Variables
The application requires the following variables defined in a `key.env` file (root of `be-sba`) or as system properties:
```env
DB_HOST=...
DB_PORT=...
DB_NAME=...
DB_USER=...
DB_PASSWORD=...
JWT_SECRET=...
MAIL_USERNAME=...
MAIL_PASSWORD=...
GOOGLE_CLIENT_ID=...
GOOGLE_CLIENT_SECRET=...
GOOGLE_DRIVE_FOLDER_ID=...
GOOGLE_DRIVE_CLIENT_ID=...
GOOGLE_DRIVE_CLIENT_SECRET=...
GOOGLE_DRIVE_REFRESH_TOKEN=...
```

### Installation & Run
1. Build the project:
   ```bash
   ./mvnw clean install
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## 🧪 Test Accounts
The `DbInitializer` class automatically creates these accounts on startup if the database is empty:
- **Admin:** `admin` / `admin123`
- **Staff 1:** `staff1` / `staff123`
- **Staff 2:** `staff2` / `staff123`

## 🛠 Tech Stack
- **Core:** Java Spring Boot 4.x
- **Security:** Spring Security & JWT (JsonWebToken)
- **Database:** MySQL / Spring Data JPA (Hibernate)
- **Authentication:** Local Login & OAuth2 Google Integration
- **Mailing:** JavaMailSender for notifications
- **Storage:** Google Drive API for movie poster management
- **Utilities:** Lombok & MapStruct

## 📂 Folder Structure
```text
src/main/java/.../besba/
 ├── base/          # Base classes (BaseResponse, PageDTO)
 ├── config/        # System configuration (SecurityConfig, CORS)
 ├── controller/    # REST API Controllers (Movies, Showtimes, Bookings)
 ├── dto/           # Data Transfer Objects
 ├── entity/        # JPA Database Entities
 ├── exception/     # Centralized Exception Handling
 ├── repository/    # Spring Data JPA Repositories
 ├── security/      # JWT, OAuth2, and Filter configuration
 ├── service/       # Business logic implementations
 └── utils/         # Helper utilities (Email, JWT, String)
```
