package state;

import java.io.Serializable;

import collection.model.SlotGM;

@SuppressWarnings("serial")
public class StateManager implements Serializable {

	private State currentState;
	private RectangleState rectangleState;
	private CircleState circleState;
	private SelectState selectState;
	private LassoState lassoState;
	private MoveState moveState;
	private ResizeState resizeState;

	public StateManager(SlotGM slotGM) {
		rectangleState = new RectangleState(slotGM);
		circleState = new CircleState(slotGM);
		selectState = new SelectState(slotGM);
		lassoState = new LassoState(slotGM);
		moveState = new MoveState(slotGM);
		resizeState = new ResizeState(slotGM);
		currentState = selectState;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setRectangleState() {
		currentState = rectangleState;
	}

	public void setCircleState() {
		currentState = circleState;
	}

	public void setSelectState() {
		currentState = selectState;
	}

	public void setLassoState() {
		currentState = lassoState;
	}

	public void resetCurrentState() {
		currentState = selectState;
	}

	public void setMoveState() {
		currentState = moveState;
	}

	public void setResizeState() {
		currentState = resizeState;
	}
}
