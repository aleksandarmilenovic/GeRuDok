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
public class CloseAction extends AbstractAction {
	public CloseAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/close.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("closeaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("closeaction"));
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
	//	WorkspaceTree tree = AppCore.getInstance().getWorkspaceTree();
	//	MutableTreeNode node = (MutableTreeNode) tree.getLastSelectedPathComponent();
		ProjectM node = (ProjectM) AppWindow.getInstance().getJtree().getLastSelectedPathComponent();
		((ProjectController) ((ProjectM) node).getController()).getProjectView().hide();
	}
	public void updateAction(){
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("closeaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("closeaction"));
	}
}
