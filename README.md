# 🎓 Workshop Management System – Spring Boot JPA Backend

A complete backend system for managing workshops, sessions, presenters, and attendees (both undergraduates and postgraduates), built using **Spring Boot** and **JPA**.

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- MySQL / H2 (Dev)
- Maven

---

## 📦 Project Structure

```
src/
└── main/
    └── java/
        └── com/backend/Backend/
            ├── model/
            │   ├── Workshop.java
            │   ├── Session.java
            │   ├── Presenter.java
            │   ├── Under_graduates.java
            │   ├── Post_graduates.java
            │   └── Person.java
            └── resources/
                └── application.properties
```

---

## 🧬 Entity Relationships Overview

- 🧑‍🎓 **Under_graduates** ↔️ (Many-to-Many) ↔️ **Session**
- 🎓 **Post_graduates** ↔️ (Many-to-Many) ↔️ **Session**
- 🎤 **Presenter** ↔️ (Many-to-Many) ↔️ **Session**
- 📅 **Session** → 🔗 Connected to `Workshop` via `workshop_id` (foreign key)

---

## 📘 Model Descriptions

### 🏛️ `Workshop.java`

```java
@Entity
public class Workshop {
    @Id
    private String id;
    private String name;
    private String description;
    private Date start_date;
    private Date end_date;
}
```

---

### 📅 `Session.java`

```java
@Entity
public class Session {
    @Id
    private String id;
    private String name;
    private String description;
    private Date date;
    private Time time;
    private int workshop_id; // FK reference to Workshop

    @ManyToMany(mappedBy="sessions")
    private List<Post_graduates> post_graduates;

    @ManyToMany(mappedBy="sessions")
    private List<Under_graduates> under_graduates;

    @ManyToMany(mappedBy="sessions")
    private List<Presenter> presenters;
}
```

---

### 🧑‍🏫 `Presenter.java`

```java
@Entity
public class Presenter {
    @Id
    private String id;
    private String name;
    private String affiliation;
    private String country;
    private String ob_title;

    @ManyToMany
    @JoinTable(
        name = "presenter_sessions",
        joinColumns = @JoinColumn(name = "presenter_id"),
        inverseJoinColumns = @JoinColumn(name = "sessions_id")
    )
    private List<Session> sessions;
}
```

---

### 🧑‍🎓 `Under_graduates.java`

```java
@Entity
public class Under_graduates {
    @Id
    private String id;
    private String degree;
    private String university;

    @ManyToMany
    @JoinTable(
        name = "under_graduate_sessions",
        joinColumns = @JoinColumn(name = "under_graduates_id"),
        inverseJoinColumns = @JoinColumn(name = "sessions_id")
    )
    private List<Session> sessions;
}
```

---

### 🎓 `Post_graduates.java`

```java
@Entity
public class Post_graduates {
    @Id
    private String id;
    private String institute;
    private String second_degree;
    private String research_interest;

    @ManyToMany
    @JoinTable(
        name = "post_graduate_sessions",
        joinColumns = @JoinColumn(name = "post_graduates_id"),
        inverseJoinColumns = @JoinColumn(name = "session_id")
    )
    private List<Session> sessions;
}
```

---

### 📄 `Person.java` (Base Class)

```java
@MappedSuperclass
public class Person {
    private String name;
    private String gender;
    private String email;
    private int phone;
}
```

> 🔍 *Note: You can extend `Person` in `Presenter`, `Under_graduates`, and `Post_graduates` if needed.*


## ▶️ How to Run

```bash
# Run using Maven Wrapper
./mvnw spring-boot:run

# Or using Maven directly
mvn spring-boot:run
```

App runs at: [http://localhost:8080](http://localhost:8080)

---

## 🔗 Sample Endpoints (To Implement)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/workshops`       | Get all workshops |
| GET    | `/sessions`        | Get all sessions |
| POST   | `/presenters`      | Create new presenter |
| POST   | `/undergraduates`  | Register undergrad attendee |
| POST   | `/postgraduates`   | Register postgrad attendee |



## 👨‍💻 Author

Built with 💻 by **Dinuki Prarthana**  
🔗 GitHub: [@Dinuki](https://github.com/Dinuki85)

---

## 📝 License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).

---
