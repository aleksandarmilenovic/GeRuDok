package collection.model.element;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import javax.swing.tree.DefaultMutableTreeNode;

import collection.model.SlotGM;

@SuppressWarnings("serial")
public class Element extends DefaultMutableTreeNode implements Serializable {

	SlotGM gMSlot;
	protected String mName;
	protected Point2D Position;
	protected SerializableStrokeAdapter Stroke;
	protected Dimension mDimension;
	protected Paint Paint;
	protected Shape Shape;
	protected boolean selected = false;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Element(String name, Point2D position, SerializableStrokeAdapter stroke, Dimension dimension, Paint paint) {
		mName = name;
		Position = position;
		Stroke = stroke;
		mDimension = dimension;
		setUserObject(name);
	}

	public Element duplicate() {
		Element element = new Element(mName, new Point2D.Double(Position.getX(), Position.getY()),
				new SerializableStrokeAdapter(new BasicStroke(1)), new Dimension(mDimension), Paint);
		element.setParent(gMSlot);
		if (Shape instanceof Rectangle2D) {
			Rectangle2D rect = new Rectangle2D.Double(element.Position.getX() - element.getDimension().getWidth() / 2,
					element.Position.getY() - element.getDimension().getHeight() / 2, element.mDimension.getWidth(),
					element.mDimension.getHeight());
			element.setShape(rect);
		} else {
			Ellipse2D ellipse = new Ellipse2D.Double(element.Position.getX() - element.getDimension().getWidth() / 2,
					element.Position.getY() - element.getDimension().getHeight() / 2, element.mDimension.getWidth(),
					element.mDimension.getHeight());
			element.setShape(ellipse);
		}
		return element;
	}

	public Element(Element e) {
		if (e instanceof RectangleElement) {
			RectangleElement RE = (RectangleElement) e;
			mName = RE.getName();
			Position = RE.getPosition();
			Stroke = (SerializableStrokeAdapter) RE.getStroke();
			mDimension = RE.getDimension();
			setUserObject(RE.getName());
		}
		if (e instanceof CircleElement) {
			CircleElement CE = (CircleElement) e;
			mName = CE.getName();
			Position = CE.getPosition();
			Stroke = (SerializableStrokeAdapter) CE.getStroke();
			mDimension = CE.getDimension();
			setUserObject(CE.getName());
		}

	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public void setPosition(Point2D mPosition) {
		this.Position = mPosition;
	}

	public void setPosition(double x, double y) {
		this.Position.setLocation(x, y);
	}

	public Point2D getPosition() {
		return Position;
	}

	public Stroke getStroke() {
		return Stroke;
	}

	public Dimension getDimension() {
		return mDimension;
	}

	public Paint getPaint() {
		return Paint;
	}

	public Shape getShape() {
		return Shape;
	}

	public void setShape(Shape shape) {
		Shape = shape;
	}

}
