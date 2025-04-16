# Vacuum Cleaner Low-Level Design

A Java implementation of a vacuum cleaner controller system that simulates the movement of a vacuum cleaner in a room using a coordinate grid system.

## Project Overview

This project demonstrates low-level design principles by implementing a vacuum cleaner that can navigate through a room based on simple instructions. The vacuum cleaner can:

- Move forward
- Turn left
- Turn right
- Track its position and direction

The system uses a coordinate grid to represent the room, and the vacuum cleaner's position is defined by x and y coordinates along with a direction (North, East, South, or West).

## Classes and Structure

- **SimpleVacuumController**: Main controller for the vacuum cleaner that processes instructions
- **VacuumService**: Service that handles the execution of instructions
- **Model**:
  - `Cell`: Represents a position in the grid with coordinates and direction
- **Enums**:
  - `DirectionEnum`: Defines the four possible directions (N, E, S, W)
- **Request**:
  - `MoveRequest`: Contains the current position and instruction to be executed
- **Validator**:
  - `ParameterValidator`: Interface for request validation
  - `BasicParameterValidator`: Implementation that validates move requests
- **Template**:
  - `BizTemplate`: Template for business operations
  - `BizBaseCallback`: Abstract class for business logic callbacks

## How to Use

### Prerequisites
- Java 17+
- Maven

### Building the Project
```bash
mvn clean install
```

### Running the Application
```java
// Create a 6x6 room with vacuum starting at position (1, 2) facing North
SimpleVacuumController controller = new SimpleVacuumController(6, 6, 1, 2, DirectionEnum.N);

// Display initial state
controller.displayRoom();

// Process a series of instructions
String instructions = "LMLMLMLMM";
Cell finalPosition = controller.processInstructions(instructions);

// Display the final state
controller.displayRoom();
```

### Instruction Format
- `L`: Turn left
- `R`: Turn right
- `M`: Move forward one step

## Examples

### Sample Input
Starting position: (1, 2) facing North
Instructions: LMLMLMLMM

### Expected Output
Final position: (1, 3) facing North

## Testing

Unit tests are included to verify the functionality:
- Direction changes (left and right turns)
- Movement
- Boundary conditions
- Complex instruction sequences

Run tests with:
```bash
mvn test
```

## Design Patterns Used

- **Template Method Pattern**: Used in BizTemplate and BizBaseCallback
- **Strategy Pattern**: For different validation strategies
- **Model-View-Controller (MVC)**: Overall architecture approach

## Future Enhancements

- Add obstacle detection
- Implement different cleaning strategies
- Add battery management
- Support multiple vacuum cleaners
- Add a GUI representation

## License

This project is licensed for educational purposes.

## Author

Original author: akash gond