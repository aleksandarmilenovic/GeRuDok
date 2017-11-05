package actions.AA;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import collection.model.ProjectM;
import collection.model.WorkspaceM;
import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class CloseAllAction extends AbstractAction {
	public CloseAllAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W,
				java.awt.event.InputEvent.CTRL_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
		putValue(SMALL_ICON, loadIcon("images/close.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("closeallaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("closeallaction"));
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
		
		WorkspaceM mode = (WorkspaceM) AppWindow.getInstance().getTreeModel().getRoot();
		
		int i=0; 
		int k;
		k=mode.getChildCount();
		
		for (i=0;i<k;i++){
			ProjectM mod = (ProjectM) mode.getChildAt(i);
			mod.getController().getProjectView().hide();
		}
		
	}
	public void updateAction(){
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("closeallaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("closeallaction"));	
	}
}
