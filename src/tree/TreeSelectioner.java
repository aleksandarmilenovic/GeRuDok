package tree;

import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import actions.AA.ActionManager;
import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.ProjectM;
import collection.model.SlotGM;
import collection.model.SlotTM;
import collection.model.WorkspaceM;
import collection.view.DocumentView;
import collection.view.slot.GraphSlotView;
import collection.view.slot.TextSlotView;
import gui.AppWindow;
import gui.BorderUnselector;

public class TreeSelectioner implements TreeSelectionListener {

	public void valueChanged(TreeSelectionEvent e) {

		JTree tree = AppWindow.getInstance().getJtree();
		TreeM treeM = AppWindow.getInstance().getTreeModel();
		MutableTreeNode node = (MutableTreeNode) tree.getLastSelectedPathComponent();

		if (node instanceof WorkspaceM) {
			new BorderUnselector();

			AppWindow.getInstance().getStatusBar().setStatusLabelText((String) ((WorkspaceM) node).getUserObject());
			JDesktopPane desk = AppWindow.getInstance().getDesktop();

			if (desk.getSelectedFrame() != null) {
				try {
					desk.getSelectedFrame().setSelected(false);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			}
		}

		if (node instanceof ProjectM) {
			new BorderUnselector();
			try {
				((ProjectM) node).getController().getProjectView().setSelected(true);
				AppWindow.getInstance().getStatusBar().setStatusLabelText(((ProjectM) node).getProjectName());
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		}

		if (node instanceof DocumentM) {
			new BorderUnselector();
			DocumentView docview = ((DocumentM) node).getController().getDocView();
			TreeNode[] path = treeM.getPathToRoot(node);
			AppWindow.getInstance().getStatusBar().setStatusLabelText(((DocumentM) node).getDocumentName());

			try {
				((ProjectM) node.getParent()).getController().getProjectView().setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}

			tree.setSelectionPath(new TreePath(path));
			((ProjectM) node.getParent()).getController().getProjectView().getTabber().setSelectedComponent(docview);
		}

		if (node instanceof PageM) {
			new BorderUnselector();
			TreeNode[] path = treeM.getPathToRoot(node);
			DocumentM docM = ((DocumentM) node.getParent());
			DocumentView docview = docM.getController().getDocView();

			AppWindow.getInstance().getStatusBar().setStatusLabelText(((PageM) node).getPageName());

			try {
				((ProjectM) docM.getParent()).getController().getProjectView().setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}

			((ProjectM) docM.getParent()).getController().getProjectView().getTabber().setSelectedComponent(docview);

			((PageM) node).getPageController().getPageView().setSelectedBorder();

			tree.setSelectionPath(new TreePath(path));

		}

		if (node instanceof SlotGM) {
			new BorderUnselector();
			TreeNode[] path = treeM.getPathToRoot(node);
			PageM pageM = (PageM) node.getParent();
			DocumentM docM = ((DocumentM) pageM.getParent());
			DocumentView docview = docM.getController().getDocView();

			AppWindow.getInstance().getStatusBar().setStatusLabelText(((SlotGM) node).getSlotGMName());
			try {
				((ProjectM) docM.getParent()).getController().getProjectView().setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}

			((ProjectM) docM.getParent()).getController().getProjectView().getTabber().setSelectedComponent(docview);

			tree.setSelectionPath(new TreePath(path));

		}
		if (node instanceof SlotGM) {
			new BorderUnselector();
			GraphSlotView graphView = ((SlotGM) node).getSlotController().getGraphSlotView();
			graphView.setSlotStampSelected();
			TreeNode[] path = treeM.getPathToRoot(node);
			PageM pageM = (PageM) node.getParent();
			DocumentM docM = ((DocumentM) pageM.getParent());
			DocumentView docview = docM.getController().getDocView();
			AppWindow.getInstance().getStatusBar().setStatusLabelText(((SlotGM) node).getSlotGMName());
			try {
				((ProjectM) docM.getParent()).getController().getProjectView().setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}

			((ProjectM) docM.getParent()).getController().getProjectView().getTabber().setSelectedComponent(docview);

			tree.setSelectionPath(new TreePath(path));

		}

		if (node instanceof SlotTM) {
			new BorderUnselector();
			TextSlotView textView = ((SlotTM) node).getTextslotcontroller().getTextSlotView();
			textView.setSlotStampSelected();
			TreeNode[] path = treeM.getPathToRoot(node);
			PageM pageM = (PageM) node.getParent();
			DocumentM docM = ((DocumentM) pageM.getParent());
			DocumentView docview = docM.getController().getDocView();

			AppWindow.getInstance().getStatusBar().setStatusLabelText(((SlotTM) node).getSlotTMName());
			try {
				((ProjectM) docM.getParent()).getController().getProjectView().setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}

			((ProjectM) docM.getParent()).getController().getProjectView().getTabber().setSelectedComponent(docview);

			tree.setSelectionPath(new TreePath(path));

		}

		ActionManager.setActivex();
		AppWindow.getInstance().getPopup().setActivex();
	}
}
