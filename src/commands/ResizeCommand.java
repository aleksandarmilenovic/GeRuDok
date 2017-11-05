package commands;

import java.io.Serializable;

import collection.model.SlotGM;
import collection.model.element.Element;

@SuppressWarnings("serial")
public class ResizeCommand extends Command implements Serializable {

	private SlotGM gMSlot;
	private Element OldState;
	private Element ActiveState;
	private Element activeStateBackup;

	private boolean first;

	public ResizeCommand(SlotGM model, Element oldState, Element newState) {
		gMSlot = model;
		OldState = oldState;
		ActiveState = newState;
		activeStateBackup = ActiveState.duplicate();
		first = true;
	}

	@Override
	public void doCommand() {

		if (!first) {

			ActiveState.setShape(activeStateBackup.getShape());
			ActiveState.getPosition().setLocation(activeStateBackup.getPosition());
			ActiveState.getDimension().setSize(activeStateBackup.getDimension());

			gMSlot.getElementSelectionManager().clearAllHandles();
			gMSlot.notifyObservers(1);
			gMSlot.getSlotController().getGraphSlotView().updateUI();
			gMSlot.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
		}

	}

	@Override
	public void undoCommand() {

		ActiveState.setShape(OldState.getShape());
		ActiveState.getPosition().setLocation(OldState.getPosition());
		ActiveState.getDimension().setSize(OldState.getDimension());
		first = false;
		gMSlot.getElementSelectionManager().clearAllHandles();
		gMSlot.notifyObservers(1);
		gMSlot.getSlotController().getGraphSlotView().updateUI();
		gMSlot.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();

	}

}
