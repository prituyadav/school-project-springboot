# school-project-springboot

# School Management System

A Spring Boot + MongoDB based School Management System built as a Capstone Project for MCA 4th Semester, Uttaranchal University.

## 📘 Project Summary

This backend system supports CRUD operations for Schools, Teachers, Courses, and Students, and enables student enrollment into courses. Swagger UI is used for API testing/documentation.

---

## 📁 Project Structure

```
├── src
│   └── main
│       ├── java/com/learning/school
│       │   ├── controller
│       │   ├── model
│       │   ├── repository
│       │   ├── service
│       │   └── dto
│       └── resources
│           └── application.properties
├── pom.xml
└── README.md
```

---

## 🛠️ Technologies Used

* **Spring Boot 3.2.5**
* **MongoDB**
* **Java 17**
* **Maven**
* **Swagger/OpenAPI**

---

## 🔧 How to Setup & Run

### Prerequisites:

* Java 17 JDK
* Maven
* MongoDB installed and running locally

### Steps to Run:

```bash
mvn clean install
source school-env.sh
java -jar target/school-0.0.1-SNAPSHOT.jar
```

The app will start on: `http://localhost:9090`

---

## 📑 Swagger API Docs

Once the project is running, access Swagger UI:

```
http://localhost:9090/swagger-ui/index.html
```

This provides all API endpoints and testable documentation.

---

## 🧠 Modules

* **School Module**
* **Teacher Module**
* **Course Module**
* **Student Module**

---

## 🧩 ER Diagram

* **School** - id, name, board, address
* **Teacher** - id, name, subject, schoolId
* **Course** - id, name, description, teacherId
* **Student** - id, name, email, enrolledCourseIds

### Relationships:

* A School has many Teachers
* A Teacher teaches many Courses
* A Student can enroll in many Courses

---

## 🛡 Security & Validations

* Input validation using `@Valid`
* Exception handling with `@ControllerAdvice`
* Role-based access control planned for future

---

## 🔮 Future Enhancements

* JWT Authentication
* Admin Dashboard UI
* Email Notification System
* File Uploads

---

## 📎 Project Link

GitHub Repository: [https://github.com/prituyadav/school-project-springboot](https://github.com/prituyadav/school-project-springboot)

---

## 📩 Contact

---
