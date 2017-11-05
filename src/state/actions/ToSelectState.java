package state.actions;

import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;

import collection.model.SlotGM;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class ToSelectState extends AbstractAction {

	public ToSelectState() {
		putValue(NAME, "Selection");
		putValue(SMALL_ICON, loadIcon("images/selection.png"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("selection"));
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
		JTree tree = AppWindow.getInstance().getJtree();
		SlotGM node = (SlotGM) tree.getLastSelectedPathComponent();
		if (node instanceof SlotGM) {
			((SlotGM) node).startSelectState();
		}
	}

	public void updateAction() {
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("selection"));
	}
}
