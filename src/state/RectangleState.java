package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import collection.model.SlotGM;
import commands.AddElementCommand;

@SuppressWarnings("serial")
public class RectangleState extends State implements Serializable {

	private SlotGM mMediator;

	public RectangleState(SlotGM slotGM) {
		mMediator = slotGM;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();

		mMediator.notifyObservers(position);

		mMediator.getCommandManager().addCommand(
				new AddElementCommand(mMediator, mMediator.getElementSelectionManager(), position, SlotGM.RECTANGLE));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

}
