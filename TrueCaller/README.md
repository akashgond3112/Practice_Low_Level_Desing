# Account Management System

## Overview
This True Caller Account Management System is a Java-based application that provides functionality for managing user accounts with comprehensive profile information. The system follows object-oriented design principles and implements the builder pattern for creating complex objects.

## Project Structure

### Core Domain Models
- **Account**: The main entity representing a user account with personal, contact, and social information
- **PersonalInfo**: Contains user's personal information like name, DOB, gender, etc.
- **Contact**: Stores contact information such as phone number and email
- **Address**: Represents physical address details
- **SocialInfo**: Manages social media profile information
- **Tag**: Enum for categorizing accounts (EDUCATION, SERVICES, LEGAL, BEAUTY_PERSONAL_CARE)
- **SocialProfileType**: Enum for supported social media platforms (FACEBOOK, ORKUT, YOUTUBE, TWITTER)

### Service Layer
- **AccountService**: Implements business logic for account operations (create, read, update, delete)

### Repository Layer
- **AccountRepository**: Interface defining data access operations
- **AccountRepositoryImpl**: Concrete implementation of the repository using an in-memory data store

### Controller Layer
- **AccountController**: Entry point for API requests, delegates to the service layer

### Exception Handling
- **AccountException**: Base exception class for account-related errors
    - **AccountNotFoundException**: Thrown when an account cannot be found
    - **DuplicateUsernameException**: Thrown when attempting to create an account with an existing username
    - **InvalidCredentialsException**: Thrown during failed authentication attempts

## Key Features
- Create and manage user accounts with detailed profile information
- Store multiple contact methods
- Manage address information
- Track social media profiles
- Categorize accounts by tags
- Track last access timestamps
- Authentication support

## Technical Details

### Design Patterns
- **Builder Pattern**: Used extensively with Lombok's `@Builder` annotation for creating complex objects
- **Repository Pattern**: Abstracts data access logic
- **Service Layer Pattern**: Encapsulates business logic
- **MVC Architecture**: Separation of concerns with Models, Services/Controllers

### Dependencies
- **Lombok**: Reduces boilerplate code with annotations like `@Value`, `@Builder`, and `@RequiredArgsConstructor`

## Example Usage

Creating a new account:
```java
// Create address
Address address = Address.builder()
        .addressLine1("123 Main St")
        .city("New York")
        .country("USA")
        .pinCode("10001")
        .build();

// Create personal info using custom builder that requires firstName
PersonalInfo personalInfo = PersonalInfo.builder("John")
        .lastName("Doe")
        .dob("1990-01-01")
        .gender("Male")
        .address(address)
        .company("ACME Inc")
        .build();

// Build the complete account
Account account = Account.builder()
        .id(UUID.randomUUID().toString())
        .username("johndoe")
        .password("securePassword123")
        .tag(Tag.EDUCATION)
        .personalInfo(personalInfo)
        // ... other fields
        .build();
```

## Implementation Notes

### Immutability
The system uses immutable objects (`@Value` from Lombok) to ensure thread safety and prevent unexpected state changes.

### Custom Builders
Some classes like `PersonalInfo` implement custom builders to enforce required fields:
```java
// Custom builder that requires firstName
public static PersonalInfoBuilder builder(String firstName){
    return hiddenBuilder().firstName(firstName);
}
```

### Data Access
The current implementation uses an in-memory store with `ConcurrentHashMap` for thread safety. This can be extended to connect with databases or other persistent storage solutions.

## Future Enhancements
- Add validation logic for fields like email, phone numbers
- Implement password hashing for security
- Add pagination support for listing accounts
- Implement search functionality
- Create REST API endpoints
- Add database persistence