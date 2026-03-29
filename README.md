# 🏦 Console Bank – Banking Management System (Java)

## 📌 Overview

**Console Bank** is a backend-focused banking management system built using **Core Java**, designed to simulate real-world banking operations via a command-line interface.

This project emphasizes:

* Clean architecture (Service Layer Pattern)
* Transaction integrity
* Scalable and maintainable backend design

💡 It is ideal for **backend learning, system design understanding, and interview preparation**.

---

## ✨ Key Features

### 🔐 Account Management

* Create **Savings** and **Current** accounts
* Auto-generate unique account numbers
* Maintain real-time balance and account details

---

### 💰 Secure Financial Transactions

* Deposit and Withdraw with proper validations
* Prevents:

  * Invalid amounts
  * Insufficient balance
* Instant balance updates

---

### 🔄 Fund Transfer (Atomic Transactions)

* Transfer money between accounts
* Ensures:

  * No partial transfers
  * No money loss in failure scenarios

---

### 🧾 Transaction Statements

* Full transaction history per account

Includes:

* Transaction ID
* Timestamp
* Amount
* Type (Deposit / Withdraw / Transfer)
* Notes

---

### 🔍 Search & Account Directory

* Search accounts by customer name
* View all accounts
* Implemented using **Java Stream API**

---

### ⚠️ Input Validation

Handles:

* Invalid account numbers
* Negative or zero amounts
* Insufficient balance

✔ Provides clear error messages

---

## 🛠 Tech Stack

| Category      | Technology            |
| ------------- | --------------------- |
| Language      | Java (JDK 17+)        |
| Architecture  | Service Layer Pattern |
| Data Handling | Java Collections      |
| Searching     | Java Stream API       |
| UI            | Console-based         |

---

## 🧠 Architecture

The project follows a **layered architecture**:

```id="q3xw8y"
Presentation Layer → Service Layer → Domain Layer
```

### 📌 Explanation

* **Presentation Layer** → Handles user input/output
* **Service Layer** → Contains business logic
* **Domain Layer** → Defines entities (Account, Transaction)

---

## 📂 Project Structure

```id="s5pld2"
bank-app/
└── src/
    ├── app/
    │   └── Main.java
    ├── domain/
    │   ├── Account.java
    │   └── Transaction.java
    └── service/
        ├── BankService.java
        └── BankServiceImpl.java
```

---

## 🧩 Core Design Highlights

### ✅ Service Layer Pattern

* Separates UI from business logic
* Improves:

  * Maintainability
  * Testability
  * Scalability

---

### ✅ Transaction Integrity

* Transfer is treated as a single unit
* Ensures consistency in all scenarios

---

### ✅ Stream-Based Searching

* Uses Java Streams for filtering
* Cleaner and more readable code

---

## 💻 Real-World Use Cases

* 🏦 Banking operations simulation
* 💳 Personal finance tracking
* 🔄 Secure peer-to-peer transfers

---

## 🚀 Learning Outcomes

* Strong understanding of **Core Java & OOP**

* Hands-on experience with:

  * Collections
  * Streams
  * Exception Handling
  * Transaction flow

* Ability to design **real-world backend systems**

---

## 🔮 Future Enhancements

* JDBC + MySQL integration
* Authentication (PIN / Password)
* Export statements (PDF / CSV)
* REST API using Spring Boot
* Unit testing with JUnit

---

## 📎 Why This Project Matters

This project reflects **industry-level backend thinking**:

✔ Data consistency
✔ Clean architecture
✔ Business logic separation
✔ Real-world problem solving

---

## ▶️ How to Run

```bash id="dr4w7k"
# Compile
javac Main.java

# Run
java Main
```

---

## 🤝 Connect With Me

* 📧 Email: [somildhakad500@gmail.com](mailto:somildhakad500@gmail.com)
* 💼 LinkedIn: https://www.linkedin.com/in/somil-kirar/

---

## ⭐ Support

If you like this project, please ⭐ the repository!

---

## 🔥 Author

**Somil Kirar**
