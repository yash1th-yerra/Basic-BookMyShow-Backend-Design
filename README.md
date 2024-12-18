This low level design demonstrate the knowledge on low level system design while meeting basic requirements as follows:

# BookMyShow System

## Overview

The BookMyShow system is a ticket booking platform that allows users to search for available movies and multiplexes, select shows, choose seats, and make payments. Admins can manage the system by adding new movies, multiplexes, and shows. The system uses design patterns like **Strategy**, **Observer**, and **Singleton** for flexibility, scalability, and maintainability.

## Functional Requirements

### 1. **Multiplex and Movie Search**
- Users can search for available **Multiplexes** and **Movies**.
- The search should support filtering by:
  - **Name**
  - **Genre**
  - **Region**

### 2. **Multiplex Screens**
- Each **Multiplex** contains multiple **Screens**.
- Each **Screen** has a set of **Seats** with specific types (e.g., Regular, Premium) and prices.

### 3. **Show and Seat Selection**
- Users can view available **Shows** based on the selected **movie** and **multiplex**.
- Users can select seats for the chosen show from the available seats.

### 4. **Seat Availability Check**
- The system checks the availability of selected seats before confirming the booking.
- Seat status is updated to **Booked** upon confirmation.

### 5. **Admin Role**
- **Admins** can add new **Movies**, **Multiplexes**, and **Shows** to the system.

### 6. **Show Filtering**
Users can filter shows based on the following criteria:
- **Region** (location of multiplex)
- **Movies** (by movie title)
- **Multiplexes** (by multiplex name or location)
- **Price** (e.g., affordable, premium)
- **Genre** (e.g., Action, Drama, Comedy)

### 7. **Show Sorting**
Users can sort shows based on:
- **Price** (ascending or descending)
- **Start Time** (earliest or latest)

### 8. **Payment System**
- The system supports various **Payment Methods** such as:
  - **Credit Card**, **Debit Card**, **Net Banking**, **UPI**, **Paypal**
- Different **Pricing Strategies** are supported:
  - **Discount** (for promotional offers)
  - **Off-Peak** (for lower-demand times)
  - **Peak Pricing** (for high-demand periods)

Payment Strategy and Pricing Strategy are implemented using the **Strategy Pattern**.

### 9. **Notification System**
- Users are notified via **Email** or **SMS** when a payment is successful or unsuccessful.
- The **Observer Pattern** is used for notifications, allowing dynamic addition or removal of notification types (e.g., Email, SMS).
  
#### Notification Observers:
- **Email Notification Observer**: Sends email notifications on successful payments.
- **SMS Notification Observer**: Sends SMS notifications on successful payments.

### 10. **Filtering and Sorting**
- **Filtering** is implemented using the **Strategy Design Pattern** for flexibility:
  - **Movie Filter**: Filters shows based on selected movies.
  - **Multiplex Filter**: Filters shows based on selected multiplexes.
  - **Region Filter**: Filters shows based on selected regions.

- **Sorting** will be handled using Sorting Strategies (e.g., by price or start time).

## Non-Functional Requirements

### 1. **Concurrency and Thread Safety**
- The system must handle multiple concurrent requests and ensure **thread safety**, especially for operations like booking seats, processing payments, and updating seat statuses.
- **Synchronization mechanisms** (e.g., synchronized blocks, locks) will be used to avoid race conditions in critical sections (e.g., booking tickets, updating seat availability).

### 2. **Scalability**
- The system should be able to scale as more movies, multiplexes, and shows are added.
- Though the system is in-memory, the architecture should allow for future extension to integrate with databases or external APIs.

### 3. **Availability**
- The system should be highly available, meaning users should be able to search movies, select shows, and book tickets at any time.
- **Failure recovery mechanisms** will be considered, especially for payment and booking processes.

### 4. **Performance**
- The system should efficiently handle searches, seat availability checks, and show filtering, even with a large number of users and data.
- **Efficient data structures and algorithms** should be used to optimize search and booking times.

### 5. **Maintainability**
- The code should be modular and follow design patterns like **Strategy**, **Observer**, and **Singleton** to allow for easy maintenance and extensibility.
- Each component (e.g., Payment, Sorting, Notifications) should be loosely coupled to minimize the impact of changes in one component on others.

### 6. **Security**
- **User data**, especially sensitive information like payment details, should be protected (e.g., via encryption).
- Proper **authentication** and **authorization** mechanisms should be in place to prevent unauthorized access to admin functionalities (e.g., adding movies, multiplexes).

### 7. **Usability**
- The system should have a simple, **user-friendly interface** for searching movies, selecting shows, and booking tickets.
- **Admin interfaces** should be easy to use for adding new content to the system.

### 8. **Backup and Recovery**
- Since data is stored in-memory, the system should implement **periodic backups** or recovery mechanisms to restore system state in case of failure (especially in production environments).

## Assumptions

### 1. **No Database**
- The application does not use a traditional **database**. All data (e.g., users, seats, movies, and multiplexes) are stored **in-memory** using collections like lists, maps, and sets.

### 2. **In-Memory Persistence**
- Data such as **seats**, **users**, and **movies** are persisted using in-memory storage.
- When the application is restarted, all data will be lost. This is acceptable for development or prototype purposes but would require a database in a production environment.

## Future Improvements
- Integration with a **persistent database** for permanent data storage.
- **User authentication and authorization** to manage different user roles and permissions.
- Improved **user interface** for better user experience.
- **Caching** strategies for improved performance in high-demand scenarios.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.




