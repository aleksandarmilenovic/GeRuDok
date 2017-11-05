package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import collection.model.SlotGM;
import collection.model.element.Element;

@SuppressWarnings("serial")
public class LassoState extends State implements Serializable {

	private SlotGM gMSlot;
	private Point position, firstPosition;
	private ArrayList<Element> elements;

	private Rectangle2D selectionRectangle;

	public LassoState(SlotGM slotGM) {
		gMSlot = slotGM;
		selectionRectangle = new Rectangle2D.Double();
		elements = gMSlot.getElements();
	}

	@Override
	public void mousePressed(MouseEvent e) {

		firstPosition = e.getPoint();
		if (SwingUtilities.isRightMouseButton(e)) {
			for (Element element : elements) {
				if (element.getShape().contains(firstPosition)) {
					if (gMSlot.getElementSelectionManager().getSelectionList().contains(element)) {
						gMSlot.getElementSelectionManager().removeFromSelectionList(element);
					} else {
						gMSlot.getElementSelectionManager().addToSelectionList(element);
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		gMSlot.notifyObservers(1);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if (SwingUtilities.isLeftMouseButton(e)) {

			position = e.getPoint();
			gMSlot.notifyObservers(position);

			double width = position.getX() - firstPosition.getX();
			double height = position.getY() - firstPosition.getY();

			if ((width < 0) && (height < 0)) {
				selectionRectangle.setRect(position.getX(), position.getY(), Math.abs(width), Math.abs(height));
			} else if ((width < 0) && (height >= 0)) {
				selectionRectangle.setRect(position.getX(), firstPosition.getY(), Math.abs(width), Math.abs(height));
			} else if ((width > 0) && (height < 0)) {
				selectionRectangle.setRect(firstPosition.getX(), position.getY(), Math.abs(width), Math.abs(height));
			} else {
				selectionRectangle.setRect(firstPosition.getX(), firstPosition.getY(), Math.abs(width),
						Math.abs(height));
			}

			gMSlot.notifyObservers(selectionRectangle);
		}

	}

}
