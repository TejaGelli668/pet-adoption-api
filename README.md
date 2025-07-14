# Pet Adoption Management System - Backend API

A robust Spring Boot REST API for managing pet adoptions, donations, and administrative operations. This backend service provides secure endpoints for user management, pet management, adoption processes, and administrative functions.

## 🚀 Features

### Core Functionality
- **User Management**: Registration, authentication, and profile management
- **Pet Management**: CRUD operations for pet listings and information
- **Adoption Process**: Complete adoption workflow with payment integration
- **Donation System**: Pet donation submission and management
- **Vaccination Tracking**: Comprehensive vaccination record management
- **Admin Operations**: Administrative controls and monitoring

### Technical Features
- **RESTful API Design**: Clean, well-structured API endpoints
- **JWT Authentication**: Secure token-based authentication
- **Role-Based Access Control**: Separate admin and user permissions
- **Database Integration**: NoSQL database for scalable data storage
- **Payment Processing**: Integrated payment gateway for adoption fees
- **Data Validation**: Comprehensive input validation and sanitization

## 🛠️ Technologies Used

- **Framework**: Spring Boot 2.7+
- **Language**: Java 11+
- **Database**: NoSQL (MongoDB)
- **Authentication**: JWT (JSON Web Tokens)
- **Build Tool**: Maven
- **Testing**: JUnit 5, Mockito
- **Documentation**: Swagger/OpenAPI 3
- **Logging**: SLF4J with Logback

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- Java 11 or higher
- Maven 3.6+
- MongoDB (or access to MongoDB Atlas)
- Git

## 🚀 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/TejaGelli668/pet-adoption-api.git
   cd pet-adoption-api
   ```

2. **Configure the database**
   Update `src/main/resources/application.properties`:
   ```properties
   # MongoDB Configuration
   spring.data.mongodb.uri=mongodb://localhost:27017/pet_adoption
   
   # JWT Configuration
   jwt.secret=your_jwt_secret_key
   jwt.expiration=86400000
   
   # Payment Gateway Configuration
   payment.gateway.key=your_payment_key
   payment.gateway.secret=your_payment_secret
   
   # Server Configuration
   server.port=8080
   server.servlet.context-path=/api
   ```

3. **Build the application**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Run tests**
   ```bash
   mvn test
   ```

## 🌐 API Endpoints

### Authentication Endpoints
```
POST /api/auth/register          - User registration
POST /api/auth/login             - User login
POST /api/auth/refresh           - Refresh JWT token
POST /api/auth/logout            - User logout
```

### User Endpoints
```
GET    /api/user/dashboard              - User dashboard data
GET    /api/user/pet-adoptions          - User's adoption history
POST   /api/user/pet-adoptions          - Create adoption application
GET    /api/user/pet-donations          - User's donation history
POST   /api/user/pet-donations/create-new - Create new pet donation
```

### Pet Endpoints
```
GET    /api/pets                     - Get all available pets
GET    /api/pets/:petId              - Get specific pet details
POST   /api/pets/:petId/adopt        - Initiate adoption process
POST   /api/pets/:petId/adopt/:adoptionId/pay-fee - Process payment
```

### Admin Endpoints

#### Dashboard & Users
```
GET    /api/admin/dashboard          - Admin dashboard statistics
GET    /api/admin/users              - Get all users
GET    /api/admin/users/:id          - Get specific user
PUT    /api/admin/users/:id          - Update user information
DELETE /api/admin/users/:id          - Delete user account
```

#### Pet Management
```
GET    /api/admin/pets               - Get all pets (admin view)
POST   /api/admin/pets/create-new    - Create new pet listing
GET    /api/admin/pets/:petId        - Get pet details (admin)
PUT    /api/admin/pets/:petId/update - Update pet information
DELETE /api/admin/pets/:petId        - Delete pet listing
```

#### Adoption Management
```
GET    /api/admin/pet-adoptions      - Get all adoption applications
GET    /api/admin/pet-adoptions/:id  - Get specific adoption
PUT    /api/admin/pet-adoptions/:id  - Update adoption status
DELETE /api/admin/pet-adoptions/:id  - Cancel adoption
```

#### Donation Management
```
GET    /api/admin/pet-donations      - Get all donation submissions
GET    /api/admin/pet-donations/:id  - Get specific donation
PUT    /api/admin/pet-donations/:id  - Update donation status
DELETE /api/admin/pet-donations/:id  - Remove donation
```

#### Vaccination Management
```
GET    /api/admin/pets/:petId/vaccination           - Get vaccination records
POST   /api/admin/pets/:petId/vaccination/new       - Add vaccination record
GET    /api/admin/pets/:petId/vaccination/:vaccineId - Get specific vaccination
PUT    /api/admin/pets/:petId/vaccination/:vaccineId/update - Update vaccination
DELETE /api/admin/pets/:petId/vaccination/:vaccineId - Delete vaccination record
```

## 📊 Data Models

### User Model
```java
{
    "id": "string",
    "firstName": "string",
    "lastName": "string",
    "email": "string",
    "phoneNumber": "string",
    "address": "string",
    "role": "USER | ADMIN",
    "createdAt": "timestamp",
    "updatedAt": "timestamp"
}
```

### Pet Model
```java
{
    "id": "string",
    "name": "string",
    "species": "string",
    "breed": "string",
    "age": "number",
    "gender": "MALE | FEMALE",
    "color": "string",
    "size": "SMALL | MEDIUM | LARGE",
    "description": "string",
    "healthStatus": "string",
    "adoptionFee": "number",
    "status": "AVAILABLE | ADOPTED | PENDING",
    "images": ["string"],
    "createdAt": "timestamp",
    "updatedAt": "timestamp"
}
```

### Adoption Model
```java
{
    "id": "string",
    "petId": "string",
    "userId": "string",
    "applicationDate": "timestamp",
    "status": "PENDING | APPROVED | REJECTED | COMPLETED",
    "adoptionFee": "number",
    "paymentStatus": "PENDING | PAID | FAILED",
    "notes": "string",
    "createdAt": "timestamp",
    "updatedAt": "timestamp"
}
```

### Vaccination Model
```java
{
    "id": "string",
    "petId": "string",
    "vaccineName": "string",
    "dateAdministered": "date",
    "nextDueDate": "date",
    "veterinarian": "string",
    "notes": "string",
    "createdAt": "timestamp",
    "updatedAt": "timestamp"
}
```

## 🔐 Security

### Authentication
- JWT token-based authentication
- Password encryption using BCrypt
- Token expiration and refresh mechanism
- Role-based access control

### Authorization
- Admin routes protected with `@PreAuthorize("hasRole('ADMIN')")`
- User routes protected with `@PreAuthorize("hasRole('USER')")`
- Resource-level security for pet and adoption operations

### Input Validation
- Bean Validation (JSR-303) annotations
- Custom validation for business rules
- SQL injection prevention
- XSS protection

## 📝 Configuration

### Database Configuration
```properties
# MongoDB Configuration
spring.data.mongodb.uri=mongodb://localhost:27017/pet_adoption
spring.data.mongodb.database=pet_adoption

