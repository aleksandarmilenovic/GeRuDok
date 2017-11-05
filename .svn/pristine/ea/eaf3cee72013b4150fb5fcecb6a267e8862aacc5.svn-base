package collection.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import collection.model.DocumentM;
import collection.model.ProjectM;
import collection.model.WorkspaceM;
import collection.view.DocumentView;
import collection.view.DocumentView.kontejner;
import collection.view.ProjectView.tabic;
import gui.AppWindow;
import tree.TreeM;

public class ViewSelectionListener extends MouseAdapter {

	@Override
	public void mousePressed(MouseEvent e) {

		JTree tree = AppWindow.getInstance().getJtree();
		TreeM tmodel = AppWindow.getInstance().getTreeModel();

		if (e.getSource() instanceof JDesktopPane) {
			JDesktopPane desk = (JDesktopPane) e.getSource();

			if (desk.getSelectedFrame() != null) {
				try {
					desk.getSelectedFrame().setSelected(false);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			}
			WorkspaceM root = (WorkspaceM) AppWindow.getInstance().getTreeModel().getRoot();
			TreeNode[] path = AppWindow.getInstance().getTreeModel().getPathToRoot(root);
			AppWindow.getInstance().getJtree().setSelectionPath(new TreePath(path));
		}

		if (e.getSource() instanceof tabic) {
			tabic pane = (tabic) e.getSource();
			if (pane.getSelectedComponent() != null) {
				DocumentM model = ((DocumentView) pane.getSelectedComponent()).getModel();
				TreeNode[] path = tmodel.getPathToRoot(model);
				tree.setSelectionPath(new TreePath(path));
			} else {
				ProjectM model = pane.getModelic();
				TreeNode[] path = tmodel.getPathToRoot(model);
				tree.setSelectionPath(new TreePath(path));
			}
		}

		if (e.getSource() instanceof kontejner) {
			kontejner kontis = (kontejner) e.getSource();
			TreeNode[] path = tmodel.getPathToRoot(kontis.getModel());
			tree.setSelectionPath(new TreePath(path));
		}

		if (e.getSource() instanceof PageView) {
			PageView pageView = (PageView) e.getSource();
			TreeNode[] path = tmodel.getPathToRoot(pageView.getModel());
			tree.setSelectionPath(new TreePath(path));
		}

		if (e.getSource() instanceof SlotView) {
			SlotView slotView = (SlotView) e.getSource();
			TreeNode[] path = tmodel.getPathToRoot(slotView.getModel());
			tree.setSelectionPath(new TreePath(path));
		}
	}
}
