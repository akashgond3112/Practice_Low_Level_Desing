package com.java.lld.design.request;


import com.java.lld.design.model.Cell;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoveRequest {

    // Current cell
    private Cell currCell;

    // Instruction
    private char instruction;

    public MoveRequest(Cell currCell, char instruction) {
        this.currCell = currCell;
        this.instruction = instruction;
    }
}