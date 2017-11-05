package collection.view.slot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

import collection.model.SlotGM;
import collection.model.element.Element;
import collection.model.element.ElementHandle;
import collection.model.element.ElementSelectionManager;

@SuppressWarnings("serial")
public class GraphSlotCanvas extends JPanel {

	private SlotGM gMSlot;
	private ArrayList<Element> elements;
	private ElementSelectionManager elementSelectionManager;
	@SuppressWarnings("unused")
	private ArrayList<Point2D> points;
	@SuppressWarnings("unused")
	private Graphics2D g2d;
	private Rectangle2D restangle;
	@SuppressWarnings("unused")
	private boolean paint = false;
	private boolean triger = false;

	public static Point2D startingPoint = null;
	public static double translateX = 0;
	public static double translateY = 0;
	public static double scaling = 1;
	public final static double translateFactor = 10;
	public final static double scalingFactor = 1.2;

	public static AffineTransform mTransformation;

	public GraphSlotCanvas(SlotGM slotGM) {
		setBackground(Color.WHITE);
		gMSlot = slotGM;
		elements = gMSlot.getElements();
		elementSelectionManager = gMSlot.getElementSelectionManager();
		mTransformation = gMSlot.getmTransformation();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.transform(mTransformation);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for (Element element : elements) {

			if (elementSelectionManager.getSelectionListSize() > 0
					&& elementSelectionManager.getSelectionList().contains(element)) {

				Graphics2D g2d2 = (Graphics2D) g.create();

				g2d2.setColor(Color.RED);
				g2d2.setStroke(new BasicStroke((float) (3), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
				g2d2.draw(element.getShape());

				try {
					ArrayList<ElementHandle> elementHandles = elementSelectionManager.selectedElementHandles(element);
					for (ElementHandle elementHandle : elementHandles) {
						g2d2.setColor(Color.RED);
						g2d2.fill(elementHandle);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				g2d2.setPaint(element.getPaint());
				AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
				g2d2.setComposite(alcom);
				g2d2.fill(element.getShape());
				g2d2.dispose();

			} else {

				g2d.setPaint(element.getPaint());
				g2d.fill(element.getShape());

			}

		}

		if (triger) {
			paintSelectionRectangle(g2d);
		}

	}

	public void turnON(Rectangle2D selectionRectangle) {
		restangle = selectionRectangle;
		triger = true;
	}

	public void paintSelectionRectangle(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(2));
		g2d.draw(restangle);
		solveElementSelectionRectangle();
	}

	public void solveElementSelectionRectangle() {

		elementSelectionManager.selectElements(restangle, elements);

	}

	public void transformToUserSpace(Point2D deviceSpace) {
		try {
			mTransformation.inverseTransform(deviceSpace, deviceSpace);
		} catch (NoninvertibleTransformException e) {
			e.printStackTrace();
		}
	}

	public void setPaint(Rectangle2D rectangle2d, boolean t) {
		restangle = rectangle2d;
		paint = t;
		triger = true;
	}

	public void setPaint2(boolean b) {
		paint = b;

	}

	public void turnOFF() {
		triger = false;
	}

}
