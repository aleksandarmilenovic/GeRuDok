package actions.tile;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class TileCascadeAction extends AbstractAction {
	public TileCascadeAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		putValue(SMALL_ICON, loadIcon("images/tileCascade.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("tilecascade"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("tilecascade"));
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
		JInternalFrame[] allframes = AppWindow.getInstance().getDesktop().getAllFrames();
		int x = 0;
		int y = 0;
		int count = 0;

		count = allframes.length;
		ArrayList<JInternalFrame> visibleframes = new ArrayList<JInternalFrame>();

		for (int j = 0; j < count; j++) {
			JInternalFrame g = allframes[j];
			if (g.isVisible()) {
				visibleframes.add(g);
			}
		}

		count = visibleframes.size();

		for (int i = count - 1; i >= 0; i--) {
			visibleframes.get(i).setSize(400, 400);
			visibleframes.get(i).setLocation(x, y);
			x += 15;
			y += 25;
		}

	}

	public void updateAction() {
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("tilecascade"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("tilecascade"));
	}

}
