package actions.language;

import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import gui.AppWindow;
import localization.Language;
import localization.Localization;
import values.Settings;

@SuppressWarnings("serial")
public class LanguageSerbianCyrAction extends AbstractAction {

	public LanguageSerbianCyrAction() {
		putValue(SMALL_ICON, loadIcon("images/srpska.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("srbcyr"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("srbcyr"));
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

	public void updateAction() {
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("srbcyr"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("srbcyr"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Localization.getInstance().languageChange(Language.SERBIAN_CYRILIC);
		Settings.getInstance().setLanguage(Language.SERBIAN_CYRILIC);
		AppWindow.getInstance().getStatusBar()
				.setLanguageLabelText(Localization.getInstance().getBundle().getString("srbcyr"));
	}

}