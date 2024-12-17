## BOOKMYSHOW-LLD

This Repository contains basic backend low level design of BookMyShow which is created using datastructures and design patterns.

This low level design demonstrate the knowledge on low level system design while meeting basic requirements as follows:

#### Functional Requirements:

1. Users should be able to search for Multiplex and movies.
2. Each Multiplex will have multiple screens.
3. User should be able to select a show and book available seats.
4. The application should check seat availability before confirming a booking.
5. Admin should be able to add movies and multiplexes.
6. User should be able to sort the shows based on price.
7. User Should filter shows based on region.

#### Non-Functional Requirements:
1. Concurrency and threadsafe.

#### Assumptions:

1. Application doesn't include a DB
2. Seats,Users and movies are persisted using in-Memory.

##### further changes :
1. integrating payment services using factory  and strategy design patterns.
2. develop apis using spring boot.
3. integrating database for free data flow and persistence


