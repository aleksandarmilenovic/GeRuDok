package commands;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.Serializable;

import javax.swing.JTree;

import collection.model.SlotGM;
import collection.model.element.CircleElement;
import collection.model.element.Element;
import collection.model.element.ElementSelectionManager;
import collection.model.element.RectangleElement;
import collection.view.slot.GraphSlotView;
import gui.AppWindow;

@SuppressWarnings({ "unused", "serial" })
public class AddElementCommand extends Command implements Serializable {

	private SlotGM slotgm;
	private ElementSelectionManager selectionManager;
	private Point2D position;
	private int elementType;
	private Element element = null;
	private Color color = null;
	boolean FirstTime = true;
	private JTree tree = AppWindow.getInstance().getJtree();

	public AddElementCommand(SlotGM model, ElementSelectionManager selectionManager, Point2D position,
			int elementType) {
		slotgm = model;
		this.selectionManager = selectionManager;
		this.position = position;
		this.elementType = elementType;
	}

	@Override
	public void doCommand() {

		if (FirstTime) {
			if (elementType == SlotGM.CIRCLE) {
				element = CircleElement.createDefault(position, slotgm.getElementsCount());
			} else if (elementType == SlotGM.RECTANGLE) {
				element = RectangleElement.createDefault(position, slotgm.getElementsCount());
			}
		}
		FirstTime = false;

		if (element instanceof RectangleElement) {
			AppWindow.getInstance().getTreeModel().add((RectangleElement) element);
		} else {
			AppWindow.getInstance().getTreeModel().add((CircleElement) element);
		}
		slotgm.getSlotController().getGraphSlotView().updateUI();
		slotgm.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
	}

	@Override
	public void undoCommand() {
		selectionManager.removeAllFromSelectionList();

		if (element instanceof RectangleElement) {
			AppWindow.getInstance().getTreeModel().remove((RectangleElement) element);
		} else {
			AppWindow.getInstance().getTreeModel().remove((CircleElement) element);
		}
		slotgm.removeElement(element);
		slotgm.getSlotController().getGraphSlotView().updateUI();
		slotgm.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
	}

}
