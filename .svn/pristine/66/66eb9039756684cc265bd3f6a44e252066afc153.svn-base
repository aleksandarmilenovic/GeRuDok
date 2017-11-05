package commands;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import collection.model.SlotGM;
import collection.model.element.Element;
import collection.model.element.ElementSelectionManager;

@SuppressWarnings("serial")
public class RotateCommand extends Command implements Serializable {

	private SlotGM gMSlot;
	private ElementSelectionManager selectionManager;
	private ArrayList<Element> rotatedElements;
	private boolean first;

	public RotateCommand(SlotGM model) {
		gMSlot = model;
		selectionManager = gMSlot.getElementSelectionManager();
		rotatedElements = new ArrayList<>();
		first = true;
	}

	@Override
	public void doCommand() {
		if (first) {
			Iterator<Element> it = selectionManager.getSelectionListIterator();
			while (it.hasNext()) {
				rotatedElements.add(it.next());
			}
			first = false;
		} else {
			selectionManager.removeAllFromSelectionList();
		}
		rotate();
	}

	@Override
	public void undoCommand() {
		rotate();
		selectionManager.removeAllFromSelectionList();
	}

	public void rotate() {

		for (Element element : rotatedElements) {

			double w = element.getShape().getBounds2D().getWidth();
			double h = element.getShape().getBounds2D().getHeight();

			if (element.getShape() instanceof Rectangle2D) {
				Rectangle2D rect = (Rectangle2D) element.getShape();

				Point2D center = new Point2D.Double(rect.getCenterX(), rect.getCenterY());

				rect.setRect(center.getX() - h / 2, center.getY() - w / 2, h, w);

				element.setShape(rect);
				element.getPosition().setLocation(rect.getX() + rect.getWidth() / 2,
						rect.getY() + rect.getHeight() / 2);
				element.getDimension().setSize(rect.getWidth(), rect.getHeight());

				gMSlot.getElementSelectionManager().clearAllHandles();

			} else {

				Ellipse2D ellipse = (Ellipse2D) element.getShape();

				Point2D center = new Point2D.Double(ellipse.getCenterX(), ellipse.getCenterY());

				ellipse.setFrame(center.getX() - h / 2, center.getY() - w / 2, h, w);

				element.setShape(ellipse);
				element.getPosition().setLocation(ellipse.getX() + ellipse.getWidth() / 2,
						ellipse.getY() + ellipse.getHeight() / 2);
				element.getDimension().setSize(ellipse.getWidth(), ellipse.getHeight());

				gMSlot.getElementSelectionManager().clearAllHandles();
			}
			gMSlot.getSlotController().getGraphSlotView().updateUI();
			gMSlot.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
		}
	}

}
