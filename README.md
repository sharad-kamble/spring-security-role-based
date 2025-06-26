
# 🔐 Spring Security Role-Based Authentication

This project demonstrates a simple **Spring Boot** application using **Spring Security** with **role-based access control**, **Thymeleaf templates**, and **Bootstrap** for the frontend UI.

---

## 👨‍💻 Author

GitHub: [sharad-kamble](https://github.com/sharad-kamble)

Repo: [spring-security-role-based](https://github.com/sharad-kamble/spring-security-role-based)

---

## 📌 Features

- ✅ Role-based access control with `ROLE_USER` and `ROLE_ADMIN`
- 👨‍💼 Admin can access both `/admin` and `/user`
- 🙋 User can only access `/user`
- 🔐 Custom login and logout using Spring Security
- ❌ Custom 403 (Access Denied) page
- 🌐 Thymeleaf-based responsive UI using Bootstrap 5

---

## 👥 Users & Roles

| Username | Password | Role     | Access                                 |
|----------|----------|----------|----------------------------------------|
| sharad   | 123      | USER     | `/user` only                           |
| admin    | admin    | ADMIN    | `/admin`, `/user`, and all other pages |

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java 17+
- Maven

### ▶️ Run the Project

```bash
git clone https://github.com/sharad-kamble/spring-security-role-based.git
cd spring-security-role-based
./mvnw spring-boot:run
```

---

## 🌍 Access URLs

- Login Page: `http://localhost:8080/login`
- User Dashboard: `http://localhost:8080/user`
- Admin Dashboard: `http://localhost:8080/admin`
- Access Denied Page (403): automatically shown when user tries to access `/admin`

---

## 📂 Project Structure

```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── config/SecurityConfig.java
│   │   ├── controller/DemoController.java
│   │   └── DemoApplication.java
│   └── resources/
│       ├── templates/
│       │   ├── user.html
│       │   ├── admin.html
│       │   └── error/403.html
│       └── application.properties
```

---

## 🧰 Technologies Used

- Spring Boot
- Spring Security
- Thymeleaf
- Bootstrap 5
- Java 17

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 📬 Contact

If you like the project, feel free to ⭐ star the repo!  
For suggestions or contributions, open an issue or pull request at  
👉 [https://github.com/sharad-kamble/spring-security-role-based](https://github.com/sharad-kamble/spring-security-role-based)
