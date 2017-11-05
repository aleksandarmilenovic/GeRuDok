package actions.addnew;

import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import collection.controller.GraphSlotController;
import localization.Localization;

@SuppressWarnings("serial")
public class NewGraphSlotAction extends AbstractAction {
	public NewGraphSlotAction() {
		putValue(SMALL_ICON, loadIcon("images/slotM.png"));
		putValue(NAME, Localization.getInstance().getBundle().getString("newgraphslotaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("newgraphslotaction"));
	}

	private Icon loadIcon(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = null;
		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		} else {
			System.err.println("Resource not found: " + fileName);
		}

		return icon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new GraphSlotController();
	}

	public void updateAction() {
		putValue(NAME, Localization.getInstance().getBundle().getString("newgraphslotaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("newgraphslotaction"));

	}
}
