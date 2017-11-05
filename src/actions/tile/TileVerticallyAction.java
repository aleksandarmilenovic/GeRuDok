package actions.tile;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

import gui.AppWindow;
import localization.Localization;

@SuppressWarnings("serial")
public class TileVerticallyAction extends AbstractAction {
	public TileVerticallyAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		putValue(SMALL_ICON, loadIcon("images/tileVertically.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("tilevertically"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("tilevertically"));
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
	public void actionPerformed(ActionEvent event) {
		JDesktopPane desk = AppWindow.getInstance().getDesktop();

		JInternalFrame[] allframes = desk.getAllFrames();
		int count = allframes.length;
		if (count == 0)
			return;

		int rows = 1;
		int cols = count;

		ArrayList<JInternalFrame> visibleframes = new ArrayList<JInternalFrame>();

		for (int ii = 0; ii < rows; ii++) {
			for (int jj = 0; jj < cols && ((ii * cols) + jj < count); jj++) {
				JInternalFrame g = allframes[(ii * cols) + jj];
				if (g.isVisible()) {
					visibleframes.add(g);
				}
			}
		}

		count = visibleframes.size();
		if (count == 0)
			return;
		cols = count;

		Dimension size = desk.getSize();

		int w = size.width / cols;
		int h = size.height / rows;
		int x = 0;
		int y = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols && ((i * cols) + j < count); j++) {
				JInternalFrame f = visibleframes.get((i * cols) + j);

				if (f.isMaximum()) {
					try {
						f.setMaximum(false);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
				}
				if (!f.isClosed() && f.isIcon()) {
					try {
						f.setIcon(false);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
				}
				desk.getDesktopManager().resizeFrame(f, x, y, w, h);
				x += w;
			}
			y += h;
			x = 0;
		}
	}

	public void updateAction() {
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("tilevertically"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("tilevertically"));
	}
}
