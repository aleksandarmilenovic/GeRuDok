package actions.AA;

import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.AppWindow;
import localization.Localization;
import values.Settings;

@SuppressWarnings("serial")
public class SwitchWorkspaceAction extends AbstractAction {
	public SwitchWorkspaceAction() {

		putValue(SMALL_ICON, loadIcon("images/switchworkspace.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("switchworkspaceaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("switchworkspaceaction"));
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
		String yes = Localization.getInstance().getBundle().getString("yes");
		String no = Localization.getInstance().getBundle().getString("no");
		String check = Localization.getInstance().getBundle().getString("poruka3");
		String title = Localization.getInstance().getBundle().getString("appname");
		AppWindow prozor = AppWindow.getInstance();
		String ObjButtons[] = { yes, no };
		int PromptResult = JOptionPane.showOptionDialog(prozor, check, title, JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
		if (PromptResult == JOptionPane.YES_OPTION) {
			Settings.getInstance().setPathToWorkspace(null);
			System.exit(0);
		}

	}

	public void updateAction() {
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("switchworkspaceaction"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("switchworkspaceaction"));
	}
}