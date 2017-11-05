package collection.model.element;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

@SuppressWarnings("serial")
public class RectangleElement extends Element implements Serializable {

	public RectangleElement(String name, Point2D position, SerializableStrokeAdapter stroke, Dimension dimension,
			Paint paint) {
		super(name, position, stroke, dimension, paint);
		Rectangle2D rectangle = new Rectangle2D.Double(position.getX() - dimension.getWidth() / 2,
				position.getY() - dimension.getHeight() / 2, dimension.getWidth(), dimension.getHeight());
		super.setShape(rectangle);
	}

	public static Element createDefault(Point2D pos, int elno) {
		Point2D position = (Point2D) pos.clone();
		Paint paint = Color.BLUE;

		RectangleElement el = new RectangleElement("Rectangle " + (elno + 1), position,
				new SerializableStrokeAdapter(new BasicStroke(1)), new Dimension(60, 40), paint);

		return el;
	}

}
