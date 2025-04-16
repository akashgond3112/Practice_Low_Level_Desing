package com.java.lld.design;

import com.java.lld.design.enums.DirectionEnum;
import com.java.lld.design.model.Cell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the SimpleVacuumController class
 */
public class SimpleVacuumControllerTest {

    private SimpleVacuumController controller;

    @Before
    public void setUp() {
        // Create a 6x6 room with vacuum starting at position (1, 2) facing North
        controller = new SimpleVacuumController(6, 6, 1, 2, DirectionEnum.N);
    }

    @Test
    public void testTurnLeft() {
        // Test turning left from North
        Cell position = controller.processInstruction('L');
        Assert.assertEquals(DirectionEnum.W, position.getDirection());
        
        // Test turning left from West
        position = controller.processInstruction('L');
        Assert.assertEquals(DirectionEnum.S, position.getDirection());
        
        // Test turning left from South
        position = controller.processInstruction('L');
        Assert.assertEquals(DirectionEnum.E, position.getDirection());
        
        // Test turning left from East
        position = controller.processInstruction('L');
        Assert.assertEquals(DirectionEnum.N, position.getDirection());
    }

    @Test
    public void testTurnRight() {
        // Test turning right from North
        Cell position = controller.processInstruction('R');
        Assert.assertEquals(DirectionEnum.E, position.getDirection());
        
        // Test turning right from East
        position = controller.processInstruction('R');
        Assert.assertEquals(DirectionEnum.S, position.getDirection());
        
        // Test turning right from South
        position = controller.processInstruction('R');
        Assert.assertEquals(DirectionEnum.W, position.getDirection());
        
        // Test turning right from West
        position = controller.processInstruction('R');
        Assert.assertEquals(DirectionEnum.N, position.getDirection());
    }

    @Test
    public void testMoveForward() {
        // Starting at (1, 2) facing North
        
        // Move forward
        Cell position = controller.processInstruction('M');
        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(3, position.getY());
        Assert.assertEquals(DirectionEnum.N, position.getDirection());
        
        // Turn right and move
        controller.processInstruction('R');
        position = controller.processInstruction('M');
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(3, position.getY());
        Assert.assertEquals(DirectionEnum.E, position.getDirection());
    }

    @Test
    public void testFullInstructionSequence() {
        // Starting at (1, 2) facing North
        // Process the instruction sequence: LMLMLMLMM
        Cell finalPosition = controller.processInstructions("LMLMLMLMM");
        
        // Expected final position: (1, 3) facing North
        Assert.assertEquals(1, finalPosition.getX());
        Assert.assertEquals(3, finalPosition.getY());
        Assert.assertEquals(DirectionEnum.N, finalPosition.getDirection());
    }

    @Test
    public void testBoundaryConditions() {
        // Create a smaller 3x3 room with vacuum starting at position (0, 0) facing East
        SimpleVacuumController smallRoomController = new SimpleVacuumController(3, 3, 0, 0, DirectionEnum.E);
        
        // Move forward twice, reaching edge at (2, 0)
        smallRoomController.processInstruction('M');
        Cell position = smallRoomController.processInstruction('M');
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(0, position.getY());
        
        // Attempt to move beyond the boundary
        position = smallRoomController.processInstruction('M');
        // Position should remain (2, 0) since we can't go beyond the boundary
        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(0, position.getY());
    }
}