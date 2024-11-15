---

# ATM System - Low-Level Design (LLD)

## Overview

This project is a simulation of an ATM system designed using Object-Oriented Principles. It supports core ATM functionalities, allowing customers to perform deposits, withdrawals, and balance inquiries in a secure environment.

### Key Features

- Cash and check deposits.
- Cash withdrawals.
- Account balance inquiries.
- Customer-friendly screen display and printed transaction receipts.
- Secure card reading system.
- Cash dispenser and deposit slot handling.

---

## Project Structure

The project is structured into different packages, with each package representing a key component of the ATM system.

### Package Structure

| Package                | Description |
|------------------------|-------------|
| `com.lld.design.atm`   | Core ATM components like `ATM`, `ATMService`, `Screen`, and `Printer`. |
| `com.lld.design.card`  | Card-related functionalities, including the `CardReader`. |
| `com.lld.design.cash`  | Manages cash deposits via `CashDepositSlot`. |
| `com.lld.design.check` | Manages check deposits via `CheckDepositSlot`. |
| `com.lld.design.customer` | Customer account management, including deposit and withdrawal capabilities. |
| `com.lld.design.deposit` | Abstract `DepositSlot` class and `DepositMedium` enum for deposit types. |
| `com.lld.design.exceptions` | Custom exceptions like `CustomerDoesNotExist` and `InSufficientFundException`. |
| `com.lld.design.transaction` | Handles different transaction types like cash and check deposits. |

---

## Class Breakdown

| Class                 | Description |
|-----------------------|-------------|
| `ATM`                 | Represents the ATM, containing core components like screen, printer, cash dispenser, and card reader. |
| `ATMService`          | Manages customer accounts and operations like deposits and withdrawals. |
| `CardReader`          | Handles card reading and verification for security. |
| `CashDepositSlot`     | Allows cash deposits to be made by customers. |
| `CheckDepositSlot`    | Allows check deposits to be made by customers. |
| `CustomerAccount`     | Manages individual customer accounts, including balances. |
| `DepositSlot`         | Abstract class representing deposit slots for cash or checks. |
| `Transaction`         | Base class for handling various transaction types (e.g., deposits, withdrawals). |

---

## How Components Interact

- **ATM and ATMService**: `ATM` interacts with `ATMService` to perform transactions like deposit and withdrawal.
- **Deposit Slots**: The `DepositSlot` class is inherited by `CashDepositSlot` and `CheckDepositSlot`, enabling different deposit types.
- **Transactions**: Different transaction classes in `transaction` package allow for cash and check deposits and other operations.
- **Exceptions**: Custom exceptions ensure smooth ATM operation by handling errors such as insufficient funds.

---

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 11+**
- **Maven** (for building the project, if needed)

### Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd atm-system
   ```

3. **Build the Project**:
   ```bash
   mvn compile
   ```

4. **Run the Main Class**:
   ```bash
   mvn exec:java -Dexec.mainClass=com.lld.design.MainRunner
   ```

### Example Usage

1. Insert Card
2. Enter PIN
3. Choose an action (e.g., Deposit, Withdraw, Check Balance)
4. Complete the transaction and receive confirmation on screen and printed receipt.

---

## Extending the System

This ATM system is modular and easily extendable. Here are a few potential extensions:

- **Add New Transaction Types**: Create new transaction classes extending `Transaction`.
- **Support for Multiple Currencies**: Update `ATM` and `Transaction` classes to handle multi-currency support.
- **Enhanced Security**: Implement two-factor authentication or biometric verification.

---

## Troubleshooting & Common Issues

- **Insufficient Funds Error**: Ensure that the account balance is checked before attempting a large withdrawal.
- **Customer Not Found**: Verify that the account ID is correct and the customer exists in the system.

---

## Contact

For any questions or support, please contact the project maintainer.

---