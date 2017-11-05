package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import collection.model.SlotGM;
import collection.model.element.Element;
import collection.model.element.ElementHandle;
import collection.model.element.ElementHandle.Handles;
import collection.model.element.ElementHandles;

@SuppressWarnings("serial")
public class SelectState extends State implements Serializable {
	private ArrayList<ElementHandle> handles;
	private SlotGM GMSlot;
	private ArrayList<Element> elements;
	private Point firstPosition;
	private boolean DeselectAll;
	private boolean elementHit = false;
	private ElementHandles elementHandles = null;

	public SelectState(SlotGM slotGM) {
		GMSlot = slotGM;
		elements = GMSlot.getElements();
	}

	@Override
	public void mousePressed(MouseEvent e) {

		DeselectAll = true;
		firstPosition = e.getPoint();
		GMSlot.notifyObservers(firstPosition);

		elementHandles = GMSlot.getElementSelectionManager().handleHit(firstPosition);

		if (elementHandles != null) {
			elementHit = true;
		}
		if (elementHandles == null) {
			for (Element element : elements) {

				if (element.getShape().contains(firstPosition)) {
					elementHit = true;
					if (SwingUtilities.isLeftMouseButton(e) && !e.isControlDown()) {

						GMSlot.getElementSelectionManager().removeAllFromSelectionList();
						GMSlot.getElementSelectionManager().addToSelectionList(element);

					} else if (SwingUtilities.isLeftMouseButton(e) && e.isControlDown()) {

						if (!GMSlot.getElementSelectionManager().getSelectionList().contains(element)) {
							GMSlot.getElementSelectionManager().addToSelectionList(element);
						} else {
							GMSlot.getElementSelectionManager().removeFromSelectionList(element);
						}

					} else if (SwingUtilities.isRightMouseButton(e) && e.isControlDown()) {

						if (GMSlot.getElementSelectionManager().getSelectionList().contains(element)) {
							GMSlot.getElementSelectionManager().removeFromSelectionList(element);
						}
					}
					DeselectAll = false;
					GMSlot.notifyObservers(firstPosition);
				}
			}
			if (DeselectAll && !e.isControlDown()) {
				GMSlot.getElementSelectionManager().removeAllFromSelectionList();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		GMSlot.notifyObservers(firstPosition);
		elementHit = false;
		elementHandles = null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (elementHit && SwingUtilities.isLeftMouseButton(e)) {
			Point2D point = e.getPoint();
			GMSlot.notifyObservers(point);
			elementHit = false;
			if (elementHandles != null) {
				handles = elementHandles.getHandles();
				if (!GMSlot.getElementSelectionManager().getSelectionList().contains(elementHandles.getElement())) {
					GMSlot.getElementSelectionManager().getSelectionList().add(elementHandles.getElement());
				}
				for (ElementHandle elementHandle : handles) {
					if (elementHandle.contains(point)) {
						Handles handleEnum = elementHandle.getHandleType();
						if (handleEnum == Handles.CENTER) {
							GMSlot.startMoveState();
						} else
							GMSlot.startResizeState();
					}
				}
			}
		}
	}

}