# Connection Pool Settings
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
```

### JWT Configuration
```properties
jwt.secret=your_super_secret_key_here
jwt.expiration=86400000
jwt.refresh.expiration=604800000
```

### Payment Gateway
```properties
payment.gateway.url=https://api.paymentgateway.com
payment.gateway.key=your_payment_key
payment.gateway.secret=your_payment_secret
```

## 🧪 Testing

### Unit Tests
```bash
mvn test
```

### Integration Tests
```bash
mvn test -Dtest=*IntegrationTest
```

### Test Coverage
```bash
mvn jacoco:report
```

## 🚀 Deployment

### Local Development
```bash
mvn spring-boot:run
```

### Production Build
```bash
mvn clean package -DskipTests
java -jar target/pet-adoption-api-1.0.0.jar
```

### Docker Deployment
```dockerfile
FROM openjdk:11-jre-slim
COPY target/pet-adoption-api-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 📋 Environment Variables

For production deployment, set these environment variables:

```bash
JWT_SECRET=your_jwt_secret
MONGODB_URI=mongodb://localhost:27017/pet_adoption
PAYMENT_GATEWAY_KEY=your_payment_key
PAYMENT_GATEWAY_SECRET=your_payment_secret
```

## 📊 Monitoring & Logging

### Health Check
```
GET /api/actuator/health
```

### Application Metrics
```
GET /api/actuator/metrics
```

### Logging Configuration
- Logs are configured in `src/main/resources/logback-spring.xml`
- Different log levels for development and production
- File and console logging supported

## 🔧 Development Tools

### API Documentation
- Swagger UI available at: `http://localhost:8080/api/swagger-ui.html`
- OpenAPI specification at: `http://localhost:8080/api/v3/api-docs`

### Database Tools
- MongoDB Compass for database management
- Spring Data MongoDB for repository operations

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/petadoption/
│   │       ├── controller/     # REST controllers
│   │       ├── service/        # Business logic
│   │       ├── repository/     # Data access layer
│   │       ├── model/          # Entity models
│   │       ├── dto/            # Data transfer objects
│   │       ├── config/         # Configuration classes
│   │       └── security/       # Security configuration
│   └── resources/
│       ├── application.properties
│       └── logback-spring.xml
└── test/
    └── java/                   # Test classes
```

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Teja Gelli**
- GitHub: [@TejaGelli668](https://github.com/TejaGelli668)
- Email: tejagelli@example.com

## 🔗 Related Repositories

- **Frontend Application**: [pet-adoption-ui](https://github.com/TejaGelli668/pet-adoption-ui)

## 📞 Support

If you have any questions or need help with setup, please open an issue in the repository or contact the maintainer.

---

**Note**: This is the backend API. Make sure to also set up the [frontend application](https://github.com/TejaGelli668/pet-adoption-ui) for the complete system.
