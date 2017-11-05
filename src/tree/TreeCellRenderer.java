package tree;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.ProjectM;
import collection.model.SlotGM;
import collection.model.SlotTM;
import collection.model.WorkspaceM;
import collection.model.element.CircleElement;
import collection.model.element.RectangleElement;

public class TreeCellRenderer extends DefaultTreeCellRenderer {

	private static final long serialVersionUID = 3335154436891486670L;

	public TreeCellRenderer() {
		setClosedIcon(null);
		setLeafIcon(null);
		setOpenIcon(null);
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		if (value instanceof WorkspaceM) {
			URL imageURL = getClass().getResource("images/smallworkspace.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}
		if (value instanceof ProjectM) {
			URL imageURL = getClass().getResource("images/smallproject.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}

		if (value instanceof DocumentM) {
			URL imageURL = getClass().getResource("images/smalldocument.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}

		if (value instanceof PageM) {
			URL imageURL = getClass().getResource("images/smallpage.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}

		if (value instanceof SlotGM) {
			URL imageURL = getClass().getResource("images/smallgraph.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}

		if (value instanceof SlotTM) {
			URL imageURL = getClass().getResource("images/smalltext.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}

		if (value instanceof CircleElement) {
			URL imageURL = getClass().getResource("images/smallcircle.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}

		if (value instanceof RectangleElement) {
			URL imageURL = getClass().getResource("images/smallrectangle.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}
		return this;
	}
}