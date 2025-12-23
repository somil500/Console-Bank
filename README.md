🏦 Console Bank - Robust Banking Management System
A comprehensive Java-based banking application designed to manage financial operations through a command-line interface. This project focuses on clean architecture, transaction integrity, and efficient data handling.

📌 Project Overview
Console Bank is a backend application that simulates real-world banking operations. It allows users to manage multiple account types (Savings/Current), perform secure financial transactions, and track account histories through detailed statements. The project follows a service-layer pattern to separate business logic from user interaction.

🚀 Key Features
Dynamic Account Management: Open Savings or Current accounts with unique account numbers.

Secure Transactions: Integrated logic for Deposits and Withdrawals with real-time balance updates.

Inter-Account Transfers: Facilitates seamless money movement between two accounts.

Digital Statements: Generates detailed transaction logs including Timestamps, IDs, and transaction notes.

Advanced Search & List: Filter and find accounts by Customer Name or view the entire bank directory.

Input Validation: Robust error handling for invalid amounts or non-existent accounts.

🛠 Tech Stack
Language: Java (JDK 17+)

Architecture: Service-Oriented (Domain, Service, Implementation layers)

Data Structure: Collections Framework (List, Stream API)

Formatting: Clean Console UI with Block Text formatting

💻 Use Cases
Banking Clerk Operations: A bank employee can use the "Account List" and "Search" features to manage customer inquiries.

Personal Finance Tracking: Users can generate an "Account Statement" to review their spending habits and transaction history.

Peer-to-Peer Payments: The "Transfer" module allows users to settle debts or move funds between their own accounts instantly.

🧠 Key Challenges & Learnings
1. Maintaining State & Transaction Integrity
Challenge: Ensuring that during a Transfer, money isn't "lost" if the system fails between the withdrawal from Account A and the deposit to Account B. Solution: Implemented atomic-style logic within the BankService to ensure both sides of the transaction complete successfully.

2. Implementation of Service Layer Pattern
Challenge: Keeping the Main.java file clean and focused only on user input. Solution: Decoupled the logic by creating a BankService interface and a BankserviceImp implementation, making the code more maintainable and testable.

3. Data Retrieval with Stream API
Challenge: Efficiently searching through accounts and transactions. Solution: Leveraged Java Streams to filter and search for customer names dynamically, allowing for a more modern and readable codebase.

📂 Project Structure
Plaintext

bank-app/
└── src/
    ├── app/
    │   └── Main.java             # Entry point & Console UI Logic
    ├── domain/
    │   ├── Account.java          # Account Model (Balance, Type, Owner)
    │   └── Transaction.java      # Transaction Model (ID, Timestamp, Note)
    └── Service/
        ├── BankService.java      # Interface defining business rules
        └── BankserviceImp.java   # Implementation of core banking logic
