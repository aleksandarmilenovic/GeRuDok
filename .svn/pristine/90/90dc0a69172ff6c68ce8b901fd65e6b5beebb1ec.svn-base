package actions.addnew;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import collection.controller.DocumentController;
import localization.Localization;

@SuppressWarnings("serial")
public class NewDocumentAction extends AbstractAction {
	public NewDocumentAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/document.png"));
		putValue(NAME, Localization.getInstance().getBundle().getString("newdocumentaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("newdocumentaction"));
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
		new DocumentController();
	}

	public void updateAction() {
		putValue(NAME, Localization.getInstance().getBundle().getString("newdocumentaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("newdocumentaction"));

	}
}