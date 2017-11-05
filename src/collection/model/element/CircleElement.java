package collection.model.element;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.Serializable;

@SuppressWarnings("serial")
public class CircleElement extends Element implements Serializable {

	public CircleElement(String name, Point2D position, SerializableStrokeAdapter stroke, Dimension dimension,
			Paint paint) {
		super(name, position, stroke, dimension, paint);
		Ellipse2D circle = new Ellipse2D.Double(position.getX() - dimension.getWidth() / 2,
				position.getY() - dimension.getHeight() / 2, dimension.getWidth(), dimension.getHeight());
		super.setShape(circle);
	}

	public static Element createDefault(Point2D pos, int elno) {
		Point2D position = (Point2D) pos.clone();
		Paint paint = Color.BLACK;

		CircleElement circle = new CircleElement("Circle " + (elno + 1), position,
				new SerializableStrokeAdapter(new BasicStroke(1)), new Dimension(40, 40), paint);

		return circle;
	}

}
