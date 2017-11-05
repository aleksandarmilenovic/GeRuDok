package actions.AA;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import collection.controller.ProjectController;
import collection.model.ProjectM;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class OpenProjectAction  extends AbstractAction {
	public OpenProjectAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/project.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("openprojectaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("openprojectaction"));
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
		ProjectM node = (ProjectM) AppWindow.getInstance().getJtree().getLastSelectedPathComponent();
		((ProjectController) ((ProjectM) node).getController()).getProjectView().show();
	}
	
	public void updateAction(){
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("openprojectaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("openprojectaction"));
	}
}