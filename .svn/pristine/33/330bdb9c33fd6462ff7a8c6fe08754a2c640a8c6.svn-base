package actions.addnew;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import collection.controller.ProjectController;
import localization.Localization;

@SuppressWarnings("serial")
public class NewProjectAction extends AbstractAction {
	public NewProjectAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/project.png"));
		putValue(NAME, Localization.getInstance().getBundle().getString("newprojectaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("newprojectaction"));
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
		new ProjectController();	
	}
	public void updateAction() {
		putValue(NAME, Localization.getInstance().getBundle().getString("newprojectaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("newprojectaction"));
	}
}
