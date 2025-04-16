package com.java.lld.design;

import com.java.lld.design.controller.VacuumService;
import com.java.lld.design.enums.DirectionEnum;
import com.java.lld.design.model.Cell;
import com.java.lld.design.request.MoveRequest;

public class SimpleVacuumController {

    // Room represented as a grid of cells
    private Cell[][] cells;
    
    // Vacuum service to handle instructions
    private VacuumService vacuumService;
    
    // Current position of the vacuum cleaner
    private Cell currentPosition;

    /**
     * Constructor to initialize the vacuum controller with a specific room size
     * @param rows Number of rows in the room
     * @param cols Number of columns in the room
     * @param startX Starting X position
     * @param startY Starting Y position
     * @param startDirection Starting direction
     */
    public SimpleVacuumController(int rows, int cols, int startX, int startY, DirectionEnum startDirection) {
        this.cells = new Cell[rows][cols];
        this.vacuumService = new VacuumService(rows, cols, startX, startY, startDirection);
        this.currentPosition = cells[startX][startY] = new Cell(startX, startY, startDirection);
    }

    /**
     * Process a single instruction for the vacuum cleaner
     * @param instruction The instruction character: 'L' (left), 'R' (right), or 'M' (move)
     * @return The new position after processing the instruction
     */
    public Cell processInstruction(char instruction) {
        MoveRequest request = new MoveRequest(currentPosition, instruction);
        Cell newPosition = vacuumService.instruct(request);
        this.currentPosition = newPosition;
        return newPosition;
    }

    /**
     * Process a sequence of instructions
     * @param instructions String of characters representing instructions
     * @return The final position after all instructions are processed
     */
    public Cell processInstructions(String instructions) {
        Cell position = currentPosition;
        System.out.println("Starting position: " + position);
        
        for (char instruction : instructions.toCharArray()) {
            position = processInstruction(instruction);
            System.out.println("After instruction '" + instruction + "': " + position);
        }
        
        return position;
    }

    /**
     * Get the current position of the vacuum cleaner
     * @return Current cell position
     */
    public Cell getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Display the current room state with the position of the vacuum cleaner
     */
    public void displayRoom() {
        System.out.println("Room state:");
        System.out.println("Vacuum position: " + currentPosition);
        
        for (int y = cells[0].length - 1; y >= 0; y--) {
            for (int x = 0; x < cells.length; x++) {
                if (x == currentPosition.getX() && y == currentPosition.getY()) {
                    switch (currentPosition.getDirection()) {
                        case N: System.out.print("↑ "); break;
                        case E: System.out.print("→ "); break;
                        case S: System.out.print("↓ "); break;
                        case W: System.out.print("← "); break;
                    }
                } else {
                    System.out.print("· ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Main method to demonstrate the vacuum controller
     */
    public static void main(String[] args) {
        // Create a 6x6 room with vacuum starting at position (1, 2) facing North
        SimpleVacuumController controller = new SimpleVacuumController(6, 6, 1, 2, DirectionEnum.N);
        
        // Display initial state
        controller.displayRoom();
        
        // Process a series of instructions
        String instructions = "LMLMLMLMM";
        Cell finalPosition = controller.processInstructions(instructions);
        
        // Display the final state
        controller.displayRoom();
        System.out.println("Final position: " + finalPosition);
    }
}