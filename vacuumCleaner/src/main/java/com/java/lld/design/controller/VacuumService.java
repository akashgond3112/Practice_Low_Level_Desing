package com.java.lld.design.controller;

import com.java.lld.design.enums.DirectionEnum;
import com.java.lld.design.model.Cell;
import com.java.lld.design.request.MoveRequest;
import com.java.lld.design.template.BizBaseCallback;
import com.java.lld.design.template.BizTemplate;
import com.java.lld.design.validator.BasicParameterValidator;
import com.java.lld.design.validator.ParameterValidator;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
public class VacuumService extends BizBaseCallback<MoveRequest, Cell> {

	public static final String AFTER_TURNING_LEFT = "After turning left: {}";
	public static final String AFTER_MOVING_FORWARD = "After moving forward: {}";
	private final BizTemplate template = new BizTemplate();
	private static Cell[][] room;
	private static Cell currCell;
	private final ParameterValidator parameterValidator = new BasicParameterValidator();

	// Vacuum service initialize
	public VacuumService(int m, int n, int x, int y, DirectionEnum dir) {
		room = new Cell[m][n];
		if (x < 0 || x >= m || y < 0 || y >= n) {
			throw new IllegalArgumentException("Invalid starting position");
		} else {
			currCell = room[x][y] = new Cell(x, y, dir);
		}
	}

	// "ch" -> Instruction which can be 'L','M','R'
	public Cell instruct(MoveRequest request) {
		return template.execute(request, this);
	}

	@Override
	protected void bizPreProcess(MoveRequest request, Cell result, Map<Object, Object> container) {
		try {
			parameterValidator.validate(request);
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid request parameters", e);
		}
	}

	@Override
	protected void bizProcess(MoveRequest request, Cell result, Map container) {
		Cell cell = request.getCurrCell();
		char instruction = request.getInstruction();
		
		switch (instruction) {
			case 'L':
				// Turn left
				turnLeft(cell);
				break;
			case 'R':
				// Turn right
				turnRight(cell);
				break;
			case 'M':
				// Move forward
				moveForward(cell);
				break;
			default:
				throw new IllegalArgumentException("Invalid instruction: " + instruction);
		}
		
		// Update the result with current cell values
		result.setX(cell.getX());
		result.setY(cell.getY());
		result.setDirection(cell.getDirection());
	}
	
	private void turnLeft(Cell cell) {
		DirectionEnum currentDirection = cell.getDirection();
		switch (currentDirection) {
			case N:
				cell.setDirection(DirectionEnum.W);
				break;
			case W:
				cell.setDirection(DirectionEnum.S);
				break;
			case S:
				cell.setDirection(DirectionEnum.E);
				break;
			case E:
				cell.setDirection(DirectionEnum.N);
				break;
		}
	}
	
	private void turnRight(Cell cell) {
		DirectionEnum currentDirection = cell.getDirection();
		switch (currentDirection) {
			case N:
				cell.setDirection(DirectionEnum.E);
				break;
			case E:
				cell.setDirection(DirectionEnum.S);
				break;
			case S:
				cell.setDirection(DirectionEnum.W);
				break;
			case W:
				cell.setDirection(DirectionEnum.N);
				break;
		}
	}
	
	private static void moveForward(Cell cell) {
		int newX = cell.getX();
		int newY = cell.getY();
		
		switch (cell.getDirection()) {
			case N:
				newY++;
				break;
			case E:
				newX++;
				break;
			case S:
				newY--;
				break;
			case W:
				newX--;
				break;
		}
		
		// Check if the new position is valid
		if (isValidPosition(newX, newY)) {
			cell.setX(newX);
			cell.setY(newY);
			// Update the room grid
			room[newX][newY] = cell;
		} else {
			// Handle invalid position - for now, we'll just ignore the move
			log.info("Cannot move outside the room boundaries.");
		}
	}
	
	private static boolean isValidPosition(int x, int y) {
		return x >= 0 && x < room.length && y >= 0 && y < room[0].length;
	}

	@Override
	protected Cell createDefaultResult() {
		return new Cell();
	}

	public static void main(String[] args) {
		// instantiate service
		VacuumService service = new VacuumService(6, 6, 1, 2, DirectionEnum.N);

		// Execute a series of instructions
		Cell result = service.instruct(new MoveRequest(currCell, 'L'));
		log.info(AFTER_TURNING_LEFT, result);
		
		result = service.instruct(new MoveRequest(currCell, 'M'));
		log.info(AFTER_MOVING_FORWARD, result);
		
		result = service.instruct(new MoveRequest(currCell, 'L'));
		log.info(AFTER_TURNING_LEFT, result);
		
		result = service.instruct(new MoveRequest(currCell, 'M'));
		log.info(AFTER_MOVING_FORWARD, result);
		
		result = service.instruct(new MoveRequest(currCell, 'L'));
		log.info(AFTER_TURNING_LEFT, result);
		
		result = service.instruct(new MoveRequest(currCell, 'M'));
		log.info(AFTER_MOVING_FORWARD, result);
		
		result = service.instruct(new MoveRequest(currCell, 'L'));
		log.info(AFTER_TURNING_LEFT, result);
		
		result = service.instruct(new MoveRequest(currCell, 'M'));
		log.info(AFTER_MOVING_FORWARD, result);
		
		result = service.instruct(new MoveRequest(currCell, 'M'));
		log.info(AFTER_MOVING_FORWARD, result);
	}
}