package actions.AA;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import collection.controller.DocumentController;
import collection.controller.GraphSlotController;
import collection.controller.PageController;
import collection.controller.ProjectController;
import collection.controller.TextSlotController;
import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.ProjectM;
import collection.model.SlotGM;
import collection.model.SlotTM;
import collection.model.element.CircleElement;
import collection.model.element.RectangleElement;
import gui.AppWindow;
import localization.Localization;
import tree.TreeM;

@SuppressWarnings("serial")
public class DeleteAction extends AbstractAction {
	public DeleteAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/delete.png"));
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("delete"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("delete"));
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
		
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)AppWindow.getInstance().getJtree().getLastSelectedPathComponent();
		TreeM treemodel = AppWindow.getInstance().getTreeModel();
		if (node instanceof ProjectM) {
			((ProjectController) ((ProjectM) node).getController()).getProjectView().dispose();
			treemodel.removeNodeFromParent(node);
		}
		if (node instanceof DocumentM) {
			((DocumentController) ((DocumentM) node).getController()).getDocView().dispose();
			treemodel.removeNodeFromParent(node);
		}
		if (node instanceof PageM) {
			((PageController) ((PageM) node).getPageController()).getPageView().dispose();
			((DocumentM)((PageM) node).getParent()).getController().getDocView().UpdateTbar();
			treemodel.removeNodeFromParent(node);
		}
		if (node instanceof SlotTM) {
			((TextSlotController) ((SlotTM) node).getTextslotcontroller()).getTextSlotView().dispose();
			treemodel.removeNodeFromParent(node);
		}
		if (node instanceof SlotGM) {
			((GraphSlotController) ((SlotGM) node).getSlotController()).getGraphSlotView().dispose();
			treemodel.removeNodeFromParent(node);
		}
		if(node instanceof RectangleElement){
			SlotGM slot = (SlotGM) node.getParent();
			if (slot instanceof SlotGM) {
				((SlotGM) slot).getElementSelectionManager().addToSelectionList((RectangleElement)node);
				((SlotGM) slot).getElementSelectionManager().removeAllSelectedFromParent();
				slot.getSlotController().getGraphSlotView().update(null, null);
				slot.getSlotController().getGraphSlotView().getEditingWindow().update(null, null);	
			}
		}
		if(node instanceof CircleElement){
			SlotGM slot = (SlotGM) node.getParent();
			if (slot instanceof SlotGM) {
				((SlotGM) slot).getElementSelectionManager().addToSelectionList((CircleElement)node);
				((SlotGM) slot).getElementSelectionManager().removeAllSelectedFromParent();
				slot.getSlotController().getGraphSlotView().repaint();
				slot.getSlotController().getGraphSlotView().getEditingWindow().repaint();
				
			}
			
		}
	}

	public void updateAction() {
		putValue(AbstractAction.NAME, Localization.getInstance().getBundle().getString("delete"));
		putValue(SHORT_DESCRIPTION, Localization.getInstance().getBundle().getString("delete"));
	}
}