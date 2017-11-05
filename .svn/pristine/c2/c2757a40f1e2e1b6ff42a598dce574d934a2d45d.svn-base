package gui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.MutableTreeNode;

import collection.model.DocumentM;
import collection.model.PageM;
import collection.model.ProjectM;
import collection.model.SlotGM;
import collection.model.SlotTM;
import collection.model.WorkspaceM;
import collection.model.element.CircleElement;
import collection.model.element.RectangleElement;

@SuppressWarnings("serial")
public class Popup extends JPopupMenu {
	private JMenuItem newProject;
	private JMenuItem newDocument;
	private JMenuItem newPage;
	private JMenuItem newGraphSlot;
	private JMenuItem close;
	private JMenuItem newTextSlot;
	private JMenuItem open;
	private JMenuItem delete;
	private JMenuItem importProject;
	private JMenuItem exportProject;
	
	// cut/copy/paste/delete za graf elementa u stablu
	private JMenuItem copyGrafElement;
	private JMenuItem cutGrafElement;
	private JMenuItem pasteGrafElement;
	

	public Popup() {

		importProject = new JMenuItem(AppWindow.getInstance().getActionManager().getImportProjectAction());
		newProject = new JMenuItem(AppWindow.getInstance().getActionManager().getNewProjectAction());
		newDocument = new JMenuItem(AppWindow.getInstance().getActionManager().getNewDocumentAction());
		exportProject = new JMenuItem(AppWindow.getInstance().getActionManager().getExportProjectAction());
		newPage = new JMenuItem(AppWindow.getInstance().getActionManager().getNewPageAction());
		newGraphSlot = new JMenuItem(AppWindow.getInstance().getActionManager().getNewSlotAction());
		close = new JMenuItem(AppWindow.getInstance().getActionManager().getCloseAction());
		open = new JMenuItem(AppWindow.getInstance().getActionManager().getOpenProjectAction());
		newTextSlot = new JMenuItem(AppWindow.getInstance().getActionManager().getTextSlotAction());
		delete = new JMenuItem(AppWindow.getInstance().getActionManager().getDeleteAction());
		
		copyGrafElement = new JMenuItem(AppWindow.getInstance().getActionManager().getCopyStablo());
		cutGrafElement = new JMenuItem(AppWindow.getInstance().getActionManager().getCutStablo());
		pasteGrafElement = new JMenuItem(AppWindow.getInstance().getActionManager().getPasteStablo());
		
		
		add(importProject);
		add(newProject);
		add(exportProject);
		add(newDocument);
		add(newPage);
		add(newGraphSlot);
		add(newTextSlot);
		add(open);
		add(close);
		add(delete);
		
		add(copyGrafElement);
		add(cutGrafElement);
		add(pasteGrafElement);
		
	}

	public void setActivex() {
		
		importProject.setVisible(false);
		newProject.setVisible(false);
		exportProject.setVisible(false);
		newDocument.setVisible(false);
		newPage.setVisible(false);
		newGraphSlot.setVisible(false);
		newTextSlot.setVisible(false);
		open.setVisible(false);
		close.setVisible(false);
		delete.setVisible(false);
		
		copyGrafElement.setVisible(false);
		cutGrafElement.setVisible(false);
		pasteGrafElement.setVisible(false);
	
		
		setEnabled(true);

		JTree tree = AppWindow.getInstance().getJtree();
		MutableTreeNode node = (MutableTreeNode) tree.getLastSelectedPathComponent();
		if (node instanceof WorkspaceM) {
			importProject.setVisible(true);
			newProject.setVisible(true);
		} else if (node instanceof ProjectM) {
			delete.setVisible(true);
			open.setVisible(true);
			close.setVisible(true);
			newDocument.setVisible(true);
			exportProject.setVisible(true);
		} else if (node instanceof DocumentM) {
			delete.setVisible(true);
			newPage.setVisible(true);
		} else if (node instanceof PageM) {
			delete.setVisible(true);
			newGraphSlot.setVisible(true);
			newTextSlot.setVisible(true);
		} else if (node instanceof SlotGM) {
			pasteGrafElement.setVisible(true);
			delete.setVisible(true);
		} else if (node instanceof SlotTM) {
			delete.setVisible(true);
		} else if (node instanceof RectangleElement || node instanceof CircleElement) {
			copyGrafElement.setVisible(true);
			cutGrafElement.setVisible(true);
		}else {
			setEnabled(false);
			;
		}
	}
}
