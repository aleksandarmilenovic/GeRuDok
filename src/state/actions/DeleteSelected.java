package state.actions;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import collection.model.SlotGM;
import collection.model.element.Element;
import commands.DeleteElementCommand;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class DeleteSelected extends AbstractAction {

	public DeleteSelected() {
		putValue(SMALL_ICON, loadIcon("images/delete.png"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("delete"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("delete"));
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
			SlotGM slot = (SlotGM) node;
			ArrayList<Element> elementiZaBrisanje = slot.getElementSelectionManager().getSelectionList();
			for (Element element : elementiZaBrisanje) {
				slot.getCommandManager().addCommand(new DeleteElementCommand(slot, element));
			}
			slot.getElementSelectionManager().removeAllFromSelectionList();
		}
	}

	public void updateAction() {
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("delete"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("delete"));
		
	}

}
