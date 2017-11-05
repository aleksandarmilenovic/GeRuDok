package state;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;

import collection.model.SlotGM;
import collection.model.element.Element;
import commands.MoveCommand;

@SuppressWarnings("serial")
public class MoveState extends State implements Serializable {

	private double[] tackeX = new double[100];
	private double[] tackeY = new double[100];
	private ArrayList<Rectangle2D> rektovi = new ArrayList<>();
	private SlotGM gMSlot;
	private Rectangle2D rectElement = null;
	private Ellipse2D ellipseElement = null;
	private ArrayList<Element> selectionList;
	private boolean selected = false;
	private Point2D start;
	@SuppressWarnings("unused")
	private double x = 0;
	@SuppressWarnings("unused")
	private double y = 0;

	public MoveState(SlotGM graphSlot) {
		gMSlot = graphSlot;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if (!selected) {
			start = e.getPoint();
			selected = true;
		}

		Point2D last = e.getPoint();
		gMSlot.notifyObservers(last);

		double dx = last.getX() - start.getX();
		double dy = last.getY() - start.getY();

		selectionList = gMSlot.getElementSelectionManager().getSelectionList();

		if (selected) {
			int i = 0;
			for (Element element : selectionList) {

				if (element.getShape() instanceof Rectangle2D) {
					rectElement = (Rectangle2D) element.getShape();
					rectElement.setRect(element.getPosition().getX() - element.getDimension().getWidth() / 2 + dx,
							element.getPosition().getY() - element.getDimension().getHeight() / 2 + dy,
							element.getDimension().getWidth(), element.getDimension().getHeight());
					element.setShape(rectElement);
					gMSlot.getElementSelectionManager().clearAllHandles();

					tackeX[i] = rectElement.getX();
					tackeY[i] = rectElement.getY();
				} else {
					ellipseElement = (Ellipse2D) element.getShape();
					ellipseElement.setFrame(element.getPosition().getX() - element.getDimension().getWidth() / 2 + dx,
							element.getPosition().getY() - element.getDimension().getHeight() / 2 + dy,
							element.getDimension().getWidth(), element.getDimension().getHeight());
					element.setShape(ellipseElement);
					gMSlot.getElementSelectionManager().clearAllHandles();
					tackeX[i] = ellipseElement.getX();
					tackeY[i] = ellipseElement.getY();
				}
				i++;
			}

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		updateAll();
		clearAll();
		gMSlot.startSelectState();
	}

	private void updateAll() {
		gMSlot.getCommandManager().addCommand(new MoveCommand(gMSlot, tackeX, tackeY));
		rektovi.clear();
	}

	private void clearAll() {
		selected = false;
		rectElement = null;
		ellipseElement = null;
		start = null;
	}

}
