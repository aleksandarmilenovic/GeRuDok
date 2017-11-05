package state.actions;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.MutableTreeNode;
import collection.model.SlotGM;
import commands.RotateCommand;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class RotateSelectedLeft extends AbstractAction {

	public RotateSelectedLeft() {
		putValue(SMALL_ICON, loadIcon("images/rotateLeft.png"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("rotateLeft"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("rotateLeft"));
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
		MutableTreeNode node = (MutableTreeNode) tree.getLastSelectedPathComponent();
		if (node instanceof SlotGM) {
			ArrayList<collection.model.element.Element> selectedElements = ((SlotGM) node).getElementSelectionManager()
					.getSelectionList();
			if (selectedElements.size() != 0) {
				((SlotGM) node).getCommandManager().addCommand(new RotateCommand((SlotGM) node));
			}
			((SlotGM) node).startSelectState();
		}
	}

	public void updateAction() {
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("rotateLeft"));
	}

}
