package state;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import collection.model.SlotGM;
import collection.model.element.Element;
import collection.model.element.ElementHandle;
import collection.model.element.ElementHandles;
import commands.ResizeCommand;

@SuppressWarnings("serial")
public class ResizeState extends State implements Serializable {

	private SlotGM gMSlot;
	private Element Element;
	private ElementHandles ElementHandles;
	private ArrayList<ElementHandle> handles;
	private ElementHandle handle;
	private ElementHandle.Handles handleEnum;
	private boolean selected = false;
	private Point2D start;

	private Rectangle2D rectangle;
	private Ellipse2D ellipse;

	private Element oldElement;

	public ResizeState(SlotGM mediator) {
		gMSlot = mediator;

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		updateAll();
		clearAll();
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		Point2D last = e.getPoint();
		gMSlot.notifyObservers(last);

		if (!selected && handle == null) {
			ElementHandles = gMSlot.getElementSelectionManager().handleHit(last);
			if (ElementHandles == null) {
				clearAll();
				return;
			}
			Element = ElementHandles.getElement();
			handles = ElementHandles.getHandles();
			selected = true;
		}

		if (handles != null && handleEnum == null) {
			for (ElementHandle elementHandle : handles) {
				if (elementHandle.contains(last)) {
					handle = elementHandle;
					start = new Point2D.Double(handle.getCenterX(), handle.getCenterY());
					handleEnum = handle.getHandleType();
				}
			}
		}

		if (handleEnum != null) {
			calculateHandleEffect(last, e);
			oldElement = Element.duplicate();
		}

	}

	private void calculateHandleEffect(Point2D last, MouseEvent e) {

		double w = Element.getDimension().getWidth();
		double h = Element.getDimension().getHeight();
		double x = Element.getPosition().getX() - w / 2;
		double y = Element.getPosition().getY() - h / 2;

		double dx = (last.getX() - start.getX());
		double dy = (last.getY() - start.getY());

		if (Element.getShape() instanceof Rectangle2D) {

			rectangle = (Rectangle2D) Element.getShape();

			switch (handleEnum) {

			case NORTHWEST:
				if (!(w - dx < 30) && !(h - dy < 30)) {
					rectangle.setRect(x + dx, y + dy, w - dx, h - dy);
				}
				break;

			case NORTH:
				if (!(h - dy < 30)) {
					rectangle.setRect(x, y + dy, w, h - dy);
				}
				break;

			case NORTHEAST:
				if (!(w + dx < 30) && !(h - dy < 30)) {
					rectangle.setRect(x, y + dy, w + dx, h - dy);
				}
				break;

			case WEST:
				if (!(w - dx < 30)) {
					rectangle.setRect(x + dx, y, w - dx, h);
				}
				break;

			case EAST:
				if (!(w + dx < 30)) {
					rectangle.setRect(x, y, w + dx, h);
				}
				break;

			case SOUTHWEST:
				if (!(w - dx < 30) && !(h + dy < 30)) {
					rectangle.setRect(x + dx, y, w - dx, h + dy);

				}
				break;

			case SOUTH:
				if (!(h + dy < 30)) {
					rectangle.setRect(x, y, w, h + dy);
				}
				break;

			case SOUTHEAST:
				if (!(w + dx < 30) && !(h + dy < 30)) {
					rectangle.setRect(x, y, w + dx, h + dy);
				}
				break;

			default:
				break;
			}

		} else {

			ellipse = (Ellipse2D) Element.getShape();

			switch (handleEnum) {

			case NORTH:
				if (!(h - dy < 30)) {
					ellipse.setFrame(x, y + dy, w, h - dy);
				}
				break;

			case WEST:
				if (!(w - dx < 30)) {
					ellipse.setFrame(x + dx, y, w - dx, h);
				}
				break;

			case EAST:
				if (!(w + dx < 30)) {
					ellipse.setFrame(x, y, w + dx, h);
				}
				break;

			case SOUTH:
				if (!(h + dy < 30)) {
					ellipse.setFrame(x, y, w, h + dy);
				}
				break;

			default:
				break;
			}
		}
		gMSlot.notifyObservers(1);

		if (rectangle != null) {
			Element.setShape(rectangle);
		} else if (ellipse != null) {
			Element.setShape(ellipse);
		}

		gMSlot.getElementSelectionManager().clearAllHandles();
	}

	private void updateAll() {
		if (Element != null && rectangle != null) {
			Element.setShape(rectangle);
			Element.getPosition().setLocation(rectangle.getX() + rectangle.getWidth() / 2,
					rectangle.getY() + rectangle.getHeight() / 2);
			Element.getDimension().setSize(rectangle.getWidth(), rectangle.getHeight());
		} else if (Element != null && ellipse != null) {
			Element.setShape(ellipse);
			Element.getPosition().setLocation(ellipse.getX() + ellipse.getWidth() / 2,
					ellipse.getY() + ellipse.getHeight() / 2);
			Element.getDimension().setSize(ellipse.getWidth(), ellipse.getHeight());
		}
		if (gMSlot.getElementSelectionManager().getSelectionListSize() > 0) {
			gMSlot.getCommandManager().addCommand(new ResizeCommand(gMSlot, oldElement, Element));
		}

		gMSlot.getElementSelectionManager().clearAllHandles();
	}

	private void clearAll() {
		selected = false;
		start = null;
		ElementHandles = null;
		Element = null;
		handle = null;
		handleEnum = null;
		rectangle = null;
		ellipse = null;
		gMSlot.startSelectState();
	}

}
