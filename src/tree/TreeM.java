package tree;

import java.io.Serializable;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.ProjectM;
import collection.model.SlotGM;
import collection.model.SlotTM;
import collection.model.WorkspaceM;
import collection.model.element.CircleElement;
import collection.model.element.Element;
import collection.model.element.RectangleElement;
import gui.AppWindow;

@SuppressWarnings("serial")
public class TreeM extends DefaultTreeModel implements Serializable {

	public TreeM(TreeNode root) {
		super(root);
	}

	public void refresh() {
		JTree tree = AppWindow.getInstance().getJtree();
		TreePath path = tree.getSelectionPath();
		reload();
		tree.expandPath(path);
		tree.setSelectionPath(path);
	}

	public void add(ProjectM inserted) {
		WorkspaceM parent = (WorkspaceM) AppWindow.getInstance().getJtree().getSelectionPath().getLastPathComponent();
		int index = parent.getChildCount();
		insertNodeInto(inserted, parent, index);
		refresh();
	}

	public void add(DocumentM inserted) {
		ProjectM parent = (ProjectM) AppWindow.getInstance().getJtree().getSelectionPath().getLastPathComponent();
		int index = parent.getChildCount();
		insertNodeInto(inserted, parent, index);
		refresh();
	}

	public void add(PageM inserted) {
		DocumentM parent = (DocumentM) AppWindow.getInstance().getJtree().getSelectionPath().getLastPathComponent();
		int index = parent.getChildCount();
		insertNodeInto(inserted, parent, index);
		refresh();
	}

	public void add(SlotGM inserted) {
		PageM parent = (PageM) AppWindow.getInstance().getJtree().getSelectionPath().getLastPathComponent();
		int index = parent.getChildCount();
		insertNodeInto(inserted, parent, index);
		refresh();
	}

	public void add(SlotTM inserted) {
		PageM parent = (PageM) AppWindow.getInstance().getJtree().getSelectionPath().getLastPathComponent();
		int index = parent.getChildCount();
		insertNodeInto(inserted, parent, index);
		refresh();
	}

	public void add(RectangleElement inserted) {
		SlotGM parent = (SlotGM) AppWindow.getInstance().getJtree().getSelectionPath().getLastPathComponent();
		int index = parent.getChildCount();
		insertNodeInto(inserted, parent, index);
		parent.addElement(index, inserted);
		refresh();
	}

	public void add(CircleElement inserted) {
		SlotGM parent = (SlotGM) AppWindow.getInstance().getJtree().getSelectionPath().getLastPathComponent();
		int index = parent.getChildCount();
		insertNodeInto(inserted, parent, index);
		parent.addElement(index, inserted);
		refresh();
	}

	public void remove(Element element) {
		removeNodeFromParent(element);
		refresh();
	}

}
