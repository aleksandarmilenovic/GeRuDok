package commands;

import java.io.Serializable;
import collection.model.SlotGM;
import collection.model.element.CircleElement;
import collection.model.element.Element;
import collection.model.element.RectangleElement;
import gui.AppWindow;
import tree.TreeM;

@SuppressWarnings("serial")
public class DeleteElementCommand extends Command implements Serializable {

	private SlotGM slotgm;
	private Element element = null;

	public DeleteElementCommand(SlotGM model, Element elem) {
		slotgm = model;
		element = elem;

	}

	@Override
	public void doCommand() {
		TreeM treemodel = AppWindow.getInstance().getTreeModel();
		slotgm.removeElementFromList(element);
		treemodel.remove(element);
		slotgm.getSlotController().getGraphSlotView().updateUI();
		slotgm.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
	}

	@Override
	public void undoCommand() {

		if (element instanceof RectangleElement) {
			AppWindow.getInstance().getTreeModel().add((RectangleElement) element);
		} else {
			AppWindow.getInstance().getTreeModel().add((CircleElement) element);
		}

		slotgm.getSlotController().getGraphSlotView().updateUI();
		slotgm.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
	}
}
