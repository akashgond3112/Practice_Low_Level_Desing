package com.java.lld.design.validator;

import com.java.lld.design.request.MoveRequest;

public class BasicParameterValidator implements ParameterValidator {

    @Override
    public void validate(Object request) throws Exception {
        if (!(request instanceof MoveRequest)) {
            throw new IllegalArgumentException("Request must be of type MoveRequest");
        }

        MoveRequest moveRequest = (MoveRequest) request;
        checkIfValidInstruction(moveRequest);
        checkIfValidCoordinates(moveRequest);
    }

    private void checkIfValidCoordinates(MoveRequest request) {
        if (request.getCurrCell() == null) {
            throw new IllegalArgumentException("Cell cannot be null");
        }
        
        int x = request.getCurrCell().getX();
        int y = request.getCurrCell().getY();
        
        // Assuming a standard room size of maximum 100x100 (arbitrary boundary check)
        if (x < 0 || x >= 100 || y < 0 || y >= 100) {
            throw new IllegalArgumentException("Coordinates out of valid range: x=" + x + ", y=" + y);
        }
    }

    private void checkIfValidInstruction(MoveRequest request) {
        char instruction = request.getInstruction();
        if (instruction != 'L' && instruction != 'R' && instruction != 'M') {
            throw new IllegalArgumentException("Invalid instruction: " + instruction + 
                ". Instruction must be one of: L (left), R (right), or M (move)");
        }
    }
}