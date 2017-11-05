package actions.AA;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import collection.model.SlotGM;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class RedoAction extends AbstractAction {

	RedoAction() {
		putValue(SMALL_ICON, loadIcon("images/redo.png"));
		putValue(NAME, Localization.getInstance().getBundle().getString("redo"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("redo"));
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
		SlotGM slotgm = (SlotGM) AppWindow.getInstance().getJtree().getLastSelectedPathComponent();
		slotgm.getCommandManager().doCommand();
	}
	
	public void updateAction(){
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("redo"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("redo"));
		}
}
