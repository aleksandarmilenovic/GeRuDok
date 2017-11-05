package collection.model.element;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ElementHandles implements Serializable {

	private ArrayList<ElementHandle> elementHandles;
	private Element element;

	public ElementHandles(Element element) {
		elementHandles = new ArrayList<ElementHandle>();
		this.element = element;
		addHandles();
	}

	private void addHandles() {

		if (element.getShape() instanceof Rectangle2D) {

			Rectangle2D rect = (Rectangle2D) element.getShape();

			elementHandles
					.add(new ElementHandle(ElementHandle.Handles.NORTHWEST, new Point2D.Double(rect.getX(), rect.getY())));
		
			elementHandles.add(new ElementHandle(ElementHandle.Handles.NORTH,
					new Point2D.Double(rect.getX() + rect.getWidth() / 2, rect.getY())));
		
			elementHandles.add(new ElementHandle(ElementHandle.Handles.NORTHEAST,
					new Point2D.Double(rect.getX() + rect.getWidth(), rect.getY())));
		
			elementHandles.add(new ElementHandle(ElementHandle.Handles.WEST,
					new Point2D.Double(rect.getX(), rect.getY() + rect.getHeight() / 2)));
			
			elementHandles.add(new ElementHandle(ElementHandle.Handles.EAST,
					new Point2D.Double(rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight() / 2)));
			
			elementHandles.add(new ElementHandle(ElementHandle.Handles.SOUTHWEST,
					new Point2D.Double(rect.getX(), rect.getY() + rect.getHeight())));
			
			elementHandles.add(new ElementHandle(ElementHandle.Handles.SOUTH,
					new Point2D.Double(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight())));
			
			elementHandles.add(new ElementHandle(ElementHandle.Handles.SOUTHEAST,
					new Point2D.Double(rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight())));

			elementHandles.add(new ElementHandle(ElementHandle.Handles.CENTER,
					new Point2D.Double(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2)));

		} else if (element.getShape() instanceof Ellipse2D) {

			Ellipse2D ellipse = (Ellipse2D) element.getShape();

			elementHandles.add(new ElementHandle(ElementHandle.Handles.NORTH,
					new Point2D.Double(ellipse.getX() + ellipse.getWidth() / 2, ellipse.getY())));

			elementHandles.add(new ElementHandle(ElementHandle.Handles.WEST,
					new Point2D.Double(ellipse.getX(), ellipse.getY() + ellipse.getHeight() / 2)));

			elementHandles.add(new ElementHandle(ElementHandle.Handles.EAST,
					new Point2D.Double(ellipse.getX() + ellipse.getWidth(), ellipse.getY() + ellipse.getHeight() / 2)));

			elementHandles.add(new ElementHandle(ElementHandle.Handles.SOUTH,
					new Point2D.Double(ellipse.getX() + ellipse.getWidth() / 2, ellipse.getY() + ellipse.getHeight())));

			elementHandles.add(new ElementHandle(ElementHandle.Handles.CENTER, new Point2D.Double(
					ellipse.getX() + ellipse.getWidth() / 2, ellipse.getY() + ellipse.getHeight() / 2)));

		}
	}

	public Element getElement() {
		return element;
	}

	public ArrayList<ElementHandle> getHandles() {
		return elementHandles;
	}
}
