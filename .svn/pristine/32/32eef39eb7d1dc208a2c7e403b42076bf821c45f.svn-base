package collection.model.element;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ElementHandle extends Rectangle2D implements Serializable {

	private Handles Handle;
	private double width = 12;
	private double height = 12;
	private double mX, mY;

	public ElementHandle(Handles handle, Point2D point) {

		Handle = handle;
		mX = point.getX() - width / 2;
		mY = point.getY() - height / 2;
	}

	public enum Handles {
		NORTHWEST, NORTH, NORTHEAST, WEST, EAST, SOUTHWEST, SOUTH, SOUTHEAST, CENTER
	}

	public Handles getHandleType() {
		return Handle;
	}

	@Override
	public Rectangle2D createIntersection(Rectangle2D r) {
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D r) {
		return null;
	}

	@Override
	public int outcode(double x, double y) {
		return 0;
	}

	@Override
	public void setRect(double x, double y, double w, double h) {
		mX = x;
		mY = y;
		width = w;
		height = h;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getX() {
		return mX;
	}

	@Override
	public double getY() {
		return mY;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
