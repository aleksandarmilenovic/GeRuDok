package tree;

import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.MutableTreeNode;

import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.ProjectM;
import collection.model.SlotGM;
import collection.model.SlotTM;
import collection.model.element.CircleElement;
import collection.model.element.RectangleElement;
import gui.AppWindow;

public class CellEditListener implements CellEditorListener {

	TreeCellEditor editor;

	public CellEditListener(TreeCellEditor editore) {
		editor = editore;
	}

	@Override
	public void editingCanceled(ChangeEvent e) {
	}

	@Override
	public void editingStopped(ChangeEvent e) {

		JTree tree = AppWindow.getInstance().getJtree();
		MutableTreeNode node = (MutableTreeNode) tree.getLastSelectedPathComponent();

		String edited = (String) editor.getCellEditorValue();

		if (node instanceof ProjectM) {
			((ProjectM) node).setProjectName(edited);
			((ProjectM) node).getController().getProjectView().setTitle(edited);
		}

		if (node instanceof DocumentM) {
			((DocumentM) node).setDocumentName(edited);
			int index = ((ProjectM) node.getParent()).getController().getProjectView().getTabber().getSelectedIndex();
			((ProjectM) node.getParent()).getController().getProjectView().getTabber().setTitleAt(index, edited);
		}

		if (node instanceof PageM) {
			((PageM) node).setPageName(edited);
			((PageM) node).getPageController().getPageView().getStamp().setText(edited);
		}

		if (node instanceof SlotTM) {
			((SlotTM) node).setSlotTMName(edited);
			((SlotTM) node).getTextslotcontroller().getTextSlotView().setSlotStampTitle(edited);
		}

		if (node instanceof SlotGM) {
			((SlotGM) node).setSlotGMName(edited);
			((SlotGM) node).getSlotController().getGraphSlotView().setSlotStampTitle(edited);
		}

		if (node instanceof RectangleElement) {
			((RectangleElement) node).setName(edited);
		}

		if (node instanceof CircleElement) {
			((CircleElement) node).setName(edited);
		}
	}

}
