package tree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import gui.AppWindow;
import gui.Popup;

public class TreeMouseListener extends MouseAdapter {

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			Popup meni = AppWindow.getInstance().getPopup();
			JTree tree = AppWindow.getInstance().getJtree();
			TreePath path = tree.getPathForLocation(e.getX(), e.getY());

			if (path == null) {
				tree.setSelectionPath(null);
			} else {
				tree.setSelectionPath(path);
			}

			if (meni.isEnabled()) {
				meni.show(tree, e.getX(), e.getY());
			}
		}
	}

}
