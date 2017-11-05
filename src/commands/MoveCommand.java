package commands;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import collection.model.SlotGM;
import collection.model.element.Element;
import java.awt.geom.Rectangle2D;

public class MoveCommand extends Command {

	private double[] PtacakX = new double[100];
	private double[] PtacakY = new double[100];
	private double[] tacakX = new double[100];
	private double[] tacakY = new double[100];
	private ArrayList<Element> mSelectionList;
	private SlotGM slotgm;
	boolean mFirst;
	double newX;
	double newY;
	private Ellipse2D mEllipseElement;
	private Rectangle2D mRectElement;
	private Ellipse2D[] pEllipse = new Ellipse2D[100];
	private Rectangle2D[] pRect = new Rectangle2D[100];

	private Rectangle2D switchRect;
	private Ellipse2D switchElip;

	public MoveCommand(SlotGM model, double[] pointsX, double[] pointsY) {
		slotgm = model;
		mSelectionList = slotgm.getElementSelectionManager().getSelectionList();
		tacakX = pointsX.clone();
		tacakY = pointsY.clone();
		mFirst = true;

	}

	@Override
	public void doCommand() {
		if (mFirst) {
			int i = 0;
			for (Element element : mSelectionList) {
				if (element.getShape() instanceof Rectangle2D) {
					PtacakX[i] = element.getPosition().getX();
					PtacakY[i] = element.getPosition().getY();
					element.getPosition().setLocation(tacakX[i] + element.getDimension().getWidth() / 2,
							tacakY[i] + element.getDimension().getHeight() / 2);

					mRectElement = (Rectangle2D) element.getShape();
					mRectElement.setRect(element.getPosition().getX() - element.getDimension().getWidth() / 2,
							element.getPosition().getY() - element.getDimension().getHeight() / 2,
							element.getDimension().getWidth(), element.getDimension().getHeight());
					element.setShape(mRectElement);

					pRect[i] = mRectElement;
					slotgm.getElementSelectionManager().clearAllHandles();

				} else {
					PtacakX[i] = element.getPosition().getX();
					PtacakY[i] = element.getPosition().getY();
					element.getPosition().setLocation(tacakX[i] + element.getDimension().getWidth() / 2,
							tacakY[i] + element.getDimension().getHeight() / 2);

					mEllipseElement = (Ellipse2D) element.getShape();
					mEllipseElement.setFrame(element.getPosition().getX() - element.getDimension().getWidth() / 2,
							element.getPosition().getY() - element.getDimension().getHeight() / 2,
							element.getDimension().getWidth(), element.getDimension().getHeight());
					pEllipse[i] = mEllipseElement;

					element.setShape(mEllipseElement);
					slotgm.getElementSelectionManager().clearAllHandles();

				}
				slotgm.getElementSelectionManager().clearAllHandles();
				i++;
				slotgm.getSlotController().getGraphSlotView().updateUI();
				slotgm.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
			}
		}
		slotgm.getSlotController().getGraphSlotView().updateUI();
		slotgm.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();

	}

	@Override
	public void undoCommand() {
		int i = 0;
		for (Element element : mSelectionList) {
			if (element.getShape() instanceof Rectangle2D) {

				element.setShape(pRect[i]);
				element.getPosition().setLocation(PtacakX[i], PtacakY[i]);
				(switchRect) = (Rectangle2D) element.getShape();
				switchRect.setRect(element.getPosition().getX() - element.getDimension().getWidth() / 2,
						element.getPosition().getY() - element.getDimension().getHeight() / 2,
						element.getDimension().getWidth(), element.getDimension().getHeight());
				element.setShape(switchRect);
				slotgm.getElementSelectionManager().clearAllHandles();

			} else {

				element.setShape(pEllipse[i]);
				element.getPosition().setLocation(PtacakX[i], PtacakY[i]);
				switchElip = (Ellipse2D) element.getShape();
				switchElip.setFrame(element.getPosition().getX() - element.getDimension().getWidth() / 2,
						element.getPosition().getY() - element.getDimension().getHeight() / 2,
						element.getDimension().getWidth(), element.getDimension().getHeight());
				element.setShape(switchElip);
				slotgm.getElementSelectionManager().clearAllHandles();
			}
			slotgm.getElementSelectionManager().clearAllHandles();
			i++;
			slotgm.getSlotController().getGraphSlotView().updateUI();
			slotgm.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();
		}
		slotgm.getSlotController().getGraphSlotView().updateUI();
		slotgm.getSlotController().getGraphSlotView().getEditingWindow().getCanvas().updateUI();

	}

}